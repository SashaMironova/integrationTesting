package lab2.main;

import java.io.FileWriter;
import java.io.IOException;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import static java.lang.Math.E;
import static java.lang.Math.pow;


public class FuncCalculator {
    TrigCalculator trig;
    LogCalculator log;

    public FuncCalculator(TrigCalculator trig, LogCalculator log) {
        this.trig = trig;
        this.log = log;
    }

    CSVWriter writer;
    double Eps = 10E-4;

    public double compute(double x,double eps){
        if (Double.isNaN(x) || Double.isInfinite(x) || Double.isNaN(eps) || Double.isInfinite(eps)) return Double.NaN;
        return x>0? f2(x,eps): f1(x,eps);
    }

    public double f1(double x, double eps){
        return pow((((pow(trig.cot(x, eps),3)+trig.tan(x, eps))-(trig.csc(x, eps)*trig.cot(x,eps)))-(trig.sin(x,eps)*(trig.sec(x, eps)*(trig.csc(x,eps)-trig.sin(x,eps))))),2);
    }

    public double f2(double x,double eps){
        return (pow((((log.log(x,3.0,eps)-log.log(x,10.0,eps))/ log.log(x,5.0,eps)))/log.log(x,5.0,eps),2))+(log.log(x,10.0, eps)+log.log(x,10.0, eps));
    }

    public void createCSV(double startX, double endX, double step) throws IOException {
        if(startX>=endX)
            System.err.println("Wrong value");
        String csv = "log.csv";
        writer = new CSVWriter(new FileWriter(csv));
        String [] header = "x,f(x),sin(x),cos(x),tan(x),cot(x),sec(x),csc(x),log_3(x),log_5(x),log_10(x),ln(x)".split(",");
        writer.writeNext(header);
        while (startX<endX){
            writer.writeNext(startX+","+compute(startX,Eps)+","+ trig.sin(startX,Eps)+","+trig.cos(startX,Eps)+","+trig.tan(startX,Eps)+
                    ","+ trig.cot(startX,Eps)+","+trig.sec(startX,Eps)+","+trig.csc(startX,Eps)+","+log.log(startX,3.0, Eps)+","+log.log(startX,5.0,Eps)+","+log.log(startX,10.0,Eps)+","+ log.ln(startX,Eps));
            startX+=step;
        }
        writer.close();
    }
}
