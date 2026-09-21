
package chamadostecnicos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Chamado {
    private long id;
    private String titulo;
    private String descricao;
    private Prioridade prioridade;
    private StatusChamado status;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataEncerramento;
    private Cliente cliente;
    private Tecnico tecnico;
    protected List<Atendimento> atendimentos = new ArrayList<>();

    public void setId(long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public void setStatus(StatusChamado status) {
        this.status = status;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public void setDataEncerramento(LocalDateTime dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }
    
    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public StatusChamado getStatus() {
        return status;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public LocalDateTime getDataEncerramento() {
        return dataEncerramento;
    }
    
    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }
    
    public void atribuirTecnico(Tecnico t){
        this.tecnico = t;
    }
    
    public void alterarStatus(StatusChamado s){
        this.status = s;
    }
            
    public boolean estaAberto(){
        return status.equals(StatusChamado.ABERTO);
    }
    
    public void encerrar(){
        if (atendimentos.isEmpty()){
            return;
        }
        alterarStatus(StatusChamado.ENCERRADO);
        dataEncerramento= LocalDateTime.now();
    }    
}
