package org.thijmen;

import lombok.Getter;
import lombok.Setter;

public class Hypotheek {

    @Getter @Setter private double inkomen;
    @Getter @Setter private double procentRente;
    @Getter @Setter private double maximaalTeLenen;
    @Getter @Setter private boolean studySchuld;
    @Getter @Setter private double renteBedragPerMaand;
    @Getter @Setter private double aflossingsBedrag;
    @Getter @Setter private double totaalMaandBedrag;
    @Getter @Setter private int rentevastePeriode;

    private ZipCodeChecker zipCodeChecker;
    private Calculator calculator;

    public Hypotheek() {
        this.zipCodeChecker = new ZipCodeChecker();
        this.calculator = new Calculator(this);
    }

    public void setRentevasteperiode(int jaar) {
        switch (jaar) {
            case 1 -> this.procentRente = 2;
            case 5 -> this.procentRente = 3;
            case 10 -> this.procentRente = 3.5;
            case 20 -> this.procentRente = 4.5;
            case 30 -> this.procentRente = 5;
            default -> throw new IllegalArgumentException("Invalid jaar: " + jaar);
        }
        this.rentevastePeriode = jaar;
    }

    public boolean checkZipcode(String zipcode) {
        return zipCodeChecker.checkZipCode(zipcode);
    }

    public void calculate() {
        this.calculator.maxHypotheekLast();
        this.calculator.procentRentePerMaand();
    }

}
