# find_a_sitter_spring
Spring backend for find a sitter

The backend is written in Java with the Spring framework.

The spring framework uses Dependency injection(DI) and inversion of control (IOC) to make our application loosely coupled.

## about the application.

We are using Json Web Tokens(JWT) and spring security to manage our sessions and Hibernate to map our entities to the database,
this approch gets us fast and easy methods for saving and retriving data.

We needed a lot of data in the application to streestest how it handles under the load, for that we used 2 dependencies.
Spring-shell, which gives us an interactive shell for running custom commands (methods to populate the database with dummy data).
And Faker, a dependency to get dummy data like names, cities, quotes etc.

Combined made we 3 shell commands to populate the database.

#### generate_roles
#### generate_users
#### generate_ratings

When running the backend, use these to commands (in that order) via the shell(run terminal) to populate the database. 

