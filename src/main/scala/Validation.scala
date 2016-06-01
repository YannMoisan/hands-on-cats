import scala.util.{Failure, Success, Try}

object Validation {
  case class Person(age: Int, name: String)
  object Person {
    def apply(age: String, name: String): Try[Person] = {
      val tryAge = validateAge(age)
      val tryName = validateName(name)

      tryAge match {
        case Success(age) =>
          tryName match {
            case Success(name) => Success(Person(age, name))
            case Failure(e2) => Failure(e2)
          }
        case Failure(e1) =>
          tryName match {
            case Success(name) => Failure(e1)
            case Failure(e2) => Failure(new IllegalArgumentException(e1.getMessage + e2.getMessage))
          }
      }
    }
  }
  def validateAge(s: String) : Try[Int] =
    Try(s.toInt)

  def validateName(s: String) : Try[String] = if (s.length > 10) Failure(new IllegalArgumentException("name too long")) else Success(s)

}
