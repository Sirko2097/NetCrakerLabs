package firstpractise.output;

import firstpractise.annotations.ArrayFiller;
import firstpractise.fillers.Filler;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.charts.*;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLineSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;


/**
 * This class is using to output information.
 *
 * @author Serhii Muzhylivskyi
 */
public class View {

    private Map<String, Long> times;
    private String type;

    public View() {
    }

    public View(Map<String, Long> times, String type) {
        this.times = times;
        this.type = type;
    }

    /**
     * Method for printing from map.<br>
     * It prints "filler" method and their sorting time.
     */
    public void printAnswer() {
        System.out.println(type);
        times.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println();
    }

    public void printExcel(Filler filler, ArrayList<LinkedHashMap<String, Long>> infoAboutTime) {
        ArrayList<XSSFSheet> sheets = new ArrayList<>();
        List<String> columns = new ArrayList<>(infoAboutTime.get(0).keySet());
        ArrayList<Integer> rows = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook();

        Class<?> fClass = filler.getClass();
        for (Method m : fClass.getMethods()) {
            if (m.isAnnotationPresent(ArrayFiller.class)) {
                ArrayFiller arrayFiller = m.getAnnotation(ArrayFiller.class);
                sheets.add(workbook.createSheet(arrayFiller.name()));
            }
        }

        for (int i = Filler.getN() - 1; i >= 0; i--) {
            if (i % 1000 == 0) {
                rows.add(i);
            }
        }

        Integer[] rowArray = new Integer[rows.size()];
        for (int i = 0; i < rows.size(); i++) {
            rowArray[i] = rows.get(rows.size() - i - 1);
        }

        int rowNumber = 0;
        int columnNumber = 0;
        int i = 0;
        int step = 0;
        System.out.println("Writing data into Excel");
        for (XSSFSheet sheet : sheets) {
            Row row = sheet.createRow(0);
            for (String column : columns) {
                Cell cell = row.createCell(++columnNumber);
                cell.setCellValue(column);
            }

            columnNumber = 0;
            for (Integer integer : rows) {
                row = sheet.createRow(++rowNumber);
                Cell cell = row.createCell(columnNumber);
                cell.setCellValue(integer);
            }
            rowNumber = 0;

            Drawing drawing = sheet.createDrawingPatriarch();
            ClientAnchor anchor = drawing.createAnchor(1, 1, 1, 1, 6, 3, 19, 20);

            Chart chart = drawing.createChart(anchor);
            ChartLegend legend = chart.getOrCreateLegend();
            legend.setPosition(LegendPosition.RIGHT);

            LineChartData data = chart.getChartDataFactory().createLineChartData();

            ChartAxis bottomAxis = chart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
            ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
            leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

            ChartDataSource<Integer> x = DataSources.fromArray(rowArray);
            ArrayList<ChartDataSource<Number>> y = new ArrayList<>();

            ArrayList<Long> timeOfSort = new ArrayList<>();
            for (int k = 0; k < infoAboutTime.get(i).keySet().size() - 1; k++) {
                timeOfSort.addAll(infoAboutTime.get(i).values());
                i += 4;
            }
            Long[] item = new Long[10];
            int it = 0;
            for (int j = step; j < timeOfSort.size(); j += 10) {
                item[it] = timeOfSort.get(j);
                it++;
            }
            step++;
            for (int k = 0; k < 10; k++) {
                y.add(DataSources.fromArray(item));
            }

            LineChartSeries series1 = data.addSeries(x, y.get(0));
            series1.setTitle("Bubble");
            LineChartSeries series2 = data.addSeries(x, y.get(1));
            series2.setTitle("Reverse Bubble");
            LineChartSeries series3 = data.addSeries(x, y.get(2));
            series3.setTitle("Quick Sort");
            LineChartSeries series4 = data.addSeries(x, y.get(3));
            series4.setTitle("Arrays.sort()");
            LineChartSeries series5 = data.addSeries(x, y.get(4));
            series5.setTitle("Both Bubbles");
            LineChartSeries series6 = data.addSeries(x, y.get(5));
            series6.setTitle("Bubble and Quick");
            LineChartSeries series7 = data.addSeries(x, y.get(6));
            series7.setTitle("Bubble and Arrays.sort()");
            LineChartSeries series8 = data.addSeries(x, y.get(7));
            series8.setTitle("Reverse and Quick");
            LineChartSeries series9 = data.addSeries(x, y.get(8));
            series9.setTitle("Reverse and Arrays.sort()");
            LineChartSeries series10 = data.addSeries(x, y.get(9));
            series10.setTitle("Quick and Arrays.sort()");

            chart.plot(data, bottomAxis, leftAxis);
            XSSFChart xssfChart = (XSSFChart) chart;
            CTPlotArea plotArea = xssfChart.getCTChart().getPlotArea();
            plotArea.getLineChartArray()[0].getSmooth();
            CTBoolean ctBool = CTBoolean.Factory.newInstance();
            ctBool.setVal(false);
            plotArea.getLineChartArray()[0].setSmooth(ctBool);
            for (CTLineSer ser : plotArea.getLineChartArray()[0].getSerArray()) {
                ser.setSmooth(ctBool);
            }

            y.clear();
            i = 1;
        }

        String NAME = "Answers.xlsx";
        try (FileOutputStream fileOutputStream = new FileOutputStream(NAME)) {
            workbook.write(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done\n");
    }
}
