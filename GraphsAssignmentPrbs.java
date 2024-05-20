import java.util.*;

public class GraphsAssignmentPrbs{
    static class Edge {
        int src;
        int dest;
        int wt;
        public Edge(int s, int d,int wt){
            this.src=s;
            this.dest=d;
            this.wt=wt;
        }
    }
    public static void createGraph(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(9, 5, 1));
        graph[0].add(new Edge(9, 1, 1));

        graph[1].add(new Edge(1, 9, 1));
        graph[1].add(new Edge(1, 5, 1));

        graph[2].add(new Edge(5, 9, 1));
        graph[2].add(new Edge(5, 1, 1));
        graph[2].add(new Edge(5, 2, 1));

        graph[3].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(2, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
    }
    public static boolean detectCycle(ArrayList<Edge>graph[]){
        
    }
    public static boolean detectCycleUtil(ArrayList<Edge>graph[],){

    }
    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge>graph[]= new ArrayList[V];
        createGraph(graph);
        System.out.println(detectCycle(graph));
    }
}