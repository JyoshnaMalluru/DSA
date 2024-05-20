import java.util.*;
public class GreedyAlgorithms {
    /*public static void main(String args[]){// Time complexity O(n)
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};
        //Sorting
        int activities[] [] = new int [start.length][3];
        for(int i=0;i<start.length;i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        //lambda function shortform
        Arrays.sort(activities,Comparator.comparingDouble(o->o[2]));


        // end time basis sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        //1st Activity
        maxAct = 1;
        //ans.add(0);
        ans.add(activities[0][0]);
        //int lastEnd = end[0];
        int lastEnd = activities[0][2];
        for(int i=1;i<end.length;i++){
            //if(start[i] >= lastEnd){
            if(activities[i][1]>=lastEnd){
                maxAct++;
                //ans.add(i);
                ans.add(activities[i][0]);
                //lastEnd = end[i];
                lastEnd = activities[i][2];
            }
        }

        System.out.println("maxActivities "+ maxAct);
        for(int i=0;i<ans.size();i++){
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();
    }*/

    //FRACTIONAL KNAPSNACK
    /*public static void main (String args[]){
        int val [] = {60,100,120};
        int weight[] ={10,20,30};
        int w = 50;
        
        double ratio[][] = new double[val.length][2];
        //0th column => idx  && 1st col => ratio

        for(int i=0;i<val.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=val[i]/(double)weight[i];
        }

        // ascending order
        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));

        int capacity =w;
        int finalVal = 0;

        for(int i=ratio.length-1;i>=0;i--){
            int idx = (int) ratio[i][0];
            if(capacity>=weight[idx]){
                finalVal+=val[idx];
                capacity-=weight[idx];
            }else{
                finalVal += (ratio[i][1]*capacity);
                capacity =0;
                break;
            }

        }

       System.out.println("final value ="+ finalVal);
    }*/


    //MIN ABSOLUTE DIFFERENCE PAIRS
    /*public static void main(String args[]){//O(n log n)
        int A[] ={4,1,8,7};
        int B[] ={2,3,6,5};

        Arrays.sort(A);
        Arrays.sort(B);
        int mindiff = 0;
        for(int i=0;i<A.length;i++){
           mindiff+=Math.abs(A[i]-B[i]);
        }
        System.out.println("Min Absolute Difference "+ mindiff);
    }*/

    //MAX LENGTH CHAIN OF PAIRS
    /*public static void main(String args[]){//O(n log n)
        int pairs[][] ={{5,24},{39,60},{5,28},{27,40},{50,90}};

        Arrays.sort(pairs,Comparator.comparingDouble(o->o[1]));
        int chainLen =1;
        int chainEnd = pairs[0][1];

        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0]>chainEnd){
                chainLen++;
                chainEnd=pairs[i][1];
                //System.out.println(chainEnd);
            }
        }

        System.out.println("chain length "+ chainLen);
    }*/

    //INDIAN COINS
    /*public static void main(String args[]){
        Integer coins[] = {1,2,5,10,20,50,100,500,2000};
        Arrays.sort(coins,Comparator.reverseOrder());
        int countOfCoins = 0;
        int amount = 590;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<coins.length;i++){
            if(coins[i]<=amount){
                while(coins[i]<=amount){
                    countOfCoins++;
                    ans.add(coins[i]);
                    amount-=coins[i];
                }
            }
        }
        System.out.println(countOfCoins);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }*/
    //JOB SEQUENCING PROBLEM
   static class Job{
        int id;
        int deadLine;
        int profit;
        public Job(int i, int d,int p){
            id =i;
            deadLine = d;
            profit = p;
        }
    }
    /*public static void main(String args[]){
        int jobsInfo[] [] ={{4,20},{1,10},{1,40},{1,30}};

        ArrayList<Job> jobs = new ArrayList<>();
         for(int i=0;i<jobsInfo.length;i++){
            jobs.add(new Job(i,jobsInfo[i][0],jobsInfo[i][1]));
         }

         Collections.sort(jobs,(obj1,obj2) -> obj2.profit-obj1.profit);
         //descending order profit

         ArrayList <Integer> seq = new ArrayList<>();
         int time =0;
         for(int i=0;i<jobs.size();i++){
            Job curr = jobs.get(i);
            if(curr.deadLine>time){
                seq.add(curr.id);
                time++;
            }
         }

         //PRINT SEQUENCE
         System.out.println("Max Jobs "+ seq.size());
         for(int i=0;i<seq.size();i++){
            System.out.print(seq.get(i)+" ");
         }
         System.out.println();
    }*/

    //CHOCOLA PROBLEM
    /*public static void main(String args[]){
        int n=4 , m=6;
        Integer CostVer[] = {2,1,3,1,4};//m-1
        Integer CostHor[] = {4,1,2};//n-1

        Arrays.sort(CostVer,Collections.reverseOrder());
        Arrays.sort(CostHor,Collections.reverseOrder());

        int h = 0 , v=0;
        int hp = 1, vp =1;
        int cost = 0;

        while(h<CostVer.length && v<CostHor.length){
            if(CostVer[v]<=CostHor[h]){
                cost+=(CostHor[h]*vp);
                hp++;
                h++;
            }else{
                cost+=(CostVer[v]*hp);
                vp++;
                v++;
            }
        }

        while(h<CostHor.length){
            cost+=(CostHor[h]*vp);
                hp++;
                h++;
        }

        while(v<CostVer.length){
            cost+=(CostVer[v]*hp);
                vp++;
                v++;
        }

        System.out.println(" Min cost for cuts "+ cost);

    }*/
}
