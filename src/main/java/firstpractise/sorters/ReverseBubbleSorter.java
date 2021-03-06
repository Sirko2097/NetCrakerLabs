package firstpractise.sorters;

/**
 * This class is realization of reverse bubble sort.<br>
 * @see BubbleSorter
 *
 * @author Serhii Muzhylivskyi
 * */
public class ReverseBubbleSorter extends AbstractBubbleSorter {
    private int[] arr;

    public ReverseBubbleSorter(int[] arr) {
        super(arr);
        this.arr = arr;
    }

    public void sort() {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = arr.length - i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(j - 1, j);
                }
            }
        }
    }

    public int[] getArr() {
        return arr;
    }
}
