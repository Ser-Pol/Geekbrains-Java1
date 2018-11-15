package geekbrains;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);

        System.out.println("Enter number of task (1 - 3):");
        switch (in.nextInt())
        {
            case 1:
                spiralMatrix();
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("Not correct number");
        }
    }

    public static void spiralMatrix()
    {
        int[][] mat = new int[18][21];

        int i_b = 0, i_e = mat.length - 1;
        int j_b = 0, j_e = mat[0].length - 1;
        int total = mat.length * mat[0].length;

        int k = 0, t = 0;
        while (k < total)
        {
            switch (t % 4)
            {
                case 0:
                    for (int j = j_b; j <= j_e; j++) mat[i_b][j] = k++;
                    i_b++;
                    break;
                case 1:
                    for (int i = i_b; i <= i_e; i++) mat[i][j_e] = k++;
                    j_e--;
                    break;
                case 2:
                    for (int j = j_e; j >= j_b; j--) mat[i_e][j] = k++;
                    i_e--;
                    break;
                case 3:
                    for (int i = i_e; i >= i_b; i--) mat[i][j_b] = k++;
                    j_b++;
                    break;
            }
            t++;
        }

        for (int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat[i].length; j++)
                System.out.printf("%5d", mat[i][j]);
            System.out.println();
        }
    }
}
