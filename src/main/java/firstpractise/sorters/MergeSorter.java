package firstpractise.sorters;

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

        int[] firsPart = new int[middle];
        System.arraycopy(workSpace, 0, firsPart, 0, firsPart.length);
        firsPart = bubbleSort(firsPart);
        System.arraycopy(firsPart, 0, workSpace, 0, firsPart.length);

        int[] secondPart = new int[middle];
        System.arraycopy(workSpace, firsPart.length, secondPart, 0, secondPart.length);
        secondPart = reverseBubble(secondPart);
        System.arraycopy(secondPart, 0, workSpace, firsPart.length, secondPart.length);

        merge(workSpace);

    }

    private void mergeBubbleAndQuickSorts(int[] workSpace, int arrLength) {
        int middle = arrLength / 2;

        int[] firsPart = new int[middle];
        System.arraycopy(workSpace, 0, firsPart, 0, firsPart.length);
        firsPart = bubbleSort(firsPart);
        System.arraycopy(firsPart, 0, workSpace, 0, firsPart.length);

        int[] secondPart = new int[middle];
        System.arraycopy(workSpace, firsPart.length, secondPart, 0, secondPart.length);
        secondPart = quickSort(secondPart);
        System.arraycopy(secondPart, 0, workSpace, firsPart.length, secondPart.length);

        merge(workSpace);
    }

    private void mergeBubbleAndArraysSorts(int[] workSpace, int arrLength) {
        int middle = arrLength / 2;

        int[] firsPart = new int[middle];
        System.arraycopy(workSpace, 0, firsPart, 0, firsPart.length);
        firsPart = bubbleSort(firsPart);
        System.arraycopy(firsPart, 0, workSpace, 0, firsPart.length);

        int[] secondPart = new int[middle];
        System.arraycopy(workSpace, firsPart.length, secondPart, 0, secondPart.length);
        Arrays.sort(secondPart);
        System.arraycopy(secondPart, 0, workSpace, firsPart.length, secondPart.length);

        merge(workSpace);
    }

    private void mergeReverseBubbleAndQuickSorts(int[] workSpace, int arrLength) {
        int middle = arrLength / 2;

        int[] firsPart = new int[middle];
        System.arraycopy(workSpace, 0, firsPart, 0, firsPart.length);
        firsPart = reverseBubble(firsPart);
        System.arraycopy(firsPart, 0, workSpace, 0, firsPart.length);

        int[] secondPart = new int[middle];
        System.arraycopy(workSpace, firsPart.length, secondPart, 0, secondPart.length);
        secondPart = quickSort(secondPart);
        System.arraycopy(secondPart, 0, workSpace, firsPart.length, secondPart.length);

        merge(workSpace);
    }

    private void mergeReverseBubbleAndArraysSorts(int[] workSpace, int arrLength) {
        int middle = arrLength / 2;

        int[] firsPart = new int[middle];
        System.arraycopy(workSpace, 0, firsPart, 0, firsPart.length);
        firsPart = reverseBubble(firsPart);
        System.arraycopy(firsPart, 0, workSpace, 0, firsPart.length);

        int[] secondPart = new int[middle];
        System.arraycopy(workSpace, firsPart.length, secondPart, 0, secondPart.length);
        Arrays.sort(secondPart);
        System.arraycopy(secondPart, 0, workSpace, firsPart.length, secondPart.length);

        merge(workSpace);
    }

    private void mergeQuickAndArraysSorts(int[] workSpace, int arrLength) {
        int middle = arrLength / 2;

        int[] firsPart = new int[middle];
        System.arraycopy(workSpace, 0, firsPart, 0, firsPart.length);
        firsPart = quickSort(firsPart);
        System.arraycopy(firsPart, 0, workSpace, 0, firsPart.length);

        int[] secondPart = new int[middle];
        System.arraycopy(workSpace, firsPart.length, secondPart, 0, secondPart.length);
        Arrays.sort(secondPart);
        System.arraycopy(secondPart, 0, workSpace, firsPart.length, secondPart.length);

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

    private void merge(int[] workSpace) {
        System.arraycopy(workSpace, 0, arr, 0, workSpace.length);
        Arrays.sort(arr);
    }
}
