package exce�oes;

import Estrutura.Perfil;

//exce��o de mensagem fora do padr�o 
//a mensagem devera contem entre 1 e 140 caracterem para n�o entrar nessa exce��o


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