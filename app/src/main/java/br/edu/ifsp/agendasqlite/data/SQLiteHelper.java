package br.edu.ifsp.agendasqlite.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "agenda.db";
    static final String TABLE_NAME ="contatos";

    static final String KEY_ID = "id";
    static final String KEY_NOME = "nome";
    static final String KEY_FONE_1 = "fone";
    static final String KEY_FONE_2 = "fone_2";
    static final String KEY_EMAIL = "email";
    static final String KEY_FAVORITO = "favorito";
    static final String KEY_ANIVERSARIO = "aniversario";

    private static final int DATABASE_VERSION = 4;

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                                               + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                               + KEY_NOME + " TEXT, "
                                               + KEY_FONE_1 + " TEXT, "
                                               + KEY_EMAIL + " TEXT);" ;

    private static final String ALTER_TABLE_BD2 = "ALTER TABLE " + TABLE_NAME
                                                + " ADD COLUMN " + KEY_FAVORITO + " INTEGER DEFAULT 0;";

    private static final String ALTER_TABLE_BD3 = "ALTER TABLE " + TABLE_NAME
                                                + " ADD COLUMN " + KEY_FONE_2 + " INTEGER ";

    private static final String ALTER_TABLE_BD4 = "ALTER TABLE " + TABLE_NAME
                                                + " ADD COLUMN " + KEY_ANIVERSARIO + " INTEGER ";


    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 1 && newVersion == 2) {
            db.execSQL(ALTER_TABLE_BD2);
            oldVersion = newVersion;        // Para outras futuras atualizações
        }
        if (oldVersion == 2 && newVersion == 3) {
            db.execSQL(ALTER_TABLE_BD3);
            oldVersion = newVersion;        // Para outras futuras atualizações
        }
        if (oldVersion == 3 && newVersion == 4) {
            db.execSQL(ALTER_TABLE_BD4);
            oldVersion = newVersion;        // Para outras futuras atualizações
        }

    }
}
