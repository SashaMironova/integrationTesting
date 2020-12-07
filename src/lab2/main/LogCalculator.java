package lab2.main;

public class LogCalculator {
    private Ln ln;

    public LogCalculator(Ln ln) {
        this.ln = ln;
    }

    public double ln(double x, double eps){
       return ln.compute(x,eps);
    }

    public Double log(Double x, Double base, Double eps) {
        if (x.isNaN() || x.isInfinite()
                || eps.isNaN() || eps.isInfinite()
                || base.isNaN() || base.isInfinite()) return Double.NaN;
        else return ln.compute(x, eps / 100) / ln.compute(base, eps / 100);
    }
}
