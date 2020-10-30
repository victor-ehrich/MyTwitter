package inferface;

import java.util.Vector;
import Estrutura.Perfil;
import Estrutura.Tweet;

import exceçoes.SIException;
import exceçoes.MFPException;
import exceçoes.PDException;
import exceçoes.PIException;
import exceçoes.UJCException;
import exceçoes.PEException;

//classe MyTwitter, que é uma implementação da interface ITwitter

public class MyTwitter implements ITwitter {

	private IRepositorioUsuario repositorio;
	
	//Construtor da classe
	
	public MyTwitter(IRepositorioUsuario repositorio) {
		super();
		this.repositorio = repositorio;
	}
	
	//Aqui temos o método que cria o perfil e adiciona no repositorio
	//caso ja tenha o nome de usuario no repositorio, ele disparara a exceçao PE

	@Override
	public void criarPerfil(Perfil usuario) throws PEException {
		try { 			
			repositorio.cadastrar(usuario);
		} 
		catch (UJCException abc){
			System.out.println("usuario ja cadastrado");
			throw new PEException(usuario);	
		}
	}
	
	//Aqui temos o método que cancela o perfil, fazendo uma busca do nome de usuario passado no repositorio, e 
	//coolocando o campo ativo do perfil como false
	
	@Override
	public void cancelarPerfil(String usuario) throws PIException, PDException {
			if(usuario.equals(repositorio.buscar(usuario).getUsuario())){
				if(repositorio.buscar(usuario).isAtivo()){
					repositorio.buscar(usuario).setAtivo(false);
					System.out.println("Perfil cancelado com sucesso!");
				}
				else {
					throw new PDException(repositorio.buscar(usuario)); 
				}
			}
			
			else{
				throw new PIException(repositorio.buscar(usuario)); 
			}
	}
	
	//Aqui temos o método tweetar, o qual será escrito um tweet de até 140 caracteres, não podendo ele ser vazio
	//o tweet tambem será adicionado ao nosso repositorio

	@Override
	public void tweetar(String Usuario, String mensagem) throws PIException, MFPException {
		if(repositorio.buscar(Usuario) != null){
				if(mensagem.length()<=140 && mensagem.length() >0) {
					Tweet weet = new Tweet();
					weet.setMensagem(mensagem);
					weet.setUsuario(Usuario);
					repositorio.buscar(Usuario).addTweet(weet);
					Vector<Perfil> a = repositorio.buscar(Usuario).getSeguidores();
					for(int i=0;i<a.size();i++) {
						a.get(i).addTweet(weet);
					}
					System.out.println("Tweet realizado com sucesso!\n");
				}
				else {
					throw new MFPException(mensagem);
					}
				}
		else {
			throw new PIException(repositorio.buscar(Usuario));
		}
	}

	//aqui temos o método timeline, onde será retornada a timeline do usuario
	//caso o usuario siga alguem, a timeline dele tambem retornara os tweets da pessoa seguida
	
	@Override
	public Vector<Tweet> timeline(String usuario) throws PIException, PDException {
		if(repositorio.buscar(usuario) != null){
			if(repositorio.buscar(usuario).isAtivo()){
				return repositorio.buscar(usuario).getTimeline();
			}
			else {
				throw new PDException(repositorio.buscar(usuario)); 
			}
		}
		
		else{
			throw new PIException(repositorio.buscar(usuario)); 
		}
		
	}
	
	//aqui temos o método tweets, o qual vai ser retornado todos os tweets do usuario
	//para isso é percorrido o vector de tweet do usuario

	@Override
	public Vector<Tweet> tweets(String usuario) throws PIException, PDException {
		if(repositorio.buscar(usuario) != null){
			if(repositorio.buscar(usuario).isAtivo()){
				Vector<Tweet> a = repositorio.buscar(usuario).getTimeline();
				Vector<Tweet> b = new Vector<Tweet>();
				for(int i=0;i<a.size();i++) {
					if(a.elementAt(i).getUsuario() == usuario) {
						b.add(a.elementAt(i));
					}
				}
				return b;
			}
			else {
				throw new PDException(repositorio.buscar(usuario)); 
			}
		}
		
		else{
			throw new PIException(repositorio.buscar(usuario)); 
		}
	}

	//Função onde um usuario irá seguir outro
	//a condiçao é que os usuarios existam, estejam ativos, e que não sejam a mesma pessoa
	
	@Override
	public void seguir(String seguidor, String seguido) throws PIException, PDException, SIException {
		if(repositorio.buscar(seguidor) != null) {
			if(repositorio.buscar(seguido) != null) {
				if(repositorio.buscar(seguidor).isAtivo()) {
					if(repositorio.buscar(seguido).isAtivo()) {
						if(seguidor != seguido) {
							repositorio.buscar(seguido).addSeguidores(repositorio.buscar(seguidor));
							repositorio.buscar(seguidor).addSeguidos(repositorio.buscar(seguido));
							System.out.println(seguidor + " seguiu " + seguido +"\n");
						}
						else {
							throw new SIException(repositorio.buscar(seguido));
						}
					}
					else {
						throw new PDException(repositorio.buscar(seguido));
					}
				}
				else {
					throw new PDException(repositorio.buscar(seguidor));
				}
			}
			else {
				throw new PIException(repositorio.buscar(seguido)); 
			}
		} 
		
		else{
			throw new PIException(repositorio.buscar(seguidor)); 
		}
	}
	
	//Função numero de sequidores mostra quanto seguidores a pessoa tem

	@Override
	public int numeroSequidores(String usuario) throws PIException, PDException {
		if(repositorio.buscar(usuario) != null){
			if(repositorio.buscar(usuario).isAtivo()){
				return repositorio.buscar(usuario).getSeguidores().size();
			}
			else {
				throw new PDException(repositorio.buscar(usuario)); 
			}
		}
		
		else{
			throw new PIException(repositorio.buscar(usuario)); 
		}
	}

	//função seguidores lista as pessoas que seguem o usuario
	
	@Override
	public Vector<Perfil> seguidores(String usuario) throws PIException, PDException {
		if(repositorio.buscar(usuario) != null){
			if(repositorio.buscar(usuario).isAtivo()){
				return repositorio.buscar(usuario).getSeguidores();
			}
			else {
				throw new PDException(repositorio.buscar(usuario)); 
			}
		}
		
		else{
			throw new PIException(repositorio.buscar(usuario)); 
		}
	}

	//a função seguidos nos mostra quem o usuario segue
	
	@Override
	public Vector<Perfil> seguidos(String usuario) throws PIException, PDException {
		if(repositorio.buscar(usuario) != null){
			if(repositorio.buscar(usuario).isAtivo()){
				return repositorio.buscar(usuario).getSeguidos();
			}
			else {
				throw new PDException(repositorio.buscar(usuario)); 
			}
		}
		
		else{
			throw new PIException(repositorio.buscar(usuario)); 
		}
	}

}
