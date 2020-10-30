package Estrutura;

import java.util.Vector;
import Estrutura.Tweet;

//Classe abstrata que cont�m os campos usuario, seguidos, seguidores, timeline e ativo
public class Perfil {
	
	//Guarda o nome do perfil do usu�rio.
	private String usuario;
	//Guarda os perfis que o usu�rio est� seguindo
	private Vector<Perfil> seguidos;
	//Guarda os perfis que est�o seguindo o usu�rio
	private Vector<Perfil> seguidores;
	//Armazena os tweets do perfil e os dos perfis que o usu�rio segue
	private Vector<Tweet> timeline;
	//Diz se a conta est� ativa ou n�o
	private boolean ativo;
	
	//Construtor da nossa classe perfil
	//Aqui tamb�m ser�o instanciados a timeline, os seguidores e os seguidos
	
	public Perfil(String usuario) {
		this.usuario = new String();
		this.usuario = usuario;
		ativo = true;
		timeline = new Vector<Tweet>();
		seguidores = new Vector<Perfil>();
		seguidos = new Vector<Perfil>();
	}
	
	//Fun��o que adiciona seguidos no vector de perfil
	
	public void addSeguidos(Perfil usuario) {
		seguidos.add(usuario);
	}
	
	//Fun��o que adiciona seguidores no vector perfil
	
	public void addSeguidores(Perfil usuario) {
		seguidores.add(usuario);
	}
	
	//Fun��o que adiciona um tweet a timeline, que e um vector de tweets
	
	public void addTweet(Tweet tweet) {
		timeline.add(tweet);
	}
	
	//Fun��o que recebe um usuario, e altera o campo usuario 
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	//Fun��o que retorna o usuario
	
	public String getUsuario() {
		return usuario;
	}

	//Fun��o que retorna o vector de perfil seguidos
	
	public Vector<Perfil> getSeguidos() {
		return seguidos;
	}

	//Fun��o que retorna o vector de perfil seguidores
	
	public Vector<Perfil> getSeguidores() {
		return seguidores;
	}

	//Fun��o que retorna o Vector de tweet timeline
	
	public Vector<Tweet> getTimeline() {
		return timeline;
	}
	
	//Fun��o que coloca o campo ativo verdadeiro ou falso

	public void setAtivo(boolean valor) {
		ativo = valor;
	}
	
	//Fun��o que retorna o valor do campo ativo
	
	public boolean isAtivo() {
		return ativo;
	}


	
	
}
