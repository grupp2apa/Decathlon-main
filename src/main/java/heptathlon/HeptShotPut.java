package heptathlon;

import common.CalcTrackAndField;
import common.InputResult;

public class HeptShotPut {

    private int score;
    private double A = 56.0211;
    private double B = 1.5;
    private double C = 1.05;
    boolean active = true;
    CalcTrackAndField calc = new CalcTrackAndField();
    InputResult inputResult = new InputResult();

    // Calculate the score based on distance and height. Measured in meters.
    public int calculateResult(double distance) {

        while (active) {

            try {
                // Acceptable values.

                if (distance < 0) {
                    System.out.println("Negative input is invalid");
				/*if (distance < 5) {
					System.out.println("Value too low");*/
                    distance = inputResult.enterResult();
                } //else if (distance > 100) {
                else if (distance > 200) {
                    System.out.println("Value too high");
                    distance = inputResult.enterResult();

                } else {

                    score = calc.calculateField(A, B, C, distance);
                    active = false;
                }
            } catch (Exception e) {

                System.out.println("Please enter numbers");
            }
        }
        System.out.println("The score is: " + score);
        return score; // Return the calculated score
    }

}
