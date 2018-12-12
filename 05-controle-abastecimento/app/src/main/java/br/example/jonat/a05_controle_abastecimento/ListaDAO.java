package br.example.jonat.a05_controle_abastecimento;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.SQLData;
import java.util.ArrayList;

public class ListaDAO{
        private static ArrayList<Abastecimento> CACHE = new ArrayList<Abastecimento>();
        //public static final String nomeArquivo = "abastecimentos2.txt";

        public static boolean salvar(Context context, Abastecimento objeto){
            DBHelper meuDB = new DBHelper(context);
            SQLiteDatabase db = meuDB.getWritableDatabase();

            ContentValues chaveValor = new ContentValues();
            chaveValor.put("kilometros", objeto.getKilometros());
            chaveValor.put("litros", objeto.getLitros());
            chaveValor.put("data", objeto.getData());
            chaveValor.put("posto", objeto.getPosto());
            chaveValor.put("latitude", objeto.getLatitude());
            chaveValor.put("longitude", objeto.getLongitude());
            long id = db.insert("abastecimentos", null, chaveValor);
            objeto.setId(id);

            CACHE.add(objeto);
            return true;

//            CACHE.add(objeto);
//
//            String salvar = "";
//            salvar += objeto.getKilometros() + ";";
//            salvar += objeto.getLitros() + ";";
//            salvar += objeto.getData() + ";";
//            salvar += objeto.getPosto() + "\n";
//
//            File refArquivo = new File(context.getFilesDir().getPath() + nomeArquivo);
//            try{
//                FileWriter escritor = new FileWriter(refArquivo, true);
//                escritor.write(salvar);
//                escritor.close();
//                return true;
//            }catch (Exception e){
//                e.printStackTrace();
//                return false;
//            }
        }

        public static ArrayList<Abastecimento> getLista(Context context){
            CACHE = new ArrayList<Abastecimento>();

            DBHelper meuDB = new DBHelper(context);
            SQLiteDatabase db = meuDB.getReadableDatabase();

            String SQLBuscaAbastecimentos = "SELECT kilometros, litros, data, posto, latitude, longitude, id FROM abastecimentos";
            Cursor ponteiro = db.rawQuery(SQLBuscaAbastecimentos, null);

            while(ponteiro.moveToNext()){
                Abastecimento abastecimento = new Abastecimento();
                abastecimento.setKilometros(ponteiro.getDouble(0));
                abastecimento.setLitros(ponteiro.getDouble(1));
                abastecimento.setData(ponteiro.getString(2));
                abastecimento.setPosto(ponteiro.getString(3));
                abastecimento.setLatitude(ponteiro.getDouble(4));
                abastecimento.setLongitude(ponteiro.getDouble(5));
                abastecimento.setId(ponteiro.getLong(6));

                CACHE.add(abastecimento);
            }

            return CACHE;

//            CACHE = new ArrayList<Abastecimento>();
//
//            File refArquivo = new File(context.getFilesDir().getPath() + nomeArquivo);
//            try{
//                FileReader leitor =  new FileReader(refArquivo);
//                BufferedReader leitorDeLinha = new BufferedReader(leitor);
//
//                String linhaAbastecimento =  null;
//
//                while((linhaAbastecimento = leitorDeLinha.readLine()) != null){
//                    String[] partesDaLinha = linhaAbastecimento.split(";");
//                    Abastecimento abastecimento = new Abastecimento();
//                    abastecimento.setKilometros(Double.parseDouble(partesDaLinha[0]));
//                    abastecimento.setLitros(Double.parseDouble(partesDaLinha[1]));
//                    abastecimento.setData(partesDaLinha[2]);
//                    abastecimento.setPosto(partesDaLinha[3]);
//
//                    CACHE.add(abastecimento);
//                }
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//
//            return CACHE;
        }
}
