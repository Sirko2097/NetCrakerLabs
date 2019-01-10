package firstpractise.sorters.threads;

import firstpractise.sorters.ReverseBubbleSorter;

public class ReverseBubbleSortThread extends Thread {

    private int[] arr;

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        ReverseBubbleSorter reverseBubbleSorter = new ReverseBubbleSorter(arr);
        reverseBubbleSorter.sort();
        setArr(reverseBubbleSorter.getArr());
    }
}
