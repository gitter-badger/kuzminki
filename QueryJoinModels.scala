import kuzminki.model._
import kuzminki.model.implicits._


object QueryJoinModels {

  class IgUser extends Model("instagram_instagramuser") {
    def id = column[Int]("id")
    def igId = column[Long]("ig_id")
    def name = column[String]("name")
    def username = column[String]("username")
    def email = column[String]("email")
    def gender = column[String]("gender")
    def age = column[Short]("age")
    def country = column[String]("country")
    def city = column[String]("city")
    def lang = column[String]("lang")
    def posts = column[Int]("posts")
    def followers = column[Int]("followers")
  }

  class Vision extends Model("instagram_computervision") {
    def id = column[Int]("id")
    def igId = column[Long]("ig_id")
    def priority = column[Short]("priority")
    def isDone = column[Boolean]("is_done")
    def issue = column[String]("issue")
  }

  val igUser = Model.get[IgUser]
  val vision = Model.get[Vision]

  case class UserVision(id: Int, username: String, priority: Short, isDone: Boolean)

  class UserVisionJoin extends ExtendedJoin[IgUser, Vision] {
    val simple = read[UserVision](a.id, a.username, b.priority, b.isDone)
  }

  val userVisionJoin = Join.get[UserVisionJoin]
  implicit val toUserVisionJoin = Join.register[UserVisionJoin, IgUser, Vision]

  /*
  implicit class UserVisionJoin(join: Join[IgUser, Vision]) extends JoinRead(join) {
    println("### UserVisionJoin ###")
    val simple = read[UserVision](a.id, a.username, b.priority, b.isDone)
  }
  */
}