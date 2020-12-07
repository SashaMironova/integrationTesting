package lab2.test;

import lab2.main.Sin;
import lab2.main.TrigCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TrigCalculatorTest {
    @Test
    public void sin(){
        Sin mockSin = mock(Sin.class);
        when(mockSin.compute(1, 1.0)).thenReturn(1.0);
        TrigCalculator trigEval = new TrigCalculator(mockSin);

        assertEquals(1, trigEval.sin(1.0, 1.0));
    }

    @Test
    public void cos(){
        Sin mockSin = mock(Sin.class);
        when(mockSin.compute(10.0 + Math.PI / 2, 1.0)).thenReturn(5.0);
        TrigCalculator trigEval = new TrigCalculator(mockSin);

        assertEquals(5, trigEval.cos(10.0, 1.0));
    }

    @Test
    public void tan(){
        Sin mockSin = mock(Sin.class);
        when(mockSin.compute(10.0, 1.0)).thenReturn(10.0);
        when(mockSin.compute(10.0 + Math.PI / 2, 1.0)).thenReturn(-1.0);
        TrigCalculator trigEval = new TrigCalculator(mockSin);

        assertEquals(-10.0, trigEval.tan(10.0, 1.0));
    }

    @Test
    public void cot(){
        Sin mockSin = mock(Sin.class);
        when(mockSin.compute(10.0, 1.0)).thenReturn(10.0);
        when(mockSin.compute(10.0 + Math.PI / 2, 1.0)).thenReturn(5.0);
        TrigCalculator trigEval = new TrigCalculator(mockSin);

        assertEquals(0.5, trigEval.cot(10.0, 1.0));
    }

    @Test
    public void csc(){
        Sin mockSin = mock(Sin.class);
        when(mockSin.compute(10.0, 1.0)).thenReturn(10.0);
        TrigCalculator trigEval = new TrigCalculator(mockSin);

        assertEquals(0.1, trigEval.csc(10.0, 1.0));
    }



    @Test
    public void sinTest(){
        TrigCalculator trigEval = new TrigCalculator(new Sin());
        assertEquals(Double.NaN, trigEval.sin(Double.NaN, 1.0));
        assertEquals(Double.NaN, trigEval.sin(Double.POSITIVE_INFINITY, 1.0));
        assertEquals(Double.NaN, trigEval.sin(Double.NEGATIVE_INFINITY, 1.0));
    }

    @Test
    public void cosTest(){
        TrigCalculator trigEval = new TrigCalculator(new Sin());
        assertEquals(Double.NaN, trigEval.cos(Double.NaN, 1.0));
        assertEquals(Double.NaN, trigEval.cos(Double.POSITIVE_INFINITY, 1.0));
        assertEquals(Double.NaN, trigEval.cos(Double.NEGATIVE_INFINITY, 1.0));
    }

    @Test
    public void tanTest(){
        TrigCalculator trigEval = new TrigCalculator(new Sin());
        assertEquals(Double.NaN, trigEval.tan(Double.NaN, 1.0));
        assertEquals(Double.NaN, trigEval.tan(Double.POSITIVE_INFINITY, 1.0));
        assertEquals(Double.NaN, trigEval.tan(Double.NEGATIVE_INFINITY, 1.0));
    }

    @Test
    public void cotValidation(){
        TrigCalculator trigEval = new TrigCalculator(new Sin());
        assertEquals(Double.NaN, trigEval.cot(Double.NaN, 1.0));
        assertEquals(Double.NaN, trigEval.cot(Double.POSITIVE_INFINITY, 1.0));
        assertEquals(Double.NaN, trigEval.cot(Double.NEGATIVE_INFINITY, 1.0));
    }

    @Test
    public void cscValidation(){
        TrigCalculator trigEval = new TrigCalculator(new Sin());
        assertEquals(Double.NaN, trigEval.csc(Double.NaN, 1.0));
        assertEquals(Double.NaN, trigEval.csc(Double.POSITIVE_INFINITY, 1.0));
        assertEquals(Double.NaN, trigEval.csc(Double.NEGATIVE_INFINITY, 1.0));
    }
}
