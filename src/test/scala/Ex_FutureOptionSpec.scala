import org.specs2.concurrent.ExecutionEnv

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class Ex_FutureOptionSpec(implicit ee: ExecutionEnv) extends org.specs2.mutable.Specification {
  val futureSome = Future(Some(1))
  val futureNone = Future(None)

  "[vanilla] flatMap on Future[Option[Int]]" >> {
    "should sum integers when both option are defined" >> {
      Ex_FutureOption.vanilla.flatMap(futureSome, futureSome) must be_==(Some(2)).await
    }
    "should return None when the first option is None" >> {
      Ex_FutureOption.vanilla.flatMap(futureNone, futureSome) must be_==(None).await
    }
    "should return None when the second option is None" >> {
      Ex_FutureOption.vanilla.flatMap(futureSome, futureNone) must be_==(None).await
    }
    "should return None when both option are None" >> {
      Ex_FutureOption.vanilla.flatMap(futureNone, futureNone) must be_==(None).await
    }
  }

  "[scalaz] flatMap on Future[Option[Int]]" >> {
    "should sum integers when both option are defined" >> {
      Ex_FutureOption._scalaz.flatMap(futureSome, futureSome) must be_==(Some(2)).await
    }
    "should return None when the first option is None" >> {
      Ex_FutureOption._scalaz.flatMap(futureNone, futureSome) must be_==(None).await
    }
    "should return None when the second option is None" >> {
      Ex_FutureOption._scalaz.flatMap(futureSome, futureNone) must be_==(None).await
    }
    "should return None when both option are None" >> {
      Ex_FutureOption._scalaz.flatMap(futureNone, futureNone) must be_==(None).await
    }
  }

  "[cats] flatMap on Future[Option[Int]]" >> {
    "should sum integers when both option are defined" >> {
      Ex_FutureOption._cats.flatMap(futureSome, futureSome) must be_==(Some(2)).await
    }
    "should return None when the first option is None" >> {
      Ex_FutureOption._cats.flatMap(futureNone, futureSome) must be_==(None).await
    }
    "should return None when the second option is None" >> {
      Ex_FutureOption._cats.flatMap(futureSome, futureNone) must be_==(None).await
    }
    "should return None when both option are None" >> {
      Ex_FutureOption._cats.flatMap(futureNone, futureNone) must be_==(None).await
    }
  }

}
