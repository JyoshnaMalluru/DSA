import java.util.*;
import java.util.LinkedList;
public class Graphs {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        //0 vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        //1 vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        //2 vertex
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        //3 vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        //4 vertex
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        //5 vertex
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        //6 vertex
        graph[6].add(new Edge(6, 5, 1));

    }
    public static void bfs(ArrayList<Edge> graph[]){
        boolean visit[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visit[i]){
            bfsUtil(graph, visit);
            }
        }
    }
    public static void bfsUtil(ArrayList<Edge> graph[],boolean visit[]){//O(V+E)
    Queue<Integer>q = new LinkedList<>();
    // boolean visit[] = new boolean[graph.length];
    q.add(0);
    while(!q.isEmpty()){
        int curr = q.remove();
        if(!visit[curr]){
            System.out.print(curr+" ");
            visit[curr]=true;
            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                q.add(e.dest);
            }
        }
    }
}

public static void dfs(ArrayList<Edge>[] graph){
    boolean visit[] = new boolean[graph.length];
    for(int i=0;i<graph.length;i++){
        dfsUtil(graph,i,visit);
    }
}
public static void dfsUtil(ArrayList<Edge>[] graph, int curr , boolean visit[]){
    System.out.print(curr+" ");
    visit[curr] = true;

    for(int i=0;i<graph[curr].size();i++){
        Edge e = graph[curr].get(i);
        if(!visit[e.dest]){
            dfsUtil(graph, e.dest, visit);
        }
    }
}

public static boolean hasPath( ArrayList<Edge>[] graph , int src, int dest, boolean[] visit){//O(V+E)
    if(src == dest){
        return true;
    }
    
    visit[src] = true;
    for(int i=0;i<graph[src].size();i++){
    Edge e = graph[src].get(i);
    if(!visit[e.dest] && hasPath(graph, e.dest, dest, visit)){
        return true;
    }
}
    return false;
}
    public static void main(String[] args) {

        /* 
         *                  (5)
         *              0 ------ 1
         *                      / \
         *                  (1)/   \(3)
         *                    /     \
         *                   2 ----- 3
         *                   |   (1)
         *                (2)|
         *                   |
         *                   4
         */
        //CREATION OF GRAPH
        //  int V = 5;
        //  ArrayList<Edge>[] graph = new ArrayList[V];
        //  for(int i=0;i<V;i++){
        //     graph[i] = new ArrayList<>();
        //  }

        //  //0 vertex
        //  graph[0].add(new Edge(0, 1, 5));

        //  //1 vertex
        //  graph[1].add(new Edge(1, 2, 1));
        //  graph[1].add(new Edge(1, 3, 3));
        //  graph[1].add(new Edge(1, 2, 1));

        //  //2 vertex
        //  graph[2].add(new Edge(2, 1, 1));
        //  graph[2].add(new Edge(2, 3, 1));
        //  graph[2].add(new Edge(2, 4, 2));

        //  //3 vertex
        //  graph[3].add(new Edge(3, 2, 1));
        //  graph[3].add(new Edge(3, 1, 3));
         
        // //4 vertex
        // graph[4].add(new Edge(4, 2, 2));

        // for(int i=0;i<graph[2].size();i++){
        //     Edge e = graph[2].get(i);
        //     System.out.println(e.wt);
        // }

        /*               1-------3
         *              /        |\
         *            /          | \
         *           0           |  5------6
         *            \          | /
         *             \         |/
         *              2--------4
         */ 
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        //bfs(graph);
        //dfs(graph, 0, new boolean[V]);
        // bfs(graph);
        dfs(graph);
       //System.out.println(hasPath(graph, 0, 5, new boolean[V]));

    }
}
