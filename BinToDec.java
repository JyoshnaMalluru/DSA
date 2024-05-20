public class BinToDec {
    public static void binToDec(int binNum){
        int myNum = binNum;
        int pow = 0;
        int dec = 0;
        while(binNum>0){
        int lastDigit = binNum%10;
        dec = dec +(lastDigit *(int) Math.pow(2,pow));
        pow++;
        binNum = binNum/10;
        }
        System.out.println("decimal of "+ myNum + " is "+ dec );
    }
    public static void main(String args[]){
        binToDec(111);
    }
}
