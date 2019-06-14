class MatrixTurn {
    fun rotate(matrix: Array<IntArray>): Unit {
        var x = 0
        while (x < matrix.size) {
            var y = 0
            while (y < matrix.size) {
                matrix[x][y] = matrix[y][x] + matrix[x][y]
                matrix[y][x] = matrix[x][y] - matrix[y][x]
                matrix[x][y] = matrix[x][y] - matrix[y][x]
                y++
            }
            x++
        }
    }
}