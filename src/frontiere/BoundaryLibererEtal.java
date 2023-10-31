package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) { // attention dans le code on se trouve � l'�tal 1 sauf que c'est celle de l'indice 0 donc faire un -1 quand on veut supprimer l'�tal
		if (controlLibererEtal.isVendeur(nomVendeur)){
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		}else {
			String[] donnesEtal = controlLibererEtal.libererEtal(nomVendeur); 
			System.out.println("Vous avez vendu "+ donnesEtal[4]+ " sur " + donnesEtal[3]+ donnesEtal[2]+" .\n");
			System.out.println("En revoir "+ donnesEtal[1] + ", passez une bonne journée.\n");
			donnesEtal[0]= null; 
			
			
			
		}
	}

}
