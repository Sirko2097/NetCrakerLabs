package firstpractise.filters;

/*
 * кожний метод анотувати(власна анотація(див. завдання))
 * або додати анотацію для класу.
 *
 * анотація матиме ім'я, для зручного виклику (array filler)
 * */
public class Generator {

    private int n;

    public Generator(int n) {
        this.n = n;
    }

    public int[] getSortedArray() {
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        return arr;
    }

    public int[] getSortedArrayWithRandomElement() {
        int[] arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        arr[n] = (int) (Math.random() * 10);

        return arr;
    }

    public int[] getReverseSortedArray() {
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr.length - i;
        }

        return arr;
    }

    public int[] getArrayWithRandomLocatedElements() {
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
