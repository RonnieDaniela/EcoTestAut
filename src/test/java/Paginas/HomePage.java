package Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//Elementos
	@FindBy (id="search_query_top")
	WebElement txtBuscador;
	
	@FindBy (name="submit_search")
	WebElement btnBuscar;
	
	//Contructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Acciones sobre los elementos de las pagina web
	public void escribirEnBuscador(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	
	public void hacerClick () {
		btnBuscar.click();
	}
}
