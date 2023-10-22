package org.thijmen;

public class Calculator {

    private Hypotheek hypotheek;

    public Calculator(Hypotheek hypotheek) {
        this.hypotheek = hypotheek;
    }

    public double maxHypotheekLast() {
        double maxHypotheekLast = hypotheek.getInkomen() * 4.25;

        if (hypotheek.isStudySchuld())
            maxHypotheekLast *= 0.75;

        return maxHypotheekLast;
    }

    public double procentRentePerMaand() {
        return (hypotheek.getProcentRente() / 100) / 12;
    }

    public double rentePerMaand() {
        return hypotheek.getMaximaalTeLenen() * hypotheek.getProcentRentePerMaand();
    }

    public double aflossingsBedrag() {
        return hypotheek.getMaximaalTeLenen() / (hypotheek.getRentevastePeriode() * 12);
    }

    public double totaalMaandBedrag() {
        return hypotheek.getRenteBedragPerMaand() + hypotheek.getAflossingsBedrag();
    }

    public double totaalPerMaand() {
        return hypotheek.getTotaalMaandBedrag() * (hypotheek.getRentevastePeriode() * 12);
    }

}
