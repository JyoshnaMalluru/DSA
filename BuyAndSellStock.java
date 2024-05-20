import java.util.*;
//time complexity O(n)
public class BuyAndSellStock {
    public static int buyAndSell(int prices[]){
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
    }
}
