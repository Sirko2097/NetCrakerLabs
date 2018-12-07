package firstpractise;

import firstpractise.analyzer.Analyzer;
import firstpractise.annotations.ArrayFiller;
import firstpractise.fillers.Filler;
import firstpractise.output.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * This is start of the program.<br>
 * In this class we fill arrays for sorting, by calling appropriate methods.
 *
 * @author Serhii Muzhylivskyi
 */
public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        ArrayList<LinkedHashMap<String, Long>> informationAboutMethods = new ArrayList<>();
        try (BufferedReader ignored = new BufferedReader(new InputStreamReader(System.in))) {

            int n = (int) (Math.random() * 9999);
            Filler filler = null;
            for (int delta = 0; delta < 10000; delta += 1000) {
                n += delta;

                filler = new Filler(n);
                Class<?> fClass = filler.getClass();

                for (Method m : fClass.getMethods()) {
                    if (m.isAnnotationPresent(ArrayFiller.class)) {
                        ArrayFiller arrayFiller = m.getAnnotation(ArrayFiller.class);
                        switch (arrayFiller.name()) {
                            case "Sorted":
                                informationAboutMethods.add(new Analyzer(arrayFiller.name(), (int[]) m.invoke(fClass)).analyze(filler));
                                break;
                            case "Reverse sorted array":
                                informationAboutMethods.add(new Analyzer(arrayFiller.name(), (int[]) m.invoke(fClass)).analyze(filler));
                                break;
                            case "Sorted random array":
                                informationAboutMethods.add(new Analyzer(arrayFiller.name(), (int[]) m.invoke(fClass)).analyze(filler));
                                break;
                            case "Random located elements":
                                informationAboutMethods.add(new Analyzer(arrayFiller.name(), (int[]) m.invoke(fClass)).analyze(filler));
                                break;
                        }
                    }
                }
            }
            View view = new View();
            view.printExcel(filler, informationAboutMethods);

        } catch (IOException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }
}
