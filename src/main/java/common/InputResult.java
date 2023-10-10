package common;

import java.util.Scanner;

public class InputResult {
	double inputResult = 0;

	public double enterResult() {
		Scanner sc = new Scanner(System.in);
		boolean active = true;
		while (active) {
			System.out.println("Please enter the result:");
			try {
				String commaFix = sc.nextLine().replace(",",".");
				inputResult = Double.parseDouble(commaFix);
				active = false;
			} catch (Exception e) {
				System.out.println("Invalid input, try again.");

			}

		}
		return inputResult;
	}

}
