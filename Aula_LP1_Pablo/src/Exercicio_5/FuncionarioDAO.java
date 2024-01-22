package Exercicio_5;

public class FuncionarioDAO {
    public String gravarFuncionario(FuncionarioDTO funcionarioDTO){
        return "Os dados gravados são: " +
               "\n\nNome: " + funcionarioDTO.getNome() +
               "\nLogradouro: " + funcionarioDTO.getLogradouro() +
               "\nBairro: " + funcionarioDTO.getBairro() +
               "\nCidade: " + funcionarioDTO.getCidade() +
               "\nEstado: " + funcionarioDTO.getEstado() +
               "\nCEP: " + funcionarioDTO.getCep() +
               "\nCPF: " + funcionarioDTO.getCpf() +
               "\nRG: " + funcionarioDTO.getRg() +
               "\nNúmero: " + funcionarioDTO.getNumero();
    }
}
