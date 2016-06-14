import scala.util.{Failure, Success, Try}
import scalaz._

object Validation {

  case class Person(age: Int, name: String)

  object vanilla {

    object Person {
      def apply(age: String, name: String): Try[Validation.Person] = {
        val tryAge = validateAge(age)
        val tryName = validateName(name)

        tryAge match {
          case Success(age) =>
            tryName match {
              case Success(name) => Success(Validation.Person(age, name))
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

    def validateAge(s: String): Try[Int] =
      Try(s.toInt)

    def validateName(s: String): Try[String] = if (s.length > 10) Failure(new IllegalArgumentException("name too long")) else Success(s)
  }

  object scalaz {

    object Person {
      def apply(age: String, name: String): ValidationNel[Throwable, Person] = sys.error("todo")

      def validateAge(s: String): ValidationNel[Throwable, Int] = sys.error("todo")

      def validateName(s: String): ValidationNel[Throwable, String] = sys.error("todo")

    }

  }

}
