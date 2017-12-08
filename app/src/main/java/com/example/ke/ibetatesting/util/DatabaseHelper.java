package com.example.ke.ibetatesting.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static android.content.ContentValues.TAG;
import android.database.SQLException;
import android.widget.Spinner;

import com.example.ke.ibetatesting.constant.SQLCommand;
import com.example.ke.ibetatesting.view.addtestdata_location2Activity;

import java.util.Date;

/**
 * Created by ke on 11/22/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    static final String DATABASE_NAME="MIS571phi.db";
    private static final int DATABASE_VERSION =1;
    private static Context context;
    SQLiteDatabase db;


    private static String DATABASE_PATH;
    private final String Tester_TABLE="Tester";
    private final String Manager_TABLE="Manager";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
        DATABASE_PATH = context.getDatabasePath(DATABASE_NAME).getPath();
        createDb();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void createDb(){
        boolean dbExist = checkDbExist();
        copyDatabase();
        if(!dbExist){
            this.getReadableDatabase();
            copyDatabase();
        }
    }

    private void copyDatabase() {
        try {
            InputStream inputStream=context.getAssets().open(DATABASE_NAME);
            String outFileName =DATABASE_PATH;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[] b= new byte[10240];
            int length;
            while((length=inputStream.read(b))>0){
                outputStream.write(b,0,length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkDbExist() {
        SQLiteDatabase sqLiteDatabase =null;
        String path = DATABASE_PATH;
        try{
            sqLiteDatabase = SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.OPEN_READONLY);
}catch(Exception e){
            e.getStackTrace();
        }
        if(sqLiteDatabase!=null){
            sqLiteDatabase.close();
            return true;
        }
        return false;
    }


    public void close(){
        if(db!=null){
            db.close();
        }
    }

    public void signUpTester(String username, String password){
        String[] args = {username,password};
        db = SQLiteDatabase.openDatabase(DATABASE_PATH,null,SQLiteDatabase.OPEN_READWRITE);
        db.execSQL(SQLCommand.signup_ADDTESTER,args);

    }
    public void insertDeviceInfo(String devSN, String devDesc, String devVer){
        String []args = {devSN,devDesc,devVer};
        db = SQLiteDatabase.openDatabase(DATABASE_PATH,null,SQLiteDatabase.OPEN_READWRITE);
        db.execSQL(SQLCommand.insertDeviceInfoData,args);
    }
    //public void updateDeviceInfoInFile(String de)

    public void insertNewCaseFileData(String BC_lat,String BC_lon,String GOG_lat, String GOG_lon,String locDesc, String locType,String devSN, String testerID, String conDate, String curDate,String actType,String testCity){
        String []args={BC_lat,BC_lon,GOG_lat,GOG_lon,locDesc,locType,devSN,testerID,conDate,curDate,actType,testCity};
        db = SQLiteDatabase.openDatabase(DATABASE_PATH,null,SQLiteDatabase.OPEN_READWRITE);
        db.execSQL(SQLCommand.insertNewCaseFileData,args);
    }

    public void insertLocationData(String devlat, String devlon, String gglat, String gglon, String desc, String type){
        String []args = {devlat,devlon,gglat,gglon,desc,type};
        db = SQLiteDatabase.openDatabase(DATABASE_PATH,null,SQLiteDatabase.OPEN_READWRITE);
        db.execSQL(SQLCommand.insertLocationData,args);
    }

    public boolean checkTesterExist(String username, String password){
        String []columns={"Tester_ID"};
        db = SQLiteDatabase.openDatabase(DATABASE_PATH,null, SQLiteDatabase.OPEN_READWRITE);
        String selection="Tester_ID=? and Tester_Pass=?";
        String[] selectionArgs ={username,password};
        Cursor cursor=db.query(Tester_TABLE,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        close();
        if(count>0){
            return true;
        }else {
            return false;
        }
    }

    public boolean checkManagerExist(String managerusername, String password){
        String []columns={"Manager_ID"};
        db = SQLiteDatabase.openDatabase(DATABASE_PATH,null,SQLiteDatabase.OPEN_READWRITE);
        String selection ="Manager_ID=? and Manager_Pass=?";
        String[] selectionArgs={managerusername,password};
        Cursor cursor = db.query(Manager_TABLE,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        close();
        if(count>0){
            return true;
        }else {
            return false;
        }

    }
    public void execSQL(String sql) throws SQLException
    {
        db.execSQL(sql);
    }


    static DatabaseHelper instance = null;


    /**
          * execute sql such as update/delete/insert
          * @param sql
          * @param args
          * @throws SQLException
          */
    public void execSQL(String sql, Object[] args) throws SQLException
    {
        db.execSQL(sql, args);
    }
    /**
     * execute sql query
     * @param sql
     * @param selectionArgs
     * @return cursor
     * @throws SQLException
     */
    public Cursor execQuery(String sql,String[] selectionArgs) throws SQLException
    {
        db = SQLiteDatabase.openDatabase(DATABASE_PATH,null,SQLiteDatabase.OPEN_READWRITE);
        return db.rawQuery(sql, selectionArgs);
    }
    /**
     * execute query without arguments
     * @param sql
     * @return
     * @throws SQLException
     */
    public Cursor execQuery(String sql) throws SQLException
    {
        db = SQLiteDatabase.openDatabase(DATABASE_PATH,null,SQLiteDatabase.OPEN_READWRITE);
        return this.execQuery(sql, null);
    }
    public static DatabaseHelper getInstance()
    {
        if (instance==null) instance = new DatabaseHelper(context);
        return instance;
    }
}
