
![](https://upload.wikimedia.org/wikipedia/ru/4/48/Geekbrains_logo.svg)

# Advanced Exceptions Handling v2

## 🟥 Task

- Write a program that prompts the user to enter the following data in any order, separated by spaces:
`Last Name First Name Patronymic Birth Date Phone Number Gender`

- Data formats:
    - `Last Name`, `First Name`, `Patronymic` - strings
    - `Birth Date` - string format `dd.mm.yyyy`
    - `Phone Number` - unsigned integer without formatting
    - `Gender` - Latin characters `f`, `m` or `other`

- The program should validate the entered data based on the number of fields. If the number of fields does not match the required number, return an error code, handle it and display a message to the user indicating that they entered fewer or more fields than required.

- The program should attempt to parse the entered values and extract the required parameters. If the data formats do not match, an exception should be thrown that corresponds to the type of problem. You can use built-in Java types or create your own. The exception should be handled correctly and the user should be prompted with a message indicating what is incorrect.

- If all data is entered and processed correctly, create a file with the same name as the `Last Name` and write the data to a single line in the following format:

`<Last Name><First Name><Patronymic><Birth Date><Phone Number><Gender>`

- If multiple users have the same `Last Name`, write their data to the same file, each on a separate line.

- If there is a problem with reading from or writing to the file, handle the exception correctly and display the error stack trace to the user.

- Finally, close the file connection.

Please note: This practical assignment is required for the final training document.

## 🟩 Project structure

```txt
java/
└─ geekbrains/
   └─ java-exceptions/
      └─ AdvancedExceptionsHandlingV2/
         ├─ src/
         │  ├─ Main.java
         │  ├─ UserData.java
         │  ├─ UserInputParser.java
         │  └─ WrongParsingDataException.java
         ├─.gitignore
         └─ README.md
```

The Java Advanced Exception Handling v2 project is structured in one directory. Each change in the contents of this directory will be reflected in the table below.

Directories and files                                             | Description
------------------------------------------------------------------|------------------------------------------------------------------------
`AdvancedExceptionsHandlingV2/`                                   | Project file directory
`AdvancedExceptionsHandlingV2/src/`                               | Source code file directory
`AdvancedExceptionsHandlingV2/src/Main.java`                      | Class that is entry point for program
`AdvancedExceptionsHandlingV2/src/UserData.java`                  | Class defines model for storing user data
`AdvancedExceptionsHandlingV2/src/UserInputParser.java`           | Class parses user input and validates each input field
`AdvancedExceptionsHandlingV2/src/WrongParsingDataException.java` | Custom exception class for handling errors during parsing input data
`AdvancedExceptionsHandlingV2/.gitignore`                         | File specifies which files or parts of project should be ignored by Git
`AdvancedExceptionsHandlingV2/README.md`                          | File contains task, description of project structure and solution

## 🟦 Solution

<details>
<summary><b>Main class</b></summary>

The `Main` class contains the `main()` method, which serves as the entry point for the program and calls the `processUserInput()` method. This method prompts the user to enter data in the format `LastName FirstName PatronymicName BirthDate PhoneNumber Gender`. The `processUserInput()` method then calls the static `parse()` method in the `UserInputParser` class to parse the input and create an instance of the `UserData` class. If there is an error during parsing, the method throws a `WrongParsingDataException`. If parsing is successful, the data is written to a text file named after the user's last name.

</details>

<details>
<summary><b>UserData class</b></summary>

The `UserData` class is a data model that represents the user input. It contains variables for `lastName`, `firstName`, `patronymicName`, `birthDate`, `phoneNumber`, and `gender`, a constructor, and a `getLastName()` method. The `toString()` method is also overridden to format the data in the desired `<LastName><FirstName><PatronymicName><BirthDate><PhoneNumber><Gender>` format for writing to a text file.

</details>

<details>
<summary><b>UserInputParser class</b></summary>

The `UserInputParser` class is a utility class that performs validation on the user input and creates an instance of the `UserData` class. The `parse()` method takes the user input string and splits it into its constituent parts (last name, first name, patronymic name, birth date, phone number, gender) and checks the length of the string. Length checking is necessary to ensure that the user has entered only the required data, and has not forgotten or entered extra information.

Each part of the input string is then validated according to specific validation criteria using four static validation methods: `validateName()`, `validateBirthDate()`, `validatePhoneNumber()`, and `validateGender()`. For example, the private static `validatePhoneNumber()` method takes a string variable called `phoneNumber` as a parameter and checks it against a regular expression pattern `^\d{1,15}$`.

If all the data passes validation, the method returns an instance of the `UserData` class, otherwise a `WrongParsingDataException` is thrown.

</details>

<details>
<summary><b>WrongParsingDataException class</b></summary>

The `WrongParsingDataException` is a custom exception that extends the `Exception` class and is used to handle errors that occur during data parsing. It is thrown when the user's input data does not pass validation. It contains constructors with error messages and an exception object that caused the error.

</details>

## 🟫 Git

