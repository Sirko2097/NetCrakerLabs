package firstpractise.sorters;

public abstract class AbstractBubbleSorter extends AbstractSorter {
    public AbstractBubbleSorter(int[] arr) {
        super(arr);
    }

    public abstract void sort();
}
