package pis.chap20.m06_02

class Food

trait Animal[T <: Food] {
  def eat(food:T)
}

class Grass extends Food

class Cow extends Animal[Grass] {
  def eat(grass:Grass) {
    Console.println("냠냠 풀:" + grass)
  }
}

