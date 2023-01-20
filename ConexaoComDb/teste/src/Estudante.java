public class Estudante {
	private int codigo;
	private String nome;
	private double nota1;
	private double nota2;
	
	public Estudante(int codigo, String nome, double nota1, double nota2) {
		this.codigo = codigo;
		this.nome = nome;
		this.nota1 = nota1;
		this.nota2 = nota2;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getNota1() {
		return nota1;
	}

	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	public double getNota2() {
		return nota2;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	
	public double calcularMedia(){
	return (nota1 + nota2)/ 2;
	}

	@Override
	public String toString() {
		return "Estudante [codigo=" + codigo + ", nome=" + nome + ", nota1="
				+ nota1 + ", nota2=" + nota2 + "]";
	}
	
	
}
