package page.tests;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.objects.DashboardPage;
import page.objects.RegLogPage;
import start.GUImain;
import utility.Config;
import utility.ExcelUtils;

public class DashboardPageTest {

	public static void makeNewPost() throws InterruptedException {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter post name:");
		String postName = sc.nextLine();
		System.out.println("Enter location:");
		String location = sc.nextLine();
		// System.out.println("Enter path for image:");
		/// String path = sc.nextLine();
		String path = "C:\\Users\\Dimitrije\\eclipse-workspace\\bike.jpg";
		System.out.println("Enter description text:");
		String description = sc.nextLine();
		String type;
		String travelMode = null;

		while (true) {
			System.out.println(
					"Enter number for desired travel type: \n 1.Biciklom \n 2.Peske \n 3.Automobilom \n 4.Motociklom \n 5.Autobusom");
			type = sc.nextLine();
			if (type.matches("1") || type.matches("2") || type.matches("3") || type.matches("4") || type.matches("5")) {

			} else {
				System.out.println("Invalid input");
				continue;
			}
			break;
		}

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {

			switch (type) {
			case "1":
				travelMode = "Biciklom";
				break;
			case "2":
				travelMode = "Peške";
				break;
			case "3":
				travelMode = "Automobilom";
				break;
			case "4":
				travelMode = "Motociklom";
				break;
			case "5":
				travelMode = "Autobusom";
				break;
			}

			RegLogPage.openPage(driver, Config.URL_HOME);

			String data;
			ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);

			data = ExcelUtils.getCellData(1, 2);
			RegLogPage.sendKeys(driver, RegLogPage.USER_NAME, data);
			// Thread.sleep(1000);

			data = ExcelUtils.getCellData(1, 4);
			RegLogPage.sendKeys(driver, RegLogPage.PASSWORD, data);
			Thread.sleep(1000);

			RegLogPage.clickLogIn(driver);

			DashboardPage.clickMakePostButton(driver);
			DashboardPage.sendKeys(driver, DashboardPage.POST_NAME, postName);
			DashboardPage.sendKeys(driver, DashboardPage.TRAVEL_LOCATION, location);
			DashboardPage.clickNaziv(driver);
			DashboardPage.insertImage(driver, path);
			DashboardPage.setTravelType(driver, travelMode);
			DashboardPage.sendKeys(driver, DashboardPage.TRAVEL_DESCRIPTION, description);
			DashboardPage.clickSavePostButton(driver);
			Thread.sleep(3000);
			DashboardPage.clickLogoutButton(driver);

		} catch (Exception e) {

			e.printStackTrace();
		}
		sc.close();
		driver.close();
	}

	public static void makeNewPostGUI() throws InterruptedException {

		GUImain frame = new GUImain();
		String path = "C:\\Users\\Dimitrije\\eclipse-workspace\\bike.jpg";
		String postName = (String) JOptionPane.showInputDialog(frame, "Enter post name:",
				JOptionPane.INPUT_VALUE_PROPERTY);

		String location = (String) JOptionPane.showInputDialog(frame, "Enter location:",
				JOptionPane.INPUT_VALUE_PROPERTY);

		// String imagePath = (String) JOptionPane.showInputDialog(frame, "Enter path
		// for image:",
		// JOptionPane.INPUT_VALUE_PROPERTY);

		String travelMode = null;
		String travelType;
		while (true) {
			travelType = (String) JOptionPane.showInputDialog(frame,
					"Enter number for desired travel type: \n 1.Biciklom \n 2.Peske \n 3.Automobilom \n 4.Motociklom \n 5.Autobusom",
					JOptionPane.INPUT_VALUE_PROPERTY);
			if (travelType.matches("1") || travelType.matches("2") || travelType.matches("3") || travelType.matches("4")
					|| travelType.matches("5")) {

			} else {
				System.out.println("Invalid input");
				continue;
			}
			break;
		}

		String description = (String) JOptionPane.showInputDialog(frame, "Enter description text:",
				JOptionPane.INPUT_VALUE_PROPERTY);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {

			switch (travelType) {
			case "1":
				travelMode = "Biciklom";
				break;
			case "2":
				travelMode = "Peške";
				break;
			case "3":
				travelMode = "Automobilom";
				break;
			case "4":
				travelMode = "Motociklom";
				break;
			case "5":
				travelMode = "Autobusom";
				break;
			}

			RegLogPage.openPage(driver, Config.URL_HOME);

			String data;
			ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);

			data = ExcelUtils.getCellData(1, 2);
			RegLogPage.sendKeys(driver, RegLogPage.USER_NAME, data);
			// Thread.sleep(1000);

			data = ExcelUtils.getCellData(1, 4);
			RegLogPage.sendKeys(driver, RegLogPage.PASSWORD, data);
			Thread.sleep(1000);

			RegLogPage.clickLogIn(driver);

			DashboardPage.clickMakePostButton(driver);
			DashboardPage.sendKeys(driver, DashboardPage.POST_NAME, postName);
			DashboardPage.sendKeys(driver, DashboardPage.TRAVEL_LOCATION, location);
			DashboardPage.clickNaziv(driver);
			DashboardPage.insertImage(driver, path);
			DashboardPage.setTravelType(driver, travelMode);
			DashboardPage.sendKeys(driver, DashboardPage.TRAVEL_DESCRIPTION, description);
			DashboardPage.clickSavePostButton(driver);
			DashboardPage.clickLogoutButton(driver);
		} catch (Exception e) {

			e.printStackTrace();
		}

		driver.close();
	}

	public static void makeNewPostExcel() throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		RegLogPage.openPage(driver, Config.URL_HOME);

		String data;
		ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);

		data = ExcelUtils.getCellData(1, 2);
		RegLogPage.sendKeys(driver, RegLogPage.USER_NAME, data);

		data = ExcelUtils.getCellData(1, 4);
		RegLogPage.sendKeys(driver, RegLogPage.PASSWORD, data);

		RegLogPage.clickLogIn(driver);

		DashboardPage.clickMakePostButton(driver);

		ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME2);

		int size = 100;
		int rando = (int) (Math.random() * (size + 1));

		data = ExcelUtils.getCellData(rando, 1);
		DashboardPage.sendKeys(driver, DashboardPage.POST_NAME, data);
		data = ExcelUtils.getCellData(rando, 2);
		DashboardPage.sendKeys(driver, DashboardPage.TRAVEL_LOCATION, data);
		DashboardPage.clickNaziv(driver);
		DashboardPage.insertImage(driver, Config.BROWSE_INPUT);
		DashboardPage.clickTravelType(driver);
		DashboardPage.setTravelType(driver, "Biciklom");
		data = ExcelUtils.getCellData(rando, 0);
		DashboardPage.sendKeys(driver, DashboardPage.TRAVEL_DESCRIPTION, data);
		DashboardPage.clickSavePostButton(driver);
		DashboardPage.clickLogoutButton(driver);

		driver.close();
	}

	public static void makeNewPostExcelGUI() throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		RegLogPage.openPage(driver, Config.URL_HOME);

		String data;
		ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);

		data = ExcelUtils.getCellData(1, 2);
		RegLogPage.sendKeys(driver, RegLogPage.USER_NAME, data);

		data = ExcelUtils.getCellData(1, 4);
		RegLogPage.sendKeys(driver, RegLogPage.PASSWORD, data);

		RegLogPage.clickLogIn(driver);

		DashboardPage.clickMakePostButton(driver);

		ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME2);

		int size = 100;
		int rando = (int) (Math.random() * (size + 1));

		data = ExcelUtils.getCellData(rando, 1);
		DashboardPage.sendKeys(driver, DashboardPage.POST_NAME, data);
		data = ExcelUtils.getCellData(rando, 2);
		DashboardPage.sendKeys(driver, DashboardPage.TRAVEL_LOCATION, data);
		DashboardPage.clickNaziv(driver);
		DashboardPage.insertImage(driver, Config.BROWSE_INPUT);
		DashboardPage.clickTravelType(driver);
		DashboardPage.setTravelType(driver, "Biciklom");
		data = ExcelUtils.getCellData(rando, 0);
		DashboardPage.sendKeys(driver, DashboardPage.TRAVEL_DESCRIPTION, data);
		DashboardPage.clickSavePostButton(driver);
		DashboardPage.clickLogoutButton(driver);

		driver.close();
	}

	public static void editLastPostExcelGUI() throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		RegLogPage.openPage(driver, Config.URL_HOME);

		String data;
		ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);

		data = ExcelUtils.getCellData(1, 2);
		RegLogPage.sendKeys(driver, RegLogPage.USER_NAME, data);
		Thread.sleep(1000);

		data = ExcelUtils.getCellData(1, 4);
		RegLogPage.sendKeys(driver, RegLogPage.PASSWORD, data);
		Thread.sleep(1000);

		RegLogPage.clickLogIn(driver);

		DashboardPage.editPostButton(driver);

		ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME2);

		int size = 100;
		int rando = (int) (Math.random() * (size + 1));
		data = ExcelUtils.getCellData(rando, 0);
		DashboardPage.editPostDescription(driver, data);
		DashboardPage.clickPostChangeSave(driver);
		DashboardPage.clickLogoutButton(driver);
		driver.close();
	}

	public static void editLastPost() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter new description:");
		String newPostDescriptionText = sc.nextLine();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		RegLogPage.openPage(driver, Config.URL_HOME);

		try {
			String data;

			ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);

			data = ExcelUtils.getCellData(1, 2);
			RegLogPage.sendKeys(driver, RegLogPage.USER_NAME, data);

			data = ExcelUtils.getCellData(1, 4);
			RegLogPage.sendKeys(driver, RegLogPage.PASSWORD, data);

			RegLogPage.clickLogIn(driver);

			DashboardPage.editPostButton(driver);

			DashboardPage.editPostDescription(driver, newPostDescriptionText);
			DashboardPage.clickPostChangeSave(driver);

		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
		driver.close();
	}

	public static void editLastPostGUI() {

		GUImain frame = new GUImain();

		String newPostDescriptionText = (String) JOptionPane.showInputDialog(frame, "Enter description text:",
				JOptionPane.INPUT_VALUE_PROPERTY);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		RegLogPage.openPage(driver, Config.URL_HOME);

		try {
			String data;

			ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);

			data = ExcelUtils.getCellData(1, 2);
			RegLogPage.sendKeys(driver, RegLogPage.USER_NAME, data);

			data = ExcelUtils.getCellData(1, 4);
			RegLogPage.sendKeys(driver, RegLogPage.PASSWORD, data);

			RegLogPage.clickLogIn(driver);

			DashboardPage.editPostButton(driver);

			DashboardPage.editPostDescription(driver, newPostDescriptionText);
			DashboardPage.clickPostChangeSave(driver);

			driver.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void makeTwoPostExcel(WebDriver driver) {
		try {
			for (int i = 0; i < 2; i++) {
				DashboardPage.clickMakePostButton(driver);

				ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME2);
				String data;
				int size = 100;
				int rando = (int) (Math.random() * (size + 1));

				data = ExcelUtils.getCellData(rando, 1);
				DashboardPage.sendKeys(driver, DashboardPage.POST_NAME, data);
				data = ExcelUtils.getCellData(rando, 2);
				DashboardPage.sendKeys(driver, DashboardPage.TRAVEL_LOCATION, data);
				DashboardPage.insertImage(driver, Config.BROWSE_INPUT);
				DashboardPage.getTravelType(driver);
				DashboardPage.setTravelType(driver, "Biciklom");
				data = ExcelUtils.getCellData(rando, 0);
				DashboardPage.sendKeys(driver, DashboardPage.TRAVEL_DESCRIPTION, data);
				DashboardPage.clickSavePostButton(driver);
				Thread.sleep(2000);
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

	public static void makeTwoPostExcelGUI(WebDriver driver) {

		try {
			for (int i = 0; i < 2; i++) {
				DashboardPage.clickMakePostButton(driver);
				String data;
				ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);
				ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME2);

				int size = 100;
				int rando = (int) (Math.random() * (size + 1));

				data = ExcelUtils.getCellData(rando, 1);
				DashboardPage.sendKeys(driver, DashboardPage.POST_NAME, data);
				data = ExcelUtils.getCellData(rando, 2);
				DashboardPage.sendKeys(driver, DashboardPage.TRAVEL_LOCATION, data);
				DashboardPage.clickNaziv(driver);
				DashboardPage.insertImage(driver, Config.BROWSE_INPUT);
				DashboardPage.clickTravelType(driver);
				DashboardPage.setTravelType(driver, "Biciklom");
				data = ExcelUtils.getCellData(rando, 0);
				DashboardPage.sendKeys(driver, DashboardPage.TRAVEL_DESCRIPTION, data);
				DashboardPage.clickSavePostButton(driver);
				Thread.sleep(3000);
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteTwoLastPost() {

		Scanner sc = new Scanner(System.in);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		RegLogPage.openPage(driver, Config.URL_HOME);
		try {
			String data;

			ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);

			data = ExcelUtils.getCellData(1, 2);
			RegLogPage.sendKeys(driver, RegLogPage.USER_NAME, data);

			data = ExcelUtils.getCellData(1, 4);
			RegLogPage.sendKeys(driver, RegLogPage.PASSWORD, data);

			RegLogPage.clickLogIn(driver);
			makeTwoPostExcel(driver);

			for (int i = 0; i < 2; i++) {
				DashboardPage.deletePostButton(driver);
				driver.switchTo().alert().accept();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
		driver.close();

	}

	public static void deleteTwoLastPostGUI() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		RegLogPage.openPage(driver, Config.URL_HOME);

		try {
			String data;

			ExcelUtils.setExcelFile(Config.Path_TestData + Config.File_TestData, Config.SHEET_NAME);

			data = ExcelUtils.getCellData(1, 2);
			RegLogPage.sendKeys(driver, RegLogPage.USER_NAME, data);

			data = ExcelUtils.getCellData(1, 4);
			RegLogPage.sendKeys(driver, RegLogPage.PASSWORD, data);

			RegLogPage.clickLogIn(driver);
			makeTwoPostExcelGUI(driver);

			for (int i = 0; i < 2; i++) {
				DashboardPage.deletePostButton(driver);
				driver.switchTo().alert().accept();
				Thread.sleep(3000);
			}
			driver.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
