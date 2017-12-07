package app.views

import scala.io.StdIn

object Prompt {

  def ask(message: String) = StdIn.readLine(message)

  def reply(message: String) = println(message)

  def reply(message: Double) = println(f"Total balance £$message%.2f")

}
