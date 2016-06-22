import scalaz._
import Scalaz._

object Ex_Simple {

  def test[A](a1: A)(a2: A) = println((a1, a2))

  // Fix the compilation issue
  // by uncommenting and modifying only the line below
  // test(Some(42))(None)
  test(42.some)(None)

  // doesn't compile
  //  Main.scala:52: type mismatch;
  //  found   : None.type
  //  required: Some[Int]
}
