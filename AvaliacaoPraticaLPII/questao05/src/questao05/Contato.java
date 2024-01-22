package questao05;

public class Contato {
	
	private String nome, password, email, telefone;
	private int idade;
	private float peso;
    
	Contato(String nome, String password, String email, String telefone, int idade, float peso){
		this.nome = nome;
		this.password = password;
		this.email = email;
		this.telefone = telefone;
		this.idade = idade;
		this.peso = peso;
	}
	
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
    
    public boolean isValid() {
        return !nome.isEmpty() && !password.isEmpty() && !email.isEmpty() &&
               (idade == 0 || (idade >= 5 && idade <= 99)) &&
               (peso == 0 || (peso >= 1 && peso <= 200));
    }
    
}
