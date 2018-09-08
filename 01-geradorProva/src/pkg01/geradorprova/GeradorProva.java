package pkg01.geradorprova;

import java.util.Scanner;
import java.util.ArrayList;

public class GeradorProva {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite o nome da disciplina: ");
        String disciplina = scan.nextLine();
        
        Prova prova = new Prova(disciplina);
        
        System.out.println("Digite o local da prova: ");
        prova.setLocal(scan.nextLine());
        
        System.out.println("Digite a data da prova: ");
        prova.setData(scan.nextLine());
        
        System.out.println("Digite o peso da prova: ");
        while(true){
            try{
                prova.setPeso(Integer.parseInt(scan.nextLine()));
                break;
            }catch(Exception a){
                System.out.println(a.getMessage());
                System.out.println("Digite novamente.");
                continue;
            }
        }
        
        String continuar;
        ArrayList<Questao> aux = new ArrayList<Questao>();
        do{
            String opcao;
            
            do{
                System.out.println("Digite D para Discursiva ou O pra Objetiva");
                opcao = scan.nextLine();
             
                if(opcao.compareTo("O")!=0 && opcao.compareTo("o")!=0 && 
                   opcao.compareTo("D")!=0 && opcao.compareTo("d")!=0)
                    System.out.println("Tipo de questao nao identificado.");
                
            }while(opcao.compareTo("O")!=0 && opcao.compareTo("o")!=0 && 
                   opcao.compareTo("D")!=0 && opcao.compareTo("d")!=0);

            if(opcao.compareTo("O")==0 || opcao.compareTo("o")==0){
                Objetiva aux2 = new Objetiva();
                
                System.out.println("Digite a questao objetiva: ");
                aux2.setPergunta(scan.nextLine());
                
                System.out.println("Digite o peso da questao: ");
                while(true){
                    try{
                        aux2.setPeso(Integer.parseInt(scan.nextLine()));
                        break;
                    }catch(Exception a){
                        System.out.println(a.getMessage());
                        System.out.println("Digite novamente.");
                        continue;
                    }
                }
                
                String[] alternativas = new String[5];
                for(int i=0; i<5; i++){
                    System.out.println("Digite a alternativa "+(i+1)+": ");
                    alternativas[i] = scan.nextLine();
                }
                aux2.setOpcoes(alternativas);
                
                System.out.println("Digite a alternativa correta: ");
                while(true){
                    try{
                        aux2.setRespostaCorreta((Integer.parseInt(scan.nextLine())+1));
                        if(aux2.getRespostaCorreta()<1 || aux2.getRespostaCorreta()>5)
                            throw new IllegalArgumentException();
                        break;
                    }catch(NumberFormatException a){
                        System.out.println(a.getMessage());
                        System.out.println("Digite novamente.");
                        continue;
                    }catch(IllegalArgumentException e){
                        System.out.println("Alternativa correta precisa estar entre 1 e 5.");
                        System.out.println("Digite novamente.");
                        continue;
                    }
                }
                
                aux.add(aux2);
            }else{
                Discursiva aux2 = new Discursiva();
                
                System.out.println("Digite a questao discursiva: ");
                aux2.setPergunta(scan.nextLine());
                
                System.out.println("Digite o peso da questao: ");
                while(true){
                    try{
                        aux2.setPeso(Integer.parseInt(scan.nextLine()));
                        break;
                    }catch(Exception a){
                        System.out.println(a.getMessage());
                        System.out.println("Digite novamente.");
                        continue;
                    }   
                }
                
                System.out.println("Digite o criterio de correcao: ");
                aux2.setCriteriosCorrecao(scan.nextLine());
                
                aux.add(aux2);
            }
            
            System.out.println("Deseja adicionar mais uma questao? S/N");
            continuar = scan.nextLine();
        }while(continuar.compareTo("S")==0 || continuar.compareTo("s")==0);
        prova.setQuestoes(aux);
        
        System.out.println(prova.obtemProvaImpressa());
    }
}
