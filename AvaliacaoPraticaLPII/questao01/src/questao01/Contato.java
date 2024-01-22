package questao01;

public class Contato {
	private int id, idade;
	private String nome, password, email, telefone;
	private float peso;
	
	Contato(int id, int idade, String nome, String password, String email, String telefone, float peso){
		this.id = id;
		this.idade = idade;
		this.nome = nome;
		this.password = password;
		this.email = email;
		this.telefone = telefone;
		this.peso = peso;
	}
	
	public String toString() {
		return this.nome;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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
    
    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
}
