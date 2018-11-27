package firstpractise.sorters;

/**
 * Bubble sort realization
 * @author Serhii Muzhylivskyi
 * */
public class BubbleSorter extends AbstractBubbleSorter {

    private int[] arr;

    public BubbleSorter(int[] arr) {
        this.arr = arr;
    }

    public int[] getArr() {
        return arr;
    }

    @Override
    public void sort() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < (arr.length - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(j - 1, j);
                }
            }
        }
    }

    private void swap(int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
