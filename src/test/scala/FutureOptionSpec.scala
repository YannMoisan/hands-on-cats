import org.specs2.concurrent.ExecutionEnv

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class FutureOptionSpec(implicit ee: ExecutionEnv) extends org.specs2.mutable.Specification {
  "flatMap on Future[Option[Int]]" >> {
    val futureSome = Future(Some(1))
    val futureNone = Future(None)

    "should sum integers when both option are defined" >> {
      FutureOption.flatMap(futureSome, futureSome) must be_==(Some(2)).await
    }
    "should return None when the first option is None" >> {
      FutureOption.flatMap(futureNone, futureSome) must be_==(None).await
    }
    "should return None when the second option is None" >> {
      FutureOption.flatMap(futureSome, futureNone) must be_==(None).await
    }
    "should return None when both option are None" >> {
      FutureOption.flatMap(futureNone, futureNone) must be_==(None).await
    }
  }
}
