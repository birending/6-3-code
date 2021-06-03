package cn.day16.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
修改表记录
*/
public class JDBCTest04 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //定义sql
            String sql = "update account set count = 1000 where name = 'wangwu'";
            //获取Connection对象
            conn = DriverManager.getConnection("jdbc:mysql:///zmw", "root", "123456");
            //获取执行sql的对象 Statement
            stmt = conn.createStatement();
            //执行sql
            int count = stmt.executeUpdate(sql);
            //处理结果
            System.out.println(count);
            if (count > 0) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
