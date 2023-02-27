class WrongPasswordException extends Exception {

    public WrongPasswordException(String message) {
        super(message);
    }

    public WrongPasswordException() {
        super("Password must contain only Latin letters, numbers and underscores, and be less than 20 characters long");
    }
}
