public class OOPS5 {
    public static void main(String args[]){
        //INTERFACES
    //  Queen q= new Queen();
    //  q.moves();
     Bear B = new Bear();
     B.eats();
    /*  Student s1 = new Student();
     s1.SchoolName="Sri Vivekananda";
     Student s2 = new Student();
     System.out.println(s2.SchoolName);
      Student s3= new Student();
      s3.SchoolName="Narayana";
    System.out.println(s3.SchoolName);*/     
    //Horse h = new Horse();
    
    }
}
class Animal{
    Animal (){
        System.out.println("Animal constructer is called");
    }
}
class Horse extends Animal{
    Horse(){
        super();
        System.out.println("Horse constructer is called");
    }
}
class Student{
    static int returnPercentage(int phy,int mat,int chem){
        return (phy+chem+mat)/3;
    }
    String name;
     int roll ;
     static String SchoolName;
     void setName(String name){
        this.name = name;
     }
     String getName(){
         return this.name;
     }
}
//INTERFACES
interface Herbivore{
void eats();
}
interface Carnivore{
void eats();
}
class Bear implements Herbivore,Carnivore{
public void eats(){
    System.out.println("eats both plants and animals");
}
}
interface ChessPlayer{
    void moves();
}
class Queen implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left , right, diagonal");
    }
}
class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left , right");
    }
}