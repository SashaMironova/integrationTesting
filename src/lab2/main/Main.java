package lab2.main;
import java.io.IOException;
import java.lang.System;

public class Main {
    public static void main(String[] args) throws IOException {
        Sin sin = new Sin();
        Ln ln = new Ln();
        double eps = 1E-7;
        TrigCalculator trigCalculator = new TrigCalculator(sin);
        LogCalculator logCalculator = new LogCalculator(ln);
        FuncCalculator function = new FuncCalculator(trigCalculator, logCalculator);
        double x = 7*(Math.PI/2);

        System.out.println(sin.compute(x,eps));
        System.out.println(Math.sin(x));
        function.createCSV(-5,5,0.25);

    }
}
