package pis.chap20.m06_00

class Food
trait Animal {
  def eat(food:Food)
}

class Grass extends Food
class Cow extends Animal {
  
  def eat(food:Food) {
    Console.println("냠냠 food" + food)
  }
  
  // 다음 구문을 타입 검사에서 통과시킨다면?
  // covariant 비스무리
  // ArrayStoreException과 유사한 상황 발생
  // def eat(grass:Grass)

}