package Exercicio_1;

import javax.swing.JOptionPane;

public class ClienteVIEW {
    public static void main(String[] args) {
        ClienteDTO clienteDTO = new ClienteDTO();
        ClienteCTR clienteCTR = new ClienteCTR();

        clienteDTO.setNome(JOptionPane.showInputDialog("Informe o nome: "));
        clienteDTO.setRg(JOptionPane.showInputDialog("Informe o RG: "));
        clienteDTO.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Informe a idade: ")));

        JOptionPane.showMessageDialog(null, clienteCTR.mostrarNomeRg(clienteDTO));
        JOptionPane.showMessageDialog(null, clienteCTR.mostrarNomeIdade(clienteDTO));
    }
}
