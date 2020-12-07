package lab2.test;

import lab2.main.Ln;
import lab2.main.LogCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LogCalculatorTest {
    double eps =10E-6;

    @Test
    public void coreFunctionalityTest(){
        Ln lnMock = mock(Ln.class);
        when(lnMock.compute(0.313, eps/100)).thenReturn(0.313);
        when(lnMock.compute(0.137, eps/100)).thenReturn(0.137);

        LogCalculator logEvaluator = new LogCalculator(lnMock);
        assertEquals(0.313/0.137, logEvaluator.log(0.313,0.137, eps), eps);
    }

    @ParameterizedTest
    @CsvSource({
            "-1, 0, 1E-6",
            "NaN, 0, 1E-6",
            "Infinity, 0, 1E-6",
            "-Infinity, 0, 1E-6",
            "0, 0, NaN",
            "0, 0, Infinity",
            "0, 0, -Infinity",
            "0, -1, 1E-6",
            "0, NaN, 1E-6",
            "0, Infinity, 1E-6",
            "0, -Infinity, 1E-6",
    })
    public void failingValidation(Double x, Double base, Double eps){
        Ln lnMock = mock(Ln.class);
        LogCalculator logEval = new LogCalculator(lnMock);
        assertTrue(Double.isNaN(logEval.log(x, base, eps)));

    }

    @ParameterizedTest
    @CsvSource({
            "3,5,0.682606",
            "5,10,0.698970",
            "6,6,1",
            "3.13,2,1.646162"
    })
    public void LnIntegration(Double x, Double base, Double expected){
        LogCalculator logEval = new LogCalculator(new Ln());
        assertEquals(expected, logEval.log(x, base, eps), eps);
    }
}
