package firstpractise.sorters;

public abstract class AbstractBubbleSorter extends AbstractSorter {
    AbstractBubbleSorter(int[] arr) {
        super(arr);
    }

    public abstract void sort();
}
