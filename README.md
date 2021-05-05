# kuzminki
Postgres query builder inspired by knex

##### Connecting to the database

###### Settings
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

###### Make a connection
```scala
import kuzminki.Kuzminki
import kuzminki.model._
import kuzminki.model.implicits._

implicit val system = ActorSystem()
implicit val ec = system.dispatcher
implicit val materializer = ActorMaterializer()(system)
implicit val timeout = 3.seconds.timeout

val conf = SystemConfigFactory.load()
val db = new Kuzminki(conf.getConfig("db.kuzminki"))
```

###### Data types

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

###### Defining a table

```scala
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
In case of a column with null values use Option.
```scala
val country = column[Option[String]]("country")
// or
val country = column[String]("country").opt
```

###### Defining result types
```scala
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

###### Select query
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
```sql
SELECT "id", "username"
FROM "user"
WHERE "gender" = 'f'
AND "age" > 25
AND "country" = ANY(ARRAY['DE', 'FR', 'UK'])
ORDER BY "age"
DESC LIMIT 10
```










































