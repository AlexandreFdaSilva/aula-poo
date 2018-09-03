package pkg01.geradorprova;

public class Prova {
    private String nomeDisciplina;
    private int peso;
    private String local;
    private String data;
    private Discursiva[] questaoDiscursiva;
    private Objetiva[] questaoObjetiva;

    public Prova(){
        this.peso = 10;
    }
    
    public boolean stringIsNumeric(String str){
        for(char c : str.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
    
    public String obtemDetalhes() {
        String retur="";
        
        retur+=("Disciplina: "+this.nomeDisciplina+"\n");
        retur+=("Local: "+this.local+"\n");
        retur+=("Data: "+this.data+"\n");
        retur+=("Peso: "+this.peso+"\n");
        
        return retur;
    }
    
    public String obtemProvaImpressa(){
        String retur = obtemDetalhes();
        
        retur += "\nQuestoes discursivas: \n";
        int cont=1;
        for(int i=0; i<questaoDiscursiva.length; i++){
            retur += cont+"("+questaoDiscursiva[i].getPeso()+") - "+questaoDiscursiva[i].getPergunta()+"\n";
            cont++;
        }
        retur += "\nQuestoes objetivas: \n";
        for(int i=0; i<questaoObjetiva.length; i++){
            retur += cont+"("+questaoObjetiva[i].getPeso()+") - "+questaoObjetiva[i].getPergunta()+"\n";
            String[] aux = new String[5];
            aux = questaoObjetiva[i].getOpcoes();
            for(int j=0; j<5; j++){
                retur += "("+j+") "+aux[j]+"\n";
            }
            retur += "\n";
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
    public void setTamanhoQuestaoDiscursiva(int tam){
        this.questaoDiscursiva = new Discursiva[tam];
        for(int i=0; i<tam; i++){
            this.questaoDiscursiva[i] = new Discursiva(); 
        }
    }
    public void setTamanhoQuestaoObjetiva(int tam){
        this.questaoObjetiva = new Objetiva[tam];
        for(int i=0; i<tam; i++){
            this.questaoObjetiva[i] = new Objetiva(); 
        }
    }
    public Discursiva[] getQuestaoDiscursiva() {
        return questaoDiscursiva;
    }
    public void setQuestaoDiscursiva(Discursiva[] questaoDiscursiva) {
        this.questaoDiscursiva = questaoDiscursiva;
    }
    public Objetiva[] getQuestaoObjetiva() {
        return questaoObjetiva;
    }
    public void setQuestaoObjetiva(Objetiva[] questaoObjetiva) {
        this.questaoObjetiva = questaoObjetiva;
    }
}