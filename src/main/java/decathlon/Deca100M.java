package decathlon;

import common.*;

public class Deca100M {

	public int score;
	private double A = 25.4347;
	private double B = 18;
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
					/*if (runningTime < 5) {
					System.out.println("Value too low");*/
					runningTime = inputResult.enterResult();
				} //runningTime > 17.81
				else if (runningTime > 35.6) {
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