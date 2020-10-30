package exceçoes;

import Estrutura.Perfil;

//Exceção de seguidor inválido
//Caso o nome de usuário do seguidor seja o mesmo do seguido

public class SIException extends Exception{
    private Perfil perfil;

    //Aqui teremos o construtor, o getter e o setter da classe.
    
    public SIException(Perfil p){
        this.perfil = p;
    }
    public void setPerfil(Perfil p){
        this.perfil = p;
    }
    public Perfil getPerfil(){
        return this.perfil;
    }
}
