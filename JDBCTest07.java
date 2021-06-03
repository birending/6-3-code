package cn.day16.code;

import java.sql.*;

public class JDBCTest07 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///zmw", "root", "123456");
            String sql = "select *from account";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            /*rs.next();
            int id = rs.getInt(3);
            String name = rs.getString(2);
            double balance = rs.getDouble(1);
            System.out.println(id + "---" + name + "---" + balance + "---");*/

            while(rs.next()){
                int id = rs.getInt(3);
                String name = rs.getString(2);
                double balance = rs.getDouble(1);
                System.out.println(id + "---" + name + "---" + balance + "---");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}