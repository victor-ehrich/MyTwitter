package exceçoes;

import Estrutura.Perfil;

//exceção de mensagem fora do padrão 
//a mensagem devera contem entre 1 e 140 caracterem para não entrar nessa exceção


public class MFPException extends Exception{
    private String mensagem;

    //Aqui teremos o construtor, o getter e o setter da classe
    
    public MFPException(String mensagem){
        this.mensagem = mensagem;
    }
    public void setPerfil(String p){
        this.mensagem = p;
    }
    public String getPerfil(){
        return this.mensagem;
    }
}