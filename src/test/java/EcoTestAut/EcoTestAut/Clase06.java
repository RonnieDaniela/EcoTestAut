package EcoTestAut.EcoTestAut;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;

public class Clase06 {
	String url = "http://automationpractice.com";
	String driverPath = "..//EcoTestAut//Drivers//chromedriver.exe";
	WebDriver driver;
	String dirEvidencias = "..//EcoTestAut//Evidencias";
	String nuevoDocumento= "Evidencias AutomationPractice.docx";
	File pantalla;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	@Test
	public void Login() throws IOException, InvalidFormatException, InterruptedException {
		pantalla= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(dirEvidencias+"Login.jpg"));
		
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		
		pantalla= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(dirEvidencias+"Formulario Login.jpg"));
		
		driver.findElement(By.id("email")).sendKeys("correo@micorreo.com");
		driver.findElement(By.cssSelector("#passwd")).sendKeys("1234567");
		
		pantalla= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(dirEvidencias+"Formulario Login Completo.jpg"));
		
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		
		try {
			// Comprobar que se pudo iniciar sesión
			Assert.assertEquals(driver.getTitle(), "My account - My Store");
		} catch (AssertionError e) {
			CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + "Falla.docx", "Error luego de hacer clic en el botón para iniciar sesión");
		}
		
		
	}
	@Test
	public void LoginConDocumento() throws InvalidFormatException, IOException, InterruptedException {
		
		CapturaEvidencia.escribirTituloEnDocumento(dirEvidencias + nuevoDocumento, "Evidencias Automatizadas",18);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nuevoDocumento,"Pantalla Principal");
		
		
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
				
		driver.findElement(By.id("email")).sendKeys("correo@micorreo.com");
		driver.findElement(By.cssSelector("#passwd")).sendKeys("1234567");
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nuevoDocumento,"Login");
				
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nuevoDocumento,"Error");
		
		try {
			Assert.assertNotEquals(driver. getTitle(), "Login - My Store");
		} catch (AssertionError e) {
			CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nuevoDocumento,"Error");
		}
		
	}
	
	@Test(dataProvider="Datos Login")
	public void login(String email, String password) {
		// Paso 1 - Hacer clic en Sign In
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		
		// Paso 2 - Completar las credenciales
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.cssSelector("#passwd")).sendKeys(password);
		
		// Paso 3 - Hacer clic en el botón para iniciar sesión
		driver.findElement(By.name("SubmitLogin")).click();
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatos() {
		/* 
		 * Devolver una matriz (filas y columnas) con los datos para la ejecución 
		 * - Filas: representan cada prueba que se va a hacer
		 * - Columnas: representan los parámetros de la prueba
		 */
		Object[][] datos = new Object[3][2]; // matriz tiene 3 filas y 2 columnas

		// Primera fila de datos
		datos[0][0] = "abc@correo.com";
		datos[0][1] = "1qe3q2e23r";

		datos[1][0] = "def@correo.com";
		datos[1][1] = "78i7yit";

		datos[2][0] = "ghi@correo.com";
		datos[2][1] = "sfcsawfea";
		
		return datos;
	}

}
