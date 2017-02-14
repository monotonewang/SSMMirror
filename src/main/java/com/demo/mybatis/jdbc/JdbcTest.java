package com.demo.mybatis.jdbc;


import java.sql.*;

/**
 * Created by 7 on 2017/1/18.
 */
//  Jdbc的问题
//	1、数据库连接频繁的创建和关闭，缺点浪费数据库的资源，影响操作效率
//	设想：使用数据库连接池
//	2、sql语句是硬编码，如果需求变更需要修改sql，就需要修改java代码，需要重新编译，系统不易维护。
//	设想：将sql语句 统一配置在文件中，修改sql不需要修改java代码。
//	3、通过preparedStatement向占位符设置参数，存在硬编码（ 参数位置，参数）问题。系统不易维护。
//	设想：将sql中的占位符及对应的参数类型配置在配置文件中，能够自动输入 映射。
//	4、遍历查询结果集存在硬编码（列名）。
//	设想：自动进行sql查询结果向java对象的映射（输出映射）。
public class JdbcTest {
	public static void main(String[] args) {
		Connection connection = null;
		//PreparedStatement是预编译的Statement，通过Statement发起数据库的操作
		//PreparedStatement防止sql注入，执行数据库效率高
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			//加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");

			//通过驱动管理类获取数据库链接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?characterEncoding=utf-8", "root", "root");
			//定义sql语句 ?表示占位符
			String sql = "SELECT * FROM USER WHERE username = ?";
			//获取预处理statement
			preparedStatement = connection.prepareStatement(sql);
			//设置参数，第一个参数为sql语句中参数的序号（从1开始），第二个参数为设置的参数值
			preparedStatement.setString(1, "admin");
			//向数据库发出sql执行查询，查询出结果集
			resultSet = preparedStatement.executeQuery();
			//遍历查询结果集
			while (resultSet.next()) {
				System.out.println(resultSet.getString("id") + "  " + resultSet.getString("username"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//释放资源
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

	}
}
