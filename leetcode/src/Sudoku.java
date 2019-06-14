import java.util.HashMap;

public class Sudoku {
    Boolean[][] statesMapX = {{false, false, false, false, false, false, false, false, false}
            , {false, false, false, false, false, false, false, false, false}
            , {false, false, false, false, false, false, false, false, false}
            , {false, false, false, false, false, false, false, false, false}
            , {false, false, false, false, false, false, false, false, false}
            , {false, false, false, false, false, false, false, false, false}
            , {false, false, false, false, false, false, false, false, false}
            , {false, false, false, false, false, false, false, false, false}
            , {false, false, false, false, false, false, false, false, false}};
    Boolean[][] statesMapY = {{false, false, false, false, false, false, false, false, false}
            , {false, false, false, false, false, false, false, false, false}
            , {false, false, false, false, false, false, false, false, false}
            , {false, false, false, false, false, false, false, false, false}
            , {false, false, false, false, false, false, false, false, false}
            , {false, false, false, false, false, false, false, false, false}
            , {false, false, false, false, false, false, false, false, false}
            , {false, false, false, false, false, false, false, false, false}
            , {false, false, false, false, false, false, false, false, false}};
    Boolean[][] cellMap = {{false, false, false, false, false, false, false, false, false}
            , {false, false, false, false, false, false, false, false, false}
            , {false, false, false, false, false, false, false, false, false}
            , {false, false, false, false, false, false, false, false, false}
            , {false, false, false, false, false, false, false, false, false}
            , {false, false, false, false, false, false, false, false, false}
            , {false, false, false, false, false, false, false, false, false}
            , {false, false, false, false, false, false, false, false, false}
            , {false, false, false, false, false, false, false, false, false}};
    int sum = 81;

    private void solveSudoku(char[][] board) {
        setup(board);
    }

    private void setup(char[][] board) {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (board[x][y] != '\0') {
                    int num = Integer.parseInt(String.valueOf(board[x][y]));
                    statesMapX[x][num] = true;
                    statesMapY[y][num] = true;
                    cellMap[((x / 3) * 3 + y / 3)][num] = true;
                }
            }
        }
    }


    public static void main(String args[]) {
        Sudoku solution = new Sudoku();
        char[][] testCase = {{'a', 'b'}, {'a', 'b'}, {'a', 'b'}};
        solution.solveSudoku(testCase);
    }
}
