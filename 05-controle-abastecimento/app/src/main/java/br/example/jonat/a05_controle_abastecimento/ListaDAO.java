package br.example.jonat.a05_controle_abastecimento;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ListaDAO{
        private static ArrayList<Abastecimento> CACHE = new ArrayList<Abastecimento>();
        public static final String nomeArquivo = "abastecimentos.txt";

        public static boolean salvar(Context context, Abastecimento objeto){
            CACHE.add(objeto);

            String salvar = "";
            salvar += objeto.getKilometros() + ";";
            salvar += objeto.getLitros() + ";";
            salvar += objeto.getData() + ";";
            salvar += objeto.getPosto() + "\n";

            File refArquivo = new File(context.getFilesDir().getPath() + nomeArquivo);
            try{
                FileWriter escritor = new FileWriter(refArquivo, true);
                escritor.write(salvar);
                escritor.close();
                return true;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }

        public static ArrayList<Abastecimento> getLista(Context context){
            CACHE = new ArrayList<Abastecimento>();

            File refArquivo = new File(context.getFilesDir().getPath() + nomeArquivo);
            try{
                FileReader leitor =  new FileReader(refArquivo);
                BufferedReader leitorDeLinha = new BufferedReader(leitor);

                String linhaAbastecimento =  null;

                while((linhaAbastecimento = leitorDeLinha.readLine()) != null){
                    String[] partesDaLinha = linhaAbastecimento.split(";");
                    Abastecimento abastecimento = new Abastecimento();
                    abastecimento.setKilometros(Double.parseDouble(partesDaLinha[0]));
                    abastecimento.setLitros(Double.parseDouble(partesDaLinha[1]));
                    abastecimento.setData(partesDaLinha[2]);
                    abastecimento.setPosto(partesDaLinha[3]);

                    CACHE.add(abastecimento);
                }
            }catch(Exception e){
                e.printStackTrace();
            }

            return CACHE;
        }
}
