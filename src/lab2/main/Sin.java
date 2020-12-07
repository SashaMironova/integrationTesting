package lab2.main;

import static java.lang.Math.PI;
import static java.lang.Math.abs;

public class Sin {
    public double compute(double x,double eps){
        if (Double.isNaN(x) || Double.isInfinite(x))
            return Double.NaN;
//        if(x%PI == 0)
//            return 0;
//        if(x == 0 )
//            return 0;
//        if(x%(3*(PI/2)) ==0 )
//            return -1;
//        if(x%(PI/2) ==0 )
//            return 1;
        double sum=0;
        double preSum = x;
        int i=1;
        while (abs(preSum) > eps) {
            sum += preSum;
            preSum *= -x * x / (2 * i * (2 * i + 1));
            i++;
        }
        return sum;
    }
}
