
package chamadostecnicos;

import java.time.LocalDateTime;


public class Atendimento {
    private Long id;
    private LocalDateTime dataHora;
    private String descricao;
    private Tecnico realizadoPor;
    private Chamado chamado;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setRealizadoPor(Tecnico realizadoPor) {
        this.realizadoPor = realizadoPor;
    }
    
    public void setChamado(Chamado chamado){
        this.chamado = chamado;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public Tecnico getRealizadoPor() {
        return realizadoPor;
    }
    
    public Chamado getChamado() {
        return chamado;
    }
    
    public void registrar(){
        chamado.atendimentos.add(this);
    }
}
