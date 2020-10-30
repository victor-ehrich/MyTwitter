package inferface;

import java.util.Vector;

import Estrutura.Tweet;
import exce�oes.MFPException;
import exce�oes.PDException;
import exce�oes.PEException;
import exce�oes.PIException;
import exce�oes.SIException;
import Estrutura.Perfil;

//Interface  ITwitter


public interface ITwitter {

	//Aqui temos as fun�oes que serao implementadas na classe MyTwitter
	
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
