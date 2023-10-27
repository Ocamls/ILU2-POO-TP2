package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village; 
	private Chef abraracourcix;
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation ...");
		village = new Village("le village des irréductibles",10,5); 
		abraracourcix = new Chef("Abraracourcix", 10, village); 
		village.setChef(abraracourcix);	}
	
	

}
