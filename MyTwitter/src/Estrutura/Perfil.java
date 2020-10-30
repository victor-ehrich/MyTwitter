package Estrutura;

import java.util.Vector;
import Estrutura.Tweet;

//Classe abstrata que contém os campos usuario, seguidos, seguidores, timeline e ativo
public class Perfil {
	
	//Guarda o nome do perfil do usuário.
	private String usuario;
	//Guarda os perfis que o usuário está seguindo
	private Vector<Perfil> seguidos;
	//Guarda os perfis que estão seguindo o usuário
	private Vector<Perfil> seguidores;
	//Armazena os tweets do perfil e os dos perfis que o usuário segue
	private Vector<Tweet> timeline;
	//Diz se a conta está ativa ou não
	private boolean ativo;
	
	//Construtor da nossa classe perfil
	//Aqui também serão instanciados a timeline, os seguidores e os seguidos
	
	public Perfil(String usuario) {
		this.usuario = new String();
		this.usuario = usuario;
		ativo = true;
		timeline = new Vector<Tweet>();
		seguidores = new Vector<Perfil>();
		seguidos = new Vector<Perfil>();
	}
	
	//Função que adiciona seguidos no vector de perfil
	
	public void addSeguidos(Perfil usuario) {
		seguidos.add(usuario);
	}
	
	//Função que adiciona seguidores no vector perfil
	
	public void addSeguidores(Perfil usuario) {
		seguidores.add(usuario);
	}
	
	//Função que adiciona um tweet a timeline, que e um vector de tweets
	
	public void addTweet(Tweet tweet) {
		timeline.add(tweet);
	}
	
	//Função que recebe um usuario, e altera o campo usuario 
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	//Função que retorna o usuario
	
	public String getUsuario() {
		return usuario;
	}

	//Função que retorna o vector de perfil seguidos
	
	public Vector<Perfil> getSeguidos() {
		return seguidos;
	}

	//Função que retorna o vector de perfil seguidores
	
	public Vector<Perfil> getSeguidores() {
		return seguidores;
	}

	//Função que retorna o Vector de tweet timeline
	
	public Vector<Tweet> getTimeline() {
		return timeline;
	}
	
	//Função que coloca o campo ativo verdadeiro ou falso

	public void setAtivo(boolean valor) {
		ativo = valor;
	}
	
	//Função que retorna o valor do campo ativo
	
	public boolean isAtivo() {
		return ativo;
	}


	
	
}
