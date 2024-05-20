
/*import java.util.*;
public class Solution {
    //Linked in problems
        public static int findMinimumCost(int[] projectId, int[] bid) {
            int n = projectId.length;
            Map<Integer, Integer> projectToBid = new HashMap<>();
    
            // Initialize projectToBid with maximum bid value for each project
            for (int i = 0; i < n; i++) {
                projectToBid.put(projectId[i], Integer.MAX_VALUE);
            }
    
            // Update projectToBid with minimum bid value for each project
            for (int i = 0; i < n; i++) {
                int currProject = projectId[i];
                int currBid = bid[i];
                projectToBid.put(currProject, Math.min(projectToBid.get(currProject), currBid));
            }
    
            // Calculate the total cost
            int totalCost = 0;
            for (int cost : projectToBid.values()) {
                if (cost == Integer.MAX_VALUE) {
                    // If any project has no bids, return -1
                    return -1;
                }
                totalCost += cost;
            }
    
            return totalCost;
        }
    
        public static void main(String[] args) {
            int[] projectId = {2, 0, 1, 2};
            int[] bid = {8, 7, 6, 9};
    
            int result = findMinimumCost(projectId, bid);
            if (result != -1) {
                System.out.println("The minimum amount the customer can pay is: " + result);
            } else {
                System.out.println("No bids received for some projects. Cannot complete all projects.");
            }
        }
    }
*/
/*import java.util.*;

public class PlaylistFun {

    public static int maxFun(int[] singer, int[] length) {
        int n = singer.length;
        Map<Integer, Integer> singerCount = new HashMap<>();
        int totalFun = 0;

        for (int i = 0; i < n; i++) {
            int currSinger = singer[i];
            int currLength = length[i];

            // Update singer count
            singerCount.put(currSinger, singerCount.getOrDefault(currSinger, 0) + 1);

            // Calculate fun amount for the current song
            int funAmount = currLength * (singerCount.size());

            // Add to total fun
            totalFun += funAmount;
        }

        return totalFun;
    }

    public static void main(String[] args) {
        int[] singer = {1, 2, 1, 3}; // Example singer array
        int[] length = {5, 3, 4, 2}; // Example length array

        int result = maxFun(singer, length);
        System.out.println("Maximum fun amount: " + result);
    }
}*/

import java.util.*;

public class CubicleShopping {

    public static int binarySearch(List<Long> arr, int low, int high, long target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) == target) {
                return mid; // Target found, return its index
            } else if (arr.get(mid) < target) {
                low = mid + 1; // Adjust the search range to the right half
            } else {
                high = mid - 1; // Adjust the search range to the left half
            }
        }
        return high; // Target not found (return lower value index)
    }

    public static List<Integer> findMaximumValue(List<Integer> prices, List<Integer> pos, List<Integer> amount) {
        int priceSize = prices.size();
        int queryCount = pos.size();
        List<Long> prefixPriceSum = new ArrayList<>(priceSize);

        // Pre-compute prefix sum
        long sum = 0;
        for (int i = 0; i < priceSize; i++) {
            sum += prices.get(i);
            prefixPriceSum.add(sum);
        }

        List<Integer> result = new ArrayList<>(queryCount);
        for (int i = 0; i < queryCount; i++) {
            // Calculate target amount based on the position
            long targetAmt = (pos.get(i) == 1) ? amount.get(i) : (prefixPriceSum.get(pos.get(i) - 2) + amount.get(i));

            // Find the shop index till which we can get maximum products using binary search
            int shopIdx = binarySearch(prefixPriceSum, 0, priceSize - 1, targetAmt);

            // Calculate and store the result for the query
            result.add(shopIdx - pos.get(i) + 2);
        }

        return result;
    }

    public static void main(String [] args) {
        List<Integer> prices = Arrays.asList(3, 4, 5, 5, 7);
        List<Integer> pos = Arrays.asList(1, 2, 3);
        List<Integer> amount = Arrays.asList(10, 11, 12);

        List<Integer> maxProducts = findMaximumValue(prices, pos, amount);
        System.out.println("Maximum products for each query: " + maxProducts);
    }
}
