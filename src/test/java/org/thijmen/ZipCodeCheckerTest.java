package org.thijmen;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ZipCodeCheckerTest {

    @Test
    public void postcodeShouldBeTrue() {
        ZipCodeChecker zipCodeChecker = new ZipCodeChecker();

        boolean check = zipCodeChecker.checkZipCode("3524HJ");

        assertTrue(check);
    }

    @Test
    public void postcodeShouldBeFalse() {
        ZipCodeChecker zipCodeChecker = new ZipCodeChecker();

        boolean check = zipCodeChecker.checkZipCode("9679SW");

        assertFalse(check);
    }

}
