import Validation.Person

import scala.util.{Failure, Success}

class ValidationSpec extends org.specs2.mutable.Specification {
  "The factory method" >> {
    "should instantiate a new person when all fields are correct" >> {
      Person.apply("40", "toto") must beSuccessfulTry.withValue(Person(40, "toto"))
    }
    "should return a failure when age is wrong" >> {
      Person.apply("NaN", "toto") must beFailedTry.withThrowable[java.lang.NumberFormatException]("For input string: \"NaN\"")
    }
    "should return a failure when name is wrong" >> {
      Person.apply("40", "toolonngggggg") must beFailedTry.withThrowable[java.lang.IllegalArgumentException]("name too long")
    }
    "should return a failure (with errors accumulated) when all fields are wrong" >> {
      Person.apply("NaN", "toolonngggggg") must beFailedTry.withThrowable[java.lang.IllegalArgumentException]("For input string: \"NaN\"name too long")
    }
  }
}
