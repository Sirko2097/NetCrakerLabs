package firstpractise.sorters;

/**
 * This is a parent class for all sorters.
 *
 * @author Serhii Muzhylivskyi
 */
public abstract class AbstractSorter {

    private int[] arr;

    AbstractSorter(int[] arr) {
        this.arr = arr;
    }

    public abstract void sort();

    /**
     * This method swaps two adjacent elements.
     *
     * @param left first element
     * @param right another element, which we need move
     */
    void swap(int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
