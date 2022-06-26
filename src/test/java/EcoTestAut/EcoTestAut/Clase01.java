package EcoTestAut.EcoTestAut;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Clase01 {

	String url = "http://automationpractice.com/index.php";
	String chromeDriverPath = "..//EcoTestAut//Drivers//chromedriver.exe";
	String firefoxDriverPath = "..//EcoTestAut//Drivers//geckodriver.exe";
	
	//Simepre se coloca @Test con t mayuscula para poder llamar el import de junit
	
	@Test
	public void HacerBusquedaenChrome() {
		//Paso 1: indicar donde esta el drivers del navegador
		
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		// Paso 2: Abrir el navegador en la pagina a probar
		
		WebDriver navegador = new ChromeDriver();
		navegador.get(url);
		
		//Paso 3: Escribir la palabra/frase a buscar
		
		WebElement buscador = navegador.findElement(By.id("search_query_top"));
		buscador.sendKeys("dress");
		
		//Paso 4: Hacer la busqueda
		
		buscador.sendKeys(Keys.ENTER); //Simula la precionde la tecla "ENTER"
		
		//Paso 5: Cerrar el navegador
		navegador.close();
		
	}
	@Test
	public void HacerBusquedaenFirefox() {
		//Paso 1: indicar donde esta el drivers del navegador
		
		System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
		
		// Paso 2: Abrir el navegador en la pagina a probar
		
		WebDriver navegador = new FirefoxDriver();
		navegador.get(url);
		
		//Paso 3: Escribir la palabra/frase a buscar
		
		WebElement buscador = navegador.findElement(By.id("search_query_top"));
		buscador.sendKeys("dress");
		
		//Paso 4: Hacer la busqueda
		
		buscador.sendKeys(Keys.ENTER); //Simula la precionde la tecla "ENTER"
		
		//Paso 5: Cerrar el navegador
		// navegador.close();
		
	}

}
