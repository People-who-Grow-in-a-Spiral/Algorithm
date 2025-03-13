import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class BOJ18513 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); //N개의 샘터
        int K = Integer.parseInt(input[1]); //K개의 집

        HashMap<Integer, Boolean> map = new HashMap<>();
        Queue<Point> queue = new ArrayDeque<>();

        input = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            int index = Integer.parseInt(input[i]);
            map.put(index, true);
            queue.add(new Point(index, index));
        }

        long ans = 0;
        int cnt = 0;
        while(!queue.isEmpty()) {
            Point p = queue.poll();

            int left = p.index-1;

            if(!map.containsKey(left)) {
                map.put(left, true);
                ans += Math.abs(p.start - left);
                cnt++;
                queue.add(new Point(p.start, left));
                if(cnt == K) break;
            }

            int right = p.index+1;
            if(!map.containsKey(right)) {
                map.put(right, true);
                ans += Math.abs(p.start - right);
                cnt++;
                queue.add(new Point(p.start, right));
                if(cnt == K) break;
            }
        }

        System.out.println(ans);
    }

    static class Point {
        int start, index;

        public Point(int start, int index) {
            this.start = start;
            this.index = index;
        }
    }
}
