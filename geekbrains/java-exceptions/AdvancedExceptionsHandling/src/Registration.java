public class Registration {

    public static boolean register(String login, String password, String confirmPassword) {
        try {
            validateLogin(login);
            validatePassword(password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    private static void validateLogin(String login) throws WrongLoginException {
        String regex = "^[A-Za-z0-9_]{1,19}$";

        if (!login.matches(regex)) {
            throw new WrongLoginException();
        }
    }

    private static void validatePassword(String password, String confirmPassword) throws WrongPasswordException {
        String regex = "^[a-zA-Z0-9_]{1,19}$";

        if (!password.matches(regex)) {
            throw new WrongPasswordException("Password must contain only Latin letters, numbers and underscores, and be less than 20 characters long");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Password and password confirmation do not match");
        }
    }
}
