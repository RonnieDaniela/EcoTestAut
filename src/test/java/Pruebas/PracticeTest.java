package Pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Paginas.HomePage;

public class PracticeTest {
	String url = "http://automationpractice.com";
	String driverPath = "..//EcoTestAut//Drivers//chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina () {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void buscarPalabra() {
		HomePage inicio = new HomePage(driver);
		
		inicio.escribirEnBuscador("dress");
		inicio.hacerClick();
	}
}
