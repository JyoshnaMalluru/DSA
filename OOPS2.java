public class OOPS2 {
    public static void main(String args[]){
        //CONSTRUCTER
        /*Student s1 = new Student("JyoshnaRamkumar");
        System.out.println(s1.name);*/
        Student s1 = new Student();
        s1.marks[0]=10;
        s1.marks[1]=9;
        s1.marks[2]=9;
        /*Student s2 = new Student("Jyoshna"); 
        Student s3 = new Student(18);*/
        Student s2 = new Student(s1);
        s2.password="abcd";
        s1.marks[2]=10;
        for(int i=0;i<3;i++){
            System.out.println(s2.marks[i]);
        }

    }
}
//CONSTRUCTERS
class Student{
    String name;
    int age;
    float percentage;
    String password;
    int marks[];
    void calculatePercentage(int phy, int chem, int math){
        percentage=(phy+chem+math)/3;
    }
    /*Student(String name){
     this.name = name;
    }*/
    //COPY CONSTRUCTER
    //SHALLOW COPY CONSTRUCTER
    /*Student(Student s1){
        marks= new int[3];
        this.marks = s1.marks;
         this.name= s1.name;
         this.age = s1.age;
    }*/
    //DEEP COPY CONSTRUCTER
    Student(Student s1){
        marks= new int[3];
         this.name= s1.name;
         this.age = s1.age;
         for(int i=0;i<3;i++){
            this.marks[i]=s1.marks[i];
         }
        }
    //NON-PARAMETERIZED CONSTRUCTER
    Student(){
        marks=new int[3];
        System.out.println("constructer is called");
    }
    //PARAMETERIZED CONSTRUCTER
    Student(String name){
        this.name=name;
        System.out.println(this.name);
    }
    Student (int age){
        this.age=age;
    }
}
