package geekbrains;

import java.util.Scanner;

public class Main
{
    public static int SIZE;             // Размер игрового поля
    public static int WIN_LEN;          // Длина выигрышного ряда
    public static char[][] board;       // Игровое поле
    public static char EMPTY = '*';     // Стмвол свободного поля
    public static char CROSS = 'X';     // Символ "крестика"
    public static char ZERO = 'O';      // Символ "нолика"
    public static char HUMAN;           // Символ игрока
    public static char AI;              // Символ компьютера
    public static boolean FIRST;        // Принадлежит ли первый ход игроку

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
	// write your code here
        initGame();
    }

    public static void initGame()
    {
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

        flag = true;
        do
        {
            System.out.println();
            System.out.println("Do you play by cross (x) or zero (o)? ('X' is the first)");
            HUMAN = in.next().charAt(0);
            if (HUMAN == 'x' || HUMAN == 'X')
            {
                HUMAN = CROSS;
                AI = ZERO;
                FIRST = true;
                flag = false;
            }
            else if (HUMAN == 'o' || HUMAN == 'O')
            {
                HUMAN = ZERO;
                AI = CROSS;
                FIRST = false;
                flag = false;
            }
            else
                System.out.println("Incorrect input. Try again...");
        } while (flag);
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
