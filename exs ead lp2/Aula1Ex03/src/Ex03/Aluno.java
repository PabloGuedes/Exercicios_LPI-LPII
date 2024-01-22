package Ex03;

public class Aluno {
	String nome;
	float n1, n2, nf;
	String cf;
	
	
	public Aluno(String nome, float n1, float n2, float nf, String cf) {
		super();
		this.nome = nome;
		this.n1 = n1;
		this.n2 = n2;
		this.nf = nf;
		this.cf = cf;
	}
	
	public Aluno() {
		
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public float getN1() {
		return n1;
	}


	public void setN1(float n1) {
		this.n1 = n1;
	}


	public float getN2() {
		return n2;
	}


	public void setN2(float n2) {
		this.n2 = n2;
	}


	public float getNf() {
		return nf;
	}


	public void setNf(float nf) {
		this.nf = nf;
	}


	public String getCf() {
		return cf;
	}


	public void setCf(String cf) {
		this.cf = cf;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", n1=" + n1 + ", n2=" + n2 + ", nf=" + nf + ", cf=" + cf + "]";
	}
}
