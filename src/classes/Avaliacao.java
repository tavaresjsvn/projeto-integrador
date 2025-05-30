package grupo_1.src.classes;

import java.time.LocalDateTime;

import grupo_1.src.interfaces.EntidadeInterface;

public class Avaliacao implements EntidadeInterface {

	private String tableName = "avaliacao";
	private int idAvaliacao;
	private int idUsuario;
	private int idSalao;
	private float nota;
	private String comentario;
	private LocalDateTime dataAvaliacao;
	
	public Avaliacao() {
    }

	public Avaliacao(int idAvaliacao, int idUsuario, int idSalao, float nota, String comentario, LocalDateTime dataAvaliacao) {
		this.idAvaliacao = idAvaliacao;
		this.idUsuario = idUsuario;
		this.idSalao = idSalao;
		this.nota = nota;
		this.comentario = comentario;
		this.dataAvaliacao = dataAvaliacao;
	}

	@Override
	public String getTableName() {
		return this.tableName;
	}

	@Override
	public String[] getColumnNames() {
		String[] columnNames = {
			"id_avaliacao",
			"id_usuario",
			"id_salao",
			"nota",
			"comentario",
			"data_avaliacao"
		};
		
		return columnNames;
	}

	@Override
	public String[] getFormatedValues() {
		String[] values = new String[6];
		
		values[0] = String.valueOf(this.idAvaliacao);
		values[1] = String.valueOf(this.idUsuario);
		values[2] = String.valueOf(this.idSalao);
		values[3] = String.valueOf(this.nota);
		values[4] = "'" + this.comentario + "'";
		values[5] = "'" + this.dataAvaliacao + "'";
		
		return values;
	}

	@Override
	public String[] getPrimaryKeyColumns() {
		String[] colNames = {"id_avaliacao"};

        return colNames;
	}

	@Override
	public String[] getPrimaryKeyValues() {
		String[] values = new String[1];

        values[0] = String.valueOf(this.idAvaliacao);

        return values;
	}

	public int getIdAvaliacao() {
		return idAvaliacao;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public int getIdSalao() {
		return idSalao;
	}

	public float getNota() {
		return nota;
	}

	public String getComentario() {
		return comentario;
	}

	public LocalDateTime getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setIdSalao(int idSalao) {
		this.idSalao = idSalao;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public void setDataAvaliacao(LocalDateTime dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}	
}
