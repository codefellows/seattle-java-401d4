import java.util.HashMap;
import java.util.Map;

public class AnimalShelter {
  private Queue<Dog> dogQueue;
  private Queue<Cat> catQueue;
  private Map<Animal, Integer> arrivalOrder;
  private int numAnimalsAdded;


  public AnimalShelter() {
    this.dogQueue = new Queue<>();
    this.catQueue = new Queue<>();
    arrivalOrder = new HashMap<>();
    numAnimalsAdded = 0;
  }

  // overloading: methods with the same name, but different params
  // when we enqueue, we want to keep track of timestamp
  public void enqueue(Dog d) {
    this.dogQueue.enqueue(d);
    this.addAnimal(d);
  }

  public void enqueue(Cat c) {
    this.catQueue.enqueue(c);
    this.addAnimal(c);
  }

  private void addAnimal(Animal a) {
    arrivalOrder.put(a, this.numAnimalsAdded);
    this.numAnimalsAdded ++;
  }

  // public void enqueue(Animal a) {
  //   if (a instanceof Dog) {
  //     this.dogQueue.enqueue((Dog) a);
  //   } else if (a instanceof Cat) {
  //     this.catQueue.enqueue((Cat) a);
  //   } else {
  //     throw new IllegalArgumentException("this shelter only holds dogs and cats");
  //   }
  // }

  public Animal dequeue(String pref) {
    if (pref.equals("dog")) {
      return dogQueue.dequeue();
    } else if (pref.equals("cat")) {
      return catQueue.dequeue();
    } else if (pref.equals("")) {
      if(arrivalOrder.get(dogQueue.peek()) < arrivalOrder.get(catQueue.peek())) {
        return dogQueue.dequeue();
      } else {
        return catQueue.dequeue();
      }
    }
    return null;
  }
}

class Animal {
  public String name;
  

  public Animal(String name) {
    this.name = name;
  }
}
class Dog extends Animal {
  public Dog(String name) {
    super(name);
  }
}

class Cat extends Animal {
  public Cat(String name) {
    super(name);
  }
}
