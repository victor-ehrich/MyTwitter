package exceçoes;

import Estrutura.Perfil;

//Exceção de usuário já cadastrado
//não devem ser cadastrados usuários com o mesmo nome de usuário.

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
