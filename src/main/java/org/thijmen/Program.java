package org.thijmen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    private Hypotheek hypotheek;

    public Program() {
        hypotheek = new Hypotheek();
    }

    public void run() {
        if (!postcode())
            System.exit(-1);

        periode();
        inkomen();
        studieSchuld();

        hypotheek.calculate();
        showInfo();
        reset();
    }

    private void inkomen() {
        boolean loop = true;

        do {
            try {
                System.out.print("Voer u inkomen in: ");
                Scanner scanner = new Scanner(System.in);

                double inkomen = scanner.nextDouble();

                if (inkomen == -1)
                    break;

                hypotheek.setInkomen(hypotheek.getInkomen() + inkomen);
                System.out.println("-1 is stop");
            } catch (InputMismatchException e) {
                System.out.println("Ongeldige invoer. Voer een geldig getal in.");
            }

        } while (loop);
    }

    private boolean postcode() {
        do {
            try {
                System.out.print("Voer je postcode in: ");
                Scanner scanner = new Scanner(System.in);
                String postcode = scanner.next();

                if (!hypotheek.checkZipcode(postcode)) {
                    System.out.println("Deze zipcode is geldig!");
                    return true;
                } else {
                    System.out.println("Deze zipcode is niet geldig!");
                    return false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ongeldige invoer. Voer een geldig getal in.");
            }
        } while(true);
    }

    private void studieSchuld() {
        boolean loop = true;

        do {
            try {
                System.out.println("Heb je studieschuld? y - n");
                Scanner scanner = new Scanner(System.in);
                String studieSchuld = scanner.next();

                if (studieSchuld.equals("y")) {
                    hypotheek.setStudySchuld(true);
                    loop = false;
                } else if (studieSchuld.equals("n"))
                    hypotheek.setStudySchuld(false);
                    loop = false;
            } catch (InputMismatchException e) {
                System.out.println("Ongeldige invoer. Voer een geldig getal in.");
            }

        } while(loop);
    }

    private void periode() {
        boolean loop = true;

        do {
            try {
                System.out.println("\nHoe lang is hoe rentevaste periode?");
                System.out.println("1. 1 jaar 2%\n" +
                        "2. 5 jaar 3%\n" +
                        "3. 10 jaar 3,5%\n" +
                        "4. 20 jaar 4.5%\n" +
                        "5. 30 jaar 5%");
                Scanner scanner = new Scanner(System.in);

                int rentevastePeriode = scanner.nextInt();

                if (rentevastePeriode < 6  && rentevastePeriode > 0) {
                    switch (rentevastePeriode) {
                        case 1 -> hypotheek.setRentevasteperiode(1);
                        case 2 -> hypotheek.setRentevasteperiode(5);
                        case 3 -> hypotheek.setRentevasteperiode(10);
                        case 4 -> hypotheek.setRentevasteperiode(20);
                        case 5 -> hypotheek.setRentevasteperiode(30);
                    }
                    loop = false;
                } else {
                    System.out.println("Kies tussen 1 tot en met 5");
                }

            } catch (InputMismatchException e) {
                System.out.println("Ongeldige invoer. Voer een geldig getal in.");
            }
        } while(loop);
    }

    private void reset() {
        do {
            try {
                System.out.println("Opniew (y / n)");

                Scanner scanner = new Scanner(System.in);

                String answer = scanner.next();

                if (answer.equals("y")) {
                    hypotheek = new Hypotheek();
                    run();
                } else {
                    System.exit(-1);
                }

            } catch (InputMismatchException e) {
                System.out.println("Ongeldige invoer. Voer een geldig invoer in.");
            }
        } while(true);
    }

    private void showInfo() {
        System.out.println("Inkomen: " + hypotheek.getInkomen());
        System.out.println("Rentevaste periode: " + hypotheek.getRentevastePeriode() + " jaar - " + hypotheek.getProcentRente() + "%");
        System.out.println("Maximaal te lenen: " + hypotheek.getMaximaalTeLenen());
        System.out.println("Rente bedrag: " + hypotheek.getRenteBedragPerMaand());
        System.out.println("Aflossingbedrag: " + hypotheek.getAflossingsBedrag());
        System.out.println("Totale maandbedrag: " + hypotheek.getTotaalMaandBedrag());
        System.out.println("Totaal betaald na " + hypotheek.getTotaalBetalen() + " - " + hypotheek.getRentevastePeriode() + " jaar");
    }

}
