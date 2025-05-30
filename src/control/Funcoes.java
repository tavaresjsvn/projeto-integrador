package grupo_1.src.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import grupo_1.src.classes.*;
import grupo_1.src.data_access.DAO;

public class Funcoes {

	//Úsuário
	public static void cadastrarUsuario(Usuario usuario, DAO dao) throws SQLException {
        String query = DAO.queryInsertAutoIncrement(usuario);
        dao.executeQueryNR(query);
    }
	
	public static void atualizarUsuario(Usuario usuario, DAO dao) throws SQLException {
	    String query = DAO.queryUpdate(usuario);
	    dao.executeQueryNR(query);
	}
	
	public static void excluirUsuario(int idUsuario, DAO dao) throws SQLException {
	    String query = "DELETE FROM usuario WHERE id_usuario = " + idUsuario + ";";
	    dao.executeQueryNR(query);
	}
	
	public static Usuario buscarUsuarioPorLogin(String email, String senha, DAO dao) throws SQLException {
        String query = "SELECT * FROM usuario WHERE email = '" + email + "' AND senha = '" + senha + "';";
        ResultSet res = dao.executeQuery(query);
        if (res.next()) {
            return new Usuario(
                res.getInt("id_usuario"),
                res.getString("nome"),
                res.getString("email"),
                res.getString("cpf"),
                res.getString("telefone"),
                res.getInt("idade"),
                res.getString("endereco"),
                res.getString("senha"),
                res.getInt("id_plano")
            );
        }
        return null;
    }
	
	public static Usuario buscarUsuarioPorId(int idUsuario, DAO dao) throws SQLException {
	    String query = "SELECT * FROM usuario WHERE id_usuario = " + idUsuario + ";";
	    ResultSet res = dao.executeQuery(query);

	    if (res.next()) {
	        return new Usuario(
	            res.getInt("id_usuario"),
	            res.getString("nome"),
	            res.getString("email"),
	            res.getString("cpf"),
	            res.getString("telefone"),
	            res.getInt("idade"),
	            res.getString("endereco"),
	            res.getString("senha"),
	            res.getInt("id_plano")
	        );
	    }

	    return null;
	}

	
	public static boolean verificarAssinaturaPaga(int idUsuario, DAO dao) throws SQLException {
        String query = "SELECT p.tipo FROM usuario u INNER JOIN plano p ON u.id_plano = p.id_plano WHERE u.id_usuario = " + idUsuario + ";";
        ResultSet res = dao.executeQuery(query);
        if (res.next()) {
            String tipo = res.getString("tipo");
            return !tipo.equalsIgnoreCase("Gratuito");
        }
        return false;
    }
	
	public static boolean verificarEtapaHoje(int idUsuario, DAO dao) throws SQLException {
        String query = "SELECT COUNT(*) FROM etapa_cronograma ec " +
                       "INNER JOIN cronograma_capilar cc ON ec.id_cronograma = cc.id_cronograma " +
                       "WHERE cc.id_usuario = " + idUsuario + " AND ec.data_etapa = CURDATE();";
        ResultSet res = dao.executeQuery(query);
        res.next();
        return res.getInt(1) > 0;
    }
	
	//Perfil capilar
	public static void criarPerfilCapilar(PerfilCapilar perfil, DAO dao) throws SQLException {
        String query = DAO.queryInsertAutoIncrement(perfil);
        dao.executeQueryNR(query);
    }
	
	public static void atualizarPerfilCapilar(PerfilCapilar perfil, DAO dao) throws SQLException {
	    String query = DAO.queryUpdate(perfil);
	    dao.executeQueryNR(query);
	}
	
	public static PerfilCapilar buscarPerfilCapilarPorUsuario(int idUsuario, DAO dao) throws SQLException {
	    String query = "SELECT * FROM perfil_capilar WHERE id_usuario = " + idUsuario + ";";
	    ResultSet res = dao.executeQuery(query);
	    if (res.next()) {
	        return new PerfilCapilar(
	            res.getInt("id_perfil_capilar"),
	            res.getInt("id_usuario"),
	            res.getString("tipo_de_cabelo"),
	            res.getString("curvatura"),
	            res.getString("descricao_da_curvatura"),
	            res.getString("estado_do_cabelo"),
	            res.getString("objetivo")
	        );
	    }
	    return null;
	}
	
	//Salão
	public static void cadastrarSalao(Salao salao, DAO dao) throws SQLException {
	    String query = DAO.queryInsertAutoIncrement(salao);
	    dao.executeQueryNR(query);
	}
	
