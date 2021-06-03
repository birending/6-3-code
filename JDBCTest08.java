package cn.day16.code;

import java.sql.*;

public class JDBCTest08 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///zmw", "root", "123456");
            String sql = "select empno,ename,job,sal \n" +
                    "from emp\n" +
                    "group by job\n" +
                    "having avg(sal) between 1000 and 3000\n" +
                    "order by sal desc\n" +
                    "LIMIT 1,2; ";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            /*rs.next();
            int id = rs.getInt(3);
            String name = rs.getString(2);
            double balance = rs.getDouble(1);
            System.out.println(id + "---" + name + "---" + balance + "---");*/
            System.out.println("id" + "---" + "ename" + "---" + "job" + "---" + "sal" + "---");
            while (rs.next()) {
                int id = rs.getInt(1);
                String ename = rs.getString(2);
                String job = rs.getString(3);
                double sal = rs.getDouble(4);
                System.out.println(id + "---" + ename + "---" + job + "---" + sal + "---");
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