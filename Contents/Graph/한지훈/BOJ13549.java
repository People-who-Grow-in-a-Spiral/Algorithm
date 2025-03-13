import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ13549 {
    static int n;
    static int k;
    static int arr[];

    static Queue<Point> queue = new ArrayDeque<Point>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[100001];
        Arrays.fill(arr, -1);

        bfs();

    }

    static void bfs() {
        queue.add(new Point(n, 0));
        arr[n] = -1;

        while(!queue.isEmpty()) {
            Point p = queue.poll();

            if(p.idx == k) {
                System.out.println(p.cnt);
                break;
            }

            if(p.idx > 0 &&  arr[p.idx-1] == -1) {
                queue.add(new Point(p.idx-1, p.cnt+1));
                arr[p.idx-1] = p.cnt+1;
            }

            if(p.idx * 2 < 100001 && arr[p.idx * 2] == -1) {
                queue.add(new Point(p.idx*2, p.cnt));
                arr[p.idx*2] = p.cnt;
            }

            if(p.idx+1 < 100001 && arr[p.idx+1] == -1) {
                queue.add(new Point(p.idx+1, p.cnt+1));
                arr[p.idx+1] = p.cnt+1;
            }
        }

    }
}

class Point {
    int idx;
    int cnt;

    Point(int idx, int cnt) {
        this.idx = idx;
        this.cnt = cnt;
    }
}