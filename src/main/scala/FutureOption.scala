import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object FutureOption {
  // def findAmountById(id: String) : Future[Option[Int]]

  def flatMap(fo1: Future[Option[Int]], fo2 : Future[Option[Int]]) : Future[Option[Int]] = {
    for {
      o1 <- fo1
      o2 <- fo2
    } yield {
      for {
        i1 <- o1
        i2 <- o2
      } yield i1 + i2
    }
  }

}
