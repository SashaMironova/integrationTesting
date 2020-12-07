package lab2.main;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Ln {
    public  double compute(double x,double eps){
        if (Double.isNaN(x) || Double.isInfinite(x) || x <= 0)
            return Double.NaN;
        if(x==1) return 0;
        double z = (x-1)/(x+1);
        double preSum = 0;
        double sum = 2*z;
        int i=1;
        while (abs(-preSum + sum) > eps) {
            preSum = sum;
            sum+= 2*pow(z,2*i+1)/(2*i+1);
            i++;
        }
        return  sum;

    }
}
