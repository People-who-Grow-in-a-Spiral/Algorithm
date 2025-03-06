import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BOJ20040 {
    static int n, m;
    static int parents[];

    //Union-find
    static int find(int a) {
        if(parents[a]==a)return a;
        else return parents[a] = find(parents[a]);
    }
    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot==bRoot) return false;
        else {
            parents[bRoot] = aRoot;
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        int ans = 0;
        for(int i=0; i<m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            if(find(a)==find(b)) {
                System.out.println(i+1);
                return;
            }else {
                union(a,b);
            }
        }
        System.out.println(ans);
    }
}
