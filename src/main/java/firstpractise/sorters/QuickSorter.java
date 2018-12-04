package firstpractise.sorters;

/**
 * Quick Sort implementation.
 *
 * @author Serhii Muzhylivskyi
 * */
public class QuickSorter extends AbstractSorter {

    private int[] arr;

    public QuickSorter(int[] arr) {
        super(arr);
        this.arr = arr;
    }

    public int[] getArr() {
        return arr;
    }

    public void sort() {
        quickSort(0, arr.length - 1);
    }

    private void quickSort(int low, int high) {
        int size = high - low + 1;
        if (size <= 3) {
            manualSort(low, high);
        } else {
            int pivot = medianOf3(low, high);
            int part = partition(low, high, pivot);
            quickSort(low, part - 1);
            quickSort(part + 1, high);
        }
    }

    private int medianOf3(int low, int high) {
        int mid = (low + high) / 2;

        if (arr[low] > arr[mid]) {
            swap(low, mid);
        }

        if (arr[low] > arr[high]) {
            swap(low, high);
        }

        if (arr[mid] > arr[high]) {
            swap(mid, high);
        }

        swap(mid, high - 1);
        return arr[high - 1];
    }

    private int partition(int low, int high, int pivot) {
        int leftPtr = low;
        int rightPtr = high - 1;

        while (true) {
            while (arr[++leftPtr] < pivot) ;
            while (arr[--rightPtr] > pivot) ;

            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        swap(leftPtr, high - 1);
        return leftPtr;
    }


    private void manualSort(int low, int high) {
        int size = high - low + 1;

        if (size <= 1) {
            return;
        }

        if (size == 2) {
            if (arr[low] > arr[high]) {
                swap(low, high);
            }
        } else {
            if (arr[low] > arr[high - 1]) {
                swap(low, high - 1);
            }
            if (arr[low] > arr[high]) {
                swap(low, high);
            }
            if (arr[high - 1] > arr[high]) {
                swap(high - 1, high);
            }
        }
    }
}
