# Why
[Scalaz](https://github.com/scalaz/scalaz) is to Scala what Guava is to Java : a must to know library ! But unfortunately, learning scalaz is not so easy.


This hand's on focuses on concrete use cases instead of complex theory. The goal is to show that you can use scalaz to
improve your code and remove some boilerplate.

I've chosen some pieces of code that can benefit from scalaz. For each, a test suite will help you understand what the code does.

# Read the specifications

```
sbt test
```

# Prepare your project

Scalaz 7.1 is used, because it's the version that you depend on with Play 2.4/2.5

- add the dependency in `build.sbt`

```
libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.1.5"
```

- import stuff

```
import scalaz._
import Scalaz._
```

# Tricks

- Since scala 2.11.8, the tab completion find methods resulting from an implicit conversion. And scalaz uses a lot of them ! e.g. type `1.show<Tab>` in the REPL

```
@ 1.show
final def show: scalaz.Cord
```

- If you want to find the source of an implicit conversion, use the following code

```
@ import scala.reflect.runtime.universe._
import scala.reflect.runtime.universe._
@ showCode(reify { 1.show  }.tree)
res14: String = "Scalaz.ToShowOps(1)(Scalaz.intInstance).show"
```

# Main symbols - thanks to [reactormonk](https://gist.github.com/reactormonk/8bba396887cfa4d202c62761a1084ab5)

| Symbol  | Explanation             | Hint                                |
|---------|-------------------------|-------------------------------------|
| `\/`    | Right-leaning Either    | Split ways, go one way or the other |
| `-\/`   | Left value of `\/`        | - is on the left side               |
| `\/-`   | Right value  of `\/`      | - is on the right side              |
| `>>=`   | `flatMap`                 | shove result into                   |
| `>>`    | `flatMap(_ => ..)`        | shove into, but ignore the result   |
| `|@|` | Applicatives into Tuple | Scream operator                     |
| `|+|` | Append via Monoid       | + was taken                         |
| `>|`    | `fa.map(_ => b)` | Ignore the content and use a new value. Equivalent to `fa.as(b)` |
| `*>`    | `fa.flatMap(_ => fb)` | Do both effects, left to right, use right value |
| `<*`    | `fa.flatMap(a => fb.map(_ => a))` | Do both effects, left to right, use left value |
| `<=<`   | Alias for `compose` | Left fish |
| `>=>`   | Alias for `andThen` | Right fish |
| `===`   | Type-safe equality check | Really equals |
| `/==`   | Type-safe not-equality check | Slashed equals |
| `?|?`   | Type-safe order comparison | |

[List Of Symbols](https://oss.sonatype.org/service/local/repositories/releases/archive/org/scalaz/scalaz_2.11/7.3.0-M2/scalaz_2.11-7.3.0-M2-javadoc.jar/!/index.html#index.index-_ )

# Refactor using Scalaz

Your mission, if you accept it, is to implement all methods marked as todo using Scalaz. All the unit tests are provided and you don't need to modify them. When your implementation will be correct, the tests will pass.

Here are some hints if you need them.

## Simple

- Step 1 : solve compilation issue
- Step 2 : use scalaz

## TypeSafe

- replace `case class` with scalaz `Tag`

## Either

- replace `Either` with scalaz `\/`

## Validation

- replace `Try` with `scalaz.Validation`

## Monoid

- Hint : Monoid (don't worry, it's such a pedantic word to say a type that you can merge).

```
trait Monoid[F]  { self =>
  def append(f1: F, f2: => F): F
}
```

## Sequence

- Hint : use `Traverse` to transform `F[G[A]]` into `G[F[A]]`

## FutureOption

- Hint : use `OptionT`, a tool for composing monads.

## Reader

- Hint : use a Reader monad, to inject the dependency.

# Some links

- [examples](https://github.com/scalaz/scalaz/tree/series/7.1.x/example/src/main/scala/scalaz/example)
- [learning scalaz](http://www.eed3si9n.com/learning-scalaz/)
- Dead-Simple Dependency Injection : [Video](https://www.youtube.com/watch?v=ZasXwtTRkio) /  [Slides](https://speakerdeck.com/marakana/dead-simple-dependency-injection-in-scala)
- [Video - Scalaz for the Rest of Us at Yelp](https://www.youtube.com/watch?v=kcfIH3GYXMI)
- Scalaz Gateway Drugs [Video](https://www.youtube.com/watch?v=BsC-11Baouw) / [Slides](http://slides.com/bwmcadams/scalaz-gateway-drugs#/)
- [Training material on Scalaz 7 usage](http://www.slideshare.net/mpilquist/scalaz-13068563)
- [Typeclassopedia for scala](http://typeclassopedia.bitbucket.org/)
- [scalaz 102](http://slides.com/coltfrederickson/scalaz-102-2-1#/)
- [roll-your-own-scala](https://meta.plasm.us/posts/2015/07/11/roll-your-own-scala/)
