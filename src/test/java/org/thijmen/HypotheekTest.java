package org.thijmen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HypotheekTest {

    @Mock
    private Calculator calculator;

    @InjectMocks
    private Hypotheek hypotheek;

    @Test
    public void checkZipcodeShouldBeTrue() {
        boolean result = hypotheek.checkZipcode("3524HJ");

        Assertions.assertTrue(result);
    }

    @Test
    public void checkZipcodeShouldBeFalse() {
        boolean result = hypotheek.checkZipcode("9679SW");

        Assertions.assertFalse(result);
    }

    @Test
    public void totaalBetalenEqualsTrue() {
        Mockito.when(calculator.totaalBetalen()).thenReturn(637498.8);

        double result = hypotheek.totaalBetalen();

        Assertions.assertEquals(637498.8, result);
    }

    @Test
    public void totaalBetalenEqualsFalse() {
        Mockito.when(calculator.totaalBetalen()).thenReturn(50000.0);

        double result = hypotheek.totaalBetalen();

        Assertions.assertNotEquals(637498.8, result);
    }

    @Test
    public void totaalMandBedragEqualsTrue() {
        Mockito.when(calculator.totaalMaandBedrag()).thenReturn(1770.83);

        double result = hypotheek.totaalMaandBedrag();

        Mockito.verify(calculator).totaalMaandBedrag();

        Assertions.assertEquals(1770.83, result);
    }

    @Test
    public void totaalMandBedragEqualsFalse() {
        Mockito.when(calculator.totaalMaandBedrag()).thenReturn(1720.83);

        double result = hypotheek.totaalMaandBedrag();

        Mockito.verify(calculator).totaalMaandBedrag();

        Assertions.assertNotEquals(1770.83, result);
    }

    @Test
    public void renteVastePeriode1EqualsTrue() {
        hypotheek.setRentevasteperiode(1);

        Assertions.assertEquals(2, hypotheek.getProcentRente());
    }

    @Test
    public void renteVastePeriode5EqualsTrue() {
        hypotheek.setRentevasteperiode(5);

        Assertions.assertEquals(3, hypotheek.getProcentRente());
    }

    @Test
    public void renteVastePeriode10EqualsTrue() {
        hypotheek.setRentevasteperiode(10);

        Assertions.assertEquals(3.5, hypotheek.getProcentRente());
    }

    @Test
    public void renteVastePeriode20EqualsTrue() {
        hypotheek.setRentevasteperiode(20);

        Assertions.assertEquals(4.5, hypotheek.getProcentRente());
    }

    @Test
    public void renteVastePeriode30EqualsTrue() {
        hypotheek.setRentevasteperiode(30);

        Assertions.assertEquals(5, hypotheek.getProcentRente());
    }

    @Test
    public void renteVastePeriodeEqualsFalse() {
        hypotheek.setRentevasteperiode(1);

        Assertions.assertNotEquals(5, hypotheek.getProcentRente());
    }

    @Test
    public void calculate() {
        Mockito.when(calculator.procentRentePerMaand()).thenReturn(5.0);
        Mockito.when(calculator.maxHypotheekLast()).thenReturn(250000.0);
        Mockito.when(calculator.rentePerMaand()).thenReturn(700.0);
        Mockito.when(calculator.aflossingsBedrag()).thenReturn(1000.0);
        Mockito.when(calculator.totaalMaandBedrag()).thenReturn(1770.83);
        Mockito.when(calculator.totaalBetalen()).thenReturn(600000.0);

        hypotheek.calculate();

        Mockito.verify(calculator).procentRentePerMaand();
        Mockito.verify(calculator).maxHypotheekLast();
        Mockito.verify(calculator).rentePerMaand();
        Mockito.verify(calculator).aflossingsBedrag();
        Mockito.verify(calculator).totaalMaandBedrag();
        Mockito.verify(calculator).totaalBetalen();
    }
}
