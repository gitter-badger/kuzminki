# kuzminki
Postgres query builder inspired by knex


```scala
class User extends Model("user_user") {
    val id = column[Int]("id")
    val igId = column[Long]("ig_id")
    val username = column[String]("username")
    val name = column[String]("name")
    val email = column[String]("email")
    val age = column[Int]("age")
    val gender = column[String]("gender")
    val country = column[String]("country")
    val city = column[String]("city")
    val likes = column[Int]("likes")
    val isActive = column[Boolean]("is_active")
    val updated = column[ZonedDateTime]("updated")
    val created = column[ZonedDateTime]("created")

    val basic = (id, username)
    val slimUser = read[SlimUser](id, username, email)
  }

  Model.register[User]
```