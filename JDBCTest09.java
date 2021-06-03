package cn.day16.code;

import java.sql.*;

public class JDBCTest09 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///zmw", "root", "123456");
            String sql = "select e.ename,e.sal,d.dname,s.grade from emp e join dept d on e.deptno = d.deptno join salgrade s on e.sal between s.losal and s.hisal; ";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            /*rs.next();
            int id = rs.getInt(3);
            String name = rs.getString(2);
            double balance = rs.getDouble(1);
            System.out.println(id + "---" + name + "---" + balance + "---");*/
            System.out.println("id" + "---" + "ename" + "---" + "dname" + "---" + "sal" + "---");
            while (rs.next()) {
                int id = rs.getInt(4);
                String ename = rs.getString(1);
                String dname = rs.getString(3);
                double sal = rs.getDouble(2);
                System.out.println(id + "---" + ename + "---" + dname + "---" + sal + "---");
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