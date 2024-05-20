//INHERITANCE
public class OOPS3 {
    public static void main(String args[]){
    Fish tuna = new Fish();
    tuna.swim();
    tuna.breathe();
    /*Bird sparrow = new Bird();
    sparrow.fly();
    sparrow.breathe();*/
    /*Dog doll = new Dog();
    doll.eat();
    doll.legs=4;
    System.out.println(doll.legs);*/
    // Tuna t1 = new Tuna();
    // t1.eat();
    // Peacock p1 = new Peacock();
    // p1.feathers();
}
}
//BASE CLASS / PARENT CLASS
class Animal{
    String colour;
    void eat(){
        System.out.println("eats");
    }
    void breathe(){
        System.out.println("breathes");
    }
}
class Bird extends Animal{
    void fly(){
        System.out.println("fly");
    }
}
class Peacock extends Bird{
    void feathers(){
        System.out.println("feathers");
    }
}
class Mammal extends Animal{
    int legs;
    void walk(){
        System.out.println("walks");
    }
}
class Dog extends Mammal{
    String breed;
}
class Cat extends Mammal{
    void sound(){
        System.out.println("meow");
    }
}
//derived class / child class
class Fish extends Animal{
    int fins;
    void swim(){
        System.out.println("swims in water");
    }
}
class Tuna extends Fish{
    void type(){
        System.out.println("salt water fish");
    }
}
class Shark extends Fish{
    void size(){
        System.out.println("big fish");
    }
}
