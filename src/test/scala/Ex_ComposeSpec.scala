class Ex_ComposeSpec extends org.specs2.mutable.Specification {
  "[vanilla] compose" >> {
    "should double the inner value" >> {
      Ex_Compose.vanilla.double(List(Some(1), None, Some(2))) must_== List(Some(2), None, Some(4))
    }
  }

  "[cats] compose" >> {
    "should double the inner value" >> {
      Ex_Compose._cats.double(List(Some(1), None, Some(2))) must_== List(Some(2), None, Some(4))
    }
  }
}
