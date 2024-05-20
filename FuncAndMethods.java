public class FuncAndMethods {
    public static float avgOfThree(int a,int b,int c){
       float average = (a+b+c)/3;
       return average;
    }
    public static boolean isEven(int n){
       if(n%2==0){
          return true;
       }
       return false;
    }
    public static boolean isPalindrome(int n){
         int rev =0;
         int num= n;
        while(n>0){
            int lastDigit = n%10;
            rev = (rev*10)+lastDigit;
            n/=10;
        }
        System.out.println(rev);
        if(num==rev){
            return true;
        }
        return false;
    }
    public static void sumOfDigits(int n){
        int sum =0;
        while(n>0){
           int lastDigit = n%10;
           sum = sum+lastDigit;
           n/=10;
        }
        System.out.println(sum);
    }
    public static void main(String args[]){
       //System.out.println(avgOfThree(9,3,3));
       //System.out.println(isEven(6));
       //System.out.println(isPalindrome(127));
       sumOfDigits(123);
    }
}
