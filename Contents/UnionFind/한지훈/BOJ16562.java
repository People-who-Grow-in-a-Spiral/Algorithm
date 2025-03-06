import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ16562 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); //친구 수
        int M = Integer.parseInt(input[1]); //친구 관계 수
        int K = Integer.parseInt(input[2]); //돈

        parent = new int[N+1];
        int[] costs = new int[N+1]; //친구비
        for(int i=1; i<=N; i++) parent[i] = i;
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++) costs[i+1] = Integer.parseInt(input[i]);
        for(int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            union(Math.min(a, b), Math.max(a, b));
        }

        for(int i=1; i<=N; i++) {
            parent[i] = find(i);
        }

        int[] minCosts = new int[N+1];
        Arrays.fill(minCosts, Integer.MAX_VALUE);

        for(int i=1; i<=N; i++) {
            minCosts[parent[i]] = Math.min(minCosts[parent[i]], costs[i]);
        }

        long ans = 0;
        for(int i=1; i<=N; i++) {
            if(minCosts[i] != Integer.MAX_VALUE) ans += minCosts[i];
        }

        System.out.println(ans>K?"Oh no":ans);
    }

    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }
}