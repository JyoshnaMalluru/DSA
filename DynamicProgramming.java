import java.util.*;
public class DynamicProgramming {
    //Recursion
    public static int fibonacci(int n){
        if(n==0 || n==1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    //MEMOIZATION
    public static int fibinocci(int n, int fab[]){//O(n)
        if(n==0 || n==1){
            return n;
        }
        if(fab[n] != 0){
            return fab[n];
        }
        fab[n]= fibinocci(n-1, fab)+fibinocci(n-2, fab);
        return fab[n];
    }

    //TABULATION
    public static int fibTabulation(int n){
        if(n<=1){
            return n;
        }
        int dp[]= new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    //CLIMBING STAIRS - RECURSION
    public static int climbingStairs(int n){//O(2^n)
        if(n==0){
            return 1;
        }if(n<0){
            return 0;
        }
        return climbingStairs(n-1)+climbingStairs(n-2);
    }

    //CLIMBING STAIRS - MEMOIZATION
    public static int climbingStairsMemo(int n, int ways[]){//O(n)
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(ways[n] != -1){
            return ways[n];
        }
        ways[n]= climbingStairsMemo(n-1,ways)+climbingStairsMemo(n-2,ways);
        return ways[n];
    }

     //CLIMBING STAIRS - TABULATION
     public static int countWaysTab(int n){//O(n)
        int dp[] = new int[n+1];
        dp[0]= 1;
        for(int i=1;i<=n;i++){
          if(i==1){
            dp[i]= dp[i-1];
          }else{
            dp[i]= dp[i-1]+dp[i-2];
          }
        }
        return dp[n];
     }

     //0-1 knapsack recursion
     public static int knapsack(int val[], int wt[], int W, int n){//O(2^n)
        if(W==0 || n==0){
            return 0;
        }
          if(wt[n-1]<=W){
            //include
           int ans1 = val[n-1]+knapsack(val, wt, W-wt[n-1], n-1);
            //exclude
            int ans2 = knapsack(val, wt, W, n-1);
            return Math.max(ans1, ans2);
          }else{
            return knapsack(val, wt, W, n-1);
          }
     }

     //0-1 knapsack --MEMOIZATION
     public static int knapsack2(int val[], int wt[], int W, int n,int dp[][]){//O(n*W)
        if(W==0 || n ==0){
            return 0;
        }
        if(dp[n][W] != -1){
            return dp[n][W];
        }
          if(wt[n-1]<=W){
            //include
           int ans1 = val[n-1]+knapsack2(val, wt, W-wt[n-1], n-1,dp);
            //exclude
            int ans2 = knapsack2(val, wt, W, n-1,dp);
            dp[n][W]=Math.max(ans1, ans2);
            return dp[n][W];
          }else{
            dp[n][W] =knapsack2(val, wt, W, n-1,dp);
            return dp[n][W];
          }
     }


      //0-1 knapsack -- TABULATION
     public static void print(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
     }
    
     public static int knapsack3(int val[], int wt[], int W ){
        int n= val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j] =0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
               int v = val[i-1];
               int w = wt[i-1];
               if(w<=j){
                int incProfit = v+dp[i-1][j-w];
                int exProfit = dp[i-1][j];
                dp[i][j]= Math.max(incProfit, exProfit);
               }else{
                dp[i][j]= dp[i-1][j];
               }
            }
        }
        print(dp);
        return dp[n][W];
     }
     // tabulation - UNBOUNDED KNAPSNACK
     public static int unboundedKnapsack(int val[],int wt[],int W){
        int n = val.length;
        int dp [][] = new int[n+1][W+1];

        for(int i=0;i<n+1;i++){
            dp[i][0] = 0;
        }

        for(int i=0;i<W+1;i++){
            dp[0][i] = 0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(wt[i-1]<=j){
                    dp[i][j]=Math.max(val[i-1]+dp[i][j-wt[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][W];

     }

     //targetsum - TABULATION
     public static void print(boolean dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
     }
     public static boolean targetsum(int arr[],int sum){//O(n*sum)
        int n= arr.length;
        boolean dp[][]= new boolean[n+1][sum+1];
        //i=items && j= targetsum
        for(int i=0;i<n+1;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                int v = arr[i-1];
                //include
                if(v<=j && dp[i-1][j-v] == true){
                    dp[i][j] = true;
                }else if(dp[i-1][j]==true){
                     //exclude
                     dp[i][j] = true;
                }
               
            }
        }
        print(dp);
        return dp[n][sum];
     }

     //COIN CHANGE - TABULATION  ----O(n*sum)
     public static int coinChange(int coins[], int sum){
        int n = coins.length;
        int dp[][] = new int [n+1][sum+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<sum+1;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(coins[i-1]<=j){
                    dp[i][j]= dp[i][j-coins[i-1]]+dp[i-1][j];
                }else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][sum];
     }

     //ROD CUTTING
     public static int rodCutting(int length[],int price[], int totalRod){
        int n = price.length;
        int dp[][] = new int[n+1][totalRod+1];

        for(int i=0;i<n+1;i++){
            for(int j=0;j<totalRod+1;j++){
                if(i==0|| j==0){
                    dp[i][j] =0;
                }
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<totalRod+1;j++){
                if(length[i-1]<=j){
                  dp[i][j] = Math.max(price[i-1]+dp[i][j-length[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j] =dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][totalRod];
     }

     //LONGEST COMMON SUBSEQUENCE LCS -- RECURSION
     public static int lcSubsequence(String str1,String str2,int n,int m){
         if(n == 0 || m == 0){
            return 0;
         }

         if(str1.charAt(n - 1) == str2.charAt(m-1)){
            return lcSubsequence(str1, str2, n-1, m-1)+1;
         }else{
            int ans1 = lcSubsequence(str1, str2, n-1, m);
            int ans2 = lcSubsequence(str1, str2, n, m-1);
            return Math.max(ans1,ans2);
         }
     }

     //LCS--MEMOIZATION
     public static int lcsMemoization(String str1,String str2,int n,int m,int dp[][]){{//O(n*m)
        if(n == 0 || m == 0){
           return 0;
        }

        if(dp[n][m] != -1){
            return dp[n][m];
        }
        if(str1.charAt(n - 1) == str2.charAt(m-1)){
           return dp[n][m]= lcsMemoization(str1, str2, n-1, m-1,dp)+1;
        }else{
           int ans1 = lcsMemoization(str1, str2, n-1, m,dp);
           int ans2 = lcsMemoization(str1, str2, n, m-1,dp);
           return dp[n][m]= Math.max(ans1,ans2);
        }
    }
     }
    //LCS ---TABULATION
    public static int lcsTabulation(String str1,String str2) {//O(n*m)
        int n = str1.length();
        int m = str2.length();
        
        int dp[][] = new int [n+1][m+1];
        //initialization
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0){
                dp[i][j]=0;
                }
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]= dp[i-1][j-1]+1;
                }else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }
     
    //LONGEST COMMON SUBSTRING
    public static int longestCommonSubstring(String str1, String str2){
        int n= str1.length();
        int m = str2.length();
        int ans =0;
        int dp[][] = new int[n+1][m+1];
        
        for(int i=0;i<n+1;i++){
           dp[i][0] = 0;
        }
        for(int j=0;j<m+1;j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    ans = Math.max(ans,dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        print(dp);
        return ans;
    }
     //Longest Increasing Subseqence
    //Longest Common Subsequence
    public static int lcs(int arr1[],int arr2[]){
        int n =  arr1.length;
        int m = arr2.length;
        int dp[][] = new int[n+1][m+1];

        for(int i=0;i<n+1;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<m+1;j++){
            dp[0][j] = 0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(arr1[i-1]==arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static int lis(int arr1[]){//O(n*m)
       HashSet<Integer> set = new HashSet<>();
       for(int i=0;i<arr1.length;i++){
        set.add(arr1[i]);
       }
       int arr2[] = new int[set.size()];
       int i=0;
       for (int num : set) {
        arr2[i]= num;
        i++;
       }
       Arrays.sort(arr2);
       return lcs(arr1,arr2);
    }

    //EDIT DISTANCE
    public static int editDistance(String str1,String str2){{//O(n*m)
        int n= str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0){
                    dp[i][j]= j;
                }
                if(j==0){
                    dp[i][j]=i;
                }
            }
        }

        //bottom up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    int add = dp[i][j-1]+1;
                    int del = dp[i-1][j]+1;
                    int rep = dp[i-1][j-1]+1;
                    dp[i][j] = Math.min(add,Math.min(del,rep));
                }
            }
        }
        return dp[n][m];
    }
    }
    //STRING CONVERSION
    public static int longestCommonSubsequence(String str1, String str2){
        int m = str1.length();
        int n = str2.length();
        if(m==0 || n==0){
            return 0;
        }
        int dp[][] = new int[m+1][n+1];
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j]=Math.max(ans1,ans2);
                }
            }
        }
        return dp[m][n];
    }
    public static int stringConversion(String str1, String str2){
        int lcsVal =longestCommonSubsequence(str1,str2);
        int delVal = str1.length()-lcsVal;
        int addVal = str2.length()-lcsVal;
        int totalSteps = delVal+addVal;
        return totalSteps;
    }

    //WILD CARD MATCHING
    public static boolean wildcardMatching(String s,String p){
        int n = s.length();
        int m = p.length();

        boolean dp[][] = new boolean[n+1][m+1];

        //initialize
        dp[0][0] = true;

        for(int i=1;i<n+1;i++){
            dp[i][0] =false;
        }
        for(int j=1;j<m+1;j++){
            if(p.charAt(j-1)== '*'){
                dp[0][j]=dp[0][j-1];
            }
        }

        //bottom up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1) =='?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }

    //CATALAN NUMBER
    public static int catalanRec(int n){
        if(n==0 || n==1){
            return 1;
        }
        int ans = 0;
        for(int i=0;i<=n-1;i++){
          ans += catalanRec(i)*catalanRec(n-i-1);
        }
        return ans;
    }

    public static int catalanMem(int n,int dp[]){
        if(n==0 || n==1){
            return 1;
        }
        int ans =0;
        if(dp[n] != -1){
            return dp[n];
        }
        for(int i=0;i<n;i++){
            ans+=catalanMem(i,dp)*catalanMem(n-i-1, dp);
        }
        return dp[n] = ans;
    }

    public static int catlanTab(int n){//O(n^2)
        int dp [] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
              dp[i] +=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }

    //COUNT BST
    public static int countBst(int n){//O(n^2)
        int dp[] = new int[n+1];
        dp[0]= 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                int left = dp[j];
                int right = dp[i-j-1];
                dp[i] += left*right;
            }
        }
        return dp[n];
    }

    //MOUNTAIN RANGES
    public static int mountainRanges(int n){//O(n^2)
        int dp[] = new int[n+1];
        dp[0]= 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                int inside = dp[j];
                int outside = dp[i-j-1];
                dp[i] += inside * outside;
            }
        }
        return dp[n];
     
    }

    //MATRIX CHAIN MULTIPLICATION
    public static int mcm(int arr[], int i, int j){
       if(i==j){
        return 0;//single matrix
       }
       int minCost = Integer.MAX_VALUE;
       for(int k=i;k<=j-1;k++){
        int cost1 = mcm(arr, i, k);//A0----Ak
        int cost2 = mcm(arr, k+1, j);//Ak+1----Aj
        int cost3 = arr[i-1]*arr[k]*arr[j];
        int finalCost = cost1+cost2+cost3;
        minCost = Math.min(minCost,finalCost);
       }
       return minCost;
    }

    public static int mcmMem(int arr[], int i, int j, int dp[][]){
        if(i==j){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        for(int k=i;k<=j-1;k++){
        int cost1 = mcmMem(arr, i, k,dp);//A0----Ak
        int cost2 = mcmMem(arr, k+1, j,dp);//Ak+1----Aj
        int cost3 = arr[i-1]*arr[k]*arr[j];
        ans = Math.min(ans,cost1+cost2+cost3);
        }
        return dp[i][j] = ans;
    }
    public static void printdp(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
     }

    public static int mcmTab(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][n];
        
        //INITIALIZATION
        for(int i=0;i<n;i++){
            dp[i][i] =0;
        }

        for(int len = 2;len<=n-1;len++){
            for(int i=1;i<=n-len;i++){
                int j = i+len-1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i;k<=j-1;k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1]*arr[k]*arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1+cost2+cost3);
                }
            }
        }
        printdp(dp);
        return dp[1][n-1];
    }

    //MINIMUM PARTITION
    public static int minPartition(int arr[]){
        int n = arr.length;
        int sum = 0; 
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }

        int W = sum/2;

        int dp[][] = new int[n+1][W+1];

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=Math.max(arr[i-1]+dp[i-1][j-arr[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int sum1 = dp[n][W];
        int sum2 = sum - sum1;
        return Math.abs(sum1- sum2);
    }

    //MIN PARTITION TRUE/FALSE
    public static boolean isminPartitionExist(int arr[]){
        int n = arr.length;
        int sum = 0; 
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }

        int W = sum/2;

        int dp[][] = new int[n+1][W+1];

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=Math.max(arr[i-1]+dp[i-1][j-arr[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int sum1 = dp[n][W];
        int sum2 = sum - sum1;
        // return Math.abs(sum1- sum2);
        if(sum1 == sum2){
            return true;
        }
        return false;
    }

    //MIN JUMPS
    public static int minJumps(int nums[]){
         int n = nums.length;
         int dp[] = new int[n];
         Arrays.fill(dp,-1);
         dp[n-1] =0;

         for(int i=n-2;i>=0;i--){
            int steps = nums[i];
            int ans = Integer.MAX_VALUE;
            for(int j=i+1;j<=i+steps && j<n;j++){
                if(dp[j] != -1){
                    ans = Math.min(ans,dp[j]+1);
                }
            }
            if(ans != Integer.MAX_VALUE){
                dp[i] = ans;
            }
         }
         return dp[0];
    }
    public static void main(String[] args) {
        //int n=5;
        // System.out.println(fibonacci(n));
        // int fab[] = new int[n+1];
        // System.out.println(fibinocci(n, fab));
        //System.out.println(fibTabulation(n));
        //System.out.println(climbingStairs(n));
        // int ways[] = new int[n+1];
        // Arrays.fill(ways,-1);
        // System.out.println(climbingStairsMemo(n, ways));
        // System.out.println(countWaysTab(n));

        // int val[] = {15,14,10,45,30};
        // int wt[] ={2,5,1,3,4};
        // int W = 7;
        // System.out.println(unboundedKnapsack(val, wt, W));


        // int dp[][] = new int [val.length+1][W+1];
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        // System.out.println(knapsack(val, wt, W, val.length));
        // System.out.println(knapsack2(val, wt, W, val.length,dp));
        //System.out.println(knapsack3(val, wt, W));

        // // //TARGETSUM- TABULATION
        //  int arr[] = {4,2,7,1,3};
        // int sum = 10;
        // System.out.println(targetsum(arr, sum));

        //COIN CHANGE
        // int coins[] = {2,5,3,6};
        // int sum = 10;
        // System.out.println(coinChange(coins,sum));

        //ROD CUTTING
        // int length[] ={1,2,3,4,5,6,7,8};
        // int price[] = {1,5,8,9,10,17,17,20};
        // int totalRod = 8;
        // System.out.println(rodCutting(length, price, totalRod));

        //LONGEST COMMON SUBSEQUENCE
    //     String str1 = "abcdge";
    //     String str2 = "ace";
    //     int n = str1.length();
    //     int m= str2.length();
    //     System.out.println(lcSubsequence(str1, str2, n, m));
    // //LCS--MEMOIZATION
    //     int dp[][] = new int[n+1][m+1];
    //     for(int i=0;i<n+1;i++){
    //       for(int j=0;j<m+1;j++){
    //           dp[i][j] = -1;
    //       }
    //     }
    //     System.out.println(lcsMemoization(str1, str2, n, m, dp));
    //      System.out.println(lcsTabulation(str1, str2));


        //  String str1 = "ABCDGH";
        //  String str2 = "ACDGHR";
        //  System.out.println(longestCommonSubstring(str1, str2));

        // int arr[] = {50,3,10,7,40,80};
        // System.out.println(lis(arr));
        //System.out.println(stringConversion("pear", "sea"));
        //System.out.println(longestCommonSubsequence("intention", "execution"));
        // String str1 = "Intention";
        // String str2 = "Execution";
        // System.out.println(editDistance(str1, str2));


        // String s = "abcad";
        // String p = "**bc*d";
        // System.out.println(wildcardMatching(s, p));

        // int n =4;
        // System.out.println(catalanRec(n));

        // int dp[] = new int[n+1];
        // Arrays.fill(dp,-1);
        // System.out.println(catalanMem(n, dp));

        // System.out.println(catlanTab(n));
        int n=4;
        System.out.println(countBst(n));
        // System.out.println(mountainRanges(n));

        // int arr[] = {1,2,3,4,3};
        // int n = arr.length;
        // //System.out.println(mcm(arr, 1, n-1));
        // int dp[][] = new int[n][n];
        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // //System.out.println(mcmMem(arr, 1, n-1, dp));
        // System.out.println(mcmTab(arr));

        //int arr[] = {1,5,11,6};
        // int arr[] = {1,2,3};
        // //System.out.println(minPartition(arr));
        // System.out.println(isminPartitionExist(arr));


        // int nums[] = {2,3,1,1,4};
        // System.out.println(minJumps(nums));

     } 
    
}
