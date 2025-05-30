package grupo_1.src.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import grupo_1.src.interfaces.EntidadeInterface;

public class Recomendacao implements EntidadeInterface{

	private String tableName = "recomendacao";
	private int idRecomendacao;
	private int idPerfilCapilar;
	private String titulo;
	private String tipoRecomendacao;
	private String conteudo;
	private LocalDateTime dataCriacao;
	private LocalDate dataValidade;
	
	public Recomendacao() {
	}

	public Recomendacao(int idRecomendacao, int idPerfilCapilar, String titulo, String tipoRecomendacao, String conteudo, LocalDateTime dataCriacao, LocalDate dataValidade) {
		this.idRecomendacao = idRecomendacao;
		this.idPerfilCapilar = idPerfilCapilar;
		this.titulo = titulo;
		this.tipoRecomendacao = tipoRecomendacao;
		this.conteudo = conteudo;
		this.dataCriacao = dataCriacao;
		this.dataValidade = dataValidade;
	}

	@Override
	public String getTableName() {
		return this.tableName;
	}

	@Override
	public String[] getColumnNames() {
		String[] columnNames = {
			"id_recomendacao",
			"id_perfil_capilar",
			"titulo",
			"tipo",
			"conteudo",
			"data_criacao",
			"data_validade"
		};
		
		return columnNames;
	}

	@Override
	public String[] getFormatedValues() {
		String[] values = new String[7];
		
		values[0] = String.valueOf(this.idRecomendacao);
		values[1] = String.valueOf(this.idPerfilCapilar);
		values[2] = "'" + this.titulo + "'";
		values[3] = "'" + this.tipoRecomendacao + "'";
		values[4] = "'" + this.conteudo + "'";
		values[5] = "'" + this.dataCriacao + "'";
		values[6] = "'" + this.dataValidade + "'";
		
		return values;
	}

	@Override
	public String[] getPrimaryKeyColumns() {
		String[] colNames = {"id_recomendacao"};
		
		return colNames;
	}

	@Override
	public String[] getPrimaryKeyValues() {
		String[] values = new String[1];

        values[0] = String.valueOf(this.idRecomendacao);
        
		return values;
	}

	public int getIdRecomendacao() {
		return idRecomendacao;
	}

	public int getIdPerfilCapilar() {
		return idPerfilCapilar;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getTipoRecomendacao() {
		return tipoRecomendacao;
	}

	public String getConteudo() {
		return conteudo;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setIdPerfilCapilar(int idPerfilCapilar) {
		this.idPerfilCapilar = idPerfilCapilar;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setTipoRecomendacao(String tipoRecomendacao) {
		this.tipoRecomendacao = tipoRecomendacao;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}
}
