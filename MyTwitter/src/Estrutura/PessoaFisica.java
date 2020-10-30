package Estrutura;

//Classe que herda os atributos e fun��es da classe perfil

public class PessoaFisica extends Perfil {

	//construtor da classe
	
	public PessoaFisica(String usuario) {
		super(usuario);
	}
	
	//atributo cpf
	
	private long cpf;

	//getter do cpf, onde ser� retornado o valor do cpf
	
	public long getCpf() {
		return cpf;
	}

	//setter do cpf, onde ser� passado um long cpf, que alterara o campo cpf. 
	
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}


}
