package server;

import java.sql.*;

public class Database {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement createUserStatement;
    private static PreparedStatement getUserNicknameStatement;


    public static void connect()  {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:mainDB.db");
            statement = connection.createStatement();
//            prepareAllStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Connected to the database");



    }
    public static void disconnect() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public static void prepareAllStatement() throws SQLException {
//        createUserStatement = connection.prepareStatement("INSERT INTO user (login, password, nickname) VALUES (?, ?, ?);");
//        getUserNicknameStatement = connection.prepareStatement("SELECT nickname FROM user WHERE login = ? AND password = ?;");
//    }

    public static void createUser(String login, String password, String nickname) {
        try {
            createUserStatement = connection.prepareStatement("INSERT INTO user (login, password, nickname) VALUES (?, ?, ?);");
            createUserStatement.setString(1, login);
            createUserStatement.setString(2, password);
            createUserStatement.setString(3, nickname);
            createUserStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static String getUserNickname (String login, String password) {
        String nickname = null;
        try {
            getUserNicknameStatement = connection.prepareStatement("SELECT nickname FROM user WHERE login = ? AND password = ?;");
            getUserNicknameStatement.setString(1, login);
            getUserNicknameStatement.setString(2, password);
            ResultSet rs = getUserNicknameStatement.executeQuery();
            if (rs.next()) {
                nickname = rs.getString(1);
            } else {
                nickname = "null";
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nickname;
    }
}
