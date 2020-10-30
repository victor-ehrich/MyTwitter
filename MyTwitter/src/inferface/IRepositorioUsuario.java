package inferface;

import Estrutura.Perfil;
import exce�oes.UJCException;
import exce�oes.UNCException;

//Interface  IRepositorioUsuario

public interface IRepositorioUsuario {
	
	//cria o m�todo cadastrar, que ser� implementado na classe repositorio
	//aqui teremos a excessao UJC, que caso o nome de usuario ja esteja sendo usado, � disparada
		
	public void cadastrar(Perfil usuario) throws UJCException;
	
	//cria o m�todo buscar, que ser� implementado na classe repositorio
	
		
	public Perfil buscar(String usuario);
	
	//cria o m�todo atualizar, que ser� implementado na classe repositorio
	//aqui teremos a excessao UNC, que caso o perfil de usuario n�o exista, � disparada
		
	public void atualizar(Perfil usuario) throws UNCException;
}
