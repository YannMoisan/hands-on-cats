class Ex_FoldSpec extends org.specs2.mutable.Specification {
  "[vanilla] fold" >> {
    "should compute count and max with only one traversal" >> {
      Ex_Fold.vanilla.fold(List(1, 2, 3, 4)) must_== (4, 10)
    }
  }

  "[cats] fold" >> {
    "should compute count and max with only one traversal" >> {
      Ex_Fold._cats.fold(List(1, 2, 3, 4)) must_== (4, 10)
    }
  }
}
