package geekbrains;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        // write your code here
        varInit();

        float a = 1.3f, b = 2.4f, c = 7.2f, d = 1.2f;
        System.out.printf("\n%.1f*(%.1f + %.1f/%.1f) = %.3f\n\n", a, b, c, d, Culc(a, b, c , d));

        Scanner in = new Scanner(System.in);

        int e, f;
        System.out.println("Enter two numbers...");
        System.out.printf("(%d + %d) = %d in [10, 20] is %b\n\n", e = in.nextInt(), f = in.nextInt(), e + f, Verify(e, f));

        System.out.println("Enter the number...");
        whichSign(in.nextInt());

        System.out.println();
        System.out.println("Enter the number...");
        System.out.printf("This number is negative, isn't it? - %b\n\n", isNegative(in.nextInt()));

        System.out.println("Enter the name...");
        greeting(in.next());


        System.out.println();
        System.out.println("Enter the year...");
        isLeapYear(in.nextInt());
    }

    public static void varInit()
    {
        byte _byte = 120;
        short _short = 1234;
        int _int = 2342124;
        long _long = 343820332342323L;
        float _float = 1.2f;
        double _double = 32123.23234;
        char _char = 'a';
        boolean _boolean = true;

        System.out.printf("Byte: %,d\nShort: %,d\nInt: %,d\nLong: %,d\n", _byte, _short, _int, _long);
        System.out.printf("Float: %f\nDouble: %,f\nChar: %c\nBoolean: %b\n", _float, _double, _char, _boolean);
    }

    public static float Culc(float a, float b, float c, float d)
    {
        return a*(b + c/d);
    }

    public static boolean Verify(int e, int f)
    {
        int a = e + f;
        return a >= 10 && a<= 20;
    }

    public static void whichSign(int a)
    {
        if (a >= 0)
            System.out.println("It is positive");
        else
            System.out.println("It's negative");
    }

    public static boolean isNegative(int a)
    {
        return a < 0;
    }

    public static void greeting(String str)
    {
        System.out.println("Hello, " + str + "!");
    }

    public static void isLeapYear(int year)
    {
        System.out.printf("This year is leap, isn't it? - %b", (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0));
    }
}
