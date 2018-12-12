package br.example.jonat.a05_controle_abastecimento;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final int VERSAO_DB = 1;

    public DBHelper(Context c){
        super(c, "Banco_de_Dados", null, DBHelper.VERSAO_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQLtabela = "CREATE TABLE abastecimentos (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "KILOMETROS DOUBLE," +
                "LITROS DOUBLE," +
                "DATA TEXT," +
                "POSTO TEXT," +
                "LATITUDE DOUBLE," +
                "LONGITUDE DOUBLE" +
                ");";
        db.execSQL(SQLtabela);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE abastecimentos");
        this.onCreate(db);
    }
}
