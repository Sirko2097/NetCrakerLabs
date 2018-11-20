package firstpractise.output;

import java.util.Map;

public class View {

    private Map<String, Long> times;
    private String type;

    public View(Map<String, Long> times, String type) {
        this.times = times;
        this.type = type;
    }

    public void printAnswer() {
        System.out.println(type);
        times.forEach((k, v) -> System.out.println(k +": " + v));
        System.out.println();
    }
}
