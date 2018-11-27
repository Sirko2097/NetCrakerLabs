package firstpractise;

import firstpractise.analyzer.Analyzer;
import firstpractise.annotations.SortedArray;
import firstpractise.fillers.Generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        System.out.print("Input amount of elements: ");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            Generator generator = new Generator(n);
            Class<?> c = generator.getClass();
            Method m = c.getMethod("getSortedArray");
            SortedArray anno = m.getAnnotation(SortedArray.class);

            new Analyzer("Sorted", Generator.getSortedArray()).analyze();
            new Analyzer("Reverse sorted array", Generator.getReverseSortedArray()).analyze();
            new Analyzer("Sorted random array", Generator.getSortedArrayWithRandomElement()).analyze();
            new Analyzer("Random located elements", Generator.getArrayWithRandomLocatedElements()).analyze();
        } catch (IOException | NoSuchMethodException ex) {
            ex.printStackTrace();
        }
    }
}
