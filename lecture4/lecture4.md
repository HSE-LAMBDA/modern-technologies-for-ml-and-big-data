# Scala programming language

## Installation

+ Go to the http://www.scala-lang.org/, download fresh scala.
+ unpack it, include `export PATH="$PATH:<scala home>/bin"` into the `.bashrc` or `.profile` file
+ check if `scala` command works, the output should look like:
```
Welcome to Scala version 2.11.7 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_66).
Type in expressions to have them evaluated.
Type :help for more information.

scala> 
```

## Tutorials

There is a number of scala tutorials:
- [Scala For Java programmers](www.scala-lang.org/docu/files/ScalaTutorial.pdf)
- [A nice tutorial](http://www.tutorialspoint.com/scala/index.htm)
- [Scala tour](http://www.scala-tour.com/#/welcome)
- ...

## Basics
```scala
scala> 1 + 1
res0: Int = 2
```

Everything in scala is an object (class instance in java terms). Similar to the Java, but now even `+` is
a method of a number:

```scala
scala> val x: Int => Int = (1).+ _
x: Int => Int = <function1>
```

To define a constant value:
```scala
scala> val x = 1 + 1
x: Int = 2
```
There is a variables in scala (denoted by `var` keyword), but, please, don't use them unless you are a scala
guru and you are too strong for mutability to corrupt you.

In scala everything has fixed type ().
To define constant of type `Int`:
```scala
val x: Int = 1 + 1
```

Usually you can leave the type declaration, since compilier is smart enough to understand the type of the expression.

To define a function:
```scala
scala> def plus(x: Int, y: Int): Int = { x + y }
plus: (x: Int, y: Int)Int

scala> plus(1, 10)
res0: Int = 11
```

**Note, there is no `return` operator. The result of the last expression will be the result of the function**

To define an anonimous function:

```scala
scala> val plus = { (x : Int, y: Int) => x + y }
plus: (Int, Int) => Int = <function2>

scala> plus(1, 2)
res2: Int = 3
```
