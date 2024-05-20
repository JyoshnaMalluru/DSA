public class Pairs {
    public static void printPairs(int num[]){
        int tp=0;
        for(int i=0;i<num.length;i++){
            int curr = num[i];
            for(int j=i+1;j<num.length;j++){
                System.out.print("("+ curr +","+num[j]+")");
                tp++;
            }
            System.out.println();
        }
        System.out.println("total pairs "+tp);
    }
    //total number of pairs formula = (n(n-1))/2;
    public static void printSubArrays(int num[]){
        // sub arrays: a continuous part of an arrays;
        int ts=0;
        int sum =0;
        int mysum =0;
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for(int i=0;i<num.length;i++){
            for(int j=i;j<num.length;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(num[k]+" ");
                    sum = sum+num[k];
                }
                mysum = sum;
                if(largest<mysum){
                    largest = mysum;
                }
                if(smallest>mysum){
                    smallest = mysum;
                }
                System.out.print("sum is :"+sum);
                sum =0;
                ts++;
                System.out.println();
            }
            System.out.println();
        }
                
                System.out.println("Smallest sum is :"+ smallest);
                System.out.println("largest sum is :"+ largest);
                System.out.println("total subarrays :"+ ts);
    }
        //total number of pairs of subarrays formula = (n(n+1))/2;
// IT IS BRUTE FORCE (BASIC METHOD) BUT IT HAS THE TIME COMPLEXITY OF O(n^3) SO IT CANNOT BE USED.
public static void maxSubArraysSum(int num[]){
    int sum =0;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for(int i=0;i<num.length;i++){
        for(int j=i;j<num.length;j++){
            for(int k=i;k<=j;k++){
                sum+=num[k];
            }
            System.out.println(sum+" ");
            if(sum>max){
                max=sum;
            }
            if(sum<min){
                min=sum;
            }
            sum=0;
        }
    }
    System.out.println("max sum "+ max);
    System.out.println("min sum "+ min);
}
public static void maxSubArraysSumPrefix(int num[]){
    int sum =0;
    int prefix[] =new int[num.length];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    prefix[0]= num[0];
    for(int i=1;i<prefix.length;i++){
            prefix[i]= prefix[i-1]+num[i];
    }
    for(int i=0;i<num.length;i++){
        for(int j=i;j<num.length;j++){
            sum = i==0? prefix[j]: prefix[j]-prefix[i-1];
            if(sum>max){
                max=sum;
            }
            if(sum<min){
                min=sum;
            }
        }
    }
    System.out.println("max sum "+ max);
    System.out.println("min sum "+ min);
}
//SUM OF SUB ARRAYS
public static void kadanes(int num[]){
    int maxSum = Integer.MIN_VALUE;
    int currSum = 0;
    for(int i=0;i<num.length;i++){
        currSum+=num[i];
        if(currSum<0){
            currSum = 0;
        }
        maxSum = Math.max(currSum,maxSum);
    }
    System.out.println("our max sum is :"+ maxSum);
}
public static void kadanesnegative(int num[]){
    int maxSum = Integer.MIN_VALUE;
    int currSum = 0;
    for(int i=0;i<num.length;i++){
        maxSum = Math.max(num[i],maxSum);
    }
    System.out.println("our max sum is :"+ maxSum);
}
    public static void main(String args[]){
    int num[]={-7,-2,-3,-4};
    //int num[] = {7,2,3,4};
    //int num [] = {2,4,6,8,10};
    //int  num[] = {-2,-3,4,-1,-2,1,5,-3};
    //    printPairs(num);
    //    printSubArrays(num);
       //maxSubArraysSum(num);
       //maxSubArraysSumPrefix(num);
      kadanes(num);
      kadanesnegative(num);
    }
}
