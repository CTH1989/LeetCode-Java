import java.util.Hashtable;
public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return ;
        int n = matrix[0].length;
        if (n == 0)
            return ;
        Hashtable<Integer, Integer> hashRow = new Hashtable<Integer, Integer>();
        Hashtable<Integer, Integer> hashCol = new Hashtable<Integer, Integer>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    hashRow.put(i, 1);
                    hashCol.put(j, 1);
                }
            }
        }
        for (Integer Ele : hashRow.keySet()) {
            for (int i = 0; i < n; i++)
                matrix[Ele][i] = 0;
        }
        for (Integer Ele : hashCol.keySet()) {
            for (int i = 0; i < m; i++)
                matrix[i][Ele] = 0;
        }
    }
}
