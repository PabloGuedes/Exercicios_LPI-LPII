package Exercicio_5;

public class FuncionarioCTR {
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    
    public String gravarFuncionario(FuncionarioDTO funcionarioDTO){
        return funcionarioDAO.gravarFuncionario(funcionarioDTO);
    }
}
