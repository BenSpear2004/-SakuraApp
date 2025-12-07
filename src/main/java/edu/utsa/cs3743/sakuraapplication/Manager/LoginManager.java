package edu.utsa.cs3743.sakuraapplication.Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginManager {

    // Returns true if credentials are valid
    public static ResultSet authenticate(String username, String password) {

        String sql = "SELECT user_id, username, email FROM users WHERE username = ? AND password = ?";

        try {
            Connection conn = DataBaseManager.getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            return stmt.executeQuery(); // controller will read rs.next()

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
