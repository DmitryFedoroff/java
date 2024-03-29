import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class UserInputParser {

    public static UserData parse(String input) throws WrongParsingDataException {
        String[] data = input.split(" ");

        if (data.length != 6) {
            throw new WrongParsingDataException("Entered incorrect number of data");
        }

        String lastName = validateName(data[0], "last name");
        String firstName = validateName(data[1], "first name");
        String patronymicName = validateName(data[2], "patronymic name");
        String birthDate = validateBirthDate(data[3]);
        String phoneNumber = validatePhoneNumber(data[4]);
        String gender = validateGender(data[5]);

        return new UserData(lastName, firstName, patronymicName, birthDate, phoneNumber, gender);
    }

    private static String validateName(String name, String type) throws WrongParsingDataException {
        if (!name.matches("^[a-zA-Zа-яА-Я-]+$")) {
            throw new WrongParsingDataException("Parsing error. Invalid format for " + type);
        }
        return name;
    }

    private static String validateBirthDate(String birthDate) throws WrongParsingDataException {
        try {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate date = LocalDate.parse(birthDate, inputFormatter);
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            return date.format(outputFormatter);
        } catch (DateTimeParseException e) {
            throw new WrongParsingDataException("Parsing error. Invalid format for birth date", e);
        }
    }

    private static String validatePhoneNumber(String phoneNumber) throws WrongParsingDataException {
        if (!phoneNumber.matches("^\\d{1,15}$")) {
            throw new WrongParsingDataException("Parsing error. Invalid format for phone number");
        }
        return phoneNumber;
    }

    private static String validateGender(String gender) throws WrongParsingDataException {
        if (!gender.matches("[fm]|other")) {
            throw new WrongParsingDataException("Parsing error. Invalid format for gender");
        }
        return gender;
    }
}
