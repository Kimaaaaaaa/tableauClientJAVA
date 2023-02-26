import iut.algo.Decomposeur;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;


public class Clientele
{

	private List<Client> lstClients;

	public Clientele()
	{
		this.lstClients = new ArrayList<Client>();
		this.initTabClients();
	}

	public void initTabClients()
	{
		Scanner     scFic;
		Decomposeur dec;

		String      sPrenium;
		boolean     bPrenium;

		try
		{
			Scanner sc = new Scanner ( new FileInputStream ( "clients.data" ), "UTF8" );

			while ( sc.hasNextLine() )
			{

				dec = new Decomposeur ( sc.nextLine() );

				sPrenium = dec.getString(2);
				bPrenium = sPrenium.equals ( "true" );

				//                                    nom                prenom         prenium     anneeAdh
				this.lstClients.add ( new Client ( dec.getString(1), dec.getString(0), bPrenium, dec.getInt(3) ) );
			}

			sc.close();
		}
		catch (Exception e){ e.printStackTrace(); }
	}


	public boolean majPreniumClient ( int ligne, boolean val )
	{
		return this.lstClients.get(ligne).setPrenium ( val );
	}
	public boolean majAnneeAdhClient ( int ligne, int val )
	{ 
		return this.lstClients.get(ligne).setAnneeAdh ( val );
	}


	public void sauvegarder()
	{

		try
		{
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("clients.data"), "UTF8" ));
			
			for (Client clt:this.lstClients )
			{
				pw.println ( clt.getPrenom   () + "\t" +
				             clt.getNom      () + "\t" +
				             clt.getPrenium  () + "\t" +
				             clt.getAnneeAdh ()           );

			}
			pw.close();
		}
		catch (Exception e){ e.printStackTrace(); }
	}

	public boolean ajouterClient(String nom, String prenom)
	{
		this.lstClients.add ( 0, new Client ( nom, prenom ));
		return true;
	}
	public boolean supprimerClient(int ligne)
	{
		this.lstClients.remove(ligne);
		return true;
	}

	public List<Client> getClients()
	{
		return new ArrayList<Client>( this.lstClients );
	}
	public int getNbClients()
	{
		return this.lstClients.size();
	}


	public String toString()
	{
		String sRet = "";

		for ( Client clt: this.lstClients )
			sRet += clt.toString() + "\n";

		return sRet;
	}
}


