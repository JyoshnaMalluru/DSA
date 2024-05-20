public class OOPS {
    public static void main(String args[]){
        // Pen p1 = new Pen();
        // p1.changeColour("Blue");
        // System.out.println(p1.colour);
        // p1.changeTip(5);
        // System.out.println(p1.tip);
        // p1.colour="yellow";
        // System.out.println(p1.colour);
        //GETTERS&&SETTERS
        Pen p1 = new Pen();
        p1.changeColour("Blue");
        System.out.println(p1.getColour());
        p1.changeTip(5);
        System.out.println(p1.getTip());
        p1.changeColour("yellow");
        System.out.println(p1.getColour());

        //ACCESS MODIFIERS
        // BankAccount myAcc = new BankAccount();
        // myAcc.userName ="JyoshnaRamkumar";
        // System.out.println(myAcc.userName);
        // myAcc.setPassword("JR1595");
        //System.out.println(myAcc.password);
        
    }
}
//Access Modifiers
class BankAccount{
    public String userName;
    private String password;
    public void setPassword(String Pwd){
        password = Pwd;
    }
}
class Pen{
    // String colour;
    // int tip;
    // void changeColour(String newColour){
    //     colour = newColour;
    // }
    // void changeTip(int newTip){
    //     tip = newTip;
    // }
    //GETTERS&&SETTERS
    private String colour;
     private int tip;
    String getColour(){
        return this.colour;
    }
    int getTip(){
       return this.tip;
    }
    void changeColour(String newColour){
        this.colour = newColour;
    }
    void changeTip(int newTip){
        this.tip = newTip;
}
}


//}

