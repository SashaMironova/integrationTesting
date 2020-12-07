package lab2.main;

import static java.lang.Math.*;
import static java.lang.Math.sin;

public class TrigCalculator {
    private Sin sin;

    public TrigCalculator(Sin sin) {
        this.sin = sin;
    }


    public double sin(Double x, Double eps){
        return sin.compute(x,eps);
    }

    public double cos(double x,double eps){
        double sign;
        if (((x % (2.0 * PI)) < -1.5 * PI) || ((x % (2.0 * PI)) > 1.5 * PI) ||
                ((x % (2.0 * PI)) < PI / 2) && ((x % (2.0 * PI)) > -PI / 2))
            sign = 1;
        else
            sign = -1;
        return sin(x + PI/2,eps);
    }


    public double tan(double x, double eps){
        return sin.compute(x,eps)/cos(x,eps);
    }

    public double cot(double x, double eps){
        return cos(x,eps)/sin.compute(x,eps);
    }

    public double sec(double x, double eps){
        return 1/cos(x, eps);
    }

    public double csc(double x, double eps){
        return 1/sin.compute(x,eps);
    }
}
