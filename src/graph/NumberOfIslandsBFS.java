package graph;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int x, y;
    Pair(int x ,int y) {
        this.x = x;
        this.y = y;
    }
}
public class NumberOfIslandsBFS {
    public static void main(String[] args) {
        int arr[][] = new int[][] {
                { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 }
        };
        int count = noOfIslands(arr);
        System.out.print(count);
    }

    private static int noOfIslands(int[][] arr) {
        int count = 0;
        int row = arr.length;
        int col = arr[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(arr[i][j] == 1 && !visited[i][j]) {
                    bfs(arr, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void bfs(int[][] arr, int row, int col, boolean[][] visited) {
        int[] rowPointer = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colPointer = {-1, 0, 1, -1, 1, -1, 0, 1};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        visited[row][col] =true;

        while(!q.isEmpty()) {
            int i = q.peek().x;
            int j = q.peek().y;
            q.remove();
            for(int k = 0;k < 8;k++) {
                if(isSafe(arr, i + rowPointer[k], j + colPointer[k], visited)) {
                    visited[i + rowPointer[k]][j + colPointer[k]] = true;
                    q.add(new Pair(i + rowPointer[k], j + colPointer[k]));
                }
            }
        }
    }

    private static boolean isSafe(int[][] arr, int row, int col, boolean[][] visited) {
        return (row >= 0) && (row < arr.length) && (col >= 0) && (col < arr[0].length) && (arr[row][col] == 1 && !visited[row][col]);
    }
}
