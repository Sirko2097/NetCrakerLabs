package firstpractise.sorters;

import firstpractise.sorters.threads.ArraysSortThread;
import firstpractise.sorters.threads.BubbleSortThread;
import firstpractise.sorters.threads.QuickSortThread;
import firstpractise.sorters.threads.ReverseBubbleSortThread;

import java.util.Arrays;

public class MergeSorter {

    public int[] getArr() {
        return arr;
    }

    private int[] arr;

    public MergeSorter(int[] arr) {
        this.arr = arr;
    }


    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public void bothBubbleSort() {
        mergeBubbleSorts(arr, arr.length);
    }

    public void bubbleAndQuickSort() {
        mergeBubbleAndQuickSorts(arr, arr.length);
    }

    public void bubbleAndArraysSort() {
        mergeBubbleAndArraysSorts(arr, arr.length);
    }

    public void reverseBubbleAndQuickSort() {
        mergeReverseBubbleAndQuickSorts(arr, arr.length);
    }

    public void reverseBubbleAndArraysSort() {
        mergeReverseBubbleAndArraysSorts(arr, arr.length);
    }

    public void quickAndArraysSort() {
        mergeQuickAndArraysSorts(arr, arr.length);
    }

    private void mergeBubbleSorts(int[] workSpace, int arrLength) {
        int middle = arrLength / 2;

        int[] firstPart = new int[middle];
        System.arraycopy(workSpace, 0, firstPart, 0, firstPart.length);
        BubbleSortThread bubbleSortThread = new BubbleSortThread();
        bubbleSortThread.setArr(firstPart);

        int[] secondPart = new int[middle];
        System.arraycopy(workSpace, firstPart.length, secondPart, 0, secondPart.length);
        ReverseBubbleSortThread reverseBubbleSortThread = new ReverseBubbleSortThread();
        reverseBubbleSortThread.setArr(secondPart);

        bubbleSortThread.start();
        reverseBubbleSortThread.start();

        firstPart = bubbleSortThread.getArr();
        System.arraycopy(firstPart, 0, workSpace, 0, firstPart.length);
        secondPart = reverseBubbleSortThread.getArr();
        System.arraycopy(secondPart, 0, workSpace, firstPart.length, secondPart.length);

        merge(workSpace);
    }

    private void mergeBubbleAndQuickSorts(int[] workSpace, int arrLength) {
        int middle = arrLength / 2;

        int[] firstPart = new int[middle];
        System.arraycopy(workSpace, 0, firstPart, 0, firstPart.length);
        BubbleSortThread bubbleSortThread = new BubbleSortThread();
        bubbleSortThread.setArr(firstPart);

        int[] secondPart = new int[middle];
        System.arraycopy(workSpace, firstPart.length, secondPart, 0, secondPart.length);
        QuickSortThread quickSortThread = new QuickSortThread();
        quickSortThread.setArr(secondPart);

        bubbleSortThread.start();
        quickSortThread.start();

        firstPart = bubbleSortThread.getArr();
        System.arraycopy(firstPart, 0, workSpace, 0, firstPart.length);
        secondPart = quickSortThread.getArr();
        System.arraycopy(secondPart, 0, workSpace, firstPart.length, secondPart.length);

        merge(workSpace);
    }

    private void mergeBubbleAndArraysSorts(int[] workSpace, int arrLength) {
        int middle = arrLength / 2;

        int[] firstPart = new int[middle];
        System.arraycopy(workSpace, 0, firstPart, 0, firstPart.length);
        BubbleSortThread bubbleSortThread = new BubbleSortThread();
        bubbleSortThread.setArr(firstPart);

        int[] secondPart = new int[middle];
        System.arraycopy(workSpace, firstPart.length, secondPart, 0, secondPart.length);
        ArraysSortThread arraysSortThread = new ArraysSortThread();
        arraysSortThread.setArr(secondPart);

        bubbleSortThread.start();
        arraysSortThread.start();

        firstPart = bubbleSortThread.getArr();
        System.arraycopy(firstPart, 0, workSpace, 0, firstPart.length);
        secondPart = arraysSortThread.getArr();
        System.arraycopy(secondPart, 0, workSpace, firstPart.length, secondPart.length);

        merge(workSpace);
    }

    private void mergeReverseBubbleAndQuickSorts(int[] workSpace, int arrLength) {
        int middle = arrLength / 2;

        int[] firstPart = new int[middle];
        System.arraycopy(workSpace, 0, firstPart, 0, firstPart.length);
        ReverseBubbleSortThread reverseBubbleSortThread = new ReverseBubbleSortThread();
        reverseBubbleSortThread.setArr(firstPart);

        int[] secondPart = new int[middle];
        System.arraycopy(workSpace, firstPart.length, secondPart, 0, secondPart.length);
        QuickSortThread quickSortThread = new QuickSortThread();
        quickSortThread.setArr(secondPart);

        reverseBubbleSortThread.start();
        quickSortThread.start();

        firstPart = reverseBubbleSortThread.getArr();
        System.arraycopy(firstPart, 0, workSpace, 0, firstPart.length);
        secondPart = quickSortThread.getArr();
        System.arraycopy(secondPart, 0, workSpace, firstPart.length, secondPart.length);

        merge(workSpace);
    }

    private void mergeReverseBubbleAndArraysSorts(int[] workSpace, int arrLength) {
        int middle = arrLength / 2;

        int[] firstPart = new int[middle];
        System.arraycopy(workSpace, 0, firstPart, 0, firstPart.length);
        ReverseBubbleSortThread reverseBubbleSortThread = new ReverseBubbleSortThread();
        reverseBubbleSortThread.setArr(firstPart);

        int[] secondPart = new int[middle];
        System.arraycopy(workSpace, firstPart.length, secondPart, 0, secondPart.length);
        ArraysSortThread arraysSortThread = new ArraysSortThread();
        arraysSortThread.setArr(secondPart);

        reverseBubbleSortThread.start();
        arraysSortThread.start();

        firstPart = reverseBubbleSortThread.getArr();
        System.arraycopy(firstPart, 0, workSpace, 0, firstPart.length);
        secondPart = arraysSortThread.getArr();
        System.arraycopy(secondPart, 0, workSpace, firstPart.length, secondPart.length);

        merge(workSpace);
    }

    private void mergeQuickAndArraysSorts(int[] workSpace, int arrLength) {
        int middle = arrLength / 2;

        int[] firstPart = new int[middle];
        System.arraycopy(workSpace, 0, firstPart, 0, firstPart.length);
        QuickSortThread quickSortThread = new QuickSortThread();
        quickSortThread.setArr(firstPart);

        int[] secondPart = new int[middle];
        System.arraycopy(workSpace, firstPart.length, secondPart, 0, secondPart.length);
        ArraysSortThread arraysSortThread = new ArraysSortThread();
        arraysSortThread.setArr(secondPart);

        quickSortThread.start();
        arraysSortThread.start();

        firstPart = quickSortThread.getArr();
        System.arraycopy(firstPart, 0, workSpace, 0, firstPart.length);
        secondPart = arraysSortThread.getArr();
        System.arraycopy(secondPart, 0, workSpace, firstPart.length, secondPart.length);

        merge(workSpace);
    }

    private synchronized void merge(int[] workSpace) {
        System.arraycopy(workSpace, 0, arr, 0, workSpace.length);
        Arrays.sort(arr);
    }
}
