import java.util.*;
public class TrappingRainWater {
    public static int trappedWater(int height[]){
        int n = height.length;
        //max left bound
        int leftMax[]= new int[n];
        leftMax[0] = height[0];
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(height[i],leftMax[i-1]);
        }
        //max right bound
        int rightMax[] = new int[n];
        rightMax[n-1]= height[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(height[i],rightMax[i+1]);
        }
        int trappedRainWater=0;
        //loop
        for(int i=0;i<n;i++){
        // waterlevel = min(left bound, right bound )
        int waterlevel = Math.min(leftMax[i],rightMax[i]);
        //trapped water = waterlevel - height[i];// if width is more than 1 yhen it will be multiplied by width.
        trappedRainWater += waterlevel-height[i];
        }
        return trappedRainWater;
    }
    public static void main(String args[]){
        //int height[] ={4,2,0,6,3,2,5};
        int height[] ={0,1, 0,  2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trappedWater(height));
    }
}
