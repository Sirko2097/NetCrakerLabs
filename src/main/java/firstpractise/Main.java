package firstpractise;

import firstpractise.analyzer.Analyzer;
import firstpractise.filters.Generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        System.out.print("Input amount of elements: ");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            Generator generator = new Generator(n);
            new Analyzer("Sorted", generator.getSortedArray()).analyze();
            new Analyzer("Reverse sorted array", generator.getReverseSortedArray()).analyze();
            new Analyzer("Sorted random array", generator.getSortedArrayWithRandomElement()).analyze();
            new Analyzer("Random located elements", generator.getArrayWithRandomLocatedElements()).analyze();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
