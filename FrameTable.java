import java.awt.BorderLayout;
import javax.swing.*;


public class FrameTable extends JFrame
{
	Controleur  ctrl;
	PanelTable  panel1;
	PanelAction panel2;

	public FrameTable(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setSize ( 500, 250 );
		this.setTitle( "Gestion Client" );

		// Création des composants
		this.panel1 = new PanelTable  (this.ctrl);
		this.panel2 = new PanelAction (this.ctrl);

		// Positionnement des composants

		this.add ( panel1, BorderLayout.CENTER );
		this.add ( panel2, BorderLayout.SOUTH  );

		this.setVisible ( true );

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public int getClientActif()
	{
		return panel1.getClientActif();
	}

	public void majClient(int position)
	{
		this.panel1.majClient(position);
	}
}