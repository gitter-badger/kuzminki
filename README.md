# kuzminki
Postgres query builder inspired by knex

#####Connecting to the database

######Settings
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

######Make a connection
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

######Defining a table
```scala
class User extends Model("user") {
  val id = column[Int]("id")
  val name = column[String]("name")
  val username = column[String]("username")
  val email = column[String]("email")
  val age = column[Int]("age")
  val gender = column[Char]("gender")
  val country = column[String]("country")
  val city = column[String]("city")
  val isActive = column[Boolean]("is_active")
  val created = column[ZonedDateTime]("created")

  val basic = (id, username)
  val slimUser = read[SlimUser](id, username, email)
}

Model.register[User]
```












































