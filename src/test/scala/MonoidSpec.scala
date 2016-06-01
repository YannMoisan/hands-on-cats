class MonoidSpec extends org.specs2.mutable.Specification {
    "merge two maps" >> {
      "should work when maps don't contains same keys" >> {
        val m1 = Map("Account 1" -> 10,
          "Account 2" -> 20,
          "Account 3" -> 30)

        val m2 = Map("Account 1" -> 5,
          "Account 3" -> 7,
          "Account 4" -> 42)

        val merged = Monoid.merge(m1, m2)

        merged must_== Map(
          "Account 1" -> 15,
          "Account 2" -> 20,
          "Account 3" -> 37,
          "Account 4" -> 42
        )
      }
    }
}
