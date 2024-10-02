package com.ssafy.board.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Mysql DB 연결 객체를 제공해주고, 사용했던 자원을 해제하는 기능을 제공하는 클래스입니다.
 * 그니까 미리 연결을 다 뚫어준 것!!
 */
public class DBUtil {
	/**
     * DB 접속에 필요한 url을 작성한다.
     * url은 jdbc:mysql://[host][:port]/[database][?propertyName1][=propertyValue1]형태로 작성한다.
     * serverTimezone=UTC 클라이언트와 서버 시간대 명시적으로 설정하는 옵션 
     * UTC(Coordinated Universal Time, 협정 세계시)는 세계 시간의 표준으로, 영국 그리니치 천문대를 기준으로 한 시간
     */
	// DB와 연결하기위해 필요한 DB의 URL
	private final String url = "jdbc:mysql://localhost:3306/ssafy_board?serverTimezone=UTC";
	// DB의 USER 이름
	private final String username = "ssafy";
	// 위 USER의 PASSWORD
	private final String password = "ssafy";
	// Mysql 드라이버 클래스 이름
	private final String driverName = "com.mysql.cj.jdbc.Driver";

	/**
     * Singleton Design Pattern을 적용해준다.
     */
    private static DBUtil instance = new DBUtil();

    private DBUtil() {
        // JDBC 드라이버를 로딩한다. 드라이버 로딩은 객체 생성 시 한번만 진행하도록 하자.
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static DBUtil getInstance() {
        return instance;
    }
    /**
     * DriverManager를 통해 Connection을 생성하고 반환한다.
     *
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException{
    	return DriverManager.getConnection(url, username, password);
    }
    
    // 종료
    // 반환값이 없는 INSERT문이나 UPDATE문을 했을 경우 resultSet을 사용하지 않는다.
    // 그러면 종료할 때 종료해야할 객체가 rs, stmt, conn가 아닌 stmt, conn를 종료하게 되는데
    // 이런 경우 close() 안에 parameter의 수가 달라지므로 메소드 오버로딩을 해야하지만!!
    // AutoCloseable을 사용하면 알아서 해준다..

	/**
     * 사용한 리소스들을 정리한다.
     * Connection, Statement, ResultSet 모두 AutoCloseable 타입이다.
     * ... 을 이용하므로 필요에 따라서
     * select 계열 호출 후는 ResultSet, Statement, Connection
     * dml 호출 후는 Statement, Connection 등 다양한 조합으로 사용할 수 있다.
     *
     * @param closeables
     */
    public void close(AutoCloseable... closeables) {
        for (AutoCloseable c : closeables) {
            if (c != null) {
                try {
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}