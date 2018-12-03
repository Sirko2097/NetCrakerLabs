package firstpractise.output;

import firstpractise.annotations.ArrayFiller;
import firstpractise.fillers.Filler;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.lang.reflect.Method;
import java.util.*;

import static java.util.Arrays.*;

/**
 * This class is using to output information.
 *
 * @author Serhii Muzhylivskyi
 */
public class View {

    private Map<String, Long> times;
    private String type;
    private final String name = "Answers.xlsx";

    public View(Map<String, Long> times, String type) {
        this.times = times;
        this.type = type;
    }

    /**
     * Method for printing from map.<br>
     * It prints "filler" method and their sorting time.
     */
    public void printAnswer(Filler filler) {
        System.out.println(type);
        times.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println();

        ArrayList<XSSFSheet> sheets = new ArrayList<>();
        List<String> columns = new ArrayList<>(times.keySet());
        List<Integer> rows = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook();

        Class<?> fClass = filler.getClass();
        for (Method m : fClass.getMethods()) {
            if (m.isAnnotationPresent(ArrayFiller.class)) {
                ArrayFiller arrayFiller = m.getAnnotation(ArrayFiller.class);
                sheets.add(workbook.createSheet(arrayFiller.name()));
            }
        }

        for (int i = 0; i < Filler.getN(); i++) {
            rows.add(i);
        }



    }
}
