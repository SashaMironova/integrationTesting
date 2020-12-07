package lab2.test;

import lab2.main.FuncCalculator;
import lab2.main.LogCalculator;
import lab2.main.TrigCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FuncCalculatorTest {
    double eps =1E-6;

    @Test
    public void positive(){
        LogCalculator logEvalMock = mock(LogCalculator.class);
        when(logEvalMock.log(313.0, 3.0, eps)).thenReturn(1.0);
        when(logEvalMock.log(313.0, 10.0, eps)).thenReturn(1.0);
        when(logEvalMock.log(313.0, 5.0, eps)).thenReturn(1.0);
        TrigCalculator trigEvalMock = mock(TrigCalculator.class);
        FuncCalculator funcEval = new FuncCalculator(trigEvalMock, logEvalMock);

        funcEval.compute(313.0, eps);

        verify(logEvalMock, times(1)).log(313.0, 3.0,  eps);
        verify(logEvalMock, times(2)).log(313.0, 5.0,  eps);
        verify(logEvalMock, times(3)).log(313.0, 10.0, eps);
    }

    @Test
    public void negative(){
        TrigCalculator trigEvalMock = mock(TrigCalculator.class);
        when(trigEvalMock.sin(-313.0, eps)).thenReturn(-313.0);
        when(trigEvalMock.csc(-313.0, eps)).thenReturn(-313.0);
        when(trigEvalMock.tan(-313.0, eps)).thenReturn(-313.0);
        when(trigEvalMock.cot(-313.0, eps)).thenReturn(-313.0);
        when(trigEvalMock.sec(-313.0, eps)).thenReturn(-313.0);
        LogCalculator logEvalMock = mock(LogCalculator.class);
        FuncCalculator funcEval = new FuncCalculator(trigEvalMock, logEvalMock);

        funcEval.compute(-313.0, eps);

        verify(trigEvalMock, times(2)).sin(-313.0, eps);
        verify(trigEvalMock, times(2)).csc(-313.0, eps);
        verify(trigEvalMock, times(1)).tan(-313.0, eps);
        verify(trigEvalMock, times(2)).cot(-313.0, eps);
        verify(trigEvalMock, times(1)).sec(-313.0, eps);

    }

    @Test
    public void validation() {
        TrigCalculator mockTrig = mock(TrigCalculator.class);
        LogCalculator mockLog = mock(LogCalculator.class);

        FuncCalculator f = new FuncCalculator(mockTrig, mockLog);

        assertTrue(Double.isNaN(f.compute(Double.NaN, 1.0)));
        assertTrue(Double.isNaN(f.compute(Double.POSITIVE_INFINITY, 1.0)));
        assertTrue(Double.isNaN(f.compute(Double.NEGATIVE_INFINITY, 1.0)));
        assertTrue(Double.isNaN(f.compute(1.0, Double.NaN )));
        assertTrue(Double.isNaN(f.compute(1.0, Double.POSITIVE_INFINITY)));
        assertTrue(Double.isNaN(f.compute(1.0, Double.NEGATIVE_INFINITY)));

    }

}