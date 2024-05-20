import java.util.*;
import java.util.LinkedList;
public class graphsTwo {
    // static class  Edge{
    //     int src;
    //     int dest;
    //     public Edge(int s,int d){
    //         this.src = s;
    //         this.dest =d;
    //     }
    // }
    static class Edge {
        int dest;
        int weight;
    
        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
    
    // public static void createGraph(ArrayList<Edge> graph[]){
    //     for(int i=0;i<graph.length;i++){
    //         graph[i] = new ArrayList<>();
    //     }

    //     graph[0].add(new Edge(0,1));
    //     graph[0].add(new Edge(0,2));
    //     graph[0].add(new Edge(0,3));

    //     graph[1].add(new Edge(1,0));
    //     graph[1].add(new Edge(1,2));

    //     graph[2].add(new Edge(2,0));
    //     graph[2].add(new Edge(2,1)); 
       
    //     graph[3].add(new Edge(3,0));
    //     graph[3].add(new Edge(3,4));


    //     graph[4].add(new Edge(4,2));
    //     graph[4].add(new Edge(4,3));
    // }

    //DFS
    //UNDIRECTED
    public static boolean detectCycle(ArrayList<Edge> graph[]){
        boolean[] visit = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visit[i]){
               if(detectCycleUtil(graph,visit,i,-1)){
                return true;
               }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean visit[], int curr, int parent){
      visit[curr] = true;

      for(int i=0;i<graph[curr].size();i++){
        Edge e = graph[curr].get(i);
        if(!visit[e.dest] ){
            if(detectCycleUtil(graph, visit, e.dest, curr)){
            return true;
            }
        }
        else if(visit[e.dest] && e.dest != parent){
            return true;
        }
      }
       return false;
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(1,5));
        graph[0].add(new Edge(1,9));

        graph[1].add(new Edge(5,1));
        graph[1].add(new Edge(5,9));
        graph[1].add(new Edge(5,2));


        graph[2].add(new Edge(9,5));
        graph[2].add(new Edge(9,1)); 
       
        graph[3].add(new Edge(2,5));
        graph[3].add(new Edge(2,4));


        graph[4].add(new Edge(4,2));
    }
    public static boolean cycle(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(cycleUtil(graph,vis,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean cycleUtil(ArrayList<Edge> graph[],boolean vis[],int curr,int par){
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        vis[curr]= true;
        while(!q.isEmpty()){
            int x = q.remove();
            for (Edge e : graph[x]) {
                q.add(e.dest);
                if(!vis[e.dest]){
                    vis[e.dest] = true;
                    if(cycleUtil(graph, vis, e.dest, x)){
                        return true;
                    }
                }else if(vis[x]&& e.dest != par){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {

        /*
         *            0----------3
         *          / |
         *        /   |
         *       1    |
         *        \   |
         *         \  |
         *           2 ----------4
         */
        // int V = 5;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createGraph(graph);
        // System.out.println(detectCycle(graph));

        //  9----5----2
        //  |  /      |
        //  | /       |
        //  1         4

        int V = 5;
        ArrayList<Edge> graph[]= new ArrayList[V];
        createGraph(graph);
        System.out.println(cycle(graph));
    }


    //BIPARTITE GRAPH
    // public static void createGraph(ArrayList<Edge> graph[]){
    //     for(int i=0;i<graph.length;i++){
    //         graph[i] = new ArrayList<>();
    //     }
    //     graph[0].add(new Edge(0,1));
    //     graph[0].add(new Edge(0,2));

    //     graph[1].add(new Edge(1,0));
    //     graph[1].add(new Edge(1,3));

    //     graph[2].add(new Edge(2,4));
    //     graph[2].add(new Edge(2,0));

    //    // graph[3].add(new Edge(3,4));
    //     graph[3].add(new Edge(3,1));

    //     //graph[4].add(new Edge(4,3));
    //     graph[4].add(new Edge(4,2));

    // }

    public static boolean isBipartite(ArrayList<Edge> graph[]){
        int col[] = new int [graph.length];
        for(int i=0;i<col.length;i++){
            col[i]=-1;//no color
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<graph.length;i++){
        if(col[i]==-1){//BFS
          q.add(i);
          col[i]=0;//yellow
          while (!q.isEmpty()) {
            int curr = q.remove();
            for(int j=0;j<graph[curr].size();j++){
                Edge e = graph[curr].get(j);
                if(col[e.dest] == -1){
                    int nextCol = col[curr]==0?1:0;
                    col[e.dest]= nextCol;
                    q.add(e.dest);
                }else if(col[e.dest] == col[curr]){
                    return false;
                }
            }
          }
        }
        }
        return true;
    }
    

     //DETECTION OF CYCLE USING DFS
    // public static void createGraph(ArrayList<Edge> graph[]){
    //     for(int i=0;i<graph.length;i++){
    //        graph[i] = new ArrayList<>();
    //     }

    //     graph[0].add(new Edge(0, 2));

    //     graph[1].add(new Edge(1,0));

    //     graph[2].add(new Edge(2, 3));

    //     graph[3].add(new Edge(3, 0));

    //  }
        //DFS
     public static boolean isCycle(ArrayList<Edge> graph[]){//O(V+E)
        boolean visit[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!visit[i]){
               if(isCycleUtil(graph,i,visit,stack)){
                return true;
               }
            }
        }
        return false;
     }

     public static boolean isCycleUtil(ArrayList<Edge>graph[],int curr, boolean visit[], boolean[]stack){
        visit[curr] = true;
        stack[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(stack[e.dest]){
              return true;
            }
            if(!visit[e.dest]&& isCycleUtil(graph, e.dest, visit, stack)){
                return true;
            }
        }
        stack[curr] = false;
        return false;
     }
//     public static void main(String[] args) {
//         /*
//          *                0---------2
//          *               /          /
//          *              /          /
//          *             /          /
//          *             1          4
//          *              \        /
//          *                \    /
//          *                  3 
//          * 
//          */

// //BIPARTITE
//         //  int  V = 5;
//         //  ArrayList<Edge> graph[] = new ArrayList[V];
//         //  createGraph(graph);
//         //  System.out.println(isBipartite(graph));


//         int V = 4;
//         ArrayList<Edge> graph[] = new ArrayList[V];
//         createGraph(graph);
//         System.out.println(isCycle(graph));
   // }
}
