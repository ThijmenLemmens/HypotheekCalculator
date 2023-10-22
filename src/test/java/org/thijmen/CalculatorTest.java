package org.thijmen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class CalculatorTest {

    @Test
    public void procentRentePerMaandEqualsTrue() {
        Hypotheek mockHypotheek = Mockito.mock(Hypotheek.class);
        Mockito.when(mockHypotheek.getProcentRente()).thenReturn(2.5);

        Calculator calculator = new Calculator(mockHypotheek);
        double result = calculator.procentRentePerMaand();

        Assertions.assertEquals(0.0020833333333333333, result);
    }

    @Test
    public void procentRentePerMaandEqualsFalse() {
        Hypotheek mockHypotheek = Mockito.mock(Hypotheek.class);
        Mockito.when(mockHypotheek.getProcentRente()).thenReturn(3.0);

        Calculator calculator = new Calculator(mockHypotheek);
        double result = calculator.procentRentePerMaand();

        Assertions.assertNotEquals(0.0020833333333333333, result);
    }

    @Test
    public void maxHypotheekLast() {
        Hypotheek mockHypotheek = Mockito.mock(Hypotheek.class);
        Mockito.when(mockHypotheek.getInkomen()).thenReturn(60000.0);
    }

}