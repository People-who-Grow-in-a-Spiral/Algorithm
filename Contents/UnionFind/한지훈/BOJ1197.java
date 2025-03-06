import javax.script.Compilable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1197 {
    static class Edge implements Comparable<Edge> {
        int to, from, weight;

        public Edge  (int to, int from, int weight) {
            this.to = to;
            this.from = from;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int V, E;
    static Edge[] edgeList;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s= br.readLine().split(" ");
        V = Integer.parseInt(s[0]);
        E = Integer.parseInt(s[1]);
        edgeList = new Edge[E];
        parents = new int[V];

        //Set
        for(int i=0; i<V; i++){
            parents[i] = i;
        }

        //간선 입력 받고
        for (int i = 0; i < E; i++) {
            s = br.readLine().split(" ");
            edgeList[i] = new Edge(Integer.parseInt(s[0])-1,Integer.parseInt(s[1])-1,Integer.parseInt(s[2]));
        }
        Arrays.sort(edgeList); //간선 수대로 정렬하고

        int count = 0;
        int value = 0;

        for(Edge e: edgeList) {
            //간선마다 find 후 부모가 같지 않다면 Union, 같으면 Pass
            if(!union(e.to, e.from)) continue;
            count++;
            value += e.weight;

            if(count == V-1) break;
        }

        System.out.println(value);
    }

    static int find(int a) {
        //부모가 자신과 같을때까지 재귀. 같다면 return
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);

    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        //부모가 같다면 사이클 발생
        if(aRoot == bRoot) return false;

        //부모가 같지 않다면 b의 대표자를 a의 대표자로 맞춰줘야 함.
        parents[bRoot] = aRoot;
        return true;

    }

}