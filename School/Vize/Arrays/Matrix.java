package Arrays;

// Matriste toplam kac eleman oldugunu bulurken kullanilacak degisik yontemler. Baska yontemler ara!

public class Matrix {
    public static void main(String[] args) {
        int[][][] matrix = { { {1, 2}, {3} }, { { 4, 5, 6 } }, { {7, 8}, {9, 10}, {11, 12, 13, 14} } };

        // 1. Yontem
        /*int count = 0;
        for (int a[][] : matrix) {
            for (int b[] : a) {
                count += b.length;
            }
        }*/

        // 2. Yontem
        int count = 0;
        for (int a[][] : matrix) {
            for (int b[] : a) {
                for (int c : b) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}

