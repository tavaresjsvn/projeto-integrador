package grupo_1.src.classes;

import java.time.LocalDate;
import java.time.LocalTime;

import grupo_1.src.interfaces.EntidadeInterface;

public class EtapaCronograma implements EntidadeInterface {

	private String tableName = "etapa_cronograma";
	private int idEtapaCronograma;
	private int idCronograma;
	private Integer idRecomendacao;
	private String tipoEtapa;
	private LocalDate dataEtapa;
	private LocalTime horaEtapa;
	private String descricao;
	private boolean concluido;
	
	public EtapaCronograma() {
    }

	public EtapaCronograma(int idEtapaCronograma, int idCronograma, Integer idRecomendacao, String tipoEtapa, LocalDate dataEtapa, LocalTime horaEtapa, String descricao, boolean concluido) {
		this.idEtapaCronograma = idEtapaCronograma;
		this.idCronograma = idCronograma;
		this.idRecomendacao = idRecomendacao;
		this.tipoEtapa = tipoEtapa;
		this.dataEtapa = dataEtapa;
		this.horaEtapa = horaEtapa;
		this.descricao = descricao;
		this.concluido = concluido;
	}

	@Override
	public String getTableName() {
		return this.tableName;
	}

	@Override
	public String[] getColumnNames() {
		String[] columnNames = {
			"id_etapa_cronograma",
			"id_cronograma",
			"id_recomendacao",
			"tipo_etapa",
			"data_etapa",
			"hora_etapa",
			"descricao",
			"concluido"
		};
		
		return columnNames;
	}

	@Override
	public String[] getFormatedValues() {
		String[] values = new String[8];
		
		values[0] = String.valueOf(this.idEtapaCronograma);
		values[1] = String.valueOf(this.idCronograma);
		values[2] = String.valueOf(this.idRecomendacao);
		values[3] = "'" + this.tipoEtapa + "'";
		values[4] = "'" + this.dataEtapa + "'";
		values[5] = "'" + this.horaEtapa + "'";
		values[6] = "'" + this.descricao + "'";
		values[7] = String.valueOf(this.concluido);
		
		return values;
	}

	@Override
	public String[] getPrimaryKeyColumns() {
		String[] colNames = {"id_etapa_cronograma"};

        return colNames;
	}

	@Override
	public String[] getPrimaryKeyValues() {
		String[] values = new String[1];

        values[0] = String.valueOf(this.idEtapaCronograma);

        return values;
	}

	public int getIdEtapaCronograma() {
		return idEtapaCronograma;
	}

	public int getIdCronograma() {
		return idCronograma;
	}

	public int getIdRecomendacao() {
		return idRecomendacao;
	}

	public String getTipoEtapa() {
		return tipoEtapa;
	}

	public LocalDate getDataEtapa() {
		return dataEtapa;
	}

	public LocalTime getHoraEtapa() {
		return horaEtapa;
	}

	public String getDescricao() {
		return descricao;
	}

	public boolean isConcluido() {
		return concluido;
	}

	public void setIdCronograma(int idCronograma) {
		this.idCronograma = idCronograma;
	}

	public void setIdRecomendacao(Integer idRecomendacao) {
		this.idRecomendacao = idRecomendacao;
	}

	public void setTipoEtapa(String tipoEtapa) {
		this.tipoEtapa = tipoEtapa;
	}

	public void setDataEtapa(LocalDate dataEtapa) {
		this.dataEtapa = dataEtapa;
	}

	public void setHoraEtapa(LocalTime horaEtapa) {
		this.horaEtapa = horaEtapa;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}
}
