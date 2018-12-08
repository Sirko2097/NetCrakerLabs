package firstpractise.analyzer;


import firstpractise.fillers.Filler;
import firstpractise.sorters.BubbleSorter;
import firstpractise.sorters.MergeSorter;
import firstpractise.sorters.QuickSorter;
import firstpractise.sorters.ReverseBubbleSorter;
import org.junit.Test;

public class AnalyzerTest {

    @Test(timeout = 10000)
    public void analyze() {
        new Filler(99999);
        int[] arr = Filler.getArrayWithRandomLocatedElements();

        BubbleSorter bubbleSorter = new BubbleSorter(arr);
        bubbleSorter.sort();

        ReverseBubbleSorter reverse = new ReverseBubbleSorter(arr);
        reverse.sort();

        QuickSorter quickSorter = new QuickSorter(arr);
        quickSorter.sort();


        MergeSorter mergeSorter = new MergeSorter(arr);
        mergeSorter.bothBubbleSort();

        mergeSorter.setArr(arr);
        mergeSorter.bubbleAndQuickSort();

        mergeSorter.setArr(arr);
        mergeSorter.bubbleAndArraysSort();

        mergeSorter.setArr(arr);
        mergeSorter.reverseBubbleAndQuickSort();

        mergeSorter.setArr(arr);
        mergeSorter.reverseBubbleAndArraysSort();

        mergeSorter.setArr(arr);
        mergeSorter.quickAndArraysSort();

    }
}