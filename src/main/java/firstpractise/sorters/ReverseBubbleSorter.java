package firstpractise.sorters;

public class ReverseBubbleSorter extends AbstractBubbleSorter {
    private int[] arr;

    public ReverseBubbleSorter(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        int tempElement;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = arr.length - i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    tempElement = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tempElement;
                }
            }
        }
    }

    public int[] getArr() {
        return arr;
    }
}
