package Util;

import java.sql.*;

public class JDBCUtil {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/JDBC";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "ORBCHAIN";
    static final String PASS = "12345678f";

    String[] transactionHash;

    String[] productNames;

    String[] dates ;

    String[] txDates;

    String[] sellers;

    String[] descriptions;
    public void connect() {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql = "";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                int id  = rs.getInt("transactions");
                String name = rs.getString("productNames");
                String date = rs.getString("dates");
                String seller = rs.getString("sellers");
                String txDate = rs.getString("transactionDate");
                String des = rs.getString("descriptions");

            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}
