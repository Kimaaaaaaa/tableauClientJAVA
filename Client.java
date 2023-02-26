import java.util.GregorianCalendar;
import static java.util.GregorianCalendar.YEAR;

public class Client
{
	private String  nom;
	private String  prenom;
	private boolean prenium;
	private int     anneeAdh;

	public Client (String nom, String prenom, boolean prenium, int anneeAdh )
	{
		this.nom      = nom;
		this.prenom   = prenom;
		this.prenium  = prenium;
		this.anneeAdh = anneeAdh;
	}
	public Client (String nom, String prenom)
	{
		this (nom, prenom, false, new GregorianCalendar().get(YEAR));
	}

	public String  getNom     () { return this.nom;      }
	public String  getPrenom  () { return this.prenom;   }
	public boolean getPrenium () { return this.prenium;  }
	public int     getAnneeAdh() { return this.anneeAdh; }

	public boolean setPrenium ( boolean val )
	{
		int annee = new GregorianCalendar().get(YEAR);

		if ( annee - this.anneeAdh < 5 ) return false;
		if ( this.anneeAdh > annee || this.anneeAdh < 1900 ) return false;

		this.prenium = val;
		return true;
	}
	public boolean setAnneeAdh ( int val )
	{
		int annee = new GregorianCalendar().get ( GregorianCalendar.YEAR );

		if ( val > annee || val < 1900 ) return false;

		this.anneeAdh = val;
		return true;
	}

	public String  toString   ()
	{
		return String.format ( "%-15s", this.prenom  ) + " " +
		       String.format ( "%-15s", this.nom     ) + " " +
		       String.format ( "%-5s" , this.prenium ) + " " +
		       String.format ( "%4d",   this.anneeAdh);
	}

}