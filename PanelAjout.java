import javax.swing.*;
import java.awt.event.*;
import java.util.GregorianCalendar;
import java.awt.BorderLayout;
import java.awt.Color;

public class PanelAjout extends JPanel implements ActionListener
{
	private FrameAjout frame;
	private Controleur ctrl;

	private JButton btnAnnuler;
	private JButton btnAjouter;

	private JTextField txtNom;
	private JTextField txtPrenom;
	private JCheckBox  cbPrenium;
	private JTextField txtAnneeAdh;

	public PanelAjout(Controleur ctrl, FrameAjout frame)
	{
		JPanel panelSaisie, panelBoutons;
		JLabel lblNom, lblPrenom, lblPrenium, lblAnneeAdh;

		this.ctrl = ctrl;
		this.frame = frame;
		this.setLayout( new BorderLayout() );

		//création
		panelSaisie  = new JPanel();
		panelSaisie.setLayout( null );
		panelBoutons = new JPanel();

		this.btnAnnuler = new JButton( "Annuler" );
		this.btnAjouter = new JButton( "Ajouter" );

		lblNom      = new JLabel("nom : "           , JLabel.RIGHT);
		lblPrenom   = new JLabel("prenom : "        , JLabel.RIGHT);
		lblPrenium  = new JLabel("prenom : "        , JLabel.RIGHT);
		lblAnneeAdh = new JLabel("année adhésion : ", JLabel.RIGHT);
		lblPrenium .setForeground( Color.gray );
		lblAnneeAdh.setForeground( Color.gray );

		this.txtNom        = new JTextField();
		this.txtPrenom     = new JTextField();
		this.cbPrenium     = new JCheckBox ();
		this.txtAnneeAdh   = new JTextField();

		this.cbPrenium  .setEnabled ( false );
		this.txtAnneeAdh.setEditable( false );
		this.txtAnneeAdh.setText( "" + new GregorianCalendar().get(GregorianCalendar.YEAR) );

		//position
		this.add(panelSaisie , BorderLayout.CENTER);
		this.add(panelBoutons, BorderLayout.SOUTH );

		panelBoutons.add(this.btnAnnuler);
		panelBoutons.add(this.btnAjouter);

		panelSaisie.add(lblNom);
		panelSaisie.add(lblPrenom);
		panelSaisie.add(lblPrenium);
		panelSaisie.add(lblAnneeAdh);
		panelSaisie.add(this.txtNom);
		panelSaisie.add(this.txtPrenom);
		panelSaisie.add(this.cbPrenium);
		panelSaisie.add(this.txtAnneeAdh);

		lblNom          .setBounds(  5,  5, 120, 20);
		lblPrenom       .setBounds(  5, 30, 120, 20);
		lblPrenium      .setBounds(  5, 55, 120, 20);
		lblAnneeAdh     .setBounds(  5, 80, 120, 20);
		this.txtNom     .setBounds(135,  5, 120, 20);
		this.txtPrenom  .setBounds(135, 30, 120, 20);
		this.cbPrenium  .setBounds(135, 55, 120, 20);
		this.txtAnneeAdh.setBounds(135, 80, 120, 20);

		//activation
		this.btnAjouter.addActionListener(this);
		this.btnAnnuler.addActionListener(this);
	}
	

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == this.btnAnnuler)
			this.frame.setVisible(false);

		if (e.getSource() == this.btnAjouter)
			this.ctrl.ajouterClient( this.txtNom.getText(), this.txtPrenom.getText());
	}
}
