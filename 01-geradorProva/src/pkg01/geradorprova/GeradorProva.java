package pkg01.geradorprova;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class GeradorProva {
    public static void main(String[] args) {
        String disciplina = JOptionPane.showInputDialog("Digite o nome da disciplina: ");
        
        Prova prova = new Prova(disciplina);

        prova.setLocal(JOptionPane.showInputDialog("Digite o local da prova: "));
        
        prova.setData(JOptionPane.showInputDialog("Digite a data da prova: "));
       
        while(true){
            try{
                prova.setPeso(Integer.parseInt(JOptionPane.showInputDialog("Digite o peso da prova: ")));
                break;
            }catch(Exception a){
                JOptionPane.showMessageDialog(null, a.getMessage() + "\nDigite novamente");
                continue;
            }
        }
        
        String continuar;
        ArrayList<Questao> aux = new ArrayList<Questao>();
        do{
            String opcao;
            
            do{
                opcao = JOptionPane.showInputDialog("Digite D para Discursiva ou O pra Objetiva");
             
                if(opcao.compareTo("O")!=0 && opcao.compareTo("o")!=0 && 
                   opcao.compareTo("D")!=0 && opcao.compareTo("d")!=0)
                    JOptionPane.showMessageDialog(null, "Tipo de questao nao identificado.");
                
            }while(opcao.compareTo("O")!=0 && opcao.compareTo("o")!=0 && 
                   opcao.compareTo("D")!=0 && opcao.compareTo("d")!=0);

            if(opcao.compareTo("O")==0 || opcao.compareTo("o")==0){
                Objetiva aux2 = new Objetiva();
                
                aux2.setPergunta(JOptionPane.showInputDialog("Digite a questao objetiva: "));
                
                while(true){
                    try{
                        aux2.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Digite o peso da questao: ")));
                        break;
                    }catch(Exception a){
                        JOptionPane.showMessageDialog(null, a.getMessage() + "\nDigite novamente");
                        continue;
                    }
                }
                
                String[] alternativas = new String[5];
                for(int i=0; i<5; i++){
                    alternativas[i] = JOptionPane.showInputDialog("Digite a alternativa "+(i+1)+": ");
                }
                aux2.setOpcoes(alternativas);
                
                while(true){
                    try{
                        aux2.setRespostaCorreta((Integer.parseInt(JOptionPane.showInputDialog("Digite a alternativa correta: "))));
                        if(aux2.getRespostaCorreta()<0 || aux2.getRespostaCorreta()>4)
                            throw new IllegalArgumentException();
                        break;
                    }catch(NumberFormatException a){
                        JOptionPane.showMessageDialog(null, a.getMessage() + "\nDigite novamente");
                        continue;
                    }catch(IllegalArgumentException e){
                        JOptionPane.showMessageDialog(null, "Alternativa correta precisa estar entre 0 e 4." + "\nDigite novamente");
                        continue;
                    }
                }
                
                aux.add(aux2);
            }else{
                Discursiva aux2 = new Discursiva();
                
                aux2.setPergunta(JOptionPane.showInputDialog("Digite a questao discursiva: "));
                
                while(true){
                    try{
                        aux2.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Digite o peso da questao: ")));
                        break;
                    }catch(Exception a){
                        JOptionPane.showMessageDialog(null, a.getMessage() + "\nDigite novamente");
                        continue;
                    }   
                }
                
                aux2.setCriteriosCorrecao(JOptionPane.showInputDialog("Digite o criterio de correcao: "));
                
                aux.add(aux2);
            }
            
            continuar = JOptionPane.showInputDialog("Deseja adicionar mais uma questao? S/N");
        }while(continuar.compareTo("S")==0 || continuar.compareTo("s")==0);
        prova.setQuestoes(aux);
        
        //System.out.println(prova.obtemProvaImpressa());
        String nomeArquivo = JOptionPane.showInputDialog("Digite o nome que deseja salvar o arquivo: ");
        try{
            File arquivo = new File(nomeArquivo+".txt");
            FileWriter escritor = new FileWriter(arquivo);
            PrintWriter saida = new PrintWriter(escritor);
            saida.println(prova.obtemProvaImpressa());
            saida.close();
            JOptionPane.showMessageDialog(null, "Arquivo salvo com sucesso.");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Falha ao salvar em arquivo.");
        }
    }
}
