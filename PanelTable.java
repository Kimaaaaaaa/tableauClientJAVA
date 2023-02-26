import java.util.ArrayList;

import java.awt.*;
import javax.swing.*;


public class PanelTable extends JPanel
{
	Controleur         ctrl;
	JTable             tblGrilleDonnees;
	JScrollPane        spGrilleDonnees;

	public PanelTable (Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setLayout ( new BorderLayout() );

		JPanel panelTmp = new JPanel ( new BorderLayout() );

		// Création des composants
		this.tblGrilleDonnees = new JTable ( new GrilleDonneesModel(ctrl) );
		this.tblGrilleDonnees.setFillsViewportHeight(true);

 		this.spGrilleDonnees   = new JScrollPane( this.tblGrilleDonnees );

		// positionnement des composants
		this.add ( this.spGrilleDonnees, BorderLayout.CENTER );
	}

	public void majClient(int position)
	{
		int hauteur = this.tblGrilleDonnees.getHeight();

		this.tblGrilleDonnees.setModel( new GrilleDonneesModel(ctrl) );

		this.tblGrilleDonnees.setRowSelectionInterval(position, position);
		this.spGrilleDonnees.getViewport().setViewPosition(new Point(0, position * hauteur));
	}

	public int getClientActif()
	{
		return this.tblGrilleDonnees.getSelectedRow();
	}
}