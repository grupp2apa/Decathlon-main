package decathlon;

import common.*;

public class DecaLongJump {

    private int score;
    private double A = 0.14354;
    private double B = 220;
    private double C = 1.4;
    boolean active = true;
    CalcTrackAndField calc = new CalcTrackAndField();
    InputResult inputResult = new InputResult();

    // Calculate the score based on distance and height. Measured in centimetres.
    public int calculateResult(double distance) {

        while (active) {

            try {
                // Acceptable values.

                if (distance < 0) {
                    System.out.println("Negative input is invalid");
					/*if (distance < 250) {
					System.out.println("Value too low");*/
                    distance = inputResult.enterResult();
                } //else if (distance > 1000)
                else if (distance > 2000) {

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
