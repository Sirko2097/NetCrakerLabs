package firstpractise.sorters.threads;

import firstpractise.sorters.QuickSorter;

public class QuickSortThread extends Thread {

    private int[] arr;

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        QuickSorter quickSorter = new QuickSorter(arr);
        quickSorter.sort();
        setArr(quickSorter.getArr());
    }
}
