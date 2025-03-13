import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class BOJ4179 {
    static int n, m;
    static char[][] arr;
    static boolean[][] visited;
    static boolean[][] fire_visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayList<Point> fireArr = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new char[n][m];
        visited = new boolean[n][m];
        fire_visited= new boolean[n][m];


        Point jihun = null;

        for(int i=0; i<n; i++) {
            String s1 = br.readLine();
            for(int j=0; j<m; j++) {
                arr[i][j] = s1.charAt(j);
                if(arr[i][j] == 'J') jihun = new Point(i, j, 0);
                if(arr[i][j] == 'F') {
                    fire_visited[i][j] = true;
                    fireArr.add(new Point(i, j, 0));
                }
            }
        }

        bfs(jihun);
    }

    static void bfs(Point point) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(point); //jihun
        for(Point p: fireArr) queue.add(p); //뷸

        visited[point.i][point.j] = true;

        while(!queue.isEmpty()) {

            Point p = queue.poll();
//        	System.out.println(p.i + " " + p.j);
//        	for(int i=0; i<n; i++) {
//        		for(int j=0; j<m; j++) {
//        			System.out.print(arr[i][j]);
//        		}System.out.println();
//        	}
//        	System.out.println();

            //jihun일때
            if(arr[p.i][p.j] == 'J') {
                for(int k=0; k<4; k++) {
                    int nx = p.i + dx[k];
                    int ny = p.j + dy[k];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
                        System.out.println(p.cnt+1);
                        return;
                    }
                    if(arr[nx][ny] != '.' || visited[nx][ny]) continue;
                    queue.add(new Point(nx, ny, p.cnt+1));
                    visited[nx][ny] = true;
                    arr[nx][ny] = 'J';
                }
                arr[p.i][p.j] = '.';
            }
            else if(arr[p.i][p.j] == 'F') {
                for(int k=0; k<4; k++) {
                    int nx = p.i + dx[k];
                    int ny = p.j + dy[k];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= m || fire_visited[nx][ny] || arr[nx][ny] == '#') continue;

                    queue.add(new Point(nx, ny, p.cnt+1));
                    fire_visited[nx][ny] = true;
                    arr[nx][ny] = 'F';
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    static class Point {
        int i, j, cnt;

        Point(int i, int j, int cnt) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }
    }
}