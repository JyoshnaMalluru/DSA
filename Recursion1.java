public class Recursion1 {
    public static void printDec(int n){//TIME COMPLEXITY O(n)
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.println(n+" ");
        printDec(n-1);
    }
    public static void printInc(int n){//TIME COMPLEXITY O(n)
        if(n==1){
            System.out.println(n);
            return;
        }
        printInc(n-1);
        System.out.println(n+" ");
    }
    public static int factorial(int n){//TIME COMPLEXITY O(n)
        if(n==0){
            return 1;
        }
        int fn = n*factorial(n-1);
        return fn;
    }
    public static int sum(int n){
        if(n==1){
            return 1;
        }
        int sumA = n+sum(n-1);
        return sumA;
    }
    public static boolean isSorted(int arr[],int i){//TIME COMPLEXITY O(n)
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr,i+1);
    }
    public static int firstOccurrence(int arr[],int key,int i){//TIME COMPLEXITY O(n)
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return firstOccurrence(arr, key, i+1);
    }
    public static int lastOccurrence(int arr[],int key,int i){//TIME COMPLEXITY O(n)
        if(i==arr.length){
            return -1;
        }
        int isFound =lastOccurrence(arr, key, i+1);
        if(arr[i]==key && isFound==-1){
            return i;
        }
        return isFound;
    }
    public static int powX(int x,int n){//TIME COMPLEXITY O(n)
        if(n==0){
            return 1;
        }
        int Xnm1 = powX(x,n-1);
        int xn = x*Xnm1;
        return xn;
        // return x*powX(x,n-1);
    }
    public static int optimisedPower(int x,int n){//TIME COMPLEXITY O(log n)
        if(n==0){
            return 1;
        }
        int halfPower =optimisedPower(x, n/2);
        int xpown =halfPower *halfPower;
        if(n%2!=0){
            xpown = x*xpown;
        }
        return xpown;
    }
    public static int tilingProblem(int n){//2*n floorlength
        if(n==0||n==1){
            return 1;
        }
        //vertical
        int fnm1 = tilingProblem(n-1);
        //horizontal
        int fnm2 = tilingProblem(n-2);
        return fnm1+fnm2;
        // return tilingProblem(n-1)+tilingProblem(n-2);;
    }
    public static void removeDuplicates(String str,int idx,StringBuilder newStr,boolean map[]){
        if(idx==str.length()){
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(idx);
        if(map[currChar-'a']==true){
            removeDuplicates(str, idx+1, newStr, map);
        }else{
            map[currChar-'a']=true;
            removeDuplicates(str, idx+1, newStr.append(str.charAt(idx)), map);
        }
    }
    public static int friendsPairing(int n){
        if(n==1||n==2){
            return n;
        }
        //choice
        //single
        int fnm1 = friendsPairing(n-1);
        //pairs
        int fnm2 = friendsPairing(n-2);
        int pairWays = (n-1)*fnm2;
        int totalWays = fnm1+pairWays;
        return totalWays;
        //return friendsPairing(n-1)+(n-1)*friendsPairing(n-2);
    }
    public static void printBinaryStrings(int n,int lastPlace,String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        printBinaryStrings(n-1, 0, str+"0");
        if(lastPlace==0){
            printBinaryStrings(n-1, 1, str+"1");
        }
    }
    public static int fabinocci(int n){
        if(n==0||n==1){
            return n;
        }
        int fb1=fabinocci(n-1);
        int fb2=fabinocci(n-2);
        int fn = fb1+fb2;
        return fn;
    } 


    //ASSIGNMENT PROBLEMS
    public static void occurrenceOfN(int arr[],int key,int idx){//O(n)
      if(idx==arr.length){
         return;
      }
      if(arr[idx]==key){
        System.out.print(idx+" ");
      }
      occurrenceOfN(arr, key, idx+1);
    }
    public static int lengthOfString(String str){
        if(str.length()==0){
            return 0;
        }
        return lengthOfString(str.substring(1 ))+1;
    }
    public static void towerOfHanoi(int n,String src,String helper , String dest){
        if(n==1){
         System.out.println("transfer "+n+" disc from "+src+" to "+dest);
         return;
        }
        towerOfHanoi(n-1, src, dest, helper);
        System.out.println("transfer "+n+" disc from "+src+" to "+dest);
        towerOfHanoi(n-1, helper, src, dest);
    }
    static String words[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
    public static void numToWords(int n){
       if(n==0){
        return;
       }
       int lastDigit = n%10;
        numToWords( n/10);
        System.out.print(words[lastDigit]+" ");

    }
    public static void main(String args[]){
        //int n=5;
        //printDec(n);
        //printInc(n);
        //System.out.println(factorial(n));
        //System.out.println(sum(n));
        //int arr []={1,2,3,5,4,5};
        //System.out.println(isSorted(arr, 0));
        //System.out.println(firstOccurrence(arr,4,0));
        //System.out.println(lastOccurrence(arr, 5, 0));
        //System.out.println(powX(2,5));
        //System.out.println(optimisedPower(2, 10));
        //System.out.println(tilingProblem(4));
        //String str = "appnnacolllege";
       // removeDuplicates(str, 0, new StringBuilder(), new boolean[26]);
        //System.out.println(friendsPairing(3));
        //printBinaryStrings(3,0,"");
        //System.out.println(fabinocci(7));
        /*int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        int key = 2;
        occurrenceOfN(arr,key,0);*/
        // String str = "JyoshnaRamkumar";
        // System.out.println(lengthOfString(str));
        towerOfHanoi(3, "A", "B", "C");
        //numToWords(1234);
    }
}
