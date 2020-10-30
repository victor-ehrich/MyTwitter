package inferface;

import java.util.Vector;

import Estrutura.Tweet;
import exceçoes.MFPException;
import exceçoes.PDException;
import exceçoes.PEException;
import exceçoes.PIException;
import exceçoes.SIException;
import Estrutura.Perfil;

//Interface  ITwitter


public interface ITwitter {

	//Aqui temos as funçoes que serao implementadas na classe MyTwitter
	
	public void criarPerfil(Perfil usuario) throws PEException;
	
	public void cancelarPerfil(String usuario) throws PIException,PDException;
	
	public void tweetar(String Usuario, String mensagem) throws PIException,MFPException;
	
	public Vector<Tweet> timeline(String usuario) throws PIException,PDException;
	
	public Vector<Tweet> tweets(String usuario) throws PIException,PDException;
	
	public void seguir(String seguidor, String seguindo) throws PIException,PDException,SIException;
	
	public int numeroSequidores(String usuario) throws PIException,PDException;
	
	public Vector<Perfil> seguidores(String usuario) throws PIException,PDException;
	
	public Vector<Perfil> seguidos(String usuario) throws PIException,PDException;
}
