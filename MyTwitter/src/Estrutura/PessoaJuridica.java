package Estrutura;

//Classe que herda os atributos e fun��es da classe perfil

public class PessoaJuridica extends Perfil  {

	//atributo cpf

	private long cnpj;
		
	//construtor da classe

	public PessoaJuridica(String usuario) {
		super(usuario);
	}

	//getter do cnpf, onde ser� retornado o valor do cnpj
	
	public long getCnpj() {
		return cnpj;
	}
	
	//setter do cnpj, onde ser� passado um long cnpj, que alterara o campo cnpj. 

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

}
