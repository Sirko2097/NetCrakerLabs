package firstpractise.sorters.threads;

import java.util.Arrays;

public class ArraysSortThread extends Thread {
    private int[] arr;

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        Arrays.sort(arr);
    }
}

