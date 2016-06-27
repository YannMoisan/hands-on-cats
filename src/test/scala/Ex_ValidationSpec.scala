import Ex_Validation.Person
import cats.data.Validated.Valid
import cats.data.Validated.Invalid
import cats.std.list._

import scala.util.{Failure, Success}
import scalaz.{NonEmptyList, Failure => ZFailure, Success => ZSuccess}

class Ex_ValidationSpec extends org.specs2.mutable.Specification {
  "[vanilla] The factory method" >> {
    "should instantiate a new person when all fields are correct" >> {
      Ex_Validation.vanilla.Person.apply("40", "toto") must beSuccessfulTry.withValue(Ex_Validation.Person(40, "toto"))
    }
    "should return a failure when age is wrong" >> {
      Ex_Validation.vanilla.Person.apply("NaN", "toto") must beFailedTry.withThrowable[java.lang.NumberFormatException]("For input string: \"NaN\"")
    }
    "should return a failure when name is wrong" >> {
      Ex_Validation.vanilla.Person.apply("40", "toolonngggggg") must beFailedTry.withThrowable[java.lang.IllegalArgumentException]("name too long")
    }
    "should return a failure (with errors accumulated) when all fields are wrong" >> {
      Ex_Validation.vanilla.Person.apply("NaN", "toolonngggggg") must beFailedTry.withThrowable[java.lang.IllegalArgumentException]("For input string: \"NaN\"name too long")
    }
  }
  "[scalaz] The factory method" >> {
    "should instantiate a new person when all fields are correct" >> {
      Ex_Validation._scalaz.Person.apply("40", "toto") must_==ZSuccess(Ex_Validation.Person(40, "toto"))
    }
    "should return a failure when age is wrong" >> {
      Ex_Validation._scalaz.Person.apply("NaN", "toto").leftMap(_.map(_.getMessage)) must_==ZFailure(NonEmptyList("For input string: \"NaN\""))
    }
    "should return a failure when name is wrong" >> {
      Ex_Validation._scalaz.Person.apply("40", "toolonngggggg").leftMap(_.map(_.getMessage)) must_==ZFailure(NonEmptyList("name too long"))
    }
    "should return a failure (with errors accumulated) when all fields are wrong" >> {
      Ex_Validation._scalaz.Person.apply("NaN", "toolonngggggg").leftMap(_.map(_.getMessage)) must_==ZFailure(NonEmptyList("For input string: \"NaN\"", "name too long"))
    }
  }
  "[cats] The factory method" >> {
    "should instantiate a new person when all fields are correct" >> {
      Ex_Validation._cats.Person.apply("40", "toto") must_== Valid(Ex_Validation.Person(40, "toto"))
    }
    "should return a failure when age is wrong" >> {
      Ex_Validation._cats.Person.apply("NaN", "toto").leftMap(_.map(_.getMessage)) must_== Invalid(cats.data.NonEmptyList("For input string: \"NaN\""))
    }
    "should return a failure when name is wrong" >> {
      Ex_Validation._cats.Person.apply("40", "toolonngggggg").leftMap(_.map(_.getMessage)) must_== Invalid(cats.data.NonEmptyList("name too long"))
    }
    "should return a failure (with errors accumulated) when all fields are wrong" >> {
      Ex_Validation._cats.Person.apply("NaN", "toolonngggggg").leftMap(_.map(_.getMessage)) must_== Invalid(cats.data.NonEmptyList("For input string: \"NaN\"", "name too long"))
    }
  }

}
