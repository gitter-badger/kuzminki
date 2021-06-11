# kuzminki
Postgres query builder inspired by knex

#### Settings
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

#### Defining a table

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

// AND OR

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

// Optional conditions

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
```scala
case class UserSpending(id: Int, username: String, amount: Int)

class Customer extends Model("customer") {
  val id = column[Int]("id")
  val userId = column[Int]("user_id")
  val spending = column[Int]("amount_spent")
}

class UserCustomer extends ExtendedJoin[User, Customer] {
  val userSpending = read[UserSpending](a.id, a.username, b.spending)
}

implicit val toUserCustomer = Join.register[UserCustomer, User, Customer]
```

```scala
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
  .sql(printSql)
  .run()
  // returns UserCustomer

db
  .select(user, customer)
  .cols3(t => (
    t.a.id,
    t.a.username,
    t.b.spending
  ))
  // ...
  // returns Tuple3[Int, String, Int]

// Both result in the same SQL statement
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
```scala
// no arguments

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
```scala
// with arguments

val newUsers = db
  .select(user)
  .colsRead(_.info)
  .all
  .orderByOne(_.created.desc)
  .limit(10)
  .cacheWhere2(t => (
    t.country,
    t.city
  )

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
```scala
// with static and dynamic argumnets

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
```scala
db
  .insert(user)
  .cols2(t => (
    t.username,
    t.email
  ))
  .run(("bob", "bob@mail.com"))
```
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
DELETE FROM "user" WHERE id = 103
```
#### Delete multiple
```scala
db
  .delete(user)
  .whereOne(_.id.in(
    db.select(customer).cols1(_.userId).whereOne(_.spending === 0)
  ))
  .run()

// or

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
  .cacheOne(_.country)

stm.runCount("IT") // returns Long
```
```sql
SELECT count(*) FROM "user" WHERE country = 'IT'
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
  avg("age"),
  max("max"),
  min("min")
FROM "user"
WHERE "country" = 'US'
```
#### Aggregation having
```scala
val stm = db
  .select(userCustomerJoin)
  .cols3(t => (
    b.spending.avg,
    a.city
  ))
  .joinOn(_.id, _.userId)
  .groupByOne(_.a.city)
  .havingOne(_.b.spending > 0)
  .orderByOne(_.b.spending.avg.desc)
  .limit(10)
  .cacheWhere1(_.a.country)

stm.run("US")
```
```sql
SELECT
  avg("b"."amount_spent"),
  "a"."city"
FROM "user" "a"
INNER JOIN "customer" "b"
ON "a"."id" = "b"."user_id"
GROUP BY "a"."city"
HAVING "b"."amount_spent" > 0
AND "a"."country" = 'US'
ORDER BY "b"."amount_spent"
LIMIT 10
```
#### Nested aggrigation
```scala
db
  .select(user)
  .colsRead(_.info)
  .cols1(_.age.gt(
    db.subqueryNumber(user).cols1(_.age.avg).all
  ))
  orderByOne(_.age.desc)
  .run()
```
```sql
SELECT "id", "username", "email"
FROM "user"
WHERE "age" > (SELECT avg("age") FROM "user")
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
|                   | isNull           | Any
|                   | isNotNull        | Any
|                   | in               | Any
|                   | notIn            | Any
|                   | like             | String
|                   | startsWith       | String
|                   | endsWith         | String
|                   | similarTo        | String
|~                  | reMatch          | String
|~*                 | reIMatch         | String
|!~                 | reNotMatch       | String
|!~*                | reNotIMatch      | String























