package geekbrains;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args)
    {
	// write your code here
        revertArray();

        System.out.println();

        fillArray();

        System.out.println();

        changeArray();

        System.out.println();

        fillDiagonal();

        System.out.println();

        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int)Math.round(Math.random()*100);

        System.out.println(Arrays.toString(arr));
        printMinMax(arr);

        System.out.println();

        int[] arr1 = {1, 1, 1, 2, 1};
        int[] arr2 = {2, 1, 1, 2, 1};
        int[] arr3 = {10, 10};

        System.out.printf("Array %s is balanced, isn't it? - %b\n", Arrays.toString(arr1),checkBalance(arr1));
        System.out.printf("Array %s is balanced, isn't it? - %b\n", Arrays.toString(arr2),checkBalance(arr2));
        System.out.printf("Array %s is balanced, isn't it? - %b\n", Arrays.toString(arr3),checkBalance(arr3));

        System.out.println();
        
        int[] arr_s = new int[12];
        for (int i = 0; i < arr_s.length; i++)
            arr_s[i] = (int)Math.round(Math.random()*100);
        System.out.printf("Original array is %s\n", Arrays.toString(arr_s));
        shiftArray(arr_s, -3);
        System.out.printf("Shifted array is %s\n", Arrays.toString(arr_s));
    }

    public static void revertArray()
    {
        byte[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        System.out.println("Original array:");
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++)
            arr[i] = (byte)(1 - arr[i]);

        System.out.println("Changed array:");
        System.out.println(Arrays.toString(arr));
    }
    
    public static void fillArray()
    {
        int[] arr = new int[8];

        for (int i = 0, k = 0; k < arr.length; i += 3, k++)
            arr[k] = i;

        System.out.println(Arrays.toString(arr));
    }

    public static void changeArray()
    {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arr.length; i++)
            if (arr[i] < 6) arr[i] *= 2;

        System.out.println(Arrays.toString(arr));
    }

    public static void fillDiagonal()
    {
        int[][] arr = new int[8][8];

        for (int i = 0; i < arr.length; i++)
            arr[i][i] = arr[i][arr.length-1-i] = 1;

        for (int i = 0; i < arr.length; i++)
            System.out.println(Arrays.toString(arr[i]));
    }

    public static void printMinMax(int[] arr)
    {
        int min, max;

        min = max = arr[0];

        for (int i = 1; i < arr.length; i++)
        {
            if (min > arr[i]) min = arr[i];
            if (max < arr[i]) max = arr[i];
        }

        System.out.printf("Min of the array is %d\nMax of the array is %d\n", min, max);
    }

    public static boolean checkBalance(int[] arr)
    {
        int left = 0, right = 0;

        for (int i = 0; i < arr.length; i++)
            right += arr[i];

        for (int i = 0; i < arr.length; i++)
        {
           left += arr[i];
           right -= arr[i];
           if (left == right) return true;
        }
        return false;
    }

    public static void shiftArray(int[] arr, int n)
    {
        if (n == 0) return;
        if (n < 0) n = arr.length + n;
        n %= arr.length;

        int div = getGreatestCommonDivisor(arr.length, n);
        int num = arr.length / div;

        for (int i = 0; i < div; i++)
        {
            int p1 = 0, p2 = arr[i];
            for (int j = 0, k = (i + n)%arr.length; j < num; j++, k = (k + n)%arr.length)
            {
                if (j%2 == 0)
                {
                    p1 = arr[k];
                    arr[k] = p2;
                }
                else
                {
                    p2 = arr[k];
                    arr[k] = p1;
                }
            }
        }

    }

    public static int getGreatestCommonDivisor(int a, int b)
    {
        int div = 1;

        for (int i = 2; i <= a && i <= b ; i++)
            if (a % i == 0 && b % i == 0)
            {
                div *= i;
                a /= i;
                b /= i;
                i--;
            }
        return div;
    }
}
