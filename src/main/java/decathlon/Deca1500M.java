package decathlon;

import common.*;

public class Deca1500M {

    private int score;
    private double A = 0.03768;
    private double B = 480;
    private double C = 1.85;
    boolean active = true;

    CalcTrackAndField calc = new CalcTrackAndField();
    InputResult inputResult = new InputResult();

    // Calculate the score based on time. All running events.
    public int calculateResult(double runningTime) {

        while (active) {

            try {
                // Acceptable values.

                if (runningTime < 0) {
                    /*if (runningTime < 2) {
                    System.out.println("Value too low");*/
                    System.out.println("Negative input is invalid");
                    runningTime = inputResult.enterResult();
                }
                //else if (runningTime > 7)
                else if (runningTime > 14){
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
        System.out.println("The score is: " + score);
        return score; // Return the calculated score
    }

}
