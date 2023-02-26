import java.awt.BorderLayout;
import java.awt.Point;
import javax.swing.*;


public class FrameAjout extends JFrame
{
	private Controleur    ctrl;

	public FrameAjout(Controleur ctrl)
	{
		this.ctrl = ctrl;

		Point pos = this.ctrl.getMasterLocation();
		pos.translate(0, (int) this.ctrl.getMasterSize().getHeight() + 10);
		this.setLocation( pos );
		this.setTitle   ( "Nouveau Client" );
		this.setSize    ( (int) this.ctrl.getMasterSize().getWidth(), 200 );

		this.add(new PanelAjout(this.ctrl, this));

		this.setVisible ( true );

		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
	}
}