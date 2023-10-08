package heptathlon;

import common.*;

public class Hep200M {

    private int score;
    private double A = 4.99087;
    private double B = 42.5;
    private double C = 1.81;
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
				/*if (runningTime < 14) {
					System.out.println("Value too low");
					runningTime = inputResult.enterResult();*/
                } //else if (runningTime > 42.08)
                else if (runningTime > 84.16) {
                    // get 1 point in 42.08sec
                    System.out.println("Value too high");
                    runningTime = inputResult.enterResult();
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
