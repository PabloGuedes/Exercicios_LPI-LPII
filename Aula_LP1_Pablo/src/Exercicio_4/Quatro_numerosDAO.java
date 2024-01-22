package Exercicio_4;

public class Quatro_numerosDAO {
    public String ordenar_Numeros(Quatro_numerosDTO quatro_numerosDTO){
        if(quatro_numerosDTO.getNum4() >= quatro_numerosDTO.getNum3()){
            return "A ordem decrescente é: " +
                    quatro_numerosDTO.getNum4() + " - " + quatro_numerosDTO.getNum3() + " - " +
                    quatro_numerosDTO.getNum2() + " - " + quatro_numerosDTO.getNum1();
        }
        else{
            if((quatro_numerosDTO.getNum4() >= quatro_numerosDTO.getNum2()) && (quatro_numerosDTO.getNum4() < quatro_numerosDTO.getNum3())){
                return "A ordem decrescente é: " +
                        quatro_numerosDTO.getNum3() + " - " + quatro_numerosDTO.getNum4() + " - " +
                        quatro_numerosDTO.getNum2() + " - " + quatro_numerosDTO.getNum1();
            }
            else{
                if((quatro_numerosDTO.getNum4() >= quatro_numerosDTO.getNum1()) && (quatro_numerosDTO.getNum4() < quatro_numerosDTO.getNum2())){
                    return "A ordem decrescente é: " +
                            quatro_numerosDTO.getNum3() + " - " + quatro_numerosDTO.getNum2() + " - " +
                            quatro_numerosDTO.getNum4() + " - " + quatro_numerosDTO.getNum1();
                }
                else{
                    return "A ordem decrescente é: " +
                            quatro_numerosDTO.getNum3() + " - " + quatro_numerosDTO.getNum2() + " - " +
                            quatro_numerosDTO.getNum1() + " - " + quatro_numerosDTO.getNum4();
                }
            }           
        }
    }
}
