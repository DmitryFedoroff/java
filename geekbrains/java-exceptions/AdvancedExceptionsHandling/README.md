
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
         └─ README.md
```

The Java Advanced Exception Handling project is structured in one directory. Each change in the contents of this directory will be reflected in the table below.

Directories and files         | Description
------------------------------|-----------------------------------------------------------------
`AdvancedExceptionsHandling/` | Project file directory
`.gitignore`                  | Specify which files or parts of project should be ignored by Git
`README.md`                   | Task, description of the project structure and solution

## 🟦 Solution

## 🟫 Git

