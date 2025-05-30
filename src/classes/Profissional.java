package grupo_1.src.classes;

import grupo_1.src.interfaces.EntidadeInterface;

public class Profissional implements EntidadeInterface {

	private String tableName = "profissional";
	private int idProfissional;
	private int idSalao;
	private String nome;
	private String especialidade;
	private String telefone;
	private String descricao;
	
	public Profissional() {
	}

	public Profissional(int idProfissional, int idSalao, String nome, String especialidade, String telefone, String descricao) {
		this.idProfissional = idProfissional;
		this.idSalao = idSalao;
		this.nome = nome;
		this.especialidade = especialidade;
		this.telefone = telefone;
		this.descricao = descricao;
	}
	@Override
	public String getTableName() {
		return this.tableName;
	}

	@Override
	public String[] getColumnNames() {
		String[] columnNames = {
				"id_profissional",
				"id_salao",
				"nome",
				"especialidade",
				"telefone",
				"descricao",
		};
		
		return columnNames;
	}

	@Override
	public String[] getFormatedValues() {
		String[] values = new String[6];
		
		values[0] = String.valueOf(this.idProfissional);
		values[1] = String.valueOf(this.idSalao);
		values[2] = "'" + this.nome + "'";
		values[3] = "'" + this.especialidade + "'";
		values[4] = "'" + this.telefone + "'";
		values[5] = "'" + this.descricao + "'";
		
		return values;
	}

	@Override
	public String[] getPrimaryKeyColumns() {
		String[] colNames = {"id_profissional"};

        return colNames;
	}

	@Override
	public String[] getPrimaryKeyValues() {
		String[] values = new String[1];

        values[0] = String.valueOf(this.idProfissional);

        return values;
	}
	public int getIdProfissional() {
		return idProfissional;
	}

	public int getIdSalao() {
		return idSalao;
	}

	public String getNome() {
		return nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setIdSalao(int idSalao) {
		this.idSalao = idSalao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
