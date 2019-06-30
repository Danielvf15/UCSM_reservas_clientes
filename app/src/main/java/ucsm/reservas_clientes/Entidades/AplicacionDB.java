package ucsm.reservas_clientes.Entidades;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AplicacionDB extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="reservas.db";
    private static final String TABLE_NAME="Alumnos";
    private static final String  COLUMN_CODIGO="codigo";
    private static final String  COLUMN_DNI="dni";
    private static final String  COLUMN_NOMBRE="nombre";
    private static final String  COLUMN_TELEFONO="telefono";
    private static final String  COLUMN_CORREO="correo";

    private static final String TABLE_NAME2="Pabellon";
    private static final String  COLUMN_CODIGO2="codigo";


    private static final String TABLE_NAME3="Aula";
    private static final String  COLUMN_NUM="num";
    private static final String  COLUMN_CODIGOPAB="cod_pab";
    private static final String  COLUMN_PISO="piso";

    private static final String TABLE_NAME4="Reserva_aula";
    private static final String  COLUMN_CODIGO4="codigo";
    private static final String  COLUMN_CODIGOAULA="codigo_aula";
    private static final String  COLUMN_CODIGOPAB4="codigo_pabellon";
    private static final String  COLUMN_DIA="dia";
    private static final String  COLUMN_HORA="hora";
    private static final String  COLUMN_ESTADO="estado";
    private static final String  COLUMN_CODIGOALUM="cod_alum";
    SQLiteDatabase db;

    private static final String TABLE_CREATE="CREATE TABLE Alumnos" +
            "(codigo TEXT primary key NOT NULL,dni TEXT NOT NULL UNIQUE,nombre TEXT, telefono TEXT,correo text)";
    private static final String TABLE2_CREATE="CREATE TABLE Pabellon" +
            "(codigo TEXT NOT NULL,PRIMARY KEY(codigo))";
    private static final String TABLE3_CREATE="CREATE TABLE Aula" +
            "(num TEXT NOT NULL,cod_pab TEXT NOT NULL,piso TEXT, PRIMARY KEY(num,cod_pab),FOREIGN KEY(cod_pab) REFERENCES Pabellon(codigo))";
    private static final String TABLE4_CREATE="CREATE TABLE Reserva_aula" +
            "(codigo TEXT NOT NULL,codigo_aula TEXT NOT NULL,codigo_pabellon TEXT, dia TEXT,hora TEXT,estado TEXT,cod_alum TEXT, PRIMARY KEY(codigo), FOREIGN KEY(cod_alum) REFERENCES Alumnos(codigo))";



    public AplicacionDB(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    public AplicacionDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {//Metodo que crea la base de datos
        db.execSQL(TABLE_CREATE);
        db.execSQL("Insert into Alumnos values('2013601611','45481223','Albertl Reyes','4548123','alb_123@gmail.com')");
        db.execSQL(TABLE2_CREATE);
        db.execSQL("Insert into Pabellon values('A')");
        db.execSQL("Insert into Pabellon values('B')");
        db.execSQL("Insert into Pabellon values('C')");
        db.execSQL(TABLE3_CREATE);
        db.execSQL("Insert into Aula values('201','A','2')");
        db.execSQL("Insert into Aula values('202','A','2')");
        db.execSQL("Insert into Aula values('203','A','2')");
        db.execSQL("Insert into Aula values('204','A','2')");
        db.execSQL(TABLE4_CREATE);
        db.execSQL("insert into Reserva_aula VALUES('001','202','A','Lunes','9-11','false',null)");
        db.execSQL("insert into Reserva_aula VALUES('002','202','A','Lunes','11-1','false',null)");
        db.execSQL("insert into Reserva_aula VALUES('003','202','A','Lunes','1-3','false',null)");
        db.execSQL("insert into Reserva_aula VALUES('004','202','A','Lunes','3-5','false',null)");
        db.execSQL("insert into Reserva_aula VALUES('005','202','A','Lunes','5-7','false',null)");

        db.execSQL("insert into Reserva_aula VALUES('006','202','A','Martes','9-11','false',null)");
        db.execSQL("insert into Reserva_aula VALUES('007','202','A','Martes','11-1','false',null)");
        db.execSQL("insert into Reserva_aula VALUES('008','202','A','Martes','1-3','false',null)");
        db.execSQL("insert into Reserva_aula VALUES('009','202','A','Martes','3-5','false',null)");
        db.execSQL("insert into Reserva_aula VALUES('010','202','A','Martes','5-7','false',null)");

        db.execSQL("insert into Reserva_aula VALUES('011','202','A','Miercoles','9-11','false',null)");
        db.execSQL("insert into Reserva_aula VALUES('012','202','A','Miercoles','11-1','false',null)");
        db.execSQL("insert into Reserva_aula VALUES('013','202','A','Miercoles','1-3','false',null)");
        db.execSQL("insert into Reserva_aula VALUES('014','202','A','Miercoles','3-5','false',null)");
        db.execSQL("insert into Reserva_aula VALUES('015','202','A','Miercoles','5-7','false',null)");

        db.execSQL("insert into Reserva_aula VALUES('016','202','A','Jueves','9-11','false',null)");
        db.execSQL("insert into Reserva_aula VALUES('017','202','A','Jueves','11-1','false',null)");
        db.execSQL("insert into Reserva_aula VALUES('018','202','A','Jueves','1-3','false',null)");
        db.execSQL("insert into Reserva_aula VALUES('019','202','A','Jueves','3-5','false',null)");
        db.execSQL("insert into Reserva_aula VALUES('020','202','A','Jueves','5-7','false',null)");

        db.execSQL("insert into Reserva_aula VALUES('021','202','A','Viernes','9-11','false',null)");
        db.execSQL("insert into Reserva_aula VALUES('022','202','A','Viernes','11-1','false',null)");
        db.execSQL("insert into Reserva_aula VALUES('023','202','A','Viernes','1-3','false',null)");
        db.execSQL("insert into Reserva_aula VALUES('024','202','A','Viernes','3-5','false',null)");
        db.execSQL("insert into Reserva_aula VALUES('025','202','A','Viernes','5-7','false',null)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {//Metodo que actualiza la version de la base da datos
        String query="DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        String query2="DROP TABLE IF EXISTS "+TABLE_NAME2;
        db.execSQL(query2);
        String query3="DROP TABLE IF EXISTS "+TABLE_NAME3;
        db.execSQL(query3);;
        String query4="DROP TABLE IF EXISTS "+TABLE_NAME4;
        db.execSQL(query4);
        this.onCreate(db);
    }
}
