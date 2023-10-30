package org.thijmen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
    public void maxHypotheekLastEqualsTrue() {
        Hypotheek mockHypotheek = Mockito.mock(Hypotheek.class);
        Mockito.when(mockHypotheek.getInkomen()).thenReturn(60000.0);

        Calculator calculator = new Calculator(mockHypotheek);
        double result = calculator.maxHypotheekLast();

        Assertions.assertEquals(255000.0, result);
    }

    @Test
    public void maxHypotheekLastEqualsFalse() {
        Hypotheek mockHypotheek = Mockito.mock(Hypotheek.class);
        Mockito.when(mockHypotheek.getInkomen()).thenReturn(50000.0);

        Calculator calculator = new Calculator(mockHypotheek);
        double result = calculator.maxHypotheekLast();

        Assertions.assertNotEquals(255000.0, result);
    }

    @Test
    public void maxHypotheekWithStudyschuldLastEqualsTrue() {
        Hypotheek mockHypotheek = Mockito.mock(Hypotheek.class);
        Mockito.when(mockHypotheek.getInkomen()).thenReturn(60000.0);
        Mockito.when(mockHypotheek.isStudySchuld()).thenReturn(true);

        Calculator calculator = new Calculator(mockHypotheek);
        double result = calculator.maxHypotheekLast();

        Assertions.assertEquals(191250.0, result);
    }

    @Test
    public void maxHypotheekWithStudyschuldLastEqualsFalse() {
        Hypotheek mockHypotheek = Mockito.mock(Hypotheek.class);
        Mockito.when(mockHypotheek.getInkomen()).thenReturn(60000.0);
        Mockito.when(mockHypotheek.isStudySchuld()).thenReturn(false);

        Calculator calculator = new Calculator(mockHypotheek);
        double result = calculator.maxHypotheekLast();

        Assertions.assertNotEquals(191250.0, result);
    }

    @Test
    public void rentePerMaandEqualsTrue() {
        Hypotheek mockHypotheek = Mockito.mock(Hypotheek.class);
        Mockito.when(mockHypotheek.getMaximaalTeLenen()).thenReturn(255000.0);
        Mockito.when(mockHypotheek.getProcentRentePerMaand()).thenReturn(0.00416666666666666666666666666667);

        Calculator calculator = new Calculator(mockHypotheek);
        double result = calculator.rentePerMaand();

        Assertions.assertEquals(1062.5, result);
    }

    @Test
    public void rentePerMaandEqualsFalse() {
        Hypotheek mockHypotheek = Mockito.mock(Hypotheek.class);
        Mockito.when(mockHypotheek.getMaximaalTeLenen()).thenReturn(255000.0);
        Mockito.when(mockHypotheek.getProcentRentePerMaand()).thenReturn(0.0030833333333333333);

        Calculator calculator = new Calculator(mockHypotheek);
        double result = calculator.rentePerMaand();

        Assertions.assertNotEquals(1062.5, result);
    }

    @Test
    public void aflossingsBedragEqualsTrue() {
        Hypotheek mockHypotheek = Mockito.mock(Hypotheek.class);
        Mockito.when(mockHypotheek.getMaximaalTeLenen()).thenReturn(255000.0);
        Mockito.when(mockHypotheek.getRentevastePeriode()).thenReturn(30);

        Calculator calculator = new Calculator(mockHypotheek);
        double result = calculator.aflossingsBedrag();

        Assertions.assertEquals(708.3333333333334, result);
    }

    @Test
    public void aflossingsBedragEqualsFalse() {
        Hypotheek mockHypotheek = Mockito.mock(Hypotheek.class);
        Mockito.when(mockHypotheek.getMaximaalTeLenen()).thenReturn(255000.0);
        Mockito.when(mockHypotheek.getRentevastePeriode()).thenReturn(10);

        Calculator calculator = new Calculator(mockHypotheek);
        double result = calculator.aflossingsBedrag();

        Assertions.assertNotEquals(708.33, result);
    }

    @Test
    public void totaalMaandBedragEqualsTrue() {
        Hypotheek mockHypotheek = Mockito.mock(Hypotheek.class);
        Mockito.when(mockHypotheek.getRenteBedragPerMaand()).thenReturn(1062.5);
        Mockito.when(mockHypotheek.getAflossingsBedrag()).thenReturn(708.33);

        Calculator calculator = new Calculator(mockHypotheek);
        double result = calculator.totaalMaandBedrag();

        Assertions.assertEquals(1770.83, result);
    }

    @Test
    public void totaalMaandBedragEqualsFalse() {
        Hypotheek mockHypotheek = Mockito.mock(Hypotheek.class);
        Mockito.when(mockHypotheek.getRenteBedragPerMaand()).thenReturn(1062.5);
        Mockito.when(mockHypotheek.getAflossingsBedrag()).thenReturn(500.0);

        Calculator calculator = new Calculator(mockHypotheek);
        double result = calculator.totaalMaandBedrag();

        Assertions.assertNotEquals(1770.83, result);
    }

    @Test
    public void totaalBetalenEqualsTrue() {
        Hypotheek mockHypotheek = Mockito.mock(Hypotheek.class);
        Mockito.when(mockHypotheek.getTotaalMaandBedrag()).thenReturn(1770.83);
        Mockito.when(mockHypotheek.getRentevastePeriode()).thenReturn(30);

        Calculator calculator = new Calculator(mockHypotheek);
        double result = calculator.totaalBetalen();

        Assertions.assertEquals(637498.7999999999, result);
    }

    @Test
    public void totaalBetalenEqualsFalse() {
        Hypotheek mockHypotheek = Mockito.mock(Hypotheek.class);
        Mockito.when(mockHypotheek.getTotaalMaandBedrag()).thenReturn(1770.83);
        Mockito.when(mockHypotheek.getRentevastePeriode()).thenReturn(5);

        Calculator calculator = new Calculator(mockHypotheek);
        double result = calculator.totaalBetalen();

        Assertions.assertNotEquals(637498.8, result);
    }

}