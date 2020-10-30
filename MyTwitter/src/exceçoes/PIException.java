package exceçoes;

import Estrutura.Perfil;

//Exceção de perfil inexistente

public class PIException extends Exception{
    private Perfil perfil;

    //Aqui teremos o construtor, o getter e o setter da classe.
    
    public PIException(Perfil p){
        this.perfil = p;
    }
    public void setPerfil(Perfil p){
        this.perfil = p;
    }
    public Perfil getPerfil(){
        return this.perfil;
    }
}
