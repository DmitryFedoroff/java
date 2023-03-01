
![](https://upload.wikimedia.org/wikipedia/ru/4/48/Geekbrains_logo.svg)

# Advanced Exceptions Handling

## 🟥 Task

- Create a static method that takes three parameters as input: `login`, `password` and `confirmPassword`
- The `login` must contain only `Latin letters`, `digits` and `underline character`
- The length of `login` must be less than `20` characters. If `login` does not meet these requirements, a `WrongLoginException` must be thrown
- The `password` must contain only `Latin letters`, `digits` and `underline character`. The length of `password` must be less than `20` characters. Also `password` and `confirmPassword` must be equal
- If `password` does not meet these requirements, a `WrongPasswordException` must be thrown
- `WrongPasswordException` and `WrongLoginException` are custom exception classes with two constructors - one by default, the second takes the exception message and passes it to the `Exception` class constructor
- Exceptions are handled inside the method
- Method returns `true` if values are true or `false` otherwise

Please note: This practical assignment is required for the final training document.

## 🟩 Project structure

```txt
java/
└─ geekbrains/
   └─ java-exceptions/
      └─ AdvancedExceptionsHandling/
         ├─ src/
         │  ├─ Main.java
         │  ├─ Registration.java
         │  ├─ WrongLoginException.java
         │  └─ WrongPasswordException.java
         ├─.gitignore
         └─ README.md
```

The Java Advanced Exception Handling project is structured in one directory. Each change in the contents of this directory will be reflected in the table below.

Directories and files                                        | Description
-------------------------------------------------------------|-----------------------------------------------------------------
`AdvancedExceptionsHandling/`                                | Project file directory
`AdvancedExceptionsHandling/src/`                            | Source code file directory
`AdvancedExceptionsHandling/src/Main.java`                   | Class that is entry point for program
`AdvancedExceptionsHandling/src/Registration.java`           | Class checks validity of login and password
`AdvancedExceptionsHandling/src/WrongLoginException.java`    | Custom exception class for login 
`AdvancedExceptionsHandling/src/WrongPasswordException.java` | Custom exception class for password
`AdvancedExceptionsHandling/.gitignore`                      | File specifies which files or parts of project should be ignored by Git
`AdvancedExceptionsHandling/README.md`                       | File contains task, description of project structure and solution

## 🟦 Solution

<details>
<summary><b>Main class</b></summary>

The `Main` class is the entry point for the program, containing the `main()` method that executes when the program is run. The `Main` class initializes the `login`, `password` and `confirmPassword` variables with sample values, calls the `register()` method of the `Registration` class with those variables, and outputs a message indicating whether the registration was successful or not.

</details>

<details>
<summary><b>Registration class</b></summary>

The `Registration` class contains the `register()` method that takes in the `login`, `password` and `confirmPassword` strings as parameters. This method calls two private methods `validateLogin()` and `validatePassword()` to validate the `login` and `password` strings. If both validations pass, the register method returns `true`, indicating that the registration was successful. If either validation fails, the register method catches the corresponding exception and returns `false`, indicating that the registration failed.

The `validateLogin()` method checks if the `login` string matches a regex pattern `^[A-Za-z0-9_]{1,19}$` that allows for Latin letters, numbers, and underscores and is no longer than 19 characters. If the login string doesn't match the pattern, the method throws a `WrongLoginException`.

The `validatePassword()` method checks if the password string matches a similar regex pattern to the `login` string and is no longer than 19 characters. If the `password` string doesn't match the pattern, the method throws a `WrongPasswordException` with a message indicating the password requirements. The method also checks if the `password` string matches the `confirmPassword` string. If the `password` and `confirmPassword` don't match, the method also throws a `WrongPasswordException`.

</details>

<details>
<summary><b>WrongLoginException and WrongPasswordException classes</b></summary>

The `WrongLoginException` and `WrongPasswordException` classes extend the `Exception` class, which means they are custom exception classes that can be thrown in the program. The `WrongLoginException` class has two constructors, one with a default message and another that takes in a custom message. The `WrongPasswordException` class also has two constructors, one that takes in a custom message and another with a default message.

</details>

## 🟫 Git


