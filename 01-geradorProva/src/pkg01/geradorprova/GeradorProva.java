package pkg01.geradorprova;

import java.util.Scanner;

public class GeradorProva {
    public static void main(String[] args) {
        Prova prova = new Prova();
        prova.obtemDetalhes();
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite a quantidade de questoes discursivas: ");
        int qtdDiscursivas = Integer.parseInt(scan.nextLine());
        Discursiva[] aux1 = new Discursiva[qtdDiscursivas];
        prova.setTamanhoQuestaoDiscursiva(qtdDiscursivas);
        for(int i=0; i<qtdDiscursivas; i++){
            aux1[i] = new Discursiva();
            System.out.println("Digite o peso da questao: ");
            aux1[i].setPeso(Double.parseDouble(scan.nextLine()));
            System.out.println("Digite a questao discursiva["+i+"]: ");
            aux1[i].setPergunta(scan.nextLine());
            System.out.println("Digite o criterio de correcao: ");
            aux1[i].setCriteriosCorrecao(scan.nextLine());
        }
        prova.setQuestaoDiscursiva(aux1);
        
        System.out.println("Digite a quantidade de questoes objetivas: ");
        int qtdObjetivas = Integer.parseInt(scan.nextLine());
        Objetiva[] aux2 = new Objetiva[qtdObjetivas];
        prova.setTamanhoQuestaoObjetiva(qtdObjetivas);
        for(int i=0; i<qtdObjetivas; i++){
            aux2[i] = new Objetiva();
            System.out.println("Digite o peso da questao: ");
            aux2[i].setPeso(Integer.parseInt(scan.nextLine()));
            System.out.println("Digite a questao objetiva["+i+"]: ");
            aux2[i].setPergunta(scan.nextLine());
            String[] opcoes = new String[5];
            for(int j=0; j<5; j++){
                System.out.println("Digite a alternativa "+j+": ");
                opcoes[j] = scan.nextLine();
            }
            aux2[i].setOpcoes(opcoes);
            System.out.println("Digite a alternativa correta: ");
            aux2[i].setRespostaCorreta(Integer.parseInt(scan.nextLine()));
        }
        prova.setQuestaoObjetiva(aux2);
        
        prova.obtemProvaImpressa();
    }
}
