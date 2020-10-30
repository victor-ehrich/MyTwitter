package exce�oes;

import Estrutura.Perfil;

//Exce��o de usu�rio j� cadastrado
//n�o devem ser cadastrados usu�rios com o mesmo nome de usu�rio.

public class UJCException extends Exception{
    private Perfil perfil;

    //Aqui teremos o construtor, o getter e o setter da classe.
    
    public UJCException(Perfil p){
        this.perfil = p;
    }
    public void setPerfil(Perfil p){
        this.perfil = p;
    }
    public Perfil getPerfil(){
        return this.perfil;
    }
}
