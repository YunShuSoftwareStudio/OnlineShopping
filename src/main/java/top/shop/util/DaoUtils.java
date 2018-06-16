package top.shop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoUtils {
	private static final DaoUtils DAO_UTILS=new DaoUtils();
	
	private DaoUtils() {
		
	}
	
	public static DaoUtils getDaoUtils() {
		return DAO_UTILS;
	}
	
	static Connection conn=null;
	/**
     * 得到数据库连接
     * @throws ClassNotFoundException
     * @throws SQLException
     * @return 数据库连接
     */
    public static Connection getConn(){
    	String URL="jdbc:sqlserver://127.0.0.1:1433;DataBaseName=fruit";
        try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(URL,"sa","kingston");  //获得数据库连接
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}      
        return conn ;   //返回连接                                                         
    }
    
    /**
     * 释放资源
     * @param conn 数据库连接
     * @param pstmt PreparedStatement对象
     * @param rs 结果集
     */
    public void closeAll( Connection conn, PreparedStatement pstmt, ResultSet rs ) {
        /*  如果rs不空，关闭rs  */
        if(rs != null){
            try { rs.close();} catch (SQLException e) {e.printStackTrace();}
        }
        /*  如果pstmt不空，关闭pstmt  */
        if(pstmt != null){
            try { pstmt.close();} catch (SQLException e) {e.printStackTrace();}
        }
        /*  如果conn不空，关闭conn  */
        if(conn != null){
            try { conn.close();} catch (SQLException e) {e.printStackTrace();}
        }
    }
    
    /**
     * 执行SQL语句，可以进行增、删、改的操作，不能执行查询
     * @param preparedSql  预编译的 SQL 语句
     * @param param  预编译的 SQL 语句中的‘？’参数的字符串数组
     * @return 影响的条数
     */
    public int executeUpdateSQL(String preparedSql,String[] param,Connection conn) {
        PreparedStatement pstmt = null;
        int               num   = 0;
        /*  处理SQL,执行SQL  */
        try {
            pstmt = conn.prepareStatement(preparedSql);    // 得到PreparedStatement对象
            if( param != null ) {
                for( int i = 0; i < param.length; i++ ) {
                    pstmt.setString(i+1, param[i]);         // 为预编译sql设置参数
                }
            }
            num = pstmt.executeUpdate();                    // 执行SQL语句
        }  catch (SQLException e) {
            e.printStackTrace();                            // 处理SQLException异常
        } finally {
            closeAll(conn,pstmt,null);                     // 释放资源
        }
        return num;
    }
    
    /**
     * 执行SQL语句，可以进行查的操作，不能执行查询
     * @param preparedSql  预编译的 SQL 语句
     * @param param  预编译的 SQL 语句中的‘？’参数的字符串数组
     * @return rs 结果集
     */
    public ResultSet executeQuerySQL(String preparedSql,String[] param,Connection conn) {
        PreparedStatement pstmt = null;
        ResultSet rs=null;
        /*  处理SQL,执行SQL  */
        try {
            pstmt = conn.prepareStatement(preparedSql);    // 得到PreparedStatement对象
            if( param != null ) {
                for( int i = 0; i < param.length; i++ ) {
                    pstmt.setString(i+1, param[i]);         // 为预编译sql设置参数
                }
            }
            rs= pstmt.executeQuery();                    // 执行SQL语句
        }  catch (SQLException e) {
            e.printStackTrace();                            // 处理SQLException异常
        } 
        return rs;
    }
}
