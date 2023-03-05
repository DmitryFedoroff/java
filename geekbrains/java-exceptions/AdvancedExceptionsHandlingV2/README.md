
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
         │  └─ Main.java
         ├─.gitignore
         └─ README.md
```

The Java Advanced Exception Handling v2 project is structured in one directory. Each change in the contents of this directory will be reflected in the table below.

Directories and files                      | Description
-------------------------------------------|-----------------------------------------------------------------
`AdvancedExceptionsHandlingV2/`            | Project file directory
`AdvancedExceptionsHandling/src/`          | Source code file directory
`AdvancedExceptionsHandling/src/Main.java` | Class that is entry point for program
`AdvancedExceptionsHandlingV2/.gitignore`  | File specifies which files or parts of project should be ignored by Git
`AdvancedExceptionsHandlingV2/README.md`   | File contains task, description of project structure and solution

## 🟦 Solution

## 🟫 Git

