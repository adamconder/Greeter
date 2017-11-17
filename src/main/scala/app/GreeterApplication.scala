package app

import scala.io.StdIn

object Prompt {

  def ask(message: String) = StdIn.readLine(message)

}

trait Talking {

  protected def sayHello : String

}

trait English extends Talking {
  override protected def sayHello: String = "Hello"
}

trait French extends Talking {
  override protected def sayHello: String = "Salut"
}

abstract class Person(name : String) {
  this : Talking =>

  def speak() : String = {
    if (name.toLowerCase.contains("adam")) {
      s"You don't get a hello!"
    } else {
      s"$sayHello $name"
    }
  }

}

class Tutor(name : String) extends Person(name) with English

object GreeterApplication extends App {
  val name = Prompt.ask("What is your name? ")
  val person = new Tutor(name)
  println(person.speak())
}
