import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class BOJ16724 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        char[][] arr = new char[N][M];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        int[][] visited = new int[N][M];
        parent = new int[(N*M)+1];
        for(int i=1; i<=N*M; i++) {
            parent[i] = i;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(visited[i][j] == 0) { //방문 안한 것 중
                    int cur_i = i;
                    int cur_j = j;
                    int index = (cur_i*M) + cur_j+1;

                    while(true) {
                        int nx = cur_i + (arr[cur_i][cur_j] == 'U' ? -1 : (arr[cur_i][cur_j] == 'D' ? 1 : 0));
                        int ny = cur_j + (arr[cur_i][cur_j] == 'L' ? -1 : (arr[cur_i][cur_j] == 'R' ? 1 : 0));

                        if(visited[nx][ny] == 0) { //방문을 안했던 것이라면?
                            int x = (nx*M)+ny+1;
                            union(Math.min(index, x), Math.max(index, x));
//                            System.out.println(index + " " +  x);
//                            System.out.println(Arrays.toString(parent));
                            cur_i = nx;
                            cur_j = ny;
                            visited[nx][ny] = index;



                        } else { //방문을 했던 것이라면? 합쳐줘
//                            System.out.println(index + " " + visited[nx][ny]);
                            union(Math.min(index, visited[nx][ny]), Math.max(index, visited[nx][ny]));
                            break;
                        }
                    }
                }
            }
        }

        for(int i=1; i<=N*M; i++) find(i);
        HashSet<Integer> map = new HashSet<>();
        for(int i=1; i<=N*M; i++) map.add(parent[i]);

        System.out.println(map.size());
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
