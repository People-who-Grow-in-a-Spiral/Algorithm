import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ20955 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        parent = new int[N+1];
        for(int i=1; i<=N; i++) parent[i] = i;

        int cycleCount = 0; // 사이클 개수

        // 간선을 처리하면서 사이클 개수 계산
        for(int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            // 이미 같은 집합에 속해 있다면 사이클 발생
            if(find(u) == find(v)) {
                cycleCount++;
            } else {
                union(u, v);
            }
        }

        // 컴포넌트 개수 계산
        HashSet<Integer> components = new HashSet<>();
        for(int i=1; i<=N; i++) {
            components.add(find(i));
        }

        int componentCount = components.size();

        // 필요한 수술 횟수 = 사이클 제거 + 컴포넌트 연결
        int answer = cycleCount + (componentCount - 1);
        System.out.println(answer);
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