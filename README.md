package cn.day16.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
account表 添加一条记录insert语句
*/
public class JDBCTest03 {
    public static void main(String[] args) throws SQLException {
            Statement stmt = null;
            Connection conn = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //定义sql
            String sql = "insert into account values(null,'wangwu',3333)";
            //获取Connection对象
            conn = DriverManager.getConnection("jdbc:mysql:///zmw","root","123456");
            //获取执行sql的对象 Statement
            stmt = conn.createStatement();
            //执行sql
            int count = stmt.executeUpdate(sql);//影响的行数
            //处理结果
            System.out.println(count);
            if(count > 0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            //避免空指针异常
          /*  conn.close();
            stmt.close();*/
          if(stmt != null){
              try{
                  stmt.close();
              }catch(SQLException e){
                  e.printStackTrace();
              }
            }
            if(conn != null){
                try{
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
