import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordGenerator {

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_+=<>?";

    private static SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        int passwordLength = 12; // Customize the length of the password here
        String password = generatePassword(passwordLength);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length) {
        if (length < 4) {
            throw new IllegalArgumentException("Password length must be at least 4");
        }

        List<Character> passwordChars = new ArrayList<>();

        // Ensure at least one character from each set is included
        passwordChars.add(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        passwordChars.add(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        passwordChars.add(DIGITS.charAt(random.nextInt(DIGITS.length())));
        passwordChars.add(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));

        // Fill the remaining characters
        String allChars = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARS;
        for (int i = 4; i < length; i++) {
            passwordChars.add(allChars.charAt(random.nextInt(allChars.length())));
        }

        // Shuffle the characters to ensure randomness
        Collections.shuffle(passwordChars);

        // Convert the character list to a string
        StringBuilder password = new StringBuilder();
        for (char ch : passwordChars) {
            password.append(ch);
        }

        return password.toString();
    }
}
