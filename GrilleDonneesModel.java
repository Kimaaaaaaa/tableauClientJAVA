import java.util.List;

import javax.swing.table.AbstractTableModel;

public class GrilleDonneesModel extends AbstractTableModel
{
	private Controleur ctrl;

	private String[]   tabEntetes;
	private Object[][] tabDonnees;

	public GrilleDonneesModel (Controleur ctrl)
	{
		this.ctrl = ctrl;

		Client clt;
		List<Client> lstClients = ctrl.getClients();

		tabDonnees = new Object[lstClients.size()][4];

		for ( int lig=0; lig<lstClients.size(); lig++)
		{
			clt = lstClients.get(lig);

			tabDonnees[lig][0] = clt.getPrenom  ();
			tabDonnees[lig][1] = clt.getNom     ();
			tabDonnees[lig][2] = clt.getPrenium ();
			tabDonnees[lig][3] = clt.getAnneeAdh();
		}

		this.tabEntetes = new String[]   {   "Prénom"  , "Nom"     , "Prenium", "Année Adhésion"  };

	}

	public int    getColumnCount()                 { return this.tabEntetes.length;      }
	public int    getRowCount   ()                 { return this.tabDonnees.length;      }
	public String getColumnName (int col)          { return this.tabEntetes[col];        }
	public Object getValueAt    (int row, int col) { return this.tabDonnees[row][col];   }
	public Class  getColumnClass(int c)            { return getValueAt(0, c).getClass(); }

	public boolean isCellEditable(int row, int col)
	{
		return col == 2 || col == 3;
	}

	public void setValueAt(Object value, int row, int col)
	{
		boolean bRet;
	
		if ( col == 2 )
		{
			bRet = this.ctrl.majPreniumClient ( row, (Boolean) value );
			if ( bRet )
			{
				this.tabDonnees[row][col] = value;
				this.fireTableCellUpdated(row, col);
			}
		}

		if ( col == 3 )
		{
			bRet = this.ctrl.majAnneeAdhClient( row , (Integer) value );
			if ( bRet )
			{
				this.tabDonnees[row][col] = value;
				this.fireTableCellUpdated(row, col);
			}
			
		}

	}


}