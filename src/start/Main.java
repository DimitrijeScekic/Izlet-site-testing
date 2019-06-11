package start;

import java.util.Scanner;

import page.tests.DashboardPageTest;
import page.tests.LogInTest;
import page.tests.RegistrationTest;

public class Main {

	public static void main(String[] args) throws Exception {

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println(" \n                                     Web-site IZLET Testing: \n ");

			System.out.println(
					" Type number for desired test:\n 1. Log In Test \n 2. Registration Test \n 3. Make New Post Test \n 4. Edit Last Post Test Test \n 5. Delete Two Last Post  ");

			String test = sc.nextLine();

			switch (test) {

			case "1":
				while (true) {
					System.out.println("Type number for desired kind of test:\n 1. MANUAL \n 2. AUTOMATIC ");
					String option = sc.nextLine();
					if (option.matches("1")) {
						LogInTest.logIn();
					} else if (option.matches("2")) {
						LogInTest.logInExcel();
					} else {
						System.out.println("Invalid input");
						continue;
					}
					break;
				}
				break;

			case "2":
				while (true) {
					System.out.println("Type number for desired kind of test:\n 1. MANUAL \n 2. AUTOMATIC ");
					String option2 = sc.nextLine();
					if (option2.matches("1")) {
						RegistrationTest.registration();
					} else if (option2.matches("2")) {
						RegistrationTest.registrationExcel();
					} else {
						System.out.println("Invalid input");
						continue;
					}
					break;
				}
				break;

			case "3":
				while (true) {
					System.out.println("Type number for desired kind of test:\n 1. MANUAL \n 2. AUTOMATIC ");
					String option3 = sc.nextLine();
					if (option3.matches("1")) {
						DashboardPageTest.makeNewPost();
					} else if (option3.matches("2")) {
						DashboardPageTest.makeNewPostExcel();
					} else {
						System.out.println("Invalid input");
						continue;
					}
					break;
				}
				break;

			case "4":

				DashboardPageTest.editLastPost();

				break;

			case "5":

				DashboardPageTest.deleteTwoLastPost();

				break;

			default:
				System.out.println("Invalid input");
				continue;
			}
			sc.close();
			break;
		}

	}

}
