package common;

import java.util.Scanner;

import decathlon.Deca100M;
import decathlon.Deca1500M;
import decathlon.Deca110MHurdles;
import decathlon.Deca400M;
import decathlon.DecaDiscusThrow;
import decathlon.DecaHighJump;
import decathlon.DecaJavelinThrow;
import decathlon.DecaLongJump;
import decathlon.DecaShotPut;
import decathlon.DecaPoleVault;

import heptathlon.Hep100MHurdles;
import heptathlon.Hep200M;
import heptathlon.Hep800M;
import heptathlon.HeptHightJump;
import heptathlon.HeptJavelinThrow;
import heptathlon.HeptLongJump;
import heptathlon.HeptShotPut;

public class SelectDiscipline {

    InputResult inputResult = new InputResult();
    Scanner sc = new Scanner(System.in);
    private String selectedDiscipline;

    Deca100M deca100M = new Deca100M();
    Deca400M deca400M = new Deca400M();
    Deca110MHurdles deca110MHurdles = new Deca110MHurdles();
    Deca1500M deca1500M = new Deca1500M();
    DecaLongJump decaLongJump = new DecaLongJump();
    DecaHighJump highJump = new DecaHighJump();
    DecaPoleVault poleVault = new DecaPoleVault();
    DecaDiscusThrow discusThrow = new DecaDiscusThrow();
    DecaShotPut decaShotPut = new DecaShotPut();
    DecaJavelinThrow decaJavelinThrow = new DecaJavelinThrow();
    Hep200M hep200M = new Hep200M();
    Hep800M hep800M = new Hep800M();
    Hep100MHurdles hep100MHurdles = new Hep100MHurdles();
    HeptHightJump hepHighJump = new HeptHightJump();
    HeptLongJump hepLongJump = new HeptLongJump();
    HeptShotPut hepShotPut = new HeptShotPut();
    HeptJavelinThrow hepJavelinThrow = new HeptJavelinThrow();

    private double competitorScore;

    public void inputSelection() {
        System.out.println("Select a sport by entering a number:");

        printSports();

        try {
            int sportSelector = Integer.parseInt(sc.nextLine());
            if (sportSelector == 1) {
                System.out.println("Select a discipline by entering a number:");

                printDisciplines();


                int disciplineIndex = Integer.parseInt(sc.nextLine()) - 1;
                if (disciplineIndex >= 0 && disciplineIndex < 10) {
                    double result = inputResult.enterResult();

                    switch (disciplineIndex) {
                        case 0 -> {
                            competitorScore = deca100M.calculateResult(result);
                            selectedDiscipline = "Decathlon 100 meters";
                        }
                        case 1 -> {
                            competitorScore = deca400M.calculateResult(result);
                            selectedDiscipline = "Decathlon 400 meters";
                        }
                        case 2 -> {
                            competitorScore = deca110MHurdles.calculateResult(result);
                            selectedDiscipline = "Decathlon 110 meters hurdles";
                        }
                        case 3 -> {
                            competitorScore = deca1500M.calculateResult(result);
                            selectedDiscipline = "Decathlon 1500 meters";
                        }
                        case 4 -> {
                            competitorScore = decaLongJump.calculateResult(result);
                            selectedDiscipline = "Decathlon Long Jump";
                        }
                        case 5 -> {
                            competitorScore = highJump.calculateResult(result);
                            selectedDiscipline = "Decathlon High Jump";
                        }
                        case 6 -> {
                            competitorScore = poleVault.calculateResult(result);
                            selectedDiscipline = "Decathlon Pole Vault";
                        }
                        case 7 -> {
                            competitorScore = discusThrow.calculateResult(result);
                            selectedDiscipline = "Decathlon Discus Throw";
                        }
                        case 8 -> {
                            competitorScore = decaJavelinThrow.calculateResult(result);
                            selectedDiscipline = "Decathlon Javelin Throw";
                        }
                        case 9 -> {
                            competitorScore = decaShotPut.calculateResult(result);
                            selectedDiscipline = "Decathlon Shot Put";
                        }
                    }
                } else {
                    System.out.println("Invalid input, please select a valid discipline.");
                    inputSelection();
                }

            } else if (sportSelector == 2) {
                System.out.println("Select a discipline by entering a number:");

                printHeptathlon();


                int heptathlonIndex = Integer.parseInt(sc.nextLine()) - 1;
                if (heptathlonIndex >= 0 && heptathlonIndex < 7) {
                    double result = inputResult.enterResult();

                    switch (heptathlonIndex) {
                        case 0 -> {
                            competitorScore = hep200M.calculateResult(result);
                            selectedDiscipline = "Heptathlon 200 meters";
                        }
                        case 1 -> {
                            competitorScore = hep800M.calculateResult(result);
                            selectedDiscipline = "Heptathlon 800 meters";
                        }
                        case 2 -> {
                            competitorScore = hep100MHurdles.calculateResult(result);
                            selectedDiscipline = "Heptathlon 100 meters hurdles";
                        }
                        case 3 -> {
                            competitorScore = hepHighJump.calculateResult(result);
                            selectedDiscipline = "Heptathlon High Jump";
                        }
                        case 4 -> {
                            competitorScore = hepLongJump.calculateResult(result);
                            selectedDiscipline = "Heptathlon Long Jump";
                        }
                        case 5 -> {
                            competitorScore = hepShotPut.calculateResult(result);
                            selectedDiscipline = "Heptathlon Shot Put";
                        }
                        case 6 -> {
                            competitorScore = hepJavelinThrow.calculateResult(result);
                            selectedDiscipline = "Heptathlon Javelin Throw";
                        }
                    }
                } else {
                    System.out.println("Invalid input, please select a valid discipline.");
                    inputSelection();
                }

            } else {
                System.out.println("Invalid input, please select a valid sport.");
                inputSelection();
            }
        } catch (
                NumberFormatException e) {
            System.out.println("Invalid input, please enter a number.");
            inputSelection();
        }

    }

