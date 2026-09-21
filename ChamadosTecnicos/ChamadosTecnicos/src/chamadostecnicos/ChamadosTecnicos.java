
package chamadostecnicos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class ChamadosTecnicos {

 
    public static void main(String[] args) {
        
        Scanner option = new Scanner(System.in);
        Scanner entrada = new Scanner(System.in);
        String opt = "";
        List<Cliente> clientes = new ArrayList<>();
        List<Tecnico> tecnicos = new ArrayList<>();
        List<Equipe> equipes = new ArrayList<>();
        List<Chamado> chamados = new ArrayList<>();
        
        while (!opt.equals("0")){
            
            System.out.println("====================================");
            System.out.println("[1] Cadastrar Cliente");
            System.out.println("[2] Cadastrar Tecnico");
            System.out.println("[3] Cadastrar Equipe");
            System.out.println("[4] Abrir Chamado");
            System.out.println("[5] Listar Chamados (Relatorios)");
            System.out.println("[6] Visualizar Chamado");
            System.out.println("[7] Atribuir Tecnico ao Chamado");
            System.out.println("[8] Encerrar Chamado");
            System.out.println("[0] Sair ");
            System.out.println("====================================");
            System.out.println("Digite o numero da opcao desejada: ");
            opt= option.nextLine();
            
            if (opt.equals("1")){
                Cliente cliente = new Cliente();
                System.out.print("Informe o nome: ");
                cliente.setNome(entrada.nextLine());
                System.out.print("Informe o telefone: ");
                cliente.setTelefone(entrada.nextLine());
                System.out.print("Informe o email: ");
                cliente.setEmail(entrada.nextLine());
                clientes.add(cliente);
            }
            else if (opt.equals("2")){
                Tecnico tecnico = new Tecnico();
                System.out.print("Informe o nome: ");
                tecnico.setNome(entrada.nextLine());
                System.out.print("Informe o telefone: ");
                tecnico.setTelefone(entrada.nextLine());
                System.out.print("Informe o email: ");
                tecnico.setEmail(entrada.nextLine());
                System.out.print("Informe a especialidade: ");
                tecnico.setEspecialidade(entrada.nextLine());
                System.out.print("Informe a equipe ou digite 0 caso nao ha: ");
                String eqp = entrada.nextLine();
                if (!eqp.equals("0")){
                    for (Equipe e: equipes){
                        if (e.getNome().equalsIgnoreCase(eqp)){
                            tecnico.atribuirEquipe(e);
                        }
                    }
                }
                tecnicos.add(tecnico);
            }
            else if (opt.equals("3")){
                Equipe equipe = new Equipe();
                System.out.print("Informe o nome: ");
                equipe.setNome(entrada.nextLine());
                System.out.print("Descreva a equipe: ");
                equipe.setDescricao(entrada.nextLine());
                equipes.add(equipe);
            }
            else if (opt.equals("4")){
                Chamado chamado = new Chamado();
                System.out.print("Informe o nome do cliente: ");
                String nomeC = entrada.nextLine();
                String clienteExistente = "";
                for (Cliente c: clientes){
                    if (c.getNome().equalsIgnoreCase(nomeC)){
                        nomeC = clienteExistente;
                        chamado.setCliente(c);
                        chamado.setDataAbertura(LocalDateTime.now());
                        System.out.print("Informe o titulo: ");
                        chamado.setTitulo(entrada.nextLine());
                        System.out.print("Descreva o problema: ");
                        chamado.setDescricao(entrada.nextLine());
                        System.out.print("Informe a prioridade (BAIXA, MEDIA, ALTA): ");
                        String prior = entrada.nextLine();
                        chamado.setPrioridade(Prioridade.valueOf(prior.toUpperCase()));
                        chamado.alterarStatus(StatusChamado.ABERTO);
                        chamados.add(chamado);
                    }
                }
            }
            else if (opt.equals("5")){
                System.out.println("================================");
                System.out.println("[1] Por Status");
                System.out.println("[2] Por Prioridade");
                System.out.println("[3] Por Tecnico");
                System.out.println("[00] Voltar ao menu principal");
                System.out.println("================================");
                System.out.println("Informe o numero da opcao de relatorio desejado: ");
                opt = option.nextLine();
                while (!opt.equals("00")){
                    if (opt.equals("1")){
                        System.out.print("Informe o status (ABERTO, EM_ANDAMENTO, AGUARDANDO_CLIENTE, ENCERRADO): ");
                        String st = entrada.nextLine();
                        for (Chamado ch: chamados){
                            if (ch.getStatus().equals(StatusChamado.valueOf(st.toUpperCase()))){
                                System.out.println("Status: " + ch.getStatus() + "     Chamado: " + ch.getTitulo());       
                            }
                        }
                        break;
                    }
                    else if (opt.equals("2")){
                        System.out.print("Informe a prioridade (BAIXA, MEDIA, ALTA): ");
                        String prior = entrada.nextLine();
                        for (Chamado ch: chamados){
                            if (ch.getPrioridade().equals(Prioridade.valueOf(prior.toUpperCase()))){
                            } else {
                                System.out.println("Prioridade: " + ch.getPrioridade() + "     Chamado: " + ch.getTitulo());
                            }
                        }
                        break;
                    }
                    else if (opt.equals("3")){
                        System.out.print("Informe o tecnico: ");
                        String tec = entrada.nextLine();
                        for (Chamado ch: chamados){
                            for (Tecnico t: tecnicos){
                                if (t.getNome().equalsIgnoreCase(tec)){
                                    System.out.println("Tecnico: " + t.getNome() + "     Chamado: " + ch.getTitulo());
                                }
                            }
                        }
                        break;
                    }
                }
            }
            
            else if (opt.equals("6")){
                System.out.print("Informe o titulo do chamado que deseja visualizar: ");
                String cham = entrada.nextLine();
                for (Chamado ch: chamados){
                    if (ch.getTitulo().equalsIgnoreCase(cham)){
                        System.out.println("Titulo..............: " + ch.getTitulo());
                        System.out.println("Descricao...........: " + ch.getDescricao());
                        System.out.println("Prioridade..........: " + ch.getPrioridade());
                        System.out.println("Status..............: " + ch.getStatus());
                        System.out.println("Data de abertura....: " + ch.getDataAbertura());
                        System.out.println("Data de encerramento: " + ch.getDataEncerramento());
                        System.out.println("Cliente.............: " + ch.getCliente().getNome());
                        if (ch.getTecnico() == null){
                            System.out.println("Tecnico.............: Nao ha");
                        }
                        else{
                            System.out.println("Tecnico.............: " + ch.getTecnico().getNome());
                        }
                        for (Atendimento a: ch.atendimentos){
                            System.out.println("Atendimento.........: " + a.getDescricao());
                        }
                    }
                }
            }
            
            else if(opt.equals("7")){
               System.out.print("Informe o titulo do chamado: ");
               String cham = entrada.nextLine();
               System.out.print("Informe o nome do tecnico: ");
               String tec = entrada.nextLine();
               System.out.print("Descreva a solucao do problema: ");
               String solucao = entrada.nextLine();
               for (Chamado ch: chamados){
                   if (ch.getTitulo().equalsIgnoreCase(cham)){
                        if (ch.getStatus().equals(StatusChamado.ABERTO)){
                            for (Tecnico t: tecnicos){
                                if (t.getNome().equalsIgnoreCase(tec)){
                                    ch.atribuirTecnico(t);
                                    ch.alterarStatus(StatusChamado.EM_ANDAMENTO);
                                    Atendimento atendimento = new Atendimento();
                                    atendimento.setDataHora(LocalDateTime.now());
                                    atendimento.setDescricao(solucao);
                                    atendimento.setRealizadoPor(t);
                                    atendimento.setChamado(ch);
                                    atendimento.registrar();
                                }
                            }
                        }
                    }
                }
            }
            
            else if(opt.equals("8")){
                System.out.print("Informe o titulo do chamado que deseja encerrar: ");
                String cham = entrada.nextLine();
                for (Chamado ch: chamados){
                    if (ch.getTitulo().equalsIgnoreCase(cham)){
                        ch.encerrar();
                        System.out.println("Chamado encerrado com sucesso!");
                    }
                }
            }  
        }
    }
}
