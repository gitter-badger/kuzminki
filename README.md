# kuzminki
#Kuzminki

Kuzminki is a PostgreSQL query and access library for Scala. For driver it uses the asynchronous [rdbc](https://github.com/rdbc-io/rdbc).
The project is currently not fully tested.

#### Settings
Database settings in sbt
```sbt
db.user = {
  host = "localhost"
  port = 5432
  user = "username"
  password = "secret"
  db = "user"
  threads = 10
}
```

#### Connecting to the database
```scala
import kuzminki.Kuzminki

implicit val system = ActorSystem()
implicit val ec = system.dispatcher
implicit val materializer = ActorMaterializer()(system)
implicit val timeout = 3.seconds.timeout

val conf = SystemConfigFactory.load()
val db = new Kuzminki(conf.getConfig("db.kuzminki"))
```

#### Defining a model
The model makes sure that the compiler can check that the columns exists and the types are correct. The model does not create or modify the database table.
```scala
import kuzminki.model._
import kuzminki.model.implicits._

class User extends Model("user") {
  val id = column[Int]("id")
  val username = column[String]("username")
  val email = column[String]("email")
  val name = column[String]("name")
  val age = column[Int]("age")
  val gender = column[String]("gender")
  val country = column[String]("country")
  val city = column[String]("city")
  val discount = column[Int]("discount")
  val isActive = column[Boolean]("is_active")
  val created = column[ZonedDateTime]("created")
}
```
If a column has null values use Option.
```scala
val country = column[Option[String]]("country")
// or
val country = column[String]("country").opt
```

#### Defining result types
You can define result types in the model. That way you do not have to list the columns each time you make a query.
```scala
import kuzminki.model._
import kuzminki.model.implicits._

case class UserInfo(id: Int, username: String, email: String)

class User extends Model("user") {
  val id = column[Int]("id")
  val username = column[String]("username")
  val email = column[String]("email")
  //...

  // Shortcut for selecting columns. Returns Tupl2[Int, String]
  val basic = (id, username)

  // Create a reader for the type UserInfo
  val info = read[UserInfo](id, username, email)
}

Model.register[User]
```

#### Create an instance of a model
If you create a shortcut to read columns into a type as shown above, the compiler will not be able to check if the columns match the type. If they don not match, an error will be thrown when an instance of the class is created. Therefore, it is wise to create an instance where the model is defined to make sure an error is thrown at start-up and not unexpectedly at runtime.
```scala
// Create an instance of the model for later use and make sure there is only one instance of the model.
Model.register[User]

// Get an existing instance of the model. If it does not exist, it is created.
val user = Model.get[User]
```

#### Select query
```scala
val user = Model.get[User]

db
  .select(user)
  .cols2(t => (
    t.id,
    t.username
  ))
  .where(t => Seq(
    t.gender === "f",
    t.age > 25
  ))
  .orderByOne(_.age.desc)
  .limit(10)
  .map(handleResult)

  // returns List[Tuple2[Int, String]]
```
Output:
```sql
SELECT "id", "username"
FROM "user_profile"
WHERE "gender" = 'f'
AND "age" > 25
ORDER BY "age"
DESC LIMIT 10
```

#### Conditions
```scala
.whereOne(_.id > 100)

.where(t => Seq(
    t.gender === "f",
    t.age > 25
))
```
AND / OR
```scala
.where(t => Seq(
  t.age > 25,
  Or(
    t.country === "RU",
    t.country === "FR"
  )
))
// WHERE "age" > 25 AND ("country" == 'RU' OR "country" == 'FR')

.whereOne(t => Or(
  And(
    t.country === "RU",
    t.city === "Moscow"
  ),
  And(
    t.country === "FR",
    t.city === "Paris"
  )
))
// WHERE ("country" == 'RU' AND "city" == 'Moscow') OR ("country" == 'FR' AND "city" == 'Paris')
```
Optional conditions
```scala
.whereOpt(_.id > Some(100))

.whereOpts(t => Seq(
  t.gender === None,
  t.age > Some(25)
))
// WHERE "age" > 25

.whereOpts(t => Seq(
  t.age > Some(25),
  Or.opts(
    t.country === Some("RU"),
    t.country === Some("FR")
  )
))
// WHERE "age" > 25 AND ("country" == 'RU' OR "country" == 'FR')
```

#### Results types
```scala
.cols1(_.id)
// Int

.cols3(t => (
  t.id,
  t.username,
  t.email
))
// Tuple3[Int, String, String]

.colsAsSeq(t => Seq(
  t.id,
  t.username
))
// Seq[Any]

.cols2(_.basic)
// Tuple2[Int, String]

.colsRead(_.info)
// UserInfo
```

#### Results
```scala
.cols1(_.id)

.run() // List[Int]
.head() // Int
.headOpt() // Option[Int]

// Count

.runCount() // Int

// Conversion

.cols2(t => (
  t.age,
  t.gender
))

case class AgeGender(age: Int, gender: String)
implicit val toAgeGender: Tuple2[Int, String] => AgeGender = tup => AgeGender(tup._1, tup._2)

.runAs[AgeGender]() // List[AgeGender]
.headAs[AgeGender]() // AgeGender
.headOptAs[AgeGender] // Option[AgeGender]

// Streaming

val source: Source[Tuple2[Int, String], Future[NotUsed]] = db
  .select(user)
  .cols2(_.basic)
  .all
  .orderByOne(_.id.asc)
  .source

source.runWith(Sink.foreach(println))
```

#### Join
In a join the columns of each table are accessible under "a" and "b".
```scala
class Customer extends Model("customer") {
  val id = column[Int]("id")
  val userId = column[Int]("user_id")
  val spending = column[Int]("amount_spent")
}

val customer = Model.get[Customer]

db
  .select(user, customer)
  .cols3(t => (
    t.a.id,
    t.a.username,
    t.b.spending
  ))
  .where(t => Seq(
    t.a.age > 25,
    t.b.spending > 1000
  ))
  .orderByOne(_.b.spending.desc)
  .limit(10)
  .run()
  // returns Tuple3[Int, String, Int]
```
```sql
SELECT
  "a"."id",
  "a"."username",
  "b"."spending"
FROM "user_profile" "a"
INNER JOIN "customer" "b"
ON "a"."id" = "b"."user_id"
WHERE "a"."age" > 25
AND "b"."spending" > 1000
ORDER BY "b"."spending"
DESC LIMIT 10
```
To return the result of a joined query into a type you can extend ExtendedJoin and create a read. You will also have to create an implicit conversion.
```scala
case class UserSpending(id: Int, username: String, amount: Int)

class UserCustomer extends ExtendedJoin[User, Customer] {
  val userSpending = read[UserSpending](a.id, a.username, b.spending)
}

implicit val toUserCustomer = Join.register[UserCustomer, User, Customer]

val userCustomerJoin = Join.get[UserCustomer]

db
  .select(userCustomerJoin)
  .colsRead(_.userSpending)
  .joinOn(_.id, _.userId)
  .where(t => Seq(
    t.a.age > 25,
    t.b.spending > 1000
  ))
  .orderByOne(_.b.spending.desc)
  .limit(10)
  .run()
  // returns UserCustomer
```

#### Nested query
```scala
class Emails extends Model("old_user") {
  val email = column[String]("email")
}

val oldUser = Model.get[OldUser]

db
  .select(user)
  .cols2(_.basic)
  .whereOne(_.email.in(
    db.select(oldUser).cols1(_.email).whereOne(_.spending < 1000)
  ))
  .limit(10)
  .run()
  .map(handleResult)
```
```sql
SELECT "id", "username"
FROM "user_profile"
WHERE "email" = ANY(
  SELECT "email"
  FROM "old_user"
  WHERE "spending" < 1000
)
LIMIT 10
```

#### Cache
The query can be cached. That way the statement will by built once and the performance will be the same as with a raw query.
```scala
val newUsers = db
  .select(user)
  .colsRead(_.info)
  .all
  .orderByOne(_.created.desc)
  .limit(10)
  .cache

newUsers.run().map(handleResult)
```
```sql
SELECT "id", "username", "email"
FROM "user_profile"
ORDER BY "created" DESC
LIMIT 10
```
You can use dynamic conditions with a cached query. The arguments will match the value in a given column.
```scala
val newUsers = db
  .select(user)
  .colsRead(_.info)
  .all
  .orderByOne(_.created.desc)
  .limit(10)
  .cacheWhere2(t => (
    t.country,
    t.city
  ))

newUsers.run(("CN", "Peking")).map(handleResult)
```
```sql
SELECT "id", "username", "email"
FROM "user_profile"
WHERE "country" = 'CN'
AND "city" = 'Peking'
ORDER BY "created" DESC
LIMIT 10
```
You can use both static and dynamic conditions in a cached query.
```scala
val newUsers = db
  .select(user)
  .colsRead(_.info)
  .whereOne(_.age > 25)
  .orderByOne(_.created.desc)
  .limit(10)
  .cacheWhere1(_.country)

newUsers.run("CN").map(handleResult)
```
```sql
SELECT "id", "username", "email"
FROM "user_profile"
WHERE "age" > 25
AND "country" = 'CN'
ORDER BY "created" DESC
LIMIT 10
```

### Insert

#### Basic
To insert you define the columns as tuple and then pass a tuple of the same type to .run()
```scala
db
  .insert(user)
  .cols2(t => (
    t.username,
    t.email
  ))
  .run(("bob", "bob@mail.com"))
```
If you need to insert columns that exceed the limits of a tuple, larger than 22.
```sql
INSERT INTO "user" ("username", "email") VALUES ('bob', 'bob@mail.com')
```
#### Key/value insert
```scala
db
  .insert(user)
  .data(t => Seq(
    t.username ==> "bob",
    t.email ==> "bob@mail.com"
  ))
  .run()
```
Insert a type.
```sql
INSERT INTO "user" ("username", "email") VALUES ('bob', 'bob@mail.com')
```
#### Insert type
```scala
case class AddUser(username: String, email: String)

// add write to the model
class User extends Model("user") {
  // ...
  val addUser = write[AddUser](username, email)
}

db
  .insert(user)
  .colsWrite(_.addUser)
  .run(AddUser("bob", "bob@mail.com"))
```
```sql
INSERT INTO "user" ("username", "email") VALUES ('bob', 'bob@mail.com')
```
In most cases you will want to cache your insert statements.
#### Cache insert statement
```scala
val stm = db
  .insert(user)
  .colsWrite(userData)
  .cache

// you can call various methods on the cached statement
stm.run(user: AddUser): Future[Unit]
stm.runNum(user: AddUser): Future[Long]
stm.runList(users: List[AddUser]): Future[Unit]
stm.runListNum(users: List[AddUser]): Future[Long]
stm.streamList(users: List[AddUser]): Future[Done]
stm.fromSource(users: Source[AddUser, T]): Future[Done]
```
```sql
INSERT INTO "user" ("username", "email") VALUES ('bob', 'bob@mail.com')
```
You can insert a list. The size of the list has the limit that the generated statement may exceed the maximum length of a an SQL statement.
#### Insert list
```scala
val stm = db
  .insert(user)
  .cols2(t => (
    t.username,
    t.email
  ))
  .cache

stm.runList(List( 
  ("bob", "bob@mail.com"),
  ("joe", "joe@mail.com"),
  ("paul", "paul@mail.com")
))
```
```sql
INSERT INTO "user" ("username", "email")
VALUES ('bob', 'bob@mail.com'),
       ('joe', 'joe@mail.com'),
       ('paul', 'paul@mail.com')
```
If you need to insert a long list, use .streamList()
#### Stream list
```scala
val stm = db
  .insert(user)
  .cols2(t => (
    t.username,
    t.email
  ))
  .cache

val longListOfUsers: List[Tuple2[String, String]] = //...

stm.streamList(longListOfUsers)
```
#### Insert stream
```scala
val stm = db
  .insert(user)
  .colsWrite(_.userData)
  .cache

val userSource: Source[AddUser, T] = //...

stm.fromSource(userSource)
```
#### Insert returning
```scala
val stm = db
  .insert(user)
  .cols2(t => (
    t.username,
    t.email
  ))
  .returning3(t => (
    t.id,
    t.username,
    t.email
  ))
  .cache

stm.run(("bob", "bob@mail.com"))
```
```sql
INSERT INTO "user_profile" ("username", "email")
VALUES ("bob", "bob@mail.com")
RETURNING "id", "username", "email"
```
#### Insert on conflict do nothing
```scala
val stm = db
  .insert(user)
  .cols2(t => (
    t.username,
    t.email
  ))
  .onConflictDoNothing
  .cache

stm.run(("bob", "bob@mail.com"))
```
```sql
INSERT INTO "user_profile" ("username", "email")
VALUES ('bob', 'bob@mail.com')
ON CONFLICT DO NOTHING
```
#### Upsert
```scala
val stm = db
  .insert(user)
  .cols2(t => (
    t.username,
    t.email
  ))
  .onConflictOnColumn(_.username)
  .doUpdateOne(_.email)
  .cache

stm.run(("bob", "bob@hotmail.com"))
```
```sql
INSERT INTO "user_profile" ("username", "email")
VALUES ('bob', 'bob@hotmail.com')
ON CONFLICT ("username")
DO UPDATE SET email = 'bob@hotmail.com'
```
If you do not want duplications on a column that does not have a unique constraint use .whereNotExists(). Also, if you are streaming, using ON CONFLICT will fail. Use .whereNotExists() instead.
#### Insert where not exists
```scala
val stm = db
  .insert(user)
  .cols2(t => (
    t.username,
    t.email
  ))
  .whereNotExistsOne(_.email)
  .cache

stm.run(("bob", "bob@mail.com"))
```
```sql
INSERT INTO "user_profile" ("username", "email")
SELECT 'bob', 'bob@mail.com'
WHERE NOT EXISTS (
  SELECT 1
  FROM "user_profile"
  WHERE "email" = 'bob@mail.com'
)
```
#### Insert from select
```scala
class Email extends Model("email") {
  val email = column[String]("email")
}

val email = Model.get[Email]

db
  .insert(email)
  .cols1(_.email)
  .fromSelect(
    db.select(user).cols1(_.email).all()
  )
  .run()
```
```sql
INSERT INTO "email" ("email") SELECT "email" FROM "user"
```

### Update
```scala
db
  .update(user)
  .setOne(_.country ==> "JP")
  .whereOne(_.id === 103)
  .run()

// .runNum() for rows affected
```
```sql
UPDATE "user" SET "country" = 'JP' WHERE id = 103
```
#### Update returning
```scala
db
  .update(user)
  .set(t => Seq(
    t.country ==> "IS",
    t.city ==> "RVK"
  ))
  .whereOne(_.id === 42)
  .returning4(t => (
    t.id,
    t.email,
    t.country,
    t.city
  ))
  .run()
```
```sql
UPDATE "user_profile"
SET "country" = 'IS',
    "city" = 'RVK'
WHERE "id" = 42
RETURNING "id", "email", "country", "city"
```
You can cache an update statement if the updated column and values are static.
#### Update stream
```scala
val stm = db
  .update(user)
  .setOne(_.isActive ==> true)
  .cacheWhere1(_.id)

val ids = List(3, 27, 135)
stm.streamList(ids)
// or
stm.fromSource(Source(ids))
```
### Delete
```scala
db
  .delete(user)
  .whereOne(_.id === 103)
  .run()
```
```sql
DELETE FROM "user_profile" WHERE id = 103
```
#### Delete from select
```scala
db
  .delete(user)
  .whereOne(_.id.in(
    db.select(customer).cols1(_.userId).whereOne(_.spending === 0)
  ))
  .run()
```
With streaming
```scala
val stm = db
  .delete(user)
  .cacheWhere1(_.id)

stm.fromSource(
  db.select(customer).whereOne(_.spending === 0).source
)
```
### Aggregation

#### Count
```scala
val stm = db
  .count(user)
  .all
  .cacheWhere1(_.country)

stm.runCount("IT")
```
```sql
SELECT count(*) FROM "user_profile" WHERE "country" = 'IT'
```
#### Avg Max Min
```scala
db
  .select(user)
  .cols3(t => (
    t.age.avg,
    t.age.max,
    t.age.min
  ))
  .whereOne(_.country === "US")
  .run()
```
```sql
SELECT
  AVG("age"),
  MAX("age"),
  MIN("age")
FROM "user_profile"
WHERE "country" = 'US'
```
#### Aggregation having
```scala
val stm = db
  .select(userCustomerJoin)
  .cols2(t => (
    t.a.city,
    t.b.spending.avg
  ))
  .joinOn(_.id, _.userId)
  .groupBy(t  => Seq(
    t.a.city,
    t.a.country
  ))
  .havingOne(_.b.spending.avg > 0)
  .orderByOne(_.b.spending.avg.desc)
  .limit(10)
  .cacheHaving1(_.a.country)

println(stm.args)

stm.run("US")
```
```sql
SELECT
  "a"."city",
  avg("b"."spending")
FROM "user_profile" "a"
INNER JOIN "customer" "b"
ON "a"."id" = "b"."user_id"
GROUP BY "a"."city", "a"."country"
HAVING avg("b"."spending") > 0
AND "a"."country" = 'US'
ORDER BY avg("b"."spending")
DESC LIMIT 10
```
#### Nested aggrigation
```scala
db
  .select(user)
  .colsRead(_.info)
  .whereOne(_.age.gt(
    db.subqueryNumber(user).cols1(_.age.avg).all
  ))
  .orderByOne(_.age.desc)
  .run()
```
```sql
SELECT "id", "username", "email"
FROM "user_profile"
WHERE "age" > (
  SELECT avg("age")
  FROM "user_profile"
)
ORDER BY "age" DESC
```

#### Data types

Postgres                  | Scala
--------------------------|-----------------------------
varchar / text            | String
bool                      | Boolean
int2                      | Short
int4                      | Int
int8                      | Long
float4                    | Float
float8                    | Double
numeric                   | io.rdbc.sapi.DecimalNumber
date                      | java.time.LocalDate
time                      | java.time.LocalTime
timestamp                 | java.time.Instant
timestamp with time zone  | java.time.ZonedDateTime
uuid                      | java.util.UUID


#### Condition operators

|Operator           | Alternative      | Column type
|-------------------|------------------|------------------
|===                | matches          | Any
|!==                | not              | Any
|>                  | gt               | Numbers and time
|<                  | lt               | Numbers and time
|>=                 | gte              | Numbers and time
|<=                 | lte              | Numbers and time
|~                  | reMatch          | String
|~*                 | reIMatch         | String
|!~                 | reNotMatch       | String
|!~*                | reNotIMatch      | String
|                   | like             | String
|                   | startsWith       | String
|                   | endsWith         | String
|                   | similarTo        | String
|                   | isNull           | Any
|                   | isNotNull        | Any
|                   | in               | Any
|                   | notIn            | Any

























