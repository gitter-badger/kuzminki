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
  val gender = column[Char]("gender")
  val country = column[String]("country")
  val city = column[String]("city")
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
    t.gender === 'f',
    t.age > 25,
    t.country in Seq("DE", "FR", "UK")
  ))
  .orderByOne(_.age.desc)
  .limit(10)
  .map(//...)

  // returns List[Tuple2[Int, String]]
```
Output:
```sql
SELECT "id", "username"
FROM "user"
WHERE "gender" = 'f'
AND "age" > 25
AND "country" = ANY(ARRAY['DE', 'FR', 'UK'])
ORDER BY "age"
DESC LIMIT 10
```

#### Conditions
```scala
.whereOne(_.id > 100)

.where(t => Seq(
    t.gender === 'f',
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

case class AgeGender(age: Int, gender: Char)
implicit val toAgeGender: Tuple2[Int, Char] => AgeGender = tup => AgeGender(tup._1, tup._2)

.runAs[AgeGender]() // List[AgeGender]
.headAs[AgeGender]() // AgeGender
.headOptAs[AgeGender] // Option[AgeGender]

// Streaming

val source: Source[Tuple2[Int, String], Future[NotUsed]] =
db.select(user).cols2(_.basic).all().orderByOne(_.id.asc).source
source.runWith(Sink.foreach(println))
```


#### Join
```scala
case class UserSpending(id: Int, username: String, amount: Int)

class Customer extends Model("customer") {
  val id = column[Int]("id")
  val userId = column[Int]("user_id")
  val amountSpent = column[Int]("amount_spent")
}

class UserCustomer extends ExtendedJoin[User, Customer] {
  val userSpending = read[UserSpending](a.id, a.username, b.amountSpent)
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
    t.b.amountSpent > 1000
  ))
  .orderByOne(_.b.amountSpent.desc)
  .limit(10)
  .run()
  // returns UserCustomer

db
  .select(user, customer)
  .cols3(t => (
    t.a.id,
    t.a.username,
    t.b.amountSpent
  ))
  .joinOn(_.id, _.userId)
  .where(t => Seq(
    t.a.age > 25,
    t.b.amountSpent > 1000
  ))
  .orderByOne(_.b.amountSpent.desc)
  .limit(10)
  .run()
  // returns Tuple3[Int, String, Int]

// Both result in the same SQL statement
```
```sql
SELECT
  "a"."id",
  "a"."username",
  "b"."amount_spent"
FROM "user" "a"
INNER JOIN "customer" "b"
ON "a"."id" = "b"."user_id"
WHERE "a"."age" > 25
AND "b"."amount_spent" > 1000
ORDER BY "b"."amount_spent"
DESC LIMIT 10
```





#### Data types

Postgres                  | Scala
--------------------------|-----------------------------
varchar / text            | String
char(1)                   | Char
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

Operator           | Alternative      | Column type
-------------------|------------------|------------------
===                | matches          | Any
!==                | not              | Any
&nbsp;             | isNull           | Any
|                  | isNotNull        | Any
                   | in               | Any
                   | notIn            | Any
                   | like             | String
                   | startsWith       | String
                   | endsWith         | String
                   | similarTo        | String
~                  | reMatch          | String
~*                 | reIMatch         | String
!~                 | reNotMatch       | String
!~*                | reNotIMatch      | String
>                  | gt               | Numbers and time
<                  | lt               | Numbers and time
>=                 | gte              | Numbers and time
<=                 | lte              | Numbers and time






















