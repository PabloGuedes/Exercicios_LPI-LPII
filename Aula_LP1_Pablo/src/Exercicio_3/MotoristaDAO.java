package Exercicio_3;

public class MotoristaDAO {
    private String mensagem;
    
    public String verificar(MotoristaDTO motoristaDTO){
        if(motoristaDTO.getIdade() >= 18){
            this.mensagem = "O motorista pode ter CNH.";
        }
        else{
            this.mensagem = "O motorista não pode ter CNH.";
        }
        
        return this.mensagem;
    }
}
