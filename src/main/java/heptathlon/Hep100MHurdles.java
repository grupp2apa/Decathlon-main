package heptathlon;

import common.CalcTrackAndField;
import common.InputResult;

public class Hep100MHurdles {

    private int score;
    private double A = 9.23076;
    private double B = 26.7;
    private double C = 1.835;
    boolean active = true;
    CalcTrackAndField calc = new CalcTrackAndField();
    InputResult inputResult = new InputResult();

    // Calculate the score based on time. All running events.
    public int calculateResult(double runningTime) {

        while (active) {

            try {
                // Acceptable values.

                if (runningTime < 0) {
                    System.out.println("Negative input is invalid");
					/*if (runningTime < 5) {
					System.out.println("Value too low");*/
                    runningTime = inputResult.enterResult();
                } //else if (runningTime > 26.4)
                else if (runningTime > 52.8) {
                    System.out.println("Value too high");
                    //runningTime = inputResult.enterResult();
                } else {

                    score = calc.calculateTrack(A, B, C, runningTime);
                    active = false;
                }
            } catch (Exception e) {

                System.out.println("Please enter numbers");
            }
        }
        System.out.println("The score is " + score);
        return score; // Return the calculated score

    }

}
