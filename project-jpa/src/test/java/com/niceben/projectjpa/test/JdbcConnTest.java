package com.niceben.projectjpa.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@ExtendWith({SpringExtension.class})
public class JdbcConnTest {


    @Test
    public void testJdbc() throws Exception {
        // 1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 2.创建和数据库之间的连接
        String username = "root";
        String passport = "123456";
        String url = "jdbc:mysql://127.0.0.1:3306/mysqlConn?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=GMT%2b8&nullCatalogMeansCurrent=true";
        Connection conn = DriverManager.getConnection(url, username, passport);
        // 3.准备发送SQL
        String sql = "select * from t_person";
        PreparedStatement ps = conn.prepareStatement(sql);
        // 4.执行SQL，接收结果集
        ResultSet rs = ps.executeQuery();
        // 5.处理结果集
        while (rs.next()) {
            int personId = rs.getInt("person_id");
            String personName = rs.getString("person_name");
            int age = rs.getInt("age");
            String sex = rs.getString("sex");
            String mobile = rs.getString("mobile");
            String address = rs.getString("address");
            System.out.println("personId=" + personId +
                    ",personName=" + personName +
                    ",age=" + age +
                    ",sex=" + sex +
                    ",mobile=" + mobile +
                    ",address=" + address);
        }
        // 6.释放资源
        rs.close();
        ps.close();
        conn.close();
    }
}
