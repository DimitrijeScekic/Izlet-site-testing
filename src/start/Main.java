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

			int test = sc.nextInt();

			switch (test) {

			case 1:
				while (true) {
					System.out.println("Type number for desired kind of test:\n 1. MANUAL \n 2. AUTOMATIC ");
					int option = sc.nextInt();
					if (option == 1) {
						LogInTest.logIn();
					} else if (option == 2) {
						LogInTest.logInExcel();
					} else {
						System.out.println("Invalid input");
						continue;
					}
					break;
				}
				break;

			case 2:
				while (true) {
					System.out.println("Type number for desired kind of test:\n 1. MANUAL \n 2. AUTOMATIC ");
					int option2 = sc.nextInt();
					if (option2 == 1) {
						RegistrationTest.registration();
					} else if (option2 == 2) {
						RegistrationTest.registrationExcelAll();
					} else {
						System.out.println("Invalid input");
						continue;
					}
					break;
				}
				break;

			case 3:
				while (true) {
					System.out.println("Type number for desired kind of test:\n 1. MANUAL \n 2. AUTOMATIC ");
					int option3 = sc.nextInt();
					if (option3 == 1) {
						DashboardPageTest.makeNewPost();
					} else if (option3 == 2) {
						DashboardPageTest.makeNewPostExcel();
						DashboardPageTest.makeNewPostExcel();
					} else {
						System.out.println("Invalid input");
						continue;
					}
					break;
				}
				break;

			case 4:

				DashboardPageTest.editLastPost();

				break;

			case 5:

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
