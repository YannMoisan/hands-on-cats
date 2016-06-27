object Ex_TypeSafe {
  object unsafe {
    val userId = "1"
    val projectId = "2"

    def f(userId: String, projectId: String) = userId + projectId

    f(projectId, userId)
  }

  object vanilla {
    case class UserId(id: String) extends AnyVal
    case class ProjectId(id: String) extends AnyVal

    val userId = UserId("1")
    val projectId = ProjectId("2")

    def f(userId: UserId, projectId: ProjectId) = userId.id + projectId.id

    // as expected, the following line doesn't compile
    // f(projectId, userId)
  }

  object _scalaz {
    import scalaz.@@

    trait User
    trait Project

    def UserId(a: String): String @@ User = sys.error("todo")
    def ProjectId(a: String): String @@ Project = sys.error("todo")

    val userId = UserId("1")
    val projectId = ProjectId("2")

    def f(userId: String @@ User, projectId: String @@ Project) : String = sys.error("todo")
    // as expected, the following line doesn't compile
    // f(projectId, userId)
  }
}
