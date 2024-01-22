package MODEL;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTabela extends AbstractTableModel {

	private static final String[] colunas = {
		"ID Cliente", "Nome", "CPF", "Endere\u00E7o"
	};
	
	private ArrayList<Cliente> clientes;
	
	public ModeloTabela(ArrayList<Cliente> clientes) {
		super();
		this.clientes = clientes;
	}
	
	@Override
	public int getRowCount() {
		return clientes.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Cliente cliente = clientes.get(rowIndex);
		if(columnIndex == 0) {
			return cliente.getId();
		} else
			if (columnIndex == 1){
				return cliente.getNome();
			} else
				if (columnIndex == 2){
					return cliente.getCpf();
				} else
					if (columnIndex == 3){
						return cliente.getEndereco();
					}
		
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}

}
