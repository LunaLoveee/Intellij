package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SpecificDistance {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static int []dist = new int[300001];
    static int N, M, K, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
            dist[i] = -1;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
        }

        bfs(X);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= N; i++) {
            if(dist[i] == K){
                sb.append(i).append("\n");
            }
        }

        if(sb.isEmpty()){
            System.out.print(-1);
        }
        else{
            System.out.print(sb);
        }
    }

    public static void bfs(int target) {
        Queue<Integer> q = new LinkedList<>();
        dist[target] = 0;
        q.add(target);

        while(!q.isEmpty()) {
            int now = q.poll();

            for(int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                if(dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    q.add(next);
                }
            }
        }
    }
}