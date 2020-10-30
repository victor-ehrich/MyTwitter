package exceçoes;

import Estrutura.Perfil;

//Exceção de perfil desativado
//Caso o perfil exista, mas esteja inativo

public class PDException extends Exception{
	
    private Perfil perfil;

  //Aqui teremos o construtor, o getter e o setter da classe
    
    public PDException (Perfil p){
        this.perfil = p;
    }
    public void setPerfil(Perfil p){
        this.perfil = p;
    }
    public Perfil getPerfil(){
        return this.perfil;
    }
}
