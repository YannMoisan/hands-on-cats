class MonoidSpec extends org.specs2.mutable.Specification {
    "merge two maps of Int" >> {
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
  "merge two dictionaries : maps of List[String]" >> {
    "should work when maps don't contains same keys" >> {
      val m1 = Map("A" -> List("Ada"),
        "B" -> List("Basic", "Bash"),
        "C" -> List("Cobol"))

      val m2 = Map("A" -> List("Assembly"),
        "C" -> List("C#"),
        "D" -> List("Dart"))

      val merged = Monoid.mergeEx2(m1, m2)

      merged must_== Map(
        "A" -> List("Ada", "Assembly"),
        "B" -> List("Basic", "Bash"),
        "C" -> List("Cobol", "C#"),
        "D" -> List("Dart")
      )
    }
  }
}
