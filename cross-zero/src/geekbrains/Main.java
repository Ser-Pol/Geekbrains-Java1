package geekbrains;

import java.util.Scanner;

public class Main
{
    public static int SIZE;                // Размер игрового поля
    public static int WIN_LEN;             // Длина выигрышного ряда
    public static char[][] board;          // Игровое поле
    public static char EMPTY = '*';        // Стмвол свободного поля
    public static char CROSS = 'X';        // Символ "крестика"
    public static char ZERO = 'O';         // Символ "нолика"
    public static char HUMAN;              // Символ игрока
    public static char AI;                 // Символ компьютера
    public static boolean MOVE;            // Принадлежит ли ход игроку
    public static boolean FINISH = false;  // Закончена ли игра
    public static int[] coord = new int[2];// Координаты последнего хода (x, y). board[y][x]

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
                MOVE = true;
                flag = false;
            }
            else if (HUMAN == 'o' || HUMAN == 'O')
            {
                HUMAN = ZERO;
                AI = CROSS;
                MOVE = false;
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
        System.out.println(" (X)");
        System.out.println();
        for (int i = 0; i < SIZE; i++)
        {
            System.out.printf("%7d", i);
            for (int j = 0; j < SIZE; j++)
                System.out.printf("%5c", board[i][j]);
            System.out.println();
        }
        System.out.println("     (Y)");
    }

    public static void move()
    {
        if (MOVE)
            getHumanCoord();
        else
            getAiCoord();

        board[coord[1]][coord[0]] = (MOVE) ? HUMAN : AI;

        if (checkWin())
        {
            FINISH = true;
            if (MOVE)
                System.out.println("You win!!!");
            else
                System.out.println("You loose...");
            return;
        }
        MOVE = !MOVE;
    }

    public static boolean checkWin()
    {
/*
       0   1   2
        \  |  /
         \ | /
        ---*--- 3
         / | \
        /  |  \
*/

        if (checkDirection0() >= WIN_LEN || checkDirection1() >= WIN_LEN ||
            checkDirection2() >= WIN_LEN || checkDirection3() >= WIN_LEN) return true;

        return false;
    }

    public static int checkDirection0()
    {
        char now = (MOVE) ? HUMAN : AI;
        int count = 0, x, y;

        x = coord[0];
        y = coord[1];
        do
        {
            count++;
            x--;
            y--;
        } while (x >= 0 && y >= 0 && board[y][x] == now);

        x = coord[0];
        y = coord[1];
        do
        {
            count++;
            x++;
            y++;
        } while (x < SIZE && y < SIZE && board[y][x] == now);

        return --count;
    }

    public static int checkDirection1()
    {
        char now = (MOVE) ? HUMAN : AI;
        int count = 0, x, y;

        x = coord[0];
        y = coord[1];
        do
        {
            count++;
            y--;
        } while (y >= 0 && board[y][x] == now);

        y = coord[1];
        do
        {
            count++;
            y++;
        } while (y < SIZE && board[y][x] == now);

        return --count;
    }

    public static int checkDirection2()
    {
        char now = (MOVE) ? HUMAN : AI;
        int count = 0, x, y;

        x = coord[0];
        y = coord[1];
        do
        {
            count++;
            x++;
            y--;
        } while (x < SIZE && y >= 0 && board[y][x] == now);

        x = coord[0];
        y = coord[1];
        do
        {
            count++;
            x--;
            y++;
        } while (x >= 0 && y < SIZE && board[y][x] == now);

        return --count;
    }

    public static int checkDirection3()
    {
        char now = (MOVE) ? HUMAN : AI;
        int count = 0, x, y;

        x = coord[0];
        y = coord[1];
        do
        {
            count++;
            x--;
        } while (x >= 0 && board[y][x] == now);

        x = coord[1];
        do
        {
            count++;
            x++;
        } while (x < SIZE && board[y][x] == now);

        return --count;
    }

    public static void getHumanCoord()
    {

    }

    public static void getAiCoord()
    {

    }

}
