package firstpractise.sorters;

public class BubbleSorter extends AbstractBubbleSorter {

    private int[] arr;

    public BubbleSorter(int[] arr) {
        this.arr = arr;
    }

    int[] getArr() {
        return arr;
    }

    @Override
    public void sort() {
        int tempElement;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < (arr.length - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    tempElement = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tempElement;
                }
            }
        }
    }

}
