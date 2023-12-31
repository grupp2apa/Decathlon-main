package decathlon;

import common.CalcTrackAndField;
import common.InputResult;

public class DecaHighJump {

    private int score;
    private double A = 0.8465;
    private double B = 75;
    private double C = 1.42;
    boolean active = true;
    CalcTrackAndField calc = new CalcTrackAndField();
    InputResult inputResult = new InputResult();

    // Calculate the score based on distance and height. Measured in centimeters.
    public int calculateResult(double distance) {

        while (active) {

            try {
                // Acceptable values.

                if (distance < 0) {
                    //System.out.println("Value too low");
                    System.out.println("Negative input is invalid");
                    distance = inputResult.enterResult();
                } //lelse if (distance > 300)
                else if (distance > 600) {
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
