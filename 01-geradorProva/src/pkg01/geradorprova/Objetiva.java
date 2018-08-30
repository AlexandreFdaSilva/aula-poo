package pkg01.geradorprova;

final class Objetiva extends Questao{
    private String[] opcoes;
    private int respostaCorreta;
    
    public Objetiva(){
         this.opcoes = new String[5];
    }
    public String[] getOpcoes() {
        return opcoes;
    }
    public void setOpcoes(String[] opcoes) {
        this.opcoes = opcoes;
    }
    public int getRespostaCorreta() {
        return respostaCorreta;
    }
    public void setRespostaCorreta(int respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }
}

