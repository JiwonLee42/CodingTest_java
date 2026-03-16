import java.util.*;

class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static List<List<int []>> spaces = new ArrayList<>();
    static List<List<int []>> blocks = new ArrayList<>();

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;

        // 게임 보드, 테이블의 조각을 덩어리로 하나하나 추출
        // 방문했는지 체크 배열
        boolean[][] visitedBoard = new boolean[game_board.length][game_board[0].length];
        boolean[][] visitedTable = new boolean[table.length][table[0].length];                    

        int n = game_board.length;
        int m = game_board[0].length;

        // 위아래가 안비어있으면 연결되어있는걸로 추정하고 dfs로 탐색, 모양을 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visitedBoard[i][j] && game_board[i][j] == 0) {

                    List<int[]> shape = new ArrayList<>();
                    findShape(i, j, visitedBoard, game_board, shape, 0);

                    normalize(shape);
                    sort(shape);

                    spaces.add(shape);
                }
            }
        }

        // 테이블에서도 안비어있으면 연결되어있는 블록으로 하고 저장 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visitedTable[i][j] && table[i][j] == 1) {

                    List<int[]> shape = new ArrayList<>();
                    findShape(i, j, visitedTable, table, shape, 1);

                    normalize(shape);
                    sort(shape);

                    blocks.add(shape);
                }
            }
        }

        boolean[] used = new boolean[blocks.size()];

        // 비교
        for(List<int[]> space : spaces){
            for(int i = 0; i < blocks.size(); i++){

                if(used[i]) continue;

                List<int[]> block = blocks.get(i);

                // 크기 다르면 건너뛰기
                if(block.size() != space.size()) continue;

                List<int[]> temp = new ArrayList<>();
                for(int[] b : block){
                    temp.add(new int[]{b[0], b[1]});
                }

                for(int r = 0; r < 4; r++){
                    normalize(temp);
                    sort(temp);

                    if(isSame(temp, space)){
                        answer += space.size();
                        used[i] = true;
                        break;
                    }

                    temp = rotate(temp);
                }

                if(used[i]) break;
            }
        }

        return answer;
    }

    public static void findShape(int x, int y, boolean[][] visited, int[][] board, List<int []> shapes, int checkValue) {
        // 방문 체크
        visited[x][y] = true;
        shapes.add(new int[]{x,y});

        int n = board.length;
        int m = board[0].length;

        for (int d = 0; d < 4; d++) {
            // 다음 인덱스 
            int nextX = x + dx[d];
            int nextY = y + dy[d];

            if(nextX >= 0 && nextY >= 0 && nextX < n && nextY < m){
                // 방문 안했고 찾으려는 칸이면 체크
                if(!visited[nextX][nextY]){
                    // 비어있지 않으면 하나의 빈 공간으로 인식
                    if(board[nextX][nextY] == board[x][y] && board[nextX][nextY] == checkValue){
                        findShape(nextX,nextY,visited,board,shapes,checkValue);
                    }
                }
            }
        }        
    }

    // 회전
    public static List<int[]> rotate(List<int[]> shapes){
        List<int[]> rotated = new ArrayList<>();

        for(int[] p : shapes){
            int x = p[0];
            int y = p[1];
            rotated.add(new int[]{y,-x});
        }

        return rotated;
    }

    // 정규화 - 전부 최솟값으로 맞추도록 해서 비교 모양이 똑같도록
    public static void normalize(List<int[]> shape) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for(int[] p : shape) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
        }

        for(int[] p : shape) {
            p[0] -= minX;
            p[1] -= minY;
        }
    }

    // 정렬 - 비교할때 배열 자체로 비교할 거라서, 정렬을 해주기
    public static void sort(List<int[]> shapes) {
        Collections.sort(shapes,(a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
    }

    // 두 블록 & 공간 비교
    static boolean isSame(List<int[]> a, List<int[]> b) {

        if (a.size() != b.size()) return false;

        for (int i = 0; i < a.size(); i++) {
            int[] p1 = a.get(i);
            int[] p2 = b.get(i);

            if (p1[0] != p2[0] || p1[1] != p2[1]) {
                return false;
            }
        }

        return true;
    }
}