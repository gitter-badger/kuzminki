import kuzminki.model._
import kuzminki.model.implicits._


object QueryJoinModels {

  class IgUser extends Model("instagram_instagramuser") {
    val id = column[Int]("id")
    val igId = column[Long]("ig_id")
    val name = column[String]("name")
    val username = column[String]("username")
    val email = column[String]("email")
    val gender = column[String]("gender")
    val age = column[Short]("age")
    val country = column[String]("country")
    val city = column[String]("city")
    val lang = column[String]("lang")
    val posts = column[Int]("posts")
    val followers = column[Int]("followers")
  }

  Model.register[IgUser]

  class Vision extends Model("instagram_computervision") {
    val id = column[Int]("id")
    val igId = column[Long]("ig_id")
    val priority = column[Short]("priority")
    val isDone = column[Boolean]("is_done")
    val issue = column[String]("issue")
  }

  Model.register[Vision]

  case class UserVision(id: Int, username: String, priority: Short, isDone: Boolean)

  class UserVisionJoin extends ExtendedJoin[IgUser, Vision] {
    val simple = read[UserVision](a.id, a.username, b.priority, b.isDone)
  }

  implicit val toUserVisionJoin = Join.register[UserVisionJoin, IgUser, Vision]
}