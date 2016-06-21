import TypeSafe._

class TypeSafeSpec extends org.specs2.mutable.Specification {
  "[vanilla]" >> {
    "should merge id" >> {
      vanilla.f(vanilla.UserId("1"), vanilla.ProjectId("2")) must_== "12"
    }
  }
  "[scalaz]" >> {
    "should merge id" >> {
      scalaz.f(scalaz.UserId("1"), scalaz.ProjectId("2")) must_== "12"
    }
  }
}
