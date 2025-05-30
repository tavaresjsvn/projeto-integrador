package grupo_1.src.classes;

import grupo_1.src.interfaces.EntidadeInterface;

public class CronogramaCapilar implements EntidadeInterface {

	private String tableName = "cronograma_capilar";
	private int idCronograma;
	private int idUsuario;
	private int idPerfilCapilar;
	
	public CronogramaCapilar() {
    }

	public CronogramaCapilar(int idCronograma, int idUsuario, int idPerfilCapilar) {
		this.idCronograma = idCronograma;
		this.idUsuario = idUsuario;
		this.idPerfilCapilar = idPerfilCapilar;
	}

	@Override
	public String getTableName() {
		return this.tableName;
	}	

	@Override
	public String[] getColumnNames() {
		String[] columnNames = {
			"id_cronograma",
			"id_usuario",
			"id_perfil_capilar"
		};
		
		return columnNames;
	}

	@Override
	public String[] getFormatedValues() {
		String[] values = new String[3];
		
		values[0] = String.valueOf(this.idCronograma);
		values[1] = String.valueOf(this.idUsuario);
		values[2] = String.valueOf(this.idPerfilCapilar);
		
		return values;
	}

	@Override
	public String[] getPrimaryKeyColumns() {
		String[] colNames = {"id_cronograma"};

        return colNames;
	}

	@Override
	public String[] getPrimaryKeyValues() {
		String[] values = new String[1];

        values[0] = String.valueOf(this.idCronograma);

        return values;
	}
	
	public int getIdCronograma() {
		return idCronograma;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public int getIdPerfilCapilar() {
		return idPerfilCapilar;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setIdPerfilCapilar(int idPerfilCapilar) {
		this.idPerfilCapilar = idPerfilCapilar;
	}
}
