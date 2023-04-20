public class Main {

    public static void main(String[] args) {
        TotalAppInputValidator totalAppInputValidator = new TotalAppInputValidator();
        AppDescInputValidator appDescInputValidator = new AppDescInputValidator();

        System.out.print("Enter number of applications: ");
        int totalApplications = totalAppInputValidator.validate();

        ApplicationFinder applicationFinder = new ApplicationFinder();
        int result = applicationFinder.findMaxApplications(totalApplications, appDescInputValidator);

        System.out.print("Max number of applications that can be fulfilled: " + result);

        totalAppInputValidator.closeScanner();
        appDescInputValidator.closeScanner();
    }
}