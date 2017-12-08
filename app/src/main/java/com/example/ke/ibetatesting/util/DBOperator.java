//package com.example.ke.ibetatesting.util;
//
///**
// * Created by ke on 11/23/17.
// */
//
//
//
//
///**
// * Created by ke on 11/13/17.
// */
//
//
//        import java.io.File;
//        import java.io.FileNotFoundException;
//        import java.io.FileOutputStream;
//        import java.io.IOException;
//        import java.io.InputStream;
//        import java.io.OutputStream;
//
//        //import philips.mis.constant.DBConstant;
//
//        import android.content.Context;
//        import android.database.Cursor;
//        import android.database.SQLException;
//        import android.database.sqlite.SQLiteDatabase;
//
//        import junit.framework.Test;
//
///**
// * Class to manipulate tables & data
// * Uses singleton pattern to create single instance
// */
//public class DBOperator
//{
//    private static DBOperator instance = null;
//    private SQLiteDatabase db;
//    private  final String Tester_TABLE="Tester";
//
//
//    private final String Manager_TABLE="Manager";
//
//    public DBOperator()
//    {
//        //path of database file
//        //String path = DBConstant.DATABASE_PATH + "/" + DBConstant.DATABASE_FILE;
//        //File file = new File(path);
//        String path = DatabaseHelper.DATABASE_PATH;
//        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
//    }
//    /*
//     * Singleton Pattern
//     * Why should we avoid multiple instances here?
//     */
//    public static DBOperator getInstance()
//    {
//        if (instance==null) instance = new DBOperator();
//        return instance;
//    }
//    /**
//     * Copy database file
//     * From assets folder (in the project) to android folder (on device)
//     */
//    public static void copyDB(Context context) throws IOException,FileNotFoundException{
//        String path = DatabaseHelper.DATABASE_PATH;
//        File file = new File(path);
//        if (!file.exists()){
//            //file.mkdirs();
//            DatabaseHelper dbhelper = new DatabaseHelper(context);
//            dbhelper.getWritableDatabase();
//            InputStream is = context.getAssets().open(DatabaseHelper.DATABASE_NAME);
//            OutputStream os = new FileOutputStream(file);
//            byte[] buffer = new byte[1024];
//            int length;
//            while ((length = is.read(buffer))>0){
//                os.write(buffer, 0, length);
//            }
//            is.close();
//            os.flush();
//            os.close();
//        }
//    }
//
//    /**
//     * execute sql without returning data, such as alter
//     * @param sql
//     */
//    public void execSQL(String sql) throws SQLException
//    {
//        db.execSQL(sql);
//    }
//    /**
//     * execute sql such as update/delete/insert
//     * @param sql
//     * @param args
//     * @throws SQLException
//     */
//    public void execSQL(String sql, Object[] args) throws SQLException
//    {
//        db.execSQL(sql, args);
//    }
//    /**
//     * execute sql query
//     * @param sql
//     * @param selectionArgs
//     * @return cursor
//     * @throws SQLException
//     */
//    public Cursor execQuery(String sql,String[] selectionArgs) throws SQLException
//    {
//        return db.rawQuery(sql, selectionArgs);
//    }
//    /**
//     * execute query without arguments
//     * @param sql
//     * @return
//     * @throws SQLException
//     */
//    public Cursor execQuery(String sql) throws SQLException
//    {
//        return this.execQuery(sql, null);
//    }
//    /**
//     * close database
//     */
//    public void closeDB()
//    {
//        if (db!=null) db.close();
//    }
//
//    public boolean checkUserExist (String Tester_ID, String password){
//        String[] columns ={"Tester_ID"};
//        String selection = "Tester_ID=? and Tester_Pass=?";
//        String[] selectionArgs ={Tester_ID,password};
//
//        Cursor cursor = db.query(Tester_TABLE, columns, selection,selectionArgs,null,null,null,null);
//        int count = cursor.getCount();
//        cursor.close();
//        closeDB();
//
//        if (count>0){
//            return true;
//        }else{
//            return false;
//        }
//
//    }
//    public boolean checkManagerExist(String managerusername, String password){
//        String []columns={"Manager_ID"};
//        db = SQLiteDatabase.openDatabase(DatabaseHelper.DATABASE_PATH,null,SQLiteDatabase.OPEN_READWRITE);
//        String selection ="Manager_ID=? and Manager_Pass=?";
//        String[] selectionArgs={managerusername,password};
//
//        Cursor cursor = db.query(Manager_TABLE,columns,selection,selectionArgs,null,null,null);
//        int count = cursor.getCount();
//        cursor.close();
//        closeDB();
//        if(count>0){
//            return true;
//        }else {
//            return false;
//        }
//
//    }
//}