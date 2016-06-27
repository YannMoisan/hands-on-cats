import Ex_TypeSafe._

class Ex_TypeSafeSpec extends org.specs2.mutable.Specification {
  "[vanilla]" >> {
    "should merge id" >> {
      vanilla.f(vanilla.UserId("1"), vanilla.ProjectId("2")) must_== "12"
    }
  }
  "[scalaz]" >> {
    "should merge id" >> {
      _scalaz.f(_scalaz.UserId("1"), _scalaz.ProjectId("2")) must_== "12"
    }
  }
}
