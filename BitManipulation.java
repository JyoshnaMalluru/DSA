import java.util.*;
public class BitManipulation {
    public static void evenOrOdd(int n){
        int bitMask = 1;
        if((n&bitMask)==0){
            System.out.println("Even Number");
        }else{
            System.out.println("Odd Number");
        }
    }
    public static int getIthBit(int n,int i){
        int bitMask = 1<<i;
        if((n&bitMask)==0){
          return 0;
        }else{
            return 1;
        }
    }
    public static int setIthBit(int n ,int i){
        int bitMask = 1<<i;
        return n|bitMask;
    }
    public static int clearBit(int n,int i){
        int bitMask =~(1<<i);
        return n&bitMask;
    }
    public static int updateBit(int n,int i,int newBit){
        n = clearBit(n, newBit);
        int bitMask = 1<<i;
        return n|bitMask;
    }
    public static int clearIBits(int n,int i){
        int bitMask = ~(0)<<i;
        return n&bitMask;
    }
    public static int clearBitsInRange(int n,int i,int j){
        int a = ((~0)<<(j+1));
        int b = ((1<<i)-1);
        int bitMask=a|b;
        return n&bitMask;
    }
    public static boolean isPowerOfTwo(int n){
        return(n&(n-1))==0;
    }
    public static int setBits(int n){
        int count =0;
        while(n>0){
            if((n&1)!=0){
                count++;
            }
            n=n>>1;
        }
        return count;
    }
    public static int fastExpo(int a,int n){
        int ans=1;
        while(n>0){
            if((n&1)!=0){
                ans= a*ans;
            }
            a=a*a;
            n=n>>1;
        }
        return ans;
    }
    public static void main(String args[]){
        
        //  System.out.println(5 & 6);
        //  System.out.println(5 | 6);
        //  System.out.println(5 ^ 6);
        //  System.out.println(~5);
        //  System.out.println(5<<2);
        //  System.out.println(6>>1);
        //  evenOrOdd(5);
        //  evenOrOdd(10);
         System.out.println(getIthBit(5, 2));
         System.out.println(setIthBit(10, 2));
         System.out.println(clearBit(10, 3));
         System.out.println(updateBit(10,2,2));
         //System.out.println(clearIBits(15,2));
         //System.out.println(clearBitsInRange(10,2,4));
        // System.out.println(isPowerOfTwo(16));
        //System.out.println(setBits(15));
        //System.out.println(fastExpo(3, 5));
    }
}