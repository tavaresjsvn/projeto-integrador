package grupo_1.src.classes;

import grupo_1.src.interfaces.EntidadeInterface;

public class Plano implements EntidadeInterface {

	private String tableName = "plano";
	private int idPlano;
	private Tipo tipo;
	private int duracao; // Quantidade de meses
	private String beneficios;
	private float valor;
	
	public Plano() {
    }

	public Plano(int idPlano, Tipo tipo, int duracao, String beneficios, float valor) {
		this.idPlano = idPlano;
		this.tipo = tipo;
		this.duracao = duracao;
		this.beneficios = beneficios;
		this.valor = valor;
	}
	
	@Override
	public String getTableName() {
		return this.tableName;
	}

	@Override
	public String[] getColumnNames() {
		String[] columnNames = {
			"id_plano",
			"tipo",
			"duracao",
			"beneficios",
			"valor"
		};
		
		return columnNames;
	}

	@Override
	public String[] getFormatedValues() {
		String[] values = new String[5];
		
		values[0] = String.valueOf(this.idPlano);
		values[1] = "'" + this.tipo.name() + "'";
		values[2] = String.valueOf(this.duracao);
		values[3] = "'" + this.beneficios + "'";
		values[4] = String.valueOf(this.valor);

		return values;
	}

	@Override
	public String[] getPrimaryKeyColumns() {
		String[] colNames = {"id_plano"};

        return colNames;
	}

	@Override
	public String[] getPrimaryKeyValues() {
		String[] values = new String[1];

        values[0] = String.valueOf(this.idPlano);

        return values;
	}

	public int getIdPlano() {
		return idPlano;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public int getDuracao() {
		return duracao;
	}

	public String getBeneficios() {
		return beneficios;
	}

	public float getValor() {
		return valor;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}	
}
