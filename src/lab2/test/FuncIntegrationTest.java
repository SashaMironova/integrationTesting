package lab2.test;

import lab2.main.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class FuncIntegrationTest {
    public static FuncCalculator funcCalculator;
    double eps = 10E-2;

    @BeforeAll
    public static void prepare() {
        funcCalculator = new FuncCalculator(new TrigCalculator(new Sin()), new LogCalculator(new Ln()));
    }

    @Test
    public void oxIntersection() {
        assertEquals(0.0, funcCalculator.compute(-5.4141, eps), 0.1);
        assertEquals(0.0, funcCalculator.compute(0.29989, eps), 0.01);
    }

    @Test
    public void extremum() {
        assertEquals(Double.NaN, funcCalculator.compute(1, eps), 0.01);
    }


    @ParameterizedTest
    @CsvSource({
            "-3.0,	134397.90603269092",
            "-2.5,	38.11340603647396",
            "-2.0,	10.244535674883549",
            "-1.5,	201.58696795075517",
            "-1.0,	9.766944313064018",
            "-0.5,	129.88940762271162",
            "0.0,	NaN",
            "0.5,	2.5613061889028383",
            "1.0,	NaN",
            "1.5,	9.59691092797442",
            "2.0,	3.7654337770321717",
            "2.5,	2.6061184511470845"

    })
    public void resultCorrect(Double x, double expected){
        assertEquals(expected, funcCalculator.compute(x, eps/10), eps*10);
    }
}
