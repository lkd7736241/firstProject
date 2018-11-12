package com.sun.Insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * create by qiulisun on 2018/11/12.<br>
 */
public class InsertTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        final String jdbcDriver = "com.mysql.jdbc.Driver";
        final String jdbcUrl = "jdbc:mysql://localhost:3306/xiuzhenyuan?characterEncoding=UTF-8&useSSL=false&useAffectedRows=true";
        final String jdbcUsername = "root";
        final String jdbcPassword= "993972";

        Connection connection = null;

        Class.forName(jdbcDriver);
        connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

        if (connection != null) {
            System.out.println("获取连接成功");
            insert(connection);
        } else {
            System.out.println("获取连接失败");
        }
    }

    private static void insert(Connection connection) {
        // 开始时间
        long begin = new Date().getTime();
        //sql前缀
        String prefix = "INSERT INTO application_form " +
                "(name, qq, type, admission_time, graduate_school, studentIdOnWeb, daily_link, " +
                "slogan, brother, message_channel, create_at, update_at)" +
                "VALUES";
        try {
            //sql后缀
            StringBuffer suffix = new StringBuffer();
            //设置事务为非自动提交
            connection.setAutoCommit(false);
            //准备执行语句
            PreparedStatement preparedStatement = connection.prepareStatement("");
            // 外层循环，提交事务次数
            String qq = null;
            int count = 0;
            for (int i = 1; i <= 100; i++) {
                suffix = new StringBuffer();
                //内层循环，每次提交的数据条数
                for (int j = 1; j <= 10000; j++) {
                    //构建sql后缀
                    count = (i-1)*10000 + j;
                    qq = "suzhengrong" + String.valueOf(count);
                    suffix.append("('苏正荣', '" + qq + "', 'Android工程师', 1537027200011, '" +
                            "淮海工学院东港学院11', 'Android-591', 'http://www.jnshu.com/school/23273/daily" +
                            "', '如果我不能在IT特训营拼尽全力，为自己以后的修行路上打好基础，就让我变胖2吨！', '汪开放" +
                            "', '知乎', 1539569662011, 1539569662011),");
                }
                //构建完整的sql语句
                String sql = prefix + suffix.substring(0, suffix.length() - 1);
                //添加sql
                preparedStatement.addBatch(sql);
                //执行
                preparedStatement.executeBatch();
                //提交事务
                connection.commit();
                //清空上一次执行的数据
                suffix = new StringBuffer();
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        //结束时间
        long end = new Date().getTime();
        //耗时
        System.out.println("100万条数据插入花费时间：" + (end - begin)/1000 + " s");
        System.out.println("插入完成");
    }
}
