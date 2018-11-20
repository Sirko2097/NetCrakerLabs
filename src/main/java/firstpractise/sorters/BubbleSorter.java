package firstpractise.sorters;

public class BubbleSorter {

    private int[] arr;

    public BubbleSorter(int[] arr) {
        this.arr = arr;
    }

    int[] getArr() {
        return arr;
    }

    public void bubbleSort() {
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

    public void reverseBubbleSorter() {
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

    public void selectionSort() {
        int min;
        int nMin;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            nMin = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    nMin = j;
                }
            }

            arr[nMin] = arr[i];
            arr[i] = min;
        }
    }

}
