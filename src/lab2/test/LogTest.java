package lab2.test;

import lab2.main.Ln;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogTest {
        public static Ln ln;
        double eps = 10E-8;

        @BeforeAll
        public static void prepare(){
            ln = new Ln();
        }

        @Test
        public void oxIntersection(){
            assertEquals(0.0, ln.compute(1.0, eps), eps);
        }

        @ParameterizedTest
        @CsvSource({
                "-1,1E-6",
                "NaN,1E-6",
                "Infinity,1E-6",
                "-Infinity,1E-6",
                "0,NaN",
                "0,Infinity",
                "0,-Infinity"
        })
        public void failingValidation(Double x, Double eps){
            assertTrue(Double.isNaN(ln.compute(x, eps)));
        }

        @ParameterizedTest
        @CsvSource({
                "0.01, -4.605170",
                "0.13, -2.040221",
                "1.0, 0.0000000",
                "3.0, 1.098612",
                "0.07, -2.659260",
                "0.565, -0.570930",
                "2.0, 0.693147",
                "50.0, 3.912023"
        })
        public void successValidation(Double x, Double expected) {
            assertEquals(expected, ln.compute(x, eps/100), eps*100);
        }
    }

