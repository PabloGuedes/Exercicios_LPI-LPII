package Exercicio_4;

public class Quatro_numerosCTR {
    Quatro_numerosDAO quatro_numerosDAO = new Quatro_numerosDAO();
    
    public String ordenar_Numeros(Quatro_numerosDTO quatro_numerosDTO){
        return quatro_numerosDAO.ordenar_Numeros(quatro_numerosDTO);
    }
}
