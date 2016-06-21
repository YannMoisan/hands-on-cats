import scala.util.{Failure, Success, Try}
import scalaz.{Validation => V, _}
import Scalaz._

object Ex4_Validation {

  case class Person(age: Int, name: String)

  object vanilla {

    object Person {
      def apply(age: String, name: String): Try[Ex4_Validation.Person] = {
        val tryAge = validateAge(age)
        val tryName = validateName(name)

        tryAge match {
          case Success(age) =>
            tryName match {
              case Success(name) => Success(Ex4_Validation.Person(age, name))
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
      def apply(age: String, name: String): ValidationNel[Throwable, Person] = (validateAge(age) |@| validateName(name)) {
        Ex4_Validation.Person.apply
      }

      def validateAge(s: String): ValidationNel[Throwable, Int] = V.fromTryCatchNonFatal(s.toInt).toValidationNel

      def validateName(s: String): ValidationNel[Throwable, String] = if (s.length > 10) new IllegalArgumentException("name too long").failureNel else s.successNel

    }

  }

}
