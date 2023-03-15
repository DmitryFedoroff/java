public class Main {

    public static void main(String[] args) {
        TotalPeopleInputValidator totalPeopleInputValidator = new TotalPeopleInputValidator();

        System.out.print("Enter number of people: ");
        int totalPeople = totalPeopleInputValidator.validate();

        PeopleAgeInputValidator peopleAgeInputValidator = new PeopleAgeInputValidator(totalPeople);

        System.out.print("Enter age of people: ");
        int[] peopleAges = peopleAgeInputValidator.validate();

        int result = InvitationCounter.countInvites(totalPeople, peopleAges);

        System.out.printf("Total number of birthday invitations: " + result);

        totalPeopleInputValidator.closeScanner();
        peopleAgeInputValidator.closeScanner();
    }
}