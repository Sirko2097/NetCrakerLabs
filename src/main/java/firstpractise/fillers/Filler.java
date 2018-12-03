package firstpractise.fillers;

import firstpractise.annotations.ArrayFiller;


/**
 * This class fill array of n length<br>
 *
 * Method can be called with using reflection and annotations.
 * @see firstpractise.Main
 *
 * @author Serhii Muzhylivskyi
 * */
public class Filler {

    public static int getN() {
        return n;
    }

    private static int n;

    public Filler(int n) {
        Filler.n = n;
    }

    @ArrayFiller(name = "Sorted")
    public static int[] getSortedArray() {
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        return arr;
    }

    @ArrayFiller(name = "Sorted random array")
    public static int[] getSortedArrayWithRandomElement() {
        int[] arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        arr[n] = (int) (Math.random() * 10);

        return arr;
    }

    @ArrayFiller(name = "Reverse sorted array")
    public static int[] getReverseSortedArray() {
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr.length - i;
        }

        return arr;
    }

    @ArrayFiller(name = "Random located elements")
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



