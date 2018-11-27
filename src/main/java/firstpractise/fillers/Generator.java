package firstpractise.fillers;

import firstpractise.annotations.ArrayWithRandomLocatedElements;
import firstpractise.annotations.ReverseSortedArray;
import firstpractise.annotations.SortedArray;
import firstpractise.annotations.SortedArrayWithRandomElement;


/*
 * кожний метод анотувати(власна анотація(див. завдання))
 * або додати анотацію для класу.
 *
 * анотація матиме ім'я, для зручного виклику (array filler)
 * */
/**
 * This class fill array of n length<br>
 * @author Serhii Muzhylivskyi
 * */
public class Generator {

    private static int n;

    public Generator(int n) {
        Generator.n = n;
    }

    @SortedArray
    public static int[] getSortedArray() {
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        return arr;
    }

    @SortedArrayWithRandomElement
    public static int[] getSortedArrayWithRandomElement() {
        int[] arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        arr[n] = (int) (Math.random() * 10);

        return arr;
    }

    @ReverseSortedArray
    public static int[] getReverseSortedArray() {
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr.length - i;
        }

        return arr;
    }

    @ArrayWithRandomLocatedElements
    public static int[] getArrayWithRandomLocatedElements() {
        int[] arr = new int[n];
        int i = 0;
        int index;
        while (i <= n) {
            index = (int) (Math.random() * n);
            arr[index] = i;
            i++;
        }

        return arr;
    }
}



