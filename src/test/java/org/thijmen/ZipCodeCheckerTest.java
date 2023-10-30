package org.thijmen;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ZipCodeCheckerTest {

    @Test
    public void postcodeShouldBeTrue() {
        ZipCodeChecker zipCodeChecker = new ZipCodeChecker();

        boolean check = zipCodeChecker.checkZipCode("3524HJ");

        Assertions.assertTrue(check);
    }

    @Test
    public void postcodeShouldBeFalse() {
        ZipCodeChecker zipCodeChecker = new ZipCodeChecker();

        boolean check = zipCodeChecker.checkZipCode("9679SW");

        Assertions.assertFalse(check);
    }

}
