package questao05;

public class ContatoDAO {
	
	public void salvar(Contato contato) throws NomeObrigatorio, PasswordObrigatorio,
    EmailObrigatorio, IdadeForaDoIntervalo, PesoForaDoIntervalo {
	
		if (contato.getNome().isEmpty()) {
            throw new NomeObrigatorio("O NOME é obrigatório!!!");
        }
		
        if (contato.getPassword().isEmpty()) {
            throw new PasswordObrigatorio("O PASSWORD é obrigatório!!!");
        }
        
        if (contato.getEmail().isEmpty()) {
            throw new EmailObrigatorio("O E-MAIL é obrigatório!!!");
        }

        int idade = contato.getIdade();
        if (idade != 0 && (idade < 5 || idade > 99)) {
            throw new IdadeForaDoIntervalo("A IDADE deve estar entre 5 e 99 anos!!!");
        }

        double peso = contato.getPeso();
        if (peso != 0 && (peso < 1 || peso > 200)) {
            throw new PesoForaDoIntervalo("O PESO deve estar entre 1KG e 200KG!!!");
        }
		
        System.out.println("Nome: " + contato.getNome());
        System.out.println("Password: " + contato.getPassword());
        System.out.println("Email: " + contato.getEmail());
        System.out.println("Telefone: " + contato.getTelefone());
        System.out.println("Idade: " + contato.getIdade());
        System.out.println("Peso: " + contato.getPeso());
        System.out.println("Contato salvo com sucesso!");
	}
	
	public class NomeObrigatorio extends Exception {
	    public NomeObrigatorio(String message) {
	        super(message);
	    }
	}
	
	public class PasswordObrigatorio extends Exception {
	    public PasswordObrigatorio(String message) {
	        super(message);
	    }
	}
	
	public class EmailObrigatorio extends Exception {
	    public EmailObrigatorio(String message) {
	        super(message);
	    }
	}
	
	public class IdadeForaDoIntervalo extends Exception {
	    public IdadeForaDoIntervalo(String message) {
	        super(message);
	    }
	}
	
	public class PesoForaDoIntervalo extends Exception {
	    public PesoForaDoIntervalo(String message) {
	        super(message);
	    }
	}
}
