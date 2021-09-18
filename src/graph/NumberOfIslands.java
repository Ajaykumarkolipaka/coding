package graph;

public class NumberOfIslands {
    public static void main(String[] args) {
        int arr[][] = new int[][] {
                { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 }
        };
        int count = noOfIslands(arr);
        //System.out.println(arr.length + " " + arr[0].length);
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
                    dfs(arr, i, j, visited);
                    count++;
                }

            }
        }
        return count;
    }

    private static void dfs(int[][] arr, int row, int col, boolean[][] visited) {
        int[] rowPoints = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colPoints = {-1, 0, 1, -1, 1, -1, 0, 1};
        visited[row][col] = true;
        for(int k =0;k < 8;k++) {
            if(isSafe(arr, row + rowPoints[k], col + colPoints[k], visited))
                dfs(arr, row + rowPoints[k], col + colPoints[k], visited);
        }
    }


    private static boolean isSafe(int[][] arr, int r, int c, boolean[][] visited) {
        return (r >= 0) && (r < arr.length) && (c >= 0) && (c < arr[0].length) && (arr[r][c] == 1 && !visited[r][c]);
    }
}
