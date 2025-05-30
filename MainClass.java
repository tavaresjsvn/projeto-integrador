package grupo_1;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import grupo_1.src.classes.*;
import grupo_1.src.control.Funcoes;
import grupo_1.src.data_access.DAO;


public class MainClass {
    public static void main (String[] args) throws SQLException, ClassNotFoundException {
    	 DAO dao = DAO.getInstance();

         Usuario novoUsuario = new Usuario(
             1, "Teste Usuário", "teste.usuario@email.com", "11122233344",
             "(81) 90000-0000", 27, "Rua Teste, 999", "minhasenha", 1
         );
         Funcoes.cadastrarUsuario(novoUsuario, dao);
         System.out.println("Usuário criado.");

         Usuario usuario = Funcoes.buscarUsuarioPorLogin("teste.usuario@email.com", "minhasenha", dao);
         System.out.println("Login: " + usuario.getNome());

         PerfilCapilar perfil = new PerfilCapilar(
             3, usuario.getIdUsuario(), "Crespo", "4C", "Definido",
             "Seco e quebradiço", "Reconstrução"
         );
         Funcoes.criarPerfilCapilar(perfil, dao);
         System.out.println("Perfil capilar criado.");

         Salao salao = new Salao(
             4, "Salão Teste", "Rua dos Testes, 101", "(81) 98888-9999",
             "Hidratação, Crespos", 4.9f
         );
         Funcoes.cadastrarSalao(salao, dao);
         System.out.println("Salão cadastrado.");

         Profissional profissional = new Profissional(
             3, salao.getIdSalao(), "Joana Estilo", "Cabelos Crespos",
             "(81) 98888-1122", "Especialista em cabelos crespos e secos"
         );
         Funcoes.cadastrarProfissional(profissional, dao);
         System.out.println("Profissional cadastrado.");

         Servico servico = new Servico(
             8, salao.getIdSalao(), profissional.getIdProfissional(),
             "Hidratação Power", "Nutrição intensiva para cabelos crespos", 120.0f, "Tratamento"
         );
         String queryServico = grupo_1.src.data_access.DAO.queryInsertAutoIncrement(servico);
         dao.executeQueryNR(queryServico);
         System.out.println("Serviço cadastrado.");

         Agendamento agendamento = new Agendamento(
             3,
             usuario.getIdUsuario(),
             salao.getIdSalao(),
             profissional.getIdProfissional(),
             servico.getIdServico(),
             LocalDate.now().plusDays(2),
             LocalTime.of(14, 0),
             Status.Agendado
         );
         Funcoes.agendarServico(agendamento, dao);
         System.out.println("Serviço agendado.");

         // listando agendamentos
         Agendamento[] agendamentos = Funcoes.listarAgendamentosUsuario(usuario.getIdUsuario(), dao);
         System.out.println("Agendamentos encontrados: " + agendamentos.length);

         // cancelando agendamentos
         if (agendamentos.length > 0) {
             Funcoes.cancelarAgendamentoPorId(agendamentos[0].getIdAgendamento(), dao);
             System.out.println("Agendamento cancelado.");
         }

         Recomendacao recomendacao = new Recomendacao(
             9, perfil.getIdPerfilCapilar(), "Nutrição para Crespos",
             "Tratamento", "Use máscaras com óleos vegetais e manteigas.", null, null
         );
         Funcoes.gerarRecomendacao(recomendacao, dao);
         System.out.println("Recomendação criada.");

         Avaliacao avaliacao = new Avaliacao(
             4, usuario.getIdUsuario(), salao.getIdSalao(), 4.8f,
             "Atendimento excelente, super recomendo!", java.time.LocalDateTime.now()
         );
         Funcoes.avaliarSalao(avaliacao, dao);
         System.out.println("Avaliação realizada.");

         CronogramaCapilar cronograma = new CronogramaCapilar(0, usuario.getIdUsuario(), perfil.getIdPerfilCapilar());
         String queryCronograma = DAO.queryInsertAutoIncrement(cronograma);
         dao.executeQueryNR(queryCronograma);
         System.out.println("Cronograma criado.");

         EtapaCronograma etapa = new EtapaCronograma(
             8, cronograma.getIdCronograma(), null, "Hidratação",
             LocalDate.now().plusDays(1), LocalTime.of(9, 0),
             "Aplicar máscara nutritiva por 20 minutos.", false
         );
         Funcoes.criarEtapaCronograma(etapa, dao);
         System.out.println("Etapa de cronograma criada.");

         // marcando etapa como concluída
         Funcoes.marcarEtapaComoConcluida(etapa.getIdEtapaCronograma(), dao);
         System.out.println("Etapa marcada como concluída.");

         // verificando atraso nos agendamentos
         Funcoes.atualizarAgendamentosAtrasados(dao);
         System.out.println("Agendamentos atrasados atualizados.");
     }
}
