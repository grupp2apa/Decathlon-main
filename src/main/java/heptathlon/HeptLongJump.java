package heptathlon;

import common.CalcTrackAndField;
import common.InputResult;

public class HeptLongJump {

    private int score;
    private double A = 0.188807;
    private double B = 210;
    private double C = 1.41;
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
				/*if (distance < 0) {
					System.out.println("Value too low");*/
                    distance = inputResult.enterResult();
                } //else if (distance > 400) {
                else if (distance > 800) {
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
