
import java.awt.event.*;
import javax.swing.*;

public class PanelAction extends JPanel implements ActionListener
{
	private Controleur ctrl;
	private JButton    btnSauvegarder;
	private JButton    btnCreer;
	private JButton    btnSupprimer;

	private FrameAjout frameNouvCli;

	public PanelAction (Controleur ctrl )
	{
		this.ctrl = ctrl;

		// création des composants
		this.btnSauvegarder = new JButton ( "Sauvegarder"  );
		this.btnCreer       = new JButton ( "Créer Client" );
		this.btnSupprimer   = new JButton ( "Supprimer Client" );

		// Positionnement des composants
		this.add ( this.btnSauvegarder );
		this.add ( this.btnCreer       );
		this.add ( this.btnSupprimer   );

		// Activation des composants
		this.btnSauvegarder.addActionListener ( this );
		this.btnCreer      .addActionListener ( this );
		this.btnSupprimer  .addActionListener ( this );
	}


	public void actionPerformed ( ActionEvent e)
	{
		if ( e.getSource() == this.btnSauvegarder )
			this.ctrl.sauvegarder ();

		if ( e.getSource() == this.btnCreer )
		{	
			if ( this.frameNouvCli == null)
				this.frameNouvCli = new FrameAjout(this.ctrl);
			else
				this.frameNouvCli.setVisible(true);
		}

		if ( e.getSource() == this.btnSupprimer )
			this.ctrl.supprimerClient();
	}


}