	public static void atualizarSalao(Salao salao, DAO dao) throws SQLException {
	    String query = DAO.queryUpdate(salao);
	    dao.executeQueryNR(query);
	}
	
	public static void excluirSalao(int idSalao, DAO dao) throws SQLException {
	    String query = "DELETE FROM salao WHERE id_salao = " + idSalao + ";";
	    dao.executeQueryNR(query);
	}
	
	public static Salao[] buscarSaloesPorEspecialidade(String tipo, DAO dao) throws SQLException {
	        String query = "SELECT * FROM salao WHERE especialidades LIKE '%" + tipo + "%';";
	        ResultSet res = dao.executeQuery(query);
	        ArrayList<Salao> saloes = new ArrayList<>();
	        while (res.next()) {
	            Salao s = new Salao(
	                res.getInt("id_salao"),
	                res.getString("nome"),
	                res.getString("endereco"),
	                res.getString("telefone"),
	                res.getString("especialidades"),
	                res.getFloat("nota")
	            );
	            saloes.add(s);
	        }
	        return saloes.toArray(new Salao[0]);
	 }
	
	public static Salao[] listarTopSaloes(int limite, DAO dao) throws SQLException {
        String query = "SELECT * FROM salao ORDER BY nota DESC LIMIT " + limite + ";";
        ResultSet res = dao.executeQuery(query);
        ArrayList<Salao> saloes = new ArrayList<>();
        while (res.next()) {
            Salao s = new Salao(
                res.getInt("id_salao"),
                res.getString("nome"),
                res.getString("endereco"),
                res.getString("telefone"),
                res.getString("especialidades"),
                res.getFloat("nota")
            );
            saloes.add(s);
        }
        return saloes.toArray(new Salao[0]);
    }
	
	//Profissional
	public static void cadastrarProfissional(Profissional profissional, DAO dao) throws SQLException {
	    String query = DAO.queryInsertAutoIncrement(profissional);
	    dao.executeQueryNR(query);
	}
	
	public static void atualizarProfissional(Profissional profissional, DAO dao) throws SQLException {
	    String query = DAO.queryUpdate(profissional);
	    dao.executeQueryNR(query);
	}
	
	public static void excluirProfissional(int idProfissional, DAO dao) throws SQLException {
	    String query = "DELETE FROM profissional WHERE id_profissional = " + idProfissional + ";";
	    dao.executeQueryNR(query);
	}
	
	public static Profissional[] listarProfissionaisDoSalao(int idSalao, DAO dao) throws SQLException {
	    String query = "SELECT * FROM profissional WHERE id_salao = " + idSalao + ";";
	    ResultSet res = dao.executeQuery(query);
	    ArrayList<Profissional> lista = new ArrayList<>();
	    
	    while (res.next()) {
	        Profissional p = new Profissional(
	            res.getInt("id_profissional"),
	            res.getInt("id_salao"),
	            res.getString("nome"),
	            res.getString("especialidade"),
	            res.getString("telefone"),
	            res.getString("descricao")
	        );
	        lista.add(p);
	    }

	    return lista.toArray(new Profissional[0]);
	}
	
	//Servico
	public static Servico[] listarServicosPorSalao(int idSalao, DAO dao) throws SQLException {
        String query = "SELECT * FROM servico WHERE id_salao = " + idSalao + ";";
        ResultSet res = dao.executeQuery(query);
        ArrayList<Servico> servicos = new ArrayList<>();
        while (res.next()) {
            Servico s = new Servico(
                res.getInt("id_servico"),
                res.getInt("id_salao"),
                res.getInt("id_profissional"),
                res.getString("nome"),
                res.getString("descricao"),
                res.getFloat("preco"),
                res.getString("tipo_servico")
            );
            servicos.add(s);
        }
        return servicos.toArray(new Servico[0]);
    }
	
	public static Servico[] buscarServicosPorTipo(String tipo, DAO dao) throws SQLException {
        String query = "SELECT * FROM servico WHERE tipo_servico LIKE '%" + tipo + "%';";
        ResultSet res = dao.executeQuery(query);
        ArrayList<Servico> servicos = new ArrayList<>();
        while (res.next()) {
            Servico s = new Servico(
                res.getInt("id_servico"),
                res.getInt("id_salao"),
                res.getInt("id_profissional"),
                res.getString("nome"),
                res.getString("descricao"),
                res.getFloat("preco"),
                res.getString("tipo_servico")
            );
            servicos.add(s);
        }
        return servicos.toArray(new Servico[0]);
    }
	
