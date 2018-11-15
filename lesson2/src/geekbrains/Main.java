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
}
