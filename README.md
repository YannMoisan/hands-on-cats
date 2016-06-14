# Why
[Scalaz](https://github.com/scalaz/scalaz) is to Scala what Guava is to Java : a must known library ! But unfortunately, learning scalaz is not so easy.


This hand's on focuses on concrete use cases instead of complex theory. The goal is to show that you can use scalaz to
improve your code and remove some boilerplate.

I've chosen some pieces of code that can benefit from scalaz. For each, a test suite will help you tu understand what the code do, and test your refactored code

# Read the specifications

```
sbt test
```

# Prepare your project

We will use Scalaz 7.1, because it's the version that you depends on with Play 2.4/2.5

- add the dependency in build.sbt

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

- If you want to find the source of an implicit conversion, use the following

```
@ import scala.reflect.runtime.universe._
import scala.reflect.runtime.universe._
@ showCode(reify { 1.show  }.tree)
res14: String = "Scalaz.ToShowOps(1)(Scalaz.intInstance).show"
```

# Main symbols - thanks to [reactormonk](https://github.com/reactormonk)

| Symbol  | Explanation             | Hint                                |
|---------|-------------------------|-------------------------------------|
| \/      | Right-leaning Either    | Split ways, go one way or the other |
| -\/     | Left value of \/        | - is on the left side               |
| \/-     | Right value  of \/      | - is on the right side              |
| >>=     | flatMap                 | shove result into                   |
| >>      | flatMap(_ => ..)        | shove into, but ignore the result   |
| \|@\|   | Applicatives into Tuple | Scream operator                     |
| \|+\|   | Append via Monoid       | + was taken                         |

[List Of Symbols](https://oss.sonatype.org/service/local/repositories/releases/archive/org/scalaz/scalaz_2.11/7.3.0-M2/scalaz_2.11-7.3.0-M2-javadoc.jar/!/index.html#index.index-_ )

# Refactor

For each snippet, identify the boilerplate and refactor using scalaz. Here are some hints if you need them.

## Simple

- Step 1 : solve compilation issue
- Step 2 : use scalaz

## Validation

- replace `Try` with `scalaz.Validation`
- modify the test to match over a Validation

## Monoid

- modify only the body, not the signature
- Hint : Monoid (don't worry, it's such a pedantic word to say a type that you can merge).

```
trait Monoid[F]  { self =>
  def append(f1: F, f2: => F): F
}
```

## Sequence

- modify only the body, not the signature
- Hint : use `Traverse` to transform `F[G[A]]` into `G[F[A]]`

## FutureOption

- modify only the body, not the signature
- Hint : use `OptionT`, a tool to compose monads.

## Reader

- modify only the body, not the signature
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