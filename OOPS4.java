public class OOPS4 {
    public static void main(String args[]){
        //Mustang myHorse = new Mustang();
        //Animal->Horse->Mustang
        //abstraction
        // Horse h= new Horse();
        // h.walk();
        // System.out.println(h.colour);
        // h.changeColour();
        //METHOD OVERRIDING
        Deer d = new Deer();
        d.eat();
        //METHOD OVERLOADING
        // Calculator calc = new Calculator();
        // System.out.println(calc.sum(1,2));
        // System.out.println(calc.sum(1,2,3));
        // System.out.println(calc.sum((float)1.5,(float)2.5));
}
}
//METHOD OVERRIDING
abstract class Animal{
    String colour;
    Animal() {
        System.out.println("Animal constructer is called");
         //colour = "brown";
    }
    void eat(){
        System.out.println("eats");
    }
    //abstraction
    abstract void walk();
}
class Horse extends Animal{
    Horse(){
        System.out.println("Horse constructer is called");
    }
    void changeColour(){
        colour="dark brown";
    }
    void walk(){
        System.out.println("walks on 4 legs");
    }
}
class Mustand extends Horse{
    Mustang(){
        System.out.println("Mustang constructer is called");
    }
}
class Chicken extends Animal{
     void changeColour(){
        colour="yellow";
    }
    void walk(){
        System.out.println("walks on 2 legs");
    }
}

class Deer extends Animal{
    void eat(){
        System.out.println("eats grass");
    }
}
//METHOD OVERLOADING
class Calculator{
    int sum(int a,int b){
        return a+b;
    }
    int sum(int a,int b,int c){
        return a+b+c;
    }
    float sum(float a,float b){
        return a+b;
    }
}
