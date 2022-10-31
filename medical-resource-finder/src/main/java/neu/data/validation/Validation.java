package neu.data.validation;

public class Validation {
    public static boolean isValidString(String s) {
        Boolean isValid = true;
        if (s.isEmpty() || s.isBlank()) isValid = false;
        return isValid;
    }
    
    public static boolean isValidInteger(String s, int radix) {
        Boolean isValid = true;
        if(s.isEmpty()) isValid = false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return isValid;
    }
    
    public static boolean isValidEmail(String email) {
        Boolean isValid = true;
        if (!email.contains("@") || !email.contains(".com")) isValid = false;
        return isValid;
    }
}
