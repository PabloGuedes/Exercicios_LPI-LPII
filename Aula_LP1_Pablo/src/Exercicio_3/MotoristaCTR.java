package Exercicio_3;

public class MotoristaCTR {
    MotoristaDAO motoristaDAO = new MotoristaDAO();
    
    public String verificar(MotoristaDTO motoristaDTO){
        return motoristaDAO.verificar(motoristaDTO);
    }
}
