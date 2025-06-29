package engineering;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlInjectionExample {

    /**
     * Inline concatenation in the call — should trigger the "inline concat" check.
     */
    public void fetchUserInline(String userId) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:test");
        Statement stmt = conn.createStatement();
        // inline string concatenation in executeQuery()
        stmt.executeQuery("SELECT * FROM users WHERE id = " + userId);
    }

    /**
     * Concatenation via a local variable — should trigger the "variable initializer" check.
     */
    public void fetchUserViaVariable(String userId) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:test");
        Statement stmt = conn.createStatement();
        // build the SQL in a variable
        String sql = "SELECT * FROM users WHERE id = " + userId;
        // then pass it in
        stmt.executeQuery(sql);
    }

    /**
     * PrepareStatement with concatenation — should trigger on prepareStatement().
     */
    public void fetchUserWithPrep(String userId) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:test");
        // inline concatenation in prepareStatement()
        PreparedStatement ps = conn.prepareStatement(
            "SELECT * FROM users WHERE id = " + userId
        );
        ps.executeQuery();
    }
}