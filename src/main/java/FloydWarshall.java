import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FloydWarshall {

    public static void main (String[] args) {
        String fileName = "graph.txt";
        int[][] W = readInput(fileName);

        Graph graph = new Graph(W);
        int[][] paths_weights = graph.floydWarshall();
        int[][] pre = graph.getPre();

        print("Floyd-Marshall all-pairs shortest-path's (Floyd): ", paths_weights, Graph.INF);
        print("\nFloyd-Marshall all-pairs shortest-path (Warshall) : ", pre, -1);
    }

    static int[][] readInput (String fileName) {
        int[][] W = null;

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int n = Integer.parseInt(br.readLine());
            W = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] row = br.readLine().split("\\s+");
                for (int j = 0; j < n; j++) {
                    String x = row[j];
                    if (x.equals("INF")) {
                        W[i][j] = Graph.INF;
                    } else {
                        W[i][j] = Integer.parseInt(x);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        return W;
    }

    static void print(String title, int[][] matrix, int comparator) {
        int n = matrix.length;

        System.out.print(title + "\n\t");
        for (int i = 1; i <= n; i++) System.out.print("[" + i + "]" + "\t");
        System.out.println("");

        for (int i = 0; i < n; i++) {
            System.out.print("[" + (i + 1) + "]\t");
            for (int j = 0; j < n; j++) {
                int x = matrix[i][j];
                System.out.print(
                        (x == comparator ?
                                (comparator == -1 ? "NULL" : "INF")
                                :
                                x
                        ) + "\t"
                );
            }
            System.out.println("");
        }
    }






}
