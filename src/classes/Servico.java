package grupo_1.src.classes;

import grupo_1.src.interfaces.EntidadeInterface;

public class Servico implements EntidadeInterface{

	private String tableName = "servico";
	private int idServico;
	private int idSalao;
	private int idProfissional;
	private String nome;
	private String descricao;
	private float preco;
	private String tipoServico;
	
	public Servico() {
    }

	public Servico(int idServico, int idSalao, int idProfissional, String nome, String descricao, float preco, String tipoServico) {
		this.idServico = idServico;
		this.idSalao = idSalao;
		this.idProfissional = idProfissional;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.tipoServico = tipoServico;
	}

	@Override
	public String getTableName() {
		return this.tableName;
	}

	@Override
	public String[] getColumnNames() {
		String[] columnNames = {
				"id_servico",
				"id_salao",
				"id_profissional",
				"nome",
				"descricao",
				"preco",
				"tipo_servico"
		};
		
		return columnNames;
	}

	@Override
	public String[] getFormatedValues() {
		String[] values = new String[7];
		
		values[0] = String.valueOf(this.idServico);
		values[1] = String.valueOf(this.idSalao);
		values[2] = String.valueOf(this.idProfissional);
		values[3] = "'" + this.nome + "'";
		values[4] = "'" + this.descricao + "'";
		values[5] = String.valueOf(this.preco);
		values[6] = "'" + this.tipoServico + "'";
		
		return values;
	}

	@Override
	public String[] getPrimaryKeyColumns() {
		String[] colNames = {"id_servico"};

        return colNames;
	}

	@Override
	public String[] getPrimaryKeyValues() {
		String[] values = new String[1];

        values[0] = String.valueOf(this.idServico);

        return values;
	}	

	public int getIdServico() {
		return idServico;
	}

	public int getIdSalao() {
		return idSalao;
	}

	public int getIdProfissional() {
		return idProfissional;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public float getPreco() {
		return preco;
	}

	public String getTipoServico() {
		return tipoServico;
	}

	public void setIdSalao(int idSalao) {
		this.idSalao = idSalao;
	}

	public void setIdProfissional(int idProfissional) {
		this.idProfissional = idProfissional;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}
}
