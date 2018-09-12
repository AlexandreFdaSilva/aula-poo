package pkg01.geradorprova;

final class Objetiva extends Questao{
    private String[] opcoes;
    private int respostaCorreta;
    
    public Objetiva(){
         this.opcoes = new String[5];
    }
    
    @Override
    public String retornaQuestao(){
        String retur="";
        retur += "("+this.getPeso()+") - "+this.getPergunta()+"\r\n";
        String[] aux = new String[5];
        aux = this.getOpcoes();
        for(int j=0; j<5; j++){
            retur += "("+j+") "+aux[j]+"\r\n";
        }
        retur += "\r\n";
   
        return retur;
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

