import java.util.*;
public class GreedyAssignment {
    //MAXIMUM BALANCED STRING PARTITIONS
    //public static void main(String args[]){
        //String str = "LRRRRLLRLLRL";
        /*String str = "LRLRLRLRLRLR";
        int Lcount =0;
        int Rcount =0;
        int EqualCount =0;
        for(int idx =0; idx<str.length();idx++){
            if(str.charAt(idx)=='L'){
                Lcount++;
            }
            if(str.charAt(idx)=='R'){
                Rcount++;
            }
            if(Lcount==Rcount){
                EqualCount++;
            }
        } 

        System.out.println("Maximum Balanced String Partitions "+ EqualCount);
    }*/

    //BUY AND SELL STOCK
    /*public static int buyAndSell(int prices[]){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit= 0;
        for(int i=0;i<prices.length;i++){
            if(buyPrice<prices[i]){//profit
                 int profit = prices[i]-buyPrice;//todays profit
                maxProfit = Math.max(maxProfit,profit);
            }else{
                buyPrice= prices[i];
            }
        }
        return maxProfit;
    }
    public static void main(String args[]){
        int prices[] = {7,1,5,3,6,4};
        //int prices[] ={7,6,5,4,3,2,1};
        System.out.println(buyAndSell(prices));
    }*/

    //Kth LARGEST ODD NUMBER
   /*  public static int kthLargestOdd(int l,int r,int k){
        int x;
        if((r%2)==1){
            x= r;
        }else{
            x=r-1;
        }
        int KlargeOdd = x-2*(k-1);
        if(KlargeOdd<l){
            return 0;
        }else{
            return KlargeOdd;
        }
    }
    public static void main(String[] args){
        int l = -30;
        int r = 30;
        int k = 5;
        System.out.println(kthLargestOdd(l,r,k));
    }*/

    //LEXOGRAPHICALLY SMALLEST STRING
    public static void smallestString(int n,int k,int kk,String s){
        for(int i=n-1;i>=0;i--){
            if(kk>=25){
                s+='z';
                kk-=25;
            }else{
                s+=(char)('a'+kk);
                kk-=kk;
            }
        }
        String ans = "";
        for(int i=n-1;i>=0;i--){
            ans=ans+s.charAt(i);
        }
        System.out.println(ans);
    }
    public static void main(String args[]){
        int n = 5;
        int k=85;
        int kk = k-n;
        String s = "";
        smallestString(n,k,kk,s);
    }
    
}
