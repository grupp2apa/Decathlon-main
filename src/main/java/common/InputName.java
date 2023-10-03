package common;

import java.util.Scanner;

public class InputName {
	String compName = "";

	
	//Add competitor
	public String addCompetitor() {

		boolean active = true;
		String compName = "";
		Scanner sc = new Scanner(System.in);
		
		while (active) {
			System.out.println("Please enter the competitor's name:");
			compName = sc.nextLine();
			//	.*[a-?A-?]
				if (!compName.matches("^[a-öA-Ö]+(\\s[a-öA-Ö]+)?(\\s[a-öA-Ö]+)?$")) {
				System.out.println("Only use letters when putting in competitors name.");

			} else if ((compName.length() >= 50)) {
					System.out.println("Name is to long");
				} else {
				active = false;
			}

		} 
		return compName;
	} 
}
