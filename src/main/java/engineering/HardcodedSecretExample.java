package engineering;

public class HardcodedSecretExample {

    // Should trigger SEC_HARDCODED_SECRET
    private static final String PASSWORD = "P@ssw0rd123!";

    // Also triggers on “apiKey”
    private String apiKey = "ABCD-1234-EFGH-5678";

    public void connect() {
        System.out.println("Connecting with password: " + PASSWORD);
    }
}