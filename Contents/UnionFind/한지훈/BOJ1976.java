import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1976 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        for(int i=1; i<=N; i++) parent[i] = i;
        int M = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                if (input[j - 1].equals("1")) union(i, j);
            }
        }
        String[] input = br.readLine().split(" "); //여행 계획
        int root = find(Integer.parseInt(input[0]));
        for(int i=1; i<M; i++) {
            if(root != find(Integer.parseInt(input[i]))) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    static int find(int x) {
        if(parent[x] == x) return x; //자신이 대표자
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) parent[b] = a;
    }
}
