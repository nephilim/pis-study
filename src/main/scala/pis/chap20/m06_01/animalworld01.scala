package pis.chap20.m06_01

class Food

trait Animal {
  type EdibleFood <: Food
  def eat(food:EdibleFood)
}

class Grass extends Food

class Cow extends Animal {
  type EdibleFood = Grass
  def eat(food:EdibleFood) {
    Console.println("냠냠 food" + food)
  }
  
}


