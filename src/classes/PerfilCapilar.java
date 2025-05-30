package grupo_1.src.classes;

import grupo_1.src.interfaces.EntidadeInterface;

public class PerfilCapilar implements EntidadeInterface{

	private String tableName = "perfil_capilar";
	private int idPerfilCapilar;
	private int idUsuario;
	private String tipoDeCabelo;
	private String curvatura;
	private String descricaoDaCurvatura;
	private String estadoDoCabelo;
	private String objetivo;
	
	public PerfilCapilar() {
	}

	public PerfilCapilar(int idPerfilCapilar, int idUsuario, String tipoDeCabelo, String curvatura, String descricaoDaCurvatura, String estadoDoCabelo, String objetivo) {
		this.idPerfilCapilar = idPerfilCapilar;
		this.idUsuario = idUsuario;
		this.tipoDeCabelo = tipoDeCabelo;
		this.curvatura = curvatura;
		this.descricaoDaCurvatura = descricaoDaCurvatura;
		this.estadoDoCabelo = estadoDoCabelo;
		this.objetivo = objetivo;
	}
	
	@Override
	public String getTableName() {
		return this.tableName;
	}

	@Override
	public String[] getColumnNames() {
		String[] columnNames = {
			"id_perfil_capilar",
			"id_usuario",
			"tipo_de_cabelo",
			"curvatura",
			"descricao_da_curvatura",
			"estado_do_cabelo",
			"objetivo"
		};
		
		return columnNames;
	}

	@Override
	public String[] getFormatedValues() {
		String[] values = new String[7];
		
		values[0] = String.valueOf(this.idPerfilCapilar);
		values[1] = String.valueOf(this.idUsuario);
		values[2] = "'" + this.tipoDeCabelo + "'";
		values[3] = "'" + this.curvatura + "'";
		values[4] = "'" + this.descricaoDaCurvatura + "'";
		values[5] = "'" + this.estadoDoCabelo + "'";
		values[6] = "'" + this.objetivo + "'";
		
		return values;
	}

	@Override
	public String[] getPrimaryKeyColumns() {
		String[] colNames = {"id_perfil_capilar"};

        return colNames;
	}

	@Override
	public String[] getPrimaryKeyValues() {
		String[] values = new String[1];

        values[0] = String.valueOf(this.idPerfilCapilar);

        return values;
	}

	public int getIdPerfilCapilar() {
		return idPerfilCapilar;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public String getTipoDeCabelo() {
		return tipoDeCabelo;
	}

	public String getCurvatura() {
		return curvatura;
	}

	public String getDescricaoDaCurvatura() {
		return descricaoDaCurvatura;
	}

	public String getEstadoDoCabelo() {
		return estadoDoCabelo;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setTipoDeCabelo(String tipoDeCabelo) {
		this.tipoDeCabelo = tipoDeCabelo;
	}

	public void setCurvatura(String curvatura) {
		this.curvatura = curvatura;
	}

	public void setDescricaoDaCurvatura(String descricaoDaCurvatura) {
		this.descricaoDaCurvatura = descricaoDaCurvatura;
	}

	public void setEstadoDoCabelo(String estadoDoCabelo) {
		this.estadoDoCabelo = estadoDoCabelo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	
}
