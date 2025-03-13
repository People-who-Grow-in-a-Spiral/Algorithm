import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ16973 {
    static int N, M, H, W;
    static boolean[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static Point start, end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        getInput(br);
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start.i][start.j] = true;

        while(!queue.isEmpty()) {
            Point p = queue.poll();

            for(int k=0; k<4; k++) {
                int nx = p.i + dx[k];
                int ny = p.j + dy[k];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue; //맨 왼쪽 범위
                if(nx+H-1 >= N || ny+W-1 >= M) continue; //사각형 범위

                boolean flag = true;

                if(k == 0) { // 아래로 이동
                    for(int j=ny; j<ny+W; j++) {
                        if(arr[nx+H-1][j]) {
                            flag = false;
                            break;
                        }
                    }
                } else if(k == 1) { // 위로 이동
                    for(int j=ny; j<ny+W; j++) {
                        if(arr[nx][j]) {
                            flag = false;
                            break;
                        }
                    }
                } else if(k == 2) { // 오른쪽으로 이동
                    for(int i=nx; i<nx+H; i++) {
                        if(arr[i][ny+W-1]) {
                            flag = false;
                            break;
                        }
                    }
                } else { // 왼쪽으로 이동
                    for(int i=nx; i<nx+H; i++) {
                        if(arr[i][ny]) {
                            flag = false;
                            break;
                        }
                    }
                }

                if(flag && !visited[nx][ny]) {
                    if(nx == end.i && ny == end.j) return p.cnt+1;
                    queue.add(new Point(nx, ny, p.cnt+1));
                    visited[nx][ny] = true;
                }
            }
        }

        return -1;
    }

    //입력 받기
    static void getInput(BufferedReader br) throws IOException{
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new boolean[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                arr[i][j] = input[j].equals("1");
            }
        }

        input = br.readLine().split(" ");
        H = Integer.parseInt(input[0]);
        W = Integer.parseInt(input[1]);
        start = new Point(Integer.parseInt(input[2])-1, Integer.parseInt(input[3])-1, 0);
        end = new Point(Integer.parseInt(input[4])-1, Integer.parseInt(input[5])-1, 0);
    }

    static class Point {
        int i, j, cnt;

        public Point(int i, int j, int cnt) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }
    }
}
