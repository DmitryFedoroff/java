class WrongLoginException extends Exception {

    public WrongLoginException() {
        super("Password must contain only Latin letters, numbers and underscores, and be less than 20 characters long");
    }

    public WrongLoginException(String message) {
        super(message);
    }
}
