package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) { /* faire en sorte de pouvoir affciher les produits et les quantités.*/
		boolean acheteurReconnu = controlAcheterProduit.verifierIdentite(nomAcheteur);
		if(!acheteurReconnu) {
			System.out.println("Mais vous n'êtes pas un client du village vous!\n");
		}else{
			System.out.println("Quel produit voulez-vous acheter?\n");
			String produit = scan.next();
			if(!controlAcheterProduit.verifierProduit(produit)) {
				System.out.println("Désolé, personne ne vend ce produti au marché...\n");
			}else{
				System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + "?\n");
				Gaulois[] vendeur = controlAcheterProduit.rechercherCommerçant(produit);
				for(int i = 0; i<vendeur.length; i++) {
					System.out.println((i+1) + " - " + vendeur[i].getNom() );
				}
				int numVendeur = Clavier.entrerEntier("");
				System.out.println(nomAcheteur + ", se déplace jusqu'à l'étal du vendeur " + vendeur[numVendeur-1].getNom());
				System.out.println("Bonjour " + nomAcheteur);
				int quantite = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?\n");
				
				Etal etalVendeur = controlAcheterProduit.etalVendeur(vendeur[numVendeur-1].getNom());
				int quantiteProduitEtal = etalVendeur.getQuantite();
				if(quantite>quantiteProduitEtal&&quantite!=0) { // ici j'ai ajouté la deuxième condition il faut tester pour savoir si elle fonctionne
					System.out.println(nomAcheteur + "veut acheter " + quantite + " " + produit + ", malheureusement il n'y en a pas suffisament.\n");
					System.out.println(nomAcheteur + " repart avec les " + quantiteProduitEtal + " derniers.\n");
					etalVendeur.acheterProduit(quantiteProduitEtal);
				}else if(quantiteProduitEtal == 0) {
					System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheureusement il n'y en a plus!\n");
				}else{
					System.out.println(nomAcheteur + " a acheté " + quantite + " de " + produit + " à " + vendeur[numVendeur-1].getNom());
					etalVendeur.acheterProduit(quantite);
				}
			}
		}
	}
}
