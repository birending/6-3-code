package cn.day16.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest05 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///zmw","root","123456");
            String sql = "insert into account values(3000,'lilili',null),(4000,'liu',null),(5000,'zhu',null)";
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            if (count > 0){
                System.out.println("插入成功");
            }else{
                System.out.println("插入失败");
            }
            System.out.println(count);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
