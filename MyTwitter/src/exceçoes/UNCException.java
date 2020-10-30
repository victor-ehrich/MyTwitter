package exceçoes;

import Estrutura.Perfil;

//exceção de usuário não cadastrado

public class UNCException extends Exception{
    private Perfil perfil;

    //Aqui teremos o construtor, o getter e o setter da classe.
    
    public UNCException(Perfil p){
        this.perfil = p;
    }
    public void setPerfil(Perfil p){
        this.perfil = p;
    }
    public Perfil getPerfil(){
        return this.perfil;
    }
}
