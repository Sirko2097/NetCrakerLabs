package firstpractise.analyzer;


import firstpractise.fillers.Filler;
import firstpractise.sorters.BubbleSorter;
import firstpractise.sorters.MergeSorter;
import firstpractise.sorters.QuickSorter;
import firstpractise.sorters.ReverseBubbleSorter;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;


public class AnalyzerTest {
    int[] arr = new int[9999];

    @Test(timeout = 10000)
    public void analyze() {
        new Filler(9999);
        arr = Filler.getArrayWithRandomLocatedElements();

        BubbleSorter bubbleSorter = new BubbleSorter(arr);
        bubbleSorter.sort();

        ReverseBubbleSorter reverse = new ReverseBubbleSorter(this.arr);
        reverse.sort();

        QuickSorter quickSorter = new QuickSorter(this.arr);
        quickSorter.sort();


        MergeSorter mergeSorter = new MergeSorter(this.arr);
        mergeSorter.bothBubbleSort();

        mergeSorter.setArr(this.arr);
        mergeSorter.bubbleAndQuickSort();

        mergeSorter.setArr(this.arr);
        mergeSorter.bubbleAndArraysSort();

        mergeSorter.setArr(this.arr);
        mergeSorter.reverseBubbleAndQuickSort();

        mergeSorter.setArr(this.arr);
        mergeSorter.reverseBubbleAndArraysSort();

        mergeSorter.setArr(this.arr);
        mergeSorter.quickAndArraysSort();

    }
}