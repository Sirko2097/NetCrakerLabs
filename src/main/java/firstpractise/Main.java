package firstpractise;

import firstpractise.analyzer.Analyzer;
import firstpractise.annotations.SortedArray;
import firstpractise.fillers.Filler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        System.out.print("Input amount of elements: ");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            Filler filler = new Filler(n);
            Class<?> c = filler.getClass();
            Method m = c.getMethod("getSortedArray");
            SortedArray anno = m.getAnnotation(SortedArray.class);

            new Analyzer("Sorted", Filler.getSortedArray()).analyze();
            new Analyzer("Reverse sorted array", Filler.getReverseSortedArray()).analyze();
            new Analyzer("Sorted random array", Filler.getSortedArrayWithRandomElement()).analyze();
            new Analyzer("Random located elements", Filler.getArrayWithRandomLocatedElements()).analyze();
        } catch (IOException | NoSuchMethodException ex) {
            ex.printStackTrace();
        }
    }
}
