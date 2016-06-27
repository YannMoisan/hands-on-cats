import Ex_Reader.Dao
import org.specs2.mutable.Specification

class Ex_ReaderSpec extends Specification {
  "[vanilla] The service aggregates the result of 3 services" >> {
    "when a dao is injected" >> {
      Ex_Reader.vanilla.service(new Dao(){}) must_== List("Ahoy", "Ahoy", "Ahoy")
    }
  }
  "[scalaz] The service aggregates the result of 3 services" >> {
    "when a dao is injected" >> {
      Ex_Reader._scalaz.service(new Dao(){}) must_== List("Ahoy", "Ahoy", "Ahoy")
    }
  }
  "[cats] The service aggregates the result of 3 services" >> {
    "when a dao is injected" >> {
      Ex_Reader._cats.service(new Dao(){}) must_== List("Ahoy", "Ahoy", "Ahoy")
    }
  }
}