    public String selectedDiscipline() {
        return selectedDiscipline;
    }

    public double getCompetitorScore() {

        return competitorScore;

    }

    public void printSports() {
        System.out.println("1. Decathlon.");
        System.out.println("2. Heptathlon.");
    }

    public void printDisciplines() {
        System.out.println("1. Decathlon 100 meters. (Measured in seconds | range 0 - 35.60s)");
        System.out.println("2. Decathlon 400 meters. (Measured in seconds | range 0 - 200s)");
        System.out.println("3. Decathlon 110 meters hurdles. (Measured in seconds | range 0 - 57s)");
        System.out.println("4. Decathlon 1500 meters. (Measured in minutes and seconds | range 0 - 14m)");
        System.out.println("5. Decathlon Long Jump. (Measured in centimeters | range 0 - 2000cm)");
        System.out.println("6. Decathlon High Jump. (Measured in centimeters | range 0 - 600cm)");
        System.out.println("7. Decathlon Pole Vault. (Measured in centimeters | range 0 - 2000cm)");
        System.out.println("8. Decathlon Discus Throw. (Measured in meters | range 0 - 170m)");
        System.out.println("9. Decathlon Javelin Throw. (Measured in meters | range 0 - 220m)");
        System.out.println("10. Decathlon Shot Put. (Measured in meters | range 0 - 60m)");
    }

    public void printHeptathlon() {
        System.out.println("1. Heptathlon 200 meters. (Measured in seconds | range 0 - 84.16s)");
        System.out.println("2. Heptathlon 800 meters. (Measured in seconds | range 0 - 501.58s)");
        System.out.println("3. Heptathlon 100 meters hurdles. (Measured in seconds | range 0 - 52.80s)");
        System.out.println("4. Heptathlon High Jump. (Measured in centimeters | range 0 - 540cm)");
        System.out.println("5. Heptathlon Long Jump. (Measured in centimeters | range 0 - 800cm)");
        System.out.println("6. Heptathlon Shot Put. (Measured in meters | range 0 - 200m)");
        System.out.println("7. Heptathlon Javelin Throw. (Measured in meters | range 0 - 200m)");
    }
}