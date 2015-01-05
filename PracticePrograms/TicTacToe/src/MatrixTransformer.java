public class MatrixTransformer {

    private int[][] a;
    private int m;
    private int n;

    public MatrixTransformer(int[][] _a, int _m, int _n) {
        a = _a;
        m = _m;
        n = _n;
    }

    private int scanRow(int i) {
        int allZero = 0;
        for(int k = 0;k < n;k++)
            if (a[i][k] == 1) {
                allZero = 1;
                break;
            }

        return allZero;
    }

    private int scanColumn(int j) {
        int allZero = 0;
        for(int k = 0;k < m;k++)
            if (a[k][j] == 1) {
                allZero = 1;
                break;
            }

        return allZero;
    }

    private void setRowToAllOnes(int i) {
        for(int k = 0; k < n;k++)
            a[i][k] = 1;
    }

    private void setColToAllOnes(int j) {
        for(int k = 0; k < m;k++)
            a[k][j] = 1;
    }

//  # we're going to use the first row and column
//  # of the matrix to store row and column scan values,
//  # but we need aux storage to deal with the overlap
//  firstRow = scanRow(0)
//  firstCol = scanCol(0)
//
//  # scan each column and store result in 1st row - O(mn) work



    public void transform() {
        int firstRow = scanRow(0);
        int firstCol = scanColumn(0);


        for(int k = 0;k < n;k++) {
            a[0][k] = scanColumn(k);
        }

        // now row 0 tells us whether each column is all zeroes or not
        // it's also the correct output unless row 0 contained a 1 originally

        for(int k = 0;k < m;k++) {
            a[k][0] = scanRow(k);
        }

        a[0][0] = firstCol | firstRow;

        for (int i = 1;i < m;i++)
            for(int j = 1;j < n;j++)
                a[i][j] = a[0][j] | a[i][0];



        if (firstRow == 1) {
            setRowToAllOnes(0);
        }

        if (firstCol == 1) 
            setColToAllOnes(0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i< m;i++) {
            for(int j = 0;j < n;j++) {
                sb.append(a[i][j] + ", ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        //int[][] a = {{1, 1, 0, 1, 0}, {0, 0, 0, 0, 0},{0, 1, 0, 0, 0},{1, 0, 1, 1, 0}};
    	int[][] a = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0},{0, 1, 0, 0, 0},{0, 0, 0, 0, 0}};
        MatrixTransformer mt = new MatrixTransformer(a, 4, 5);
        mt.transform();
        System.out.println(mt);
    }

}