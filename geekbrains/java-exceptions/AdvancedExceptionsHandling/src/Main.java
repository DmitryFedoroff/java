public class Main {

    public static void main(String[] args) {
        String login = "NumsLettersLatin_91";
        String password = "19_LatinLettersNums";
        String confirmPassword = "19_LatinLettersNums";

        boolean isRegistered = Registration.register(login, password, confirmPassword);

        if (isRegistered) {
            System.out.println("Registration successful");
        } else {
            System.out.println("Registration failed");
        }
    }
}
