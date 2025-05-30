package grupo_1.src.classes;

import grupo_1.src.interfaces.EntidadeInterface;

public class Usuario implements EntidadeInterface {

	private String tableName = "usuario";
	private int idUsuario;
	private String nome;
	private String email;
	private String cpf;
	private String telefone;
	private int idade;
	private String endereco;
	private String senha;
	private int idPlano;
	
	public Usuario() {
	}

	public Usuario(int idUsuario, String nome, String email, String cpf, String telefone, int idade, String endereco, String senha, int idPlano) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
		this.idade = idade;
		this.endereco = endereco;
		this.senha = senha;
		this.idPlano = idPlano;
	}
	
	@Override
	public String getTableName() {
		return this.tableName;
	}

	@Override
	public String[] getColumnNames() {
		String[] columnNames = {
			"id_usuario",
			"nome",
			"email",
			"cpf",
			"telefone",
			"idade",
			"endereco",
			"senha",
			"id_plano"
		};
		return columnNames;
	}

	@Override
	public String[] getFormatedValues() {
		String[] values = new String[9];
		
		values[0] = String.valueOf(this.idUsuario);
		values[1] = "'" + this.nome + "'";
		values[2] = "'" + this.email + "'";
		values[3] = "'" + this.cpf + "'";
		values[4] = "'" + this.telefone + "'";
		values[5] = String.valueOf(this.idade);
		values[6] = "'" + this.endereco + "'";
		values[7] = "'" + this.senha + "'";
		values[8] = String.valueOf(this.idPlano);
		
		return values;
	}

	@Override
	public String[] getPrimaryKeyColumns() {
		String[] colNames = {"id_usuario"};

        return colNames;
	}

	@Override
	public String[] getPrimaryKeyValues() {
		String[] values = new String[1];

        values[0] = String.valueOf(this.idUsuario);

        return values;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public int getIdade() {
		return idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getSenha() {
		return senha;
	}

	public int getIdPlano() {
		return idPlano;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setIdPlano(int idPlano) {
		this.idPlano = idPlano;
	}
}
