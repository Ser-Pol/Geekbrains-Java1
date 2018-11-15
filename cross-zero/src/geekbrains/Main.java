package geekbrains;

import java.util.Scanner;

public class Main
{
    public static int SIZE;
    public static int WIN_LEN;
    public static char[][] board;
    public static char EMPTY = '*';

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
	// write your code here
        boolean flag = true;
        do
        {
            System.out.println("Enter size of the board...");
            SIZE = in.nextInt();
            System.out.println("Enter length of winning row...");
            WIN_LEN = in.nextInt();

            if (SIZE < 3)
                System.out.println("Size of the board must be greater than 2...");
            else if (WIN_LEN > SIZE)
                System.out.println("Length of winning row cannot be greater than size of the board...");
            else
                flag = false;
            System.out.println();
        } while (flag);

        board = new char[SIZE][SIZE];
        initBoard();
        printBoard();

    }

    public static void initBoard()
    {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = EMPTY;
    }

    public static void printBoard()
    {
        System.out.printf("%12d", 0);
        for (int i = 1; i < SIZE; i++) System.out.printf("%5d", i);
        System.out.println();
        System.out.println();
        for (int i = 0; i < SIZE; i++)
        {
            System.out.printf("%7d", i);
            for (int j = 0; j < SIZE; j++)
                System.out.printf("%5c", board[i][j]);
            System.out.println();
        }
    }
}
