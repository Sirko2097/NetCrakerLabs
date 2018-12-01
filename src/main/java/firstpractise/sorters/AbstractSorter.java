package firstpractise.sorters;

public abstract class AbstractSorter {

    private int[] arr;

    public AbstractSorter(int[] arr) {
        this.arr = arr;
    }

    public abstract void sort();

    void swap(int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
