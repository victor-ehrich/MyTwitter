
import java.util.Scanner;
import java.util.Vector;

import Estrutura.Perfil;
import Estrutura.PessoaFisica;
import Estrutura.PessoaJuridica;
import Estrutura.Tweet;
import exce�oes.MFPException;
import exce�oes.PDException;
import exce�oes.PEException;
import exce�oes.PIException;
import exce�oes.SIException;
import inferface.MyTwitter;
import inferface.Repositorio;

//Aqui ser� nossa classe onde interagiremos com o usu�rio.

public class Main {
	public static void main(String[] args) {
		
		//Cria o scanner, e as variaveis: uma um auxiliar, que ira ser usado no switch case,
		//Uma string que armazenara o nome do usuario.
		//Duas vari�veis do tipo Perfil para receber os perfis.
		//� instanciado tamb�m o repositorio e o twitter.
		//String mensagem recebera o conteudo a ser colocado em um tweet quando o usuario chamar tweetar.
		
		Scanner sc = new Scanner(System.in);
		String usuario;
		int aux;
		Perfil user = null;
		Perfil user2 = null;
		Repositorio rep = new Repositorio();
		MyTwitter twitter = new MyTwitter(rep);
		String mensagem = null;
		
		
		//Aqui nesse bloco apenas o armazenamento da escolhe de pessoa fisica 
		//ou juridica na variavel aux,
		//Tambem o nome do usuario na variavel usuario.
		
		System.out.println("Digite 1 para pessoa f�sica:\nDigite 2 para pessoa jur�dica:\n");
		aux = sc.nextInt();
		sc.nextLine();
		while(aux != 1 && aux !=2) {
			System.out.println("Insira um valor valido:\n");
			System.out.println("Digite 1 para pessoa f�sica:\nDigite 2 para pessoa jur�dica:\n");
			aux = sc.nextInt();
			sc.nextLine();
			}
		
		
		//implementa��o do switch e cria��o dos perfis fisicos e juridicos
		//nesse ponto � requisitado o cpf ou cnpj do usuario e � ativada a conta.
		//caso o perfil ja exista, entrara na exce��o PEExcession.
		//o perfil aqui � ativado 
		
		switch(aux) {
		case 1:
			System.out.println("Digite o nome de usuario:\n");
			usuario = sc.nextLine();
			user = new PessoaFisica(usuario);
			try {
				System.out.println("Informe o CPF:\n");
				int cpf = sc.nextInt();
				((PessoaFisica) user).setCpf(cpf);
				twitter.criarPerfil(user);
			} catch (PEException e) {
				e.printStackTrace();
			}
			user.setAtivo(true);
			break;
		case 2:
			System.out.println("Digite o nome de usuario:\n");
			usuario = sc.nextLine();
			user = new PessoaJuridica(usuario);
			try {
				System.out.println("Informe o CNPJ:\n");
				int cnpj = sc.nextInt();
				((PessoaJuridica) user).setCnpj(cnpj);
				twitter.criarPerfil(user);
			} catch (PEException e) {
				e.printStackTrace();
			}
			user.setAtivo(true);
			break;
		}
		
		//aqui iremos so repetir o codigo para a cria�ao de um segundo usuario
		//linha 92 - 132
		
		System.out.println("Digite 1 para pessoa f�sica:\nDigite 2 para pessoa jur�dica:\n");
		aux = sc.nextInt();
		sc.nextLine();
		while(aux != 1 && aux !=2) {
			System.out.println("Insira um valor valido:\n");
			System.out.println("Digite 1 para pessoa f�sica:\nDigite 2 para pessoa jur�dica:\n");
			aux = sc.nextInt();
			sc.nextLine();
			}
		
		switch(aux) {
		case 1:
			System.out.println("Digite o nome de usuario:\n");
			usuario = sc.nextLine();
			user2 = new PessoaFisica(usuario);
			try {
				System.out.println("Informe o CPF:\n");
				int cpf = sc.nextInt();
				((PessoaFisica) user2).setCpf(cpf);
				twitter.criarPerfil(user2);
			} catch (PEException e) {
				e.printStackTrace();
			}

			user2.setAtivo(true);
			break;
		case 2:
			System.out.println("Digite o nome de usuario:\n");
			usuario = sc.nextLine();
			user2 = new PessoaJuridica(usuario);
			try {
				System.out.println("Informe o CNPJ:\n");
				int cnpj = sc.nextInt();
				((PessoaJuridica) user2).setCnpj(cnpj);
				twitter.criarPerfil(user2);
			} catch (PEException e) {
				e.printStackTrace();
			}
			user2.setAtivo(true);
			break;
		}
		
		
		//tenta utilizar o metodo seguir, na qual o user vai seguir o user2
		//tamb�m � passada as 3 excessoes com o try/catch.
		//rep.buscar(user.getUsuario()).getUsuario() ir� buscar dentro do repositorio o nosso usuario, e ira 
		//retornar a string correspondete a seu user.
		//o mesmo vale para o user2
		
		try {
			System.out.println("Fun��o seguir:");
			twitter.seguir(rep.buscar(user.getUsuario()).getUsuario(),rep.buscar(user2.getUsuario()).getUsuario());
		} catch (PIException e) {	
			e.printStackTrace();
		} catch (PDException e) {
			e.printStackTrace();
		} catch (SIException e) {
			e.printStackTrace();
		}
		
		
		//Aqui iremos testar receber o numero de seguidores do nosso user2
		//resultado esperado: 1.
		//tamb�m � passada as 2 excessoes com o try/catch.
		
		try {
			System.out.println("Fun��o n�mero de seguidores:");
			int a = twitter.numeroSequidores(rep.buscar(user2.getUsuario()).getUsuario());
			System.out.println("Numero de seguidores de " + rep.buscar(user2.getUsuario()).getUsuario() + ": " + a + "\n");
		} catch (PIException e) {
			e.printStackTrace();
		} catch (PDException e) {
			e.printStackTrace();
		}
		
		//aqui iremos listar os seguidores do nosso user2
		//resultado esperado: user1
		//tamb�m � passada as 2 excessoes com o try/catch.
		
		try {
			System.out.println("Fun��o seguidores:");
			Vector<Perfil> a = twitter.seguidores(rep.buscar(user2.getUsuario()).getUsuario());
			System.out.println("seguidores de " + rep.buscar(user2.getUsuario()).getUsuario() + ":");
			for(int i=0;i<a.size();i++) {
				System.out.println("  " + (i+1) + ":" + a.get(i).getUsuario()+"\n");	
			}
		} catch (PIException e) {
			e.printStackTrace();
		} catch (PDException e) {
			e.printStackTrace();
		}
		
		//aqui iremos listar os seguidos do nosso user
		//resultado esperado: user2
		//tamb�m � passada as 2 excessoes com o try/catch.
		//O for servirar para percorrer nosso vector de perfis
		
		try {
			System.out.println("Fun��o seguidos:");
			Vector<Perfil> a = twitter.seguidos(rep.buscar(user.getUsuario()).getUsuario());
			System.out.println("seguidos de " + rep.buscar(user.getUsuario()).getUsuario() + ":");
			for(int i=0;i<a.size();i++) {
				System.out.println("  " + (i+1) + ":" + a.get(i).getUsuario()+"\n");	
			}
		} catch (PIException e) {
			e.printStackTrace();
		} catch (PDException e) {
			e.printStackTrace();
		}
		
		//Aqui iremos tweetar, passando a fun��o tweetar.
		//recebe uma String usuario, e uma String mensagem como parametros.
		//Caso a mensagem esteja vazia, ou tenha mais de 140 caracteres, a exce��o MFPException � chamada

		
		try {
			System.out.println(rep.buscar(user.getUsuario()).getUsuario() + " digite seu tweet\n");
			sc.nextLine();
			mensagem=sc.nextLine();
			twitter.tweetar(rep.buscar(user.getUsuario()).getUsuario(), mensagem);
			
		} catch (PIException e) {
			e.printStackTrace();
		} catch (MFPException e) {
			e.printStackTrace();
		}
		
		//Agora para o segundo usuario
		
		try {
			System.out.println(rep.buscar(user2.getUsuario()).getUsuario() + " digite seu tweet\n");
			mensagem=sc.nextLine();
			twitter.tweetar(rep.buscar(user2.getUsuario()).getUsuario(), mensagem);
			
		} catch (PIException e) {
			e.printStackTrace();
		} catch (MFPException e) {
			e.printStackTrace();
		}
		
		//Agora temos a timeline do user
		// ser� criado um vector<tweet> c, que receber� o vector<tweet> da timeline, para ser percorrido no for
		
		try {
			System.out.println("Fun��o Timeline do " + rep.buscar(user.getUsuario()).getUsuario() + ":");
			Vector<Tweet> c	= twitter.timeline(rep.buscar(user.getUsuario()).getUsuario());
			for(int i=0;i<c.size();i++) {
				System.out.println(c.get(i).getUsuario());	
				System.out.println("  " + c.get(i).getMensagem()+"\n");	
			}
		} catch (PIException e) {
			e.printStackTrace();
		} catch (PDException e) {
			e.printStackTrace();
		}
		
		//Timeline do user2
		
		try {
			System.out.println("Fun��o Timeline do " + rep.buscar(user2.getUsuario()).getUsuario() + ":");
			Vector<Tweet> c	= twitter.timeline(rep.buscar(user2.getUsuario()).getUsuario());
			for(int i=0;i<c.size();i++) {
				System.out.println(c.get(i).getUsuario());	
				System.out.println("  " + c.get(i).getMensagem()+"\n");	
			}
		} catch (PIException e) {
			e.printStackTrace();
		} catch (PDException e) {
			e.printStackTrace();
		}
		
		//Aqui teremos s� os tweets do user
		//o principio � o mesmo do c�digo da timeline, com algumas muda�as que ser�o mostradas quando
		//formos analisar a parte do c�digo da fun��o
		
		try {
			System.out.println("Fun��o Tweets do " + rep.buscar(user.getUsuario()).getUsuario() + ":");
			Vector<Tweet> c	= twitter.tweets(rep.buscar(user.getUsuario()).getUsuario());
			for(int i=0;i<c.size();i++) {
				System.out.println(c.get(i).getUsuario());	
				System.out.println("  " + c.get(i).getMensagem()+"\n");	
			}
		} catch (PIException e) {
			e.printStackTrace();
		} catch (PDException e) {

			e.printStackTrace();
		}
		
		//Aqui teremos s� os tweets do user2
		
		try {
			System.out.println("Fun��o Tweets do " + rep.buscar(user2.getUsuario()).getUsuario() + ":");
			Vector<Tweet> c	= twitter.tweets(rep.buscar(user2.getUsuario()).getUsuario());
			for(int i=0;i<c.size();i++) {
				System.out.println(c.get(i).getUsuario());	
				System.out.println("  " + c.get(i).getMensagem()+"\n");	
			}
		} catch (PIException e) {
			e.printStackTrace();
		} catch (PDException e) {
			e.printStackTrace();
		}
		
		//Aqui temos a fun��o cancelar, que alterara o estado do campo ativo de true para false
		
		try {
			System.out.println("Fun��o Cancelar:");
			twitter.cancelarPerfil(rep.buscar(user2.getUsuario()).getUsuario());
		} catch (PIException e) {
			e.printStackTrace();
		} catch (PDException e) {
			e.printStackTrace();
		}
		
		
		//Aqui iremos testar um caso onde o usuario tenta se seguir
		//resultado esperado � um erro, apondetando a exce�ao SIException
		
		try {
			twitter.seguir(rep.buscar(user.getUsuario()).getUsuario(),rep.buscar(user.getUsuario()).getUsuario());
		} catch (PIException e) {	
			e.printStackTrace();
		} catch (PDException e) {
			e.printStackTrace();
		} catch (SIException e) {
			e.printStackTrace();
		}
		
		sc.close();
		
	}
}
