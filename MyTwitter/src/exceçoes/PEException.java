package exce�oes;

import Estrutura.Perfil;

//Exce��o de perfil existente
//Caso j� exista uma Perfil com o mesmo nome de usuario

public class PEException extends Exception{
	
    private Perfil perfil;

    //Aqui teremos o construtor, o getter e o setter da classe.
    
    public PEException(Perfil p){
        this.perfil = p;
    }
    public void setPerfil(Perfil p){
        this.perfil = p;
    }
    public Perfil getPerfil(){
        return this.perfil;
    }
}
