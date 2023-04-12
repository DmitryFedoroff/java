public class Main {

    public static void main(String[] args) {
        AbsoluteAddrInputValidator absoluteAddrInputValidator = new AbsoluteAddrInputValidator();

        System.out.print("Enter absolute address: ");
        String inputPath = absoluteAddrInputValidator.validate();

        CanonicalPath canonicalPath = new CanonicalPath();
    }
}