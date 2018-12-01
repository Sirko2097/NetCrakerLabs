package firstpractise.analyzer;

import firstpractise.output.View;
import firstpractise.sorters.BubbleSorter;
import firstpractise.sorters.MergeSorter;
import firstpractise.sorters.QuickSorter;
import firstpractise.sorters.ReverseBubbleSorter;

import java.util.*;

/**
 * This class is using for calculating sorting time.<br>
 * It takes type of array filling and the array.<br>
 * Then all information its writes into LinkerHashMap.
 *
 * @author Sergii Muzhylivskyi
 * */
public class Analyzer {

    private String generatorType;
    private final int[] arr;
    private int[] workSpace;

    public Analyzer(String generatorType, int[] arr) {
        this.generatorType = generatorType;
        this.arr = arr;
    }

    /**
     * This method calculates sorting for every type of filling.<br>
     * All information prints to LinkedHashMap and sends it to view class.<br>
     *
     * @see View
     */
    public void analyze() {
        Map<String, Long> time = new LinkedHashMap<>();
        long start;
        long end;

        BubbleSorter bubbleSorter = new BubbleSorter(arr);
        start = new GregorianCalendar().getTimeInMillis();
        bubbleSorter.sort();
        end = new GregorianCalendar().getTimeInMillis();
        time.put("Bubble", end - start);

        ReverseBubbleSorter reverse = new ReverseBubbleSorter(this.arr);
        start = new GregorianCalendar().getTimeInMillis();
        reverse.sort();
        end = new GregorianCalendar().getTimeInMillis();
        time.put("Reverse Bubble", end - start);

        QuickSorter quickSorter = new QuickSorter(this.arr);
        start = new GregorianCalendar().getTimeInMillis();
        quickSorter.sort();
        end = new GregorianCalendar().getTimeInMillis();
        time.put("Quick Sort", end - start);

        backup();
        start = new GregorianCalendar().getTimeInMillis();
        Arrays.sort(workSpace);
        end = new GregorianCalendar().getTimeInMillis();
        time.put("Arrays.sort()", end - start);

        MergeSorter mergeSorter = new MergeSorter(this.arr);
        start = new GregorianCalendar().getTimeInMillis();
        mergeSorter.bothBubbleSort();
        end = new GregorianCalendar().getTimeInMillis();
        time.put("Both Bubbles", end - start);

        mergeSorter.setArr(this.arr);
        start = new GregorianCalendar().getTimeInMillis();
        mergeSorter.bubbleAndQuickSort();
        end = new GregorianCalendar().getTimeInMillis();
        time.put("Bubble and Quick", end - start);

        mergeSorter.setArr(this.arr);
        start = new GregorianCalendar().getTimeInMillis();
        mergeSorter.bubbleAndArraysSort();
        end = new GregorianCalendar().getTimeInMillis();
        time.put("Bubble and Arrays.sort()", end - start);

        mergeSorter.setArr(this.arr);
        start = new GregorianCalendar().getTimeInMillis();
        mergeSorter.reverseBubbleAndQuickSort();
        end = new GregorianCalendar().getTimeInMillis();
        time.put("Reverse and Quick", end - start);

        mergeSorter.setArr(this.arr);
        start = new GregorianCalendar().getTimeInMillis();
        mergeSorter.reverseBubbleAndArraysSort();
        end = new GregorianCalendar().getTimeInMillis();
        time.put("Reverse and Arrays.sort()", end - start);

        mergeSorter.setArr(this.arr);
        start = new GregorianCalendar().getTimeInMillis();
        mergeSorter.quickAndArraysSort();
        end = new GregorianCalendar().getTimeInMillis();
        time.put("Quick and Arrays.sort()", end - start);

        new View(time, generatorType).printAnswer();
    }

    private void backup() {
        workSpace = arr;
    }
}
