package pkg01.geradorprova;

import java.util.Scanner;

public class GeradorProva {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite o nome da disciplina: ");
        String disciplina = scan.nextLine();
        
        Prova prova = new Prova(disciplina);
        
        System.out.println("Digite o local da prova: ");
        prova.setLocal( scan.nextLine());
        
        System.out.println("Digite a data da prova: ");
        prova.setData(scan.nextLine());
        
        String verificacao;
        do{
            System.out.println("Digite o peso da prova: ");
            verificacao = scan.nextLine();
            if(prova.stringIsNumeric(verificacao)==false){
                System.out.println("Peso precisa ser um numero inteiro");
            }else{
                    prova.setPeso(Integer.parseInt(verificacao)); 
            }
        }while(prova.stringIsNumeric(verificacao)==false);
        
        int qtdDiscursivas=0;
        
        do{
            System.out.println("Digite a quantidade de questoes discursivas: ");
            verificacao = scan.nextLine();
            if(!prova.stringIsNumeric(verificacao)){
                System.out.println("Precisa ser um numero inteiro");
            }else{
                qtdDiscursivas = Integer.parseInt(verificacao);
            }
        }while(!prova.stringIsNumeric(verificacao));
        
        Discursiva[] aux1 = new Discursiva[qtdDiscursivas];
        prova.setTamanhoQuestaoDiscursiva(qtdDiscursivas);
        
        for(int i=0; i<qtdDiscursivas; i++){
            aux1[i] = new Discursiva();
            do{
                System.out.println("Digite o peso da questao: ");
                verificacao = scan.nextLine();
                if(!prova.stringIsNumeric(verificacao)){
                    System.out.println("Precisa ser um numero inteiro");
                }else{
                    aux1[i].setPeso(Double.parseDouble(verificacao));
                }
            }while(!prova.stringIsNumeric(verificacao));
            
            System.out.println("Digite a questao discursiva["+i+"]: ");
            aux1[i].setPergunta(scan.nextLine());
            
            System.out.println("Digite o criterio de correcao: ");
            aux1[i].setCriteriosCorrecao(scan.nextLine());
        }
        prova.setQuestaoDiscursiva(aux1);
        
        int qtdObjetivas=0;
        do{
            System.out.println("Digite a quantidade de questoes objetivas: ");
            verificacao = scan.nextLine();
            if(!prova.stringIsNumeric(verificacao)){
                System.out.println("Precisa ser um numero inteiro");
            }else{
                qtdObjetivas = Integer.parseInt(verificacao);
            }
        }while(!prova.stringIsNumeric(verificacao));
        Objetiva[] aux2 = new Objetiva[qtdObjetivas];
        prova.setTamanhoQuestaoObjetiva(qtdObjetivas);
        
        for(int i=0; i<qtdObjetivas; i++){
            aux2[i] = new Objetiva();
            
            do{
                System.out.println("Digite o peso da questao: ");
                verificacao = scan.nextLine();
                if(!prova.stringIsNumeric(verificacao)){
                    System.out.println("Precisa ser um numero inteiro");
                }else{
                    aux2[i].setPeso(Integer.parseInt(verificacao));
                }
            }while(!prova.stringIsNumeric(verificacao));
            
            
            System.out.println("Digite a questao objetiva["+i+"]: ");
            aux2[i].setPergunta(scan.nextLine());
            String[] opcoes = new String[5];
            for(int j=0; j<5; j++){
                System.out.println("Digite a alternativa "+j+": ");
                opcoes[j] = scan.nextLine();
            }
            aux2[i].setOpcoes(opcoes);
            
            boolean cond;
            do{
                cond=true;
                System.out.println("Digite a alternativa correta: ");
                verificacao = scan.nextLine();
                cond = prova.stringIsNumeric(verificacao);
                if(!cond){
                    System.out.println("Precisa ser um numero inteiro");
                }else{
                    int verificacao2 = Integer.parseInt(verificacao);
                    if(verificacao2 < 0 || verificacao2 > 4){
                        System.out.println("Numero entre 0 e 4");
                        cond = false;
                    }else{
                        aux2[i].setRespostaCorreta(verificacao2);
                    }
                }
            }while(!cond);
        }
        prova.setQuestaoObjetiva(aux2);
        
        System.out.println(prova.obtemProvaImpressa());
    }
}
