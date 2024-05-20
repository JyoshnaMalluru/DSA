public class DecToBin {
    public static void dectoBin(int decNum){
        int myNum = decNum;
        int pow = 0;
        int bin = 0;
        while(decNum>0){
            int rem = decNum%2;
            bin = bin +(rem*(int)Math.pow(10,pow));
            pow++;
            decNum=decNum/2;
        }
        System.out.println("BinNum of "+ myNum + " is "+ bin);
    }
    public static void main(String args[]){
        dectoBin(8);
    }
}
