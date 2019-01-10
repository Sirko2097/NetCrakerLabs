package firstpractise.sorters.threads;

import firstpractise.sorters.BubbleSorter;

public class BubbleSortThread extends Thread {

    private int[] arr;

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        BubbleSorter bubbleSorter = new BubbleSorter(arr);
        bubbleSorter.sort();
        setArr(bubbleSorter.getArr());
    }
}
