package grupo_1.src.classes;

import grupo_1.src.interfaces.EntidadeInterface;

public class Salao implements EntidadeInterface {

	private String tableName = "salao";
	private int idSalao;
	private String nome;
	private String endereco;
	private String telefone;
	private String especialidades;
	private float nota;
	
	public Salao() {
	}

	public Salao(int idSalao, String nome, String endereco, String telefone, String especialidades, float nota) {
		this.idSalao = idSalao;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.especialidades = especialidades;
		this.nota = nota;
	}
	

	@Override
	public String getTableName() {
		return this.tableName;
	}

	@Override
	public String[] getColumnNames() {
		String[] columnNames = {
				"id_salao",
				"nome",
				"endereco",
				"telefone",
				"especialidades",
				"nota"
		};
		
		return columnNames;
	}

	@Override
	public String[] getFormatedValues() {
		String[] values = new String[6];
		
		values[0] = String.valueOf(this.idSalao);
		values[1] = "'" + this.nome + "'";
		values[2] = "'" + this.endereco + "'";
		values[3] = "'" + this.telefone + "'";
		values[4] = "'" + this.especialidades + "'";
		values[5] = String.valueOf(this.nota);
		
		return values;
	}
	
	@Override
	public String[] getPrimaryKeyColumns() {
		String[] colNames = {"id_salao"};

        return colNames;
	}

	@Override
	public String[] getPrimaryKeyValues() {
		String[] values = new String[1];

        values[0] = String.valueOf(this.idSalao);

        return values;
	}

	public int getIdSalao() {
		return idSalao;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEspecialidades() {
		return especialidades;
	}

	public float getNota() {
		return nota;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEspecialidades(String especialidades) {
		this.especialidades = especialidades;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}
}
