
package pkg01.geradorprova;


abstract class Questao {
    private String pergunta;
    private double peso;
    
    public Questao(){
    
    }
    public String getPergunta() {
        return pergunta;
    }
    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
}
