/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

public class GeradorProva {
    public static void main(String[] args) {
        Prova x = new Prova("POO");
        //x.nomeDisciplina = "POO";
        x.setLocal("Lab 3 - Bloco B6");
        x.setData("2018-08-28");
        //x.peso = 4;
        
        //forma didatica
        //String retornoDoMetodo = x.obtemDetalhes();
        //System.out.println(retornoDoMetodo);
        
        //forma resumida
        System.out.println(x.obtemDetalhes());
        
        Discursiva d = new Discursiva();
        d.setPergunta("Qual seu nome?");
        d.setPeso(0);
        d.setCriteriosCorrecao("Saber o proprio nome");
        
        Objetiva o = new Objetiva();
        o.setPergunta("Qual das alternativas esta correta?");
        o.setPeso(2);
        String[] opcoes = new String[5];
        opcoes[0] = "Gremio";
        opcoes[1] = "Internacional";
        opcoes[2] = "Flamengo";
        opcoes[3] = "Corinthians";
        opcoes[4] = "Sao Paulo";
        o.setOpcoes(opcoes);
        o.setRespostaCorreta(3);
    }
}
