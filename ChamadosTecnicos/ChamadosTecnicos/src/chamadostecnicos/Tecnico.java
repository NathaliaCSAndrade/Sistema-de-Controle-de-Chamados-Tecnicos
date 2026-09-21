
package chamadostecnicos;

import java.time.LocalDate;


public class Tecnico extends Usuario{
    private String especialidade;
    private LocalDate dataCadastro;
    private Equipe equipe;

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
    
    public Equipe getEquipe(){
        return equipe;
    }
    
    public void atribuirEquipe(Equipe equipe){
        this.equipe= equipe;
    }
}
