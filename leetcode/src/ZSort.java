public class ZSort {
    public String convert(String s, int numRows) {
        int cellSize = numRows * 2 - 2;
        int cellLegnth = numRows-2+1;
        int maxLength = s.length() / cellSize *cellLegnth + s.length() % (cellSize);
        char[][] resultMap = new char[numRows][maxLength];
        int single = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % cellSize < numRows) {
                int y = (i / cellSize) * (numRows - 2 + 1);
                int x = i % cellSize;
                //System.out.println(i+" to >>>"+x+","+y);
                resultMap[x][y] = s.charAt(i);
            } else {
                int y = i/cellSize * cellLegnth + (i%cellSize%numRows + 1) ;
                //int y = 2*numRows-i%cellSize i % cellSize - numRows + 1 + ;
                int x = numRows -2-(i%cellSize - numRows);
                System.out.println(i+" to >>>"+x+","+y);
                resultMap[x][y] =s.charAt(i);
            }
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < maxLength; j++) {
                if (resultMap[i][j] != '\0') {
                    str.append(resultMap[i][j]);
                }
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        ZSort zSort = new ZSort();
        zSort.convert("PAYPALISHIRING", 3);
    }
}