	public static Servico[] listarServicosPorProfissional(int idProfissional, DAO dao) throws SQLException {
	    String query = "SELECT * FROM servico WHERE id_profissional = " + idProfissional + ";";
	    ResultSet res = dao.executeQuery(query);
	    ArrayList<Servico> servicos = new ArrayList<>();
	    while (res.next()) {
	        Servico s = new Servico(
	            res.getInt("id_servico"),
	            res.getInt("id_salao"),
	            res.getInt("id_profissional"),
	            res.getString("nome"),
	            res.getString("descricao"),
	            res.getFloat("preco"),
	            res.getString("tipo_servico")
	        );
	        servicos.add(s);
	    }
	    return servicos.toArray(new Servico[0]);
	}

	
	//Agendamento
	public static void agendarServico(Agendamento agendamento, DAO dao) throws SQLException {
        String query = DAO.queryInsertAutoIncrement(agendamento);
        dao.executeQueryNR(query);
    }
	
	public static boolean verificarConflitoAgendamento(int idProfissional, String data, String hora, DAO dao) throws SQLException {
        String query = "SELECT COUNT(*) FROM agendamento WHERE id_profissional = " + idProfissional + " AND data_agendamento = '" + data + "' AND hora_agendamento = '" + hora + "' AND status = 'Agendado';";
        ResultSet res = dao.executeQuery(query);
        res.next();
        return res.getInt(1) > 0;
    }
	
	public static Agendamento[] listarAgendamentosUsuario(int idUsuario, DAO dao) throws SQLException {
        String query = "SELECT * FROM agendamento WHERE id_usuario = " + idUsuario + " ORDER BY data_agendamento DESC;";
        ResultSet res = dao.executeQuery(query);
        ArrayList<Agendamento> agendamentos = new ArrayList<>();
        while (res.next()) {
            Agendamento a = new Agendamento(
                res.getInt("id_agendamento"),
                res.getInt("id_usuario"),
                res.getInt("id_salao"),
                res.getInt("id_profissional"),
                res.getInt("id_servico"),
                res.getDate("data_agendamento").toLocalDate(),
                res.getTime("hora_agendamento").toLocalTime(),
                Status.valueOf(res.getString("status"))  
            );
            agendamentos.add(a);
        }
        return agendamentos.toArray(new Agendamento[0]);
    }
	
	public static Agendamento[] listarAgendamentosFuturos(int idUsuario, DAO dao) throws SQLException {
	    String query = "SELECT * FROM agendamento WHERE id_usuario = " + idUsuario +
	                   " AND data_agendamento >= CURDATE() AND status = 'Agendado' ORDER BY data_agendamento;";
	    ResultSet res = dao.executeQuery(query);
	    ArrayList<Agendamento> lista = new ArrayList<>();
	    while (res.next()) {
	        Agendamento a = new Agendamento(
	            res.getInt("id_agendamento"),
	            res.getInt("id_usuario"),
	            res.getInt("id_salao"),
	            res.getInt("id_profissional"),
	            res.getInt("id_servico"),
	            res.getDate("data_agendamento").toLocalDate(),
	            res.getTime("hora_agendamento").toLocalTime(),
	            Status.valueOf(res.getString("status"))
	        );
	        lista.add(a);
	    }
	    return lista.toArray(new Agendamento[0]);
	}

	
	public static void cancelarAgendamentoPorId(int idAgendamento, DAO dao) throws SQLException {
        String query = "UPDATE agendamento SET status = 'Cancelado' WHERE id_agendamento = " + idAgendamento + ";";
        dao.executeQueryNR(query);
    }
	
	public static void atualizarAgendamentosAtrasados(DAO dao) throws SQLException {
	    String query = "UPDATE agendamento SET status = 'Cancelado' " +
	                   "WHERE status = 'Agendado' AND data_agendamento < CURDATE();";
	    dao.executeQueryNR(query);
	}
	
	//Recomendação
	public static void gerarRecomendacao(Recomendacao recomendacao, DAO dao) throws SQLException {
        String query = DAO.queryInsertAutoIncrement(recomendacao);
        dao.executeQueryNR(query);
    }
	
	public static Recomendacao[] listarRecomendacoesAtuais(int idPerfil, DAO dao) throws SQLException {
        String query = "SELECT * FROM recomendacao WHERE id_perfil_capilar = " + idPerfil + " AND (data_validade IS NULL OR data_validade >= CURDATE());";
        ResultSet res = dao.executeQuery(query);
        ArrayList<Recomendacao> recs = new ArrayList<>();
        while (res.next()) {
            Recomendacao r = new Recomendacao(
                res.getInt("id_recomendacao"),
                res.getInt("id_perfil_capilar"),
                res.getString("titulo"),
                res.getString("tipo"),
                res.getString("conteudo"),
                res.getTimestamp("data_criacao").toLocalDateTime(),
                res.getDate("data_validade") != null ? res.getDate("data_validade").toLocalDate() : null
            );
            recs.add(r);
        }
        return recs.toArray(new Recomendacao[0]);
    }
	
