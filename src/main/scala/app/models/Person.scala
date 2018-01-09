package app.models

class Person(name : String, age : Int, val bankAccounts: Seq[BankAccount] = Nil) {

  def this(name: String, age : Int) = this(name, age, List(new SavingsAccount("12345", 0.00)))

  private def years : String = if(age > 1) "years" else "year"

  def speak() : String = {
    if (name == "adam") {
      s"You don't get a hello!"
    } else {
      s"Hello $name, you are $age $years old. \nYou have $totalBalance in your account."
    }
  }

  def totalBalance = bankAccounts.map(_.balance).sum

  def sumAndMultipleBy(f: Double => Double) = bankAccounts.map(x => f(x.balance)).sum

}
