public class UserService {

    // Example method that validates user credentials
 
    public boolean validateUser(String username, String password, String email) {
        // Check if username meets length requirements
        if (username == null || username.length() < 5) {
            System.out.println("Username must be at least 5 characters long.");
            return false;
        }
        
        // Check if password contains special characters
        if (!password.matches(".[!@#$%^&()].*")) {
            System.out.println("Password must contain at least one special character.");
            return false;
        }

        // If validation passes
        return true;
    }
}