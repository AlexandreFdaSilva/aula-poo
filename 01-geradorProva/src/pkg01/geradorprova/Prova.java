package pkg01.geradorprova;

import java.util.Scanner;

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

    public String obtemDetalhes() {
        Scanner scan = new Scanner(System.in);
      
        System.out.println("Digite o nome da disciplina: ");
        this.nomeDisciplina = scan.nextLine();
        
        System.out.println("Digite o local da prova: ");
        this.local = scan.nextLine();
        
        System.out.println("Digite a data da prova: ");
        this.data = scan.nextLine();
        
        System.out.println("Digite o peso da prova: ");
        this.peso = Integer.parseInt(scan.nextLine());
                
        String aux = this.nomeDisciplina + " - " + this.local + " - " + this.data + " - " + this.peso;
        
        return aux;
    }
    
    public String obtemProvaImpressa(){
        System.out.println("Disciplina: " + this.nomeDisciplina);
        System.out.println("Local: " + this.local);
        System.out.println("Data: " + this.data);
        System.out.println("Peso: " + this.peso);
        System.out.println("\nQuestoes discursivas: ");
        
        return "chato pra krl hein NetBeans";
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
    }
    public void setTamanhoQuestaoObjetiva(int tam){
        this.questaoObjetiva = new Objetiva[tam];
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
