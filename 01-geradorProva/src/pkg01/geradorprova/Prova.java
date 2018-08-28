package pkg01.geradorprova;

public class Prova {

    private String nomeDisciplina;
    private int peso;
    private String local;
    private String data;

    public Prova(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.peso = 10;
    }

    public String obtemDetalhes() {
        String retorno = "";
        retorno += "Nome: " + this.getNomeDisciplina() + "\n";
        retorno += "Nome: " + this.getLocal() + "\n";
        retorno += "Nome: " + this.getData() + "\n";
        retorno += "Nome: " + this.getPeso() + "\n";
        return retorno;
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
}
