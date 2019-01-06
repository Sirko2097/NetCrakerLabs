package firstpractise.sorters;

import firstpractise.sorters.threads.BubbleSortThread;
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

        bubbleSortThread.run();
        reverseBubbleSortThread.run();

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
        firstPart = bubbleSort(firstPart);
        System.arraycopy(firstPart, 0, workSpace, 0, firstPart.length);

        int[] secondPart = new int[middle];
        System.arraycopy(workSpace, firstPart.length, secondPart, 0, secondPart.length);
        secondPart = quickSort(secondPart);
        System.arraycopy(secondPart, 0, workSpace, firstPart.length, secondPart.length);

        merge(workSpace);
    }

    private void mergeBubbleAndArraysSorts(int[] workSpace, int arrLength) {
        int middle = arrLength / 2;

        int[] firstPart = new int[middle];
        System.arraycopy(workSpace, 0, firstPart, 0, firstPart.length);
        firstPart = bubbleSort(firstPart);
        System.arraycopy(firstPart, 0, workSpace, 0, firstPart.length);

        int[] secondPart = new int[middle];
        System.arraycopy(workSpace, firstPart.length, secondPart, 0, secondPart.length);
        Arrays.sort(secondPart);
        System.arraycopy(secondPart, 0, workSpace, firstPart.length, secondPart.length);

        merge(workSpace);
    }

    private void mergeReverseBubbleAndQuickSorts(int[] workSpace, int arrLength) {
        int middle = arrLength / 2;

        int[] firstPart = new int[middle];
        System.arraycopy(workSpace, 0, firstPart, 0, firstPart.length);
        firstPart = reverseBubble(firstPart);
        System.arraycopy(firstPart, 0, workSpace, 0, firstPart.length);

        int[] secondPart = new int[middle];
        System.arraycopy(workSpace, firstPart.length, secondPart, 0, secondPart.length);
        secondPart = quickSort(secondPart);
        System.arraycopy(secondPart, 0, workSpace, firstPart.length, secondPart.length);

        merge(workSpace);
    }

    private void mergeReverseBubbleAndArraysSorts(int[] workSpace, int arrLength) {
        int middle = arrLength / 2;

        int[] firstPart = new int[middle];
        System.arraycopy(workSpace, 0, firstPart, 0, firstPart.length);
        firstPart = reverseBubble(firstPart);
        System.arraycopy(firstPart, 0, workSpace, 0, firstPart.length);

        int[] secondPart = new int[middle];
        System.arraycopy(workSpace, firstPart.length, secondPart, 0, secondPart.length);
        Arrays.sort(secondPart);
        System.arraycopy(secondPart, 0, workSpace, firstPart.length, secondPart.length);

        merge(workSpace);
    }

    private void mergeQuickAndArraysSorts(int[] workSpace, int arrLength) {
        int middle = arrLength / 2;

        int[] firstPart = new int[middle];
        System.arraycopy(workSpace, 0, firstPart, 0, firstPart.length);
        firstPart = quickSort(firstPart);
        System.arraycopy(firstPart, 0, workSpace, 0, firstPart.length);

        int[] secondPart = new int[middle];
        System.arraycopy(workSpace, firstPart.length, secondPart, 0, secondPart.length);
        Arrays.sort(secondPart);
        System.arraycopy(secondPart, 0, workSpace, firstPart.length, secondPart.length);

        merge(workSpace);
    }

    private int[] bubbleSort(int[] workArr) {
        BubbleSorter bubbleSorter = new BubbleSorter(workArr);
        bubbleSorter.sort();
        return bubbleSorter.getArr();
    }

    private int[] reverseBubble(int[] workArr) {
        ReverseBubbleSorter reverseBubbleSorter = new ReverseBubbleSorter(workArr);
        reverseBubbleSorter.sort();
        return reverseBubbleSorter.getArr();
    }

    private int[] quickSort(int[] workArr) {
        QuickSorter quickSorter = new QuickSorter(workArr);
        quickSorter.sort();
        return quickSorter.getArr();
    }

    private synchronized void merge(int[] workSpace) {
        System.arraycopy(workSpace, 0, arr, 0, workSpace.length);
        Arrays.sort(arr);
    }
}