	//Avaliação
	public static void avaliarSalao(Avaliacao avaliacao, DAO dao) throws SQLException {
        String query = DAO.queryInsertAutoIncrement(avaliacao);
        dao.executeQueryNR(query);
    }
	
	// somente admins devem usar
	public static void excluirAvaliacao(int idAvaliacao, DAO dao) throws SQLException {
	    String query = "DELETE FROM avaliacao WHERE id_avaliacao = " + idAvaliacao + ";";
	    dao.executeQueryNR(query);
	}
	
	public static Avaliacao[] listarAvaliacoesSalao(int idSalao, DAO dao) throws SQLException {
        String query = "SELECT * FROM avaliacao WHERE id_salao = " + idSalao + " ORDER BY data_avaliacao DESC;";
        ResultSet res = dao.executeQuery(query);
        ArrayList<Avaliacao> avaliacoes = new ArrayList<>();
        while (res.next()) {
            Avaliacao a = new Avaliacao(
                res.getInt("id_avaliacao"),
                res.getInt("id_usuario"),
                res.getInt("id_salao"),
                res.getFloat("nota"),
                res.getString("comentario"),
                res.getTimestamp("data_avaliacao").toLocalDateTime()
            );
            avaliacoes.add(a);
        }
        return avaliacoes.toArray(new Avaliacao[0]);
    }
	
	public static Avaliacao[] listarAvaliacoesDoUsuario(int idUsuario, DAO dao) throws SQLException {
	    String query = "SELECT * FROM avaliacao WHERE id_usuario = " + idUsuario + " ORDER BY data_avaliacao DESC;";
	    ResultSet res = dao.executeQuery(query);
	    ArrayList<Avaliacao> lista = new ArrayList<>();
	    while (res.next()) {
	        Avaliacao a = new Avaliacao(
	            res.getInt("id_avaliacao"),
	            res.getInt("id_usuario"),
	            res.getInt("id_salao"),
	            res.getFloat("nota"),
	            res.getString("comentario"),
	            res.getTimestamp("data_avaliacao").toLocalDateTime()
	        );
	        lista.add(a);
	    }
	    return lista.toArray(new Avaliacao[0]);
	}
	
	//Cronograma e Etapas
	public static void criarEtapaCronograma(EtapaCronograma etapa, DAO dao) throws SQLException {
        String query = DAO.queryInsertAutoIncrement(etapa);
        dao.executeQueryNR(query);
    }
	
	public static EtapaCronograma[] listarEtapasDoCronograma(int idCronograma, DAO dao) throws SQLException {
        String query = "SELECT * FROM etapa_cronograma WHERE id_cronograma = " + idCronograma + " ORDER BY data_etapa;";
        ResultSet res = dao.executeQuery(query);
        ArrayList<EtapaCronograma> etapas = new ArrayList<>();
        while (res.next()) {
            EtapaCronograma etapa = new EtapaCronograma(
                res.getInt("id_etapa_cronograma"),
                res.getInt("id_cronograma"),
                res.getInt("id_recomendacao"),
                res.getString("tipo_etapa"),
                res.getDate("data_etapa").toLocalDate(),
                res.getTime("hora_etapa").toLocalTime(),
                res.getString("descricao"),
                res.getBoolean("concluido")
            );
            etapas.add(etapa);
        }
        return etapas.toArray(new EtapaCronograma[0]);
    }

	public static void marcarEtapaComoConcluida(int idEtapa, DAO dao) throws SQLException {
        String query = "UPDATE etapa_cronograma SET concluido = true WHERE id_etapa_cronograma = " + idEtapa + ";";
        dao.executeQueryNR(query);
    }
	
	public static CronogramaCapilar buscarCronogramaDoUsuario(int idUsuario, DAO dao) throws SQLException {
	    String query = "SELECT * FROM cronograma_capilar WHERE id_usuario = " + idUsuario + " LIMIT 1;";
	    ResultSet res = dao.executeQuery(query);
	    if (res.next()) {
	        return new CronogramaCapilar(
	            res.getInt("id_cronograma"),
	            res.getInt("id_usuario"),
	            res.getInt("id_perfil_capilar")
	        );
	    }
	    return null;
	}
}
