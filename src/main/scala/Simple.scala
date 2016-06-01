object Simple {
  def test[A](a1: A)(a2: A) = println((a1, a2))

  // Fix the compilation issue
  // test(Some(42))(None)

  // doesn't compile
  //  Main.scala:52: type mismatch;
  //  found   : None.type
  //  required: Some[Int]
}
