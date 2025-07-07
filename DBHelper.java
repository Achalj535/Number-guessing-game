import java.sql.*;

class DBHelper {
    Connection conn;

    public DBHelper() {
        try {
            // Connect to MySQL
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/numberguessinggame",
                "root",
                "ROOT"
            );

            // Create table if not exists
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS gameresult (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "username VARCHAR(100), " +
                "attempts INT, " +
                "result VARCHAR(50), " +
                "played_at DATETIME DEFAULT CURRENT_TIMESTAMP)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveResult(String username, int attempts, String result) {
        try {
            String query = "INSERT INTO gameresult (player_name, score, result) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setInt(2, attempts);
            pstmt.setString(3, result);
            pstmt.executeUpdate();
            System.out.println("Data inserted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
