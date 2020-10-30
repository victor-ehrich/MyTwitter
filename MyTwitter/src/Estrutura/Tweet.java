package Estrutura;

//representa um tweet que encapsula o nome de usu�rio de um perfil e a mensagem de texto postada por este usu�rio.

public class Tweet {
	
	//Aqui temos os campos de usuario e mensagem, que ser�o passados no tweet
	
	private String usuario;
	private String mensagem;
	
	//Aqui temos o getter do usuario, o setter do usuario, o getter da mensagem e o setter da mensagem
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	
}
