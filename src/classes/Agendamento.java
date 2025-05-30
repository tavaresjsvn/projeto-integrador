package grupo_1.src.classes;

import java.time.LocalDate;
import java.time.LocalTime;

import grupo_1.src.interfaces.EntidadeInterface;

public class Agendamento implements EntidadeInterface {

	private String tableName = "agendamento";
	private int idAgendamento;
	private int idUsuario;
	private int idSalao;
	private int idProfissional;
	private int idServico;
	private LocalDate dataAgendamento;
	private LocalTime horaAgendamento;
	private Status status;
	
	public Agendamento() {
    }

	public Agendamento(int idAgendamento, int idUsuario, int idSalao, int idProfissional, int idServico, LocalDate dataAgendamento, LocalTime horaAgendamento, Status status) {
		this.idAgendamento = idAgendamento;
		this.idUsuario = idUsuario;
		this.idSalao = idSalao;
		this.idProfissional = idProfissional;
		this.idServico = idServico;
		this.dataAgendamento = dataAgendamento;
		this.horaAgendamento = horaAgendamento;
		this.status = status;
	}

	@Override
	public String getTableName() {
		return this.tableName;
	}

	@Override
	public String[] getColumnNames() {
		String[] columnNames = {
		    "id_agendamento",
			"id_usuario",
			"id_salao",
			"id_prosfissional",
			"id_servico",
			"data_agendamento",
			"hora_agendamento",
			"status"
		};
		
		return columnNames;
	}

	@Override
	public String[] getFormatedValues() {
		String[] values = new String[8];
		
		values[0] = String.valueOf(this.idAgendamento);
		values[1] = String.valueOf(this.idUsuario);
		values[2] = String.valueOf(this.idSalao);
		values[3] = String.valueOf(this.idProfissional);
		values[4] = String.valueOf(this.idServico);
		values[5] = "'" + this.dataAgendamento + "'";
		values[6] = "'" + this.horaAgendamento + "'";
		values[7] = "'" + this.status.name() + "'";
		
		return values;
	}

	@Override
	public String[] getPrimaryKeyColumns() {
		String[] colNames = {"id_agendamento"};

        return colNames;
	}

	@Override
	public String[] getPrimaryKeyValues() {
		String[] values = new String[1];

        values[0] = String.valueOf(this.idAgendamento);

        return values;
	}

	public int getIdAgendamento() {
		return idAgendamento;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public int getIdSalao() {
		return idSalao;
	}

	public int getIdProfissional() {
		return idProfissional;
	}

	public int getIdServico() {
		return idServico;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public LocalTime getHoraAgendamento() {
		return horaAgendamento;
	}

	public Status getStatus() {
		return status;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setIdSalao(int idSalao) {
		this.idSalao = idSalao;
	}

	public void setIdProfissional(int idProfissional) {
		this.idProfissional = idProfissional;
	}

	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public void setHoraAgendamento(LocalTime horaAgendamento) {
		this.horaAgendamento = horaAgendamento;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
