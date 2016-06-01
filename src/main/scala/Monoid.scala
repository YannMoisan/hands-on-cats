object Monoid {
  def merge(m1 : Map[String, Int], m2: Map[String, Int]) : Map[String, Int] = {
    val keys = m1.keys ++ m2.keys
    keys.map(k => k -> (m1.getOrElse(k, 0) + m2.getOrElse(k, 0))).toMap
  }
}
