public class Main {

    public static void main(String[] args) {
        ArrayLenInputValidator arrayLenInputValidator = new ArrayLenInputValidator();

        System.out.print("Enter number of classrooms: ");
        int n = arrayLenInputValidator.validate();

        ArrayNumsInputValidator classCapsInputValidator = new ArrayNumsInputValidator(n);

        System.out.print("Enter capacity of each classroom: ");
        int[] roomCaps = classCapsInputValidator.validate();

        System.out.print("Enter number of groups: ");
        int m = arrayLenInputValidator.validate();

        ArrayNumsInputValidator groupSizesInputValidator = new ArrayNumsInputValidator(m);

        System.out.print("Enter number of students in each group: ");
        int[] groupSizes = groupSizesInputValidator.validate();

        ClassroomSeating classroomSeating = new ClassroomSeating();
    }
}