import java.sql.*;

public class LoginDao {

    String sql = "select * from login where uname = ? and pass = ?";
    String url = "jdbc:mysql://localhost:3307/teluskologin";
    String db_username = "admin";
    String db_password = "root";

    public boolean check(String username, String password) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, db_username, db_password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
