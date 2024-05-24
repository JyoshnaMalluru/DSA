import java.util.*;
import java.util.LinkedList;
public class TopologicalSortGraphs {
    static class Edge{
        int src;
        int dest;
        public  Edge(int s, int d) {
          this.src = s;
          this.dest = d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3));//Printallpaths problem 

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }
    

    //TOPOGICAL SORT USING BFS
    public static void calcIndegree(ArrayList<Edge> graph[],int indegree[]){
        for(int i=0;i<graph.length;i++){
            int v = i;
            for(int j=0;j<graph[v].size();j++){
                Edge e = graph[v].get(j);
                indegree[e.dest]++;
            }
        }
    }
    public static void topSort(ArrayList<Edge> graph[]){
        int indegree[] = new int [graph.length];
        calcIndegree(graph, indegree);
        Queue<Integer>q = new LinkedList<>();

        for(int i=0;i<indegree.length;i++){
            if(indegree[i] ==0){
                q.add(i);
            }
        }
        //bfs
        while(!q.isEmpty()){
         int curr = q.remove();
         System.out.print(curr+" ");

         for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            indegree[e.dest]--;
            if(indegree[e.dest]==0){
                q.add(e.dest);
            }
         }
        }
        System.out.println();
    }
    
    //TOPOGICAL SORT USING DFS
    // public static void topSort(ArrayList<Edge> graph[]){//DFS//O(V+E)
    //     boolean visit[] = new boolean[graph.length];
    //     Stack<Integer> s = new Stack<>();

    //     for(int i=0;i<graph.length;i++){
    //         if(!visit[i]){
    //             topSortUtil(graph,i,visit,s);
    //         }
    //     }
    //     while (!s.isEmpty()) {
    //         System.out.print(s.pop()+" ");
    //     }
    // }

    public static void topSortUtil(ArrayList<Edge> graph[], int curr, boolean visit[], Stack <Integer> s){//DFS
        visit[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visit[e.dest]){
                topSortUtil(graph, e.dest, visit, s);
            }
        }
       s.push(curr);
    }
    //Print all path
    public static void printAllpaths(ArrayList<Edge>graph[],int src, int dest, String path){
        if(src == dest){
            System.out.println(path+dest);
            return;
        }
        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            printAllpaths(graph,e.dest, dest, path+src);
        }
    }
    public static void main(String[] args) {
        int V =6;
        ArrayList<Edge> graph [] = new ArrayList[V];
        createGraph(graph);
        topSort(graph);
        //printAllpaths(graph, 5, 1, "");
    }
}
