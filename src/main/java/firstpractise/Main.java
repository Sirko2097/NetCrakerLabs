package firstpractise;

import firstpractise.analyzer.Analyzer;
import firstpractise.annotations.ArrayFiller;
import firstpractise.fillers.Filler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * This is start of the program.<br>
 * In this class we fill arrays for sorting, by calling appropriate methods.
 *
 * @author Serhii Muzhylivskyi
 */
public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        System.out.print("Input amount of elements: ");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            Filler filler = new Filler(n);
            Class fClass = filler.getClass();
            for (Method m : fClass.getMethods()) {
                if (m.isAnnotationPresent(ArrayFiller.class)) {
                    ArrayFiller arrayFiller = m.getAnnotation(ArrayFiller.class);
                    switch (arrayFiller.name()) {
                        case "Sorted":
                            new Analyzer("Sorted", (int[]) m.invoke(fClass)).analyze();
                            break;
                        case "Reverse sorted array":
                            new Analyzer("Reverse sorted array", (int[]) m.invoke(fClass)).analyze();
                            break;
                        case "Sorted random array":
                            new Analyzer("Sorted random array", (int[]) m.invoke(fClass)).analyze();
                            break;
                        case "Random located elements":
                            new Analyzer("Random located elements", (int[]) m.invoke(fClass)).analyze();
                            break;
                    }
                }
            }
        } catch (IOException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }
}
