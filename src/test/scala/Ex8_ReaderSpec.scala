import Ex8_Reader.Dao
import org.specs2.mutable.Specification

class Ex8_ReaderSpec extends Specification {
  "[vanilla] The service aggregates the result of 3 services" >> {
    "when a dao is injected" >> {
      Ex8_Reader.vanilla.service(new Dao(){}) must_== List("Ahoy", "Ahoy", "Ahoy")
    }
  }
  "[scalaz] The service aggregates the result of 3 services" >> {
    "when a dao is injected" >> {
      Ex8_Reader.scalaz.service(new Dao(){}) must_== List("Ahoy", "Ahoy", "Ahoy")
    }
  }
}
