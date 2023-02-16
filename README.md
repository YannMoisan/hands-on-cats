# Why

[Cats](https://typelevel.org/cats/) is to Scala what Guava is to Java : a must to know library ! But unfortunately, learning cats is not so easy.


This hand's on focuses on concrete use cases instead of complex theory. The goal is to show that you can use cats to
improve your code and remove some boilerplate.

I've chosen some pieces of code that can benefit from cats. For each, a test suite will help you understand what the code does.

# Read the specifications

```
sbt test
```

# Prepare your project

- add the dependency in `build.sbt`

```
libraryDependencies += "org.typelevel" %% "cats-core" % "2.9.0"
```

- import stuff

# Refactor using Cats

Your mission, if you accept it, is to implement all methods marked as todo using Cats. All the unit tests are provided and you don't need to modify them. When your implementation will be correct, the tests will pass.

Here are some hints if you need them.

## Validation

- replace `Try` with `cats.Validation`

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
