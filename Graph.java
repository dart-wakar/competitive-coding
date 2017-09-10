import java.io.*;
import java.util.*;

public class Graph {

    int adjacencyMatrix[][];
    int v[];
    
    Graph(int vertices[]) {
        adjacencyMatrix = new int[vertices.length][vertices.length];
        for (int i = 0;i < vertices.length;i++) {
            for (int j = 0;j< vertices.length;j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    private void addEdge(int a,int b) {
        adjacencyMatrix[a][b] = 1;
    }

    public void printGraph() {
        int vertices[] = adjacencyMatrix[0];
        for (int i = 0;i < vertices.length;i++) {
            for (int j = 0;j< vertices.length;j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    System.out.println(i+" --- "+j);
                }
            }
        }
    }

    public static void main(String args[]) {

        int ver[] = {0,1,2,3,4,5};

        Graph g = new Graph(ver);

        g.addEdge(0,3);
        g.addEdge(0,5);
        g.addEdge(3,4);

        g.printGraph();
    }
}