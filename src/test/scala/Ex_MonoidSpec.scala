class Ex_MonoidSpec extends org.specs2.mutable.Specification {

  val transactions1 = Map(
    "Account 1" -> 10,
    "Account 2" -> 20,
    "Account 3" -> 30)

  val transactions2 = Map(
    "Account 1" -> 5,
    "Account 3" -> 7,
    "Account 4" -> 42)

  val transactionsMerged = Map(
    "Account 1" -> 15,
    "Account 2" -> 20,
    "Account 3" -> 37,
    "Account 4" -> 42
  )

  val dict1 = Map(
    "A" -> List("Ada"),
    "B" -> List("Basic", "Bash"),
    "C" -> List("Cobol"))

  val dict2 = Map(
    "A" -> List("Assembly"),
    "C" -> List("C#"),
    "D" -> List("Dart"))

  val dictMerged = Map(
    "A" -> List("Ada", "Assembly"),
    "B" -> List("Basic", "Bash"),
    "C" -> List("Cobol", "C#"),
    "D" -> List("Dart")
  )

  "[vanilla] merge two maps of Int" >> {
    "should work when maps don't contains same keys" >> {
      Ex_Monoid.vanilla.merge(transactions1, transactions2) must_== transactionsMerged
    }
  }
  "[vanilla] merge two dictionaries : maps of List[String]" >> {
    "should work when maps don't contains same keys" >> {
      Ex_Monoid.vanilla.mergeEx2(dict1, dict2) must_== dictMerged
    }
  }
  "[scalaz] merge two maps of Int" >> {
    "should work when maps don't contains same keys" >> {
      Ex_Monoid._scalaz.merge(transactions1, transactions2) must_== transactionsMerged
    }
  }
  "[scalaz] merge two dictionaries : maps of List[String]" >> {
    "should work when maps don't contains same keys" >> {
      Ex_Monoid._scalaz.mergeEx2(dict1, dict2) must_== dictMerged
    }
  }
  "[cats] merge two maps of Int" >> {
    "should work when maps don't contains same keys" >> {
      Ex_Monoid._cats.merge(transactions1, transactions2) must_== transactionsMerged
    }
  }
  "[cats] merge two dictionaries : maps of List[String]" >> {
    "should work when maps don't contains same keys" >> {
      Ex_Monoid._cats.mergeEx2(dict1, dict2) must_== dictMerged
    }
  }
}
