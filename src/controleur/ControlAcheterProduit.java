package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
	
	public Gaulois[] rechercherCommerçant(String produit) {
		Gaulois[] vendeur = village.rechercherVendeursProduit(produit);
		return vendeur;
	}
	
	public Etal etalVendeur(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
	}
	
	public boolean verifierProduit(String produit) {
		return rechercherCommerçant(produit) != null;
	}
}
