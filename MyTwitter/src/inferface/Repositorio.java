package inferface;

import java.util.Vector;

import Estrutura.Perfil;
import exce�oes.UJCException;
import exce�oes.UNCException;

//classe repositorio, que � uma implementa��o da interface IRepositorioUsuario

public class Repositorio implements IRepositorioUsuario {
	
	private Vector<Perfil> users = new Vector<Perfil>();
	
	//aqui teremos o metodo cadastrar, que recebe um Perfil.
	//nela sera conferida se o nome de usuario do Perfil passado ja nao existe, usando para isso o getUsuario
	//do perfil, e o metodo de busca que � implementado logo abaixo, sendo cadastrado no vector de perfil users.
	//caso o usuario ja esteja cadastrado, a exce��o � disparada.
	
	@Override
	public void cadastrar(Perfil usuario) throws UJCException {
		if(buscar(usuario.getUsuario())!=null) {
			throw new UJCException(usuario);
		}
		
		else{
			users.add(usuario);
			System.out.println("usuario cadastrado com sucesso!\n");
		}
	}

	//metodo de busca, aqui iremos receber uma string contendo um nome de usuario.
	//para a busca ser feita, iremos comparar utilizando equals para comparar o conteudo de um vector de perfil 
	//com o da string.
	//o vector sera percorrido, e o resultado do getUsuario do elemento daquela posi�ao � comparado com o usuario
	//passado.
	//se der igual, o Perfil ser� retornado.
	
	@Override
	public Perfil buscar(String usuario) {
		Vector<Perfil> busca = users;
		for(int i=0; i<busca.size();i++) {
			if(usuario.equals(busca.elementAt(i).getUsuario())){
				return busca.elementAt(i);
			}
		}
		return null;
	}
	
	//metodo atualizar. Aqui iremos receber um Perfil, que ser� atualizado, usando o metodo buscar para isso
	//se o perfil n existir, a exce�ao � disparada.

	@Override
	public void atualizar(Perfil usuario) throws UNCException {
		Perfil atualizar;
		atualizar = buscar(usuario.getUsuario());
		if(buscar(usuario.getUsuario()) == usuario) {
			atualizar = usuario;
			System.out.println("usuario atualizado com sucesso!");
		}
		else {
			throw new UNCException(usuario);
		}
	}

}
