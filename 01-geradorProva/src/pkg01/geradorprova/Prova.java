package pkg01.geradorprova;

import java.util.ArrayList;

public class Prova {
    private String nomeDisciplina;
    private int peso;
    private String local;
    private String data;
    private ArrayList<Questao> questoes = new ArrayList<Questao>();
    

    public Prova(String nome){
        this.nomeDisciplina = nome;
        this.peso = 10;
    }
    
    public String obtemDetalhes() {
        String retur="";
        
        retur+=("Universidade do Vale do Itajai\nEscola do mar, ciencia e tecnologia\n");
        retur+=("Disciplina: "+this.nomeDisciplina+"\n");
        retur+=("Local: "+this.local+"\n");
        retur+=("Data: "+this.data+"\n");
        retur+=("Peso: "+this.peso+"\n");
        retur+=("Aluno: ___________________________\n");
        
        return retur;
    }
    
    public String obtemProvaImpressa(){
        String retur = obtemDetalhes();
        
        int cont=1;
        for(int i=0; i<this.questoes.size(); i++){
            retur+=(cont+this.questoes.get(i).retornaQuestao()+"\n");
            cont++;
        }
        
        return retur;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }
    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }
    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public ArrayList<Questao> getQuestoes() {
        return questoes;
    }
    public void setQuestoes(ArrayList<Questao> questoes) {
        this.questoes = questoes;
    }
}