package inferface;

import Estrutura.Perfil;
import exceçoes.UJCException;
import exceçoes.UNCException;

//Interface  IRepositorioUsuario

public interface IRepositorioUsuario {
	
	//cria o método cadastrar, que será implementado na classe repositorio
	//aqui teremos a excessao UJC, que caso o nome de usuario ja esteja sendo usado, é disparada
		
	public void cadastrar(Perfil usuario) throws UJCException;
	
	//cria o método buscar, que será implementado na classe repositorio
	
		
	public Perfil buscar(String usuario);
	
	//cria o método atualizar, que será implementado na classe repositorio
	//aqui teremos a excessao UNC, que caso o perfil de usuario não exista, é disparada
		
	public void atualizar(Perfil usuario) throws UNCException;
}
