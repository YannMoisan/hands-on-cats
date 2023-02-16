import Ex_Validation.Person
import cats.data.Validated.Valid
import cats.data.Validated.Invalid

class Ex_ValidationSpec extends org.specs2.mutable.Specification {
  "[vanilla] The factory method" >> {
    "should instantiate a new person when all fields are correct" >> {
      Ex_Validation.vanilla.Person.apply("40", "toto") must beSuccessfulTry.withValue(Ex_Validation.Person(40, "toto"))
    }
    "should return a failure when age is wrong" >> {
      Ex_Validation.vanilla.Person.apply("NaN", "toto") must beFailedTry
    }
    "should return a failure when name is wrong" >> {
      Ex_Validation.vanilla.Person.apply("40", "toolonngggggg") must beFailedTry
    }
    "should return a failure (with errors accumulated) when all fields are wrong" >> {
      Ex_Validation.vanilla.Person.apply("NaN", "toolonngggggg") must beFailedTry
    }
  }
  "[cats] The factory method" >> {
    "should instantiate a new person when all fields are correct" >> {
      Ex_Validation._cats.Person.apply("40", "toto") must_== Valid(Ex_Validation.Person(40, "toto"))
    }
    "should return a failure when age is wrong" >> {
      Ex_Validation._cats.Person.apply("NaN", "toto").leftMap(_.map(_.getMessage)) must_== Invalid(cats.data.NonEmptyList.one("For input string: \"NaN\""))
    }
    "should return a failure when name is wrong" >> {
      Ex_Validation._cats.Person.apply("40", "toolonngggggg").leftMap(_.map(_.getMessage)) must_== Invalid(cats.data.NonEmptyList.one("name too long"))
    }
    "should return a failure (with errors accumulated) when all fields are wrong" >> {
      Ex_Validation._cats.Person.apply("NaN", "toolonngggggg").leftMap(_.map(_.getMessage)) must_== Invalid(cats.data.NonEmptyList.of("For input string: \"NaN\"", "name too long"))
    }
  }

}
