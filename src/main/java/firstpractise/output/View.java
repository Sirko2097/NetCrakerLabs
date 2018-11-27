package firstpractise.output;

import java.util.Map;

/**
 * This class is using to output information.
 * @author Serhii Muzhylivskyi
 * */
public class View {

    private Map<String, Long> times;
    private String type;

    public View(Map<String, Long> times, String type) {
        this.times = times;
        this.type = type;
    }
/**
 * Method for printing from map.<br>
 * It prints "filler" method and sorting time.
 * */
    public void printAnswer() {
        System.out.println(type);
        times.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println();
    }
}
