import java.util.List;
import java.awt.Point;
import java.awt.Dimension;

public class Controleur
{
	private FrameTable ihm;
	private Clientele  metier;

	public Controleur ()
	{
		this.metier = new Clientele ();
		this.ihm    = new FrameTable(this);
	}


	// Accesseurs
	public List<Client> getClients() { return this.metier.getClients(); }
	public Point getMasterLocation() { return this.ihm.getLocation();   }
	public Dimension getMasterSize() { return this.ihm.getSize();       }

	// Modificateurs
	public boolean majPreniumClient ( int ligne, boolean val ) { return this.metier.majPreniumClient ( ligne, val ); }
	public boolean majAnneeAdhClient( int ligne, int     val ) { return this.metier.majAnneeAdhClient( ligne, val ); }

	public boolean ajouterClient( String nom, String prenom )
	{
		boolean bRet = this.metier.ajouterClient (nom, prenom);
		if ( bRet ) this.ihm.majClient(0);
		
		return bRet;
	}
	public boolean supprimerClient()
	{
		int ligne = ihm.getClientActif();

		if ( ligne == -1 ) return false;

		this.metier.supprimerClient( ligne );

		if ( ligne >= this.metier.getNbClients() )
			ligne = this.metier.getNbClients() - 1;

		this.ihm.majClient(ligne);
		return true;
	}

	// Autres Méthodes
	public void sauvegarder()
	{
		this.metier.sauvegarder();
	}

	public static void main(String[] a){ new Controleur(); }
}