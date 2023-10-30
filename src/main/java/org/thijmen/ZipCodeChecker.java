package org.thijmen;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZipCodeChecker {

    public boolean checkZipCode(String zipCode) {
        if (zipCode.matches("^\\d{4}\\s?[A-Z]{2}$")) {
            Pattern pattern = Pattern.compile("^\\d{4}");

            Matcher matcher = pattern.matcher(zipCode);

            if (matcher.find()) {
                int postcodeCijfer = Integer.parseInt(matcher.group());

                if (postcodeCijfer == 9679 || postcodeCijfer == 9681 || postcodeCijfer == 9682)
                    return false;
                else
                    return true;

            }
        }

        return false;
    }
}
