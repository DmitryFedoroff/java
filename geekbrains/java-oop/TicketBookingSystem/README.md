# Ticket Booking System

## Description:

Develop a ticket booking system that facilitates the purchase of tickets for various routes on specified dates. The system should be able to handle user information, including their payment details, and maintain a record of all available tickets and their statuses. The system should also be able to process payments and update the ticket status upon successful transactions.

The system should be divided into several modules, each responsible for a specific functionality:

__User Management Module__:

- Create and manage user profiles, including their payment details

- Retrieve user information based on different criteria such as ID or username

__Ticket Management Module__:

- Maintain a database of all available tickets, including their route numbers and dates

- Update ticket status upon purchase

__Payment Processing Module__:

- Handle payment authorizations and transactions

- Facilitate transactions between users and carriers

__Carrier Management Module__:

- Maintain a database of all carriers and their payment details

__Customer Service Module__:

- Allow users to search for tickets based on date and route number

- Facilitate the ticket purchasing process, including payment authorization and ticket status update

Ensure to implement the Singleton pattern for repository classes to maintain a single instance throughout the application runtime. Implement appropriate error handling to manage exceptions gracefully and provide meaningful feedback to the users.

The system should be developed in Java, utilizing Object-Oriented Programming principles to ensure modularity and scalability. Proper documentation should be maintained for each class and method to facilitate easy understanding and future maintenance of the system.

Remember to adhere to coding best practices, including proper naming conventions, to ensure the code is clean and maintainable. 
