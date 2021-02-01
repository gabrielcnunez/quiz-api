Quiz API
=============================
## Overview

In this assignment students are tasked with creating a small RESTful API that simulates a backend for a quiz-like application. Students should begin by constructing a reasonable database model using the summary below. After they've completed their model and generated their database with JPA, they should then implement the endpoints listed at the end of this README file.

### Summary of the API

This quiz application should contain three entities: `Quiz`, `Question`, and `Answer`. Each should have a generated numerical primary key. A `Quiz` should have a name and maintain a collection of `Question` entities that are part of that quiz. A `Question` should have a text field and a collection of possible `Answer` objects. An `Answer` should also have a text field and a field which determines if the `Answer` is the correct one for the `Question` it belongs to.

---

This assignment is intentionally lacking in it's description of required services, queries, and entities/models. It is up to the student to decide how to model the requests, responses, and organize the business logic, and how to best utilize JPA/Hibernate to persist data in order to meet the specified requirements.

### Requirements

In this assignment students should use the short summary above to construct a data model and implement a database using JPA/Hibernate. After they've constructed their data model they should implement the following endpoints:

- [ ] `GET quiz`
    - Returns the collection of `Quiz` elements

- [ ] `POST quiz`
    Creates a quiz and adds to collection
    - Returns the `Quiz` that it created

- [ ] `DELETE quiz/{id}`
    Deletes the specified quiz from collection
    - Returns the deleted `Quiz`

- [ ] `PATCH quiz/{id}/rename/{newName}`
    Rename the specified quiz using the new name given
    - Returns the renamed `Quiz`

- [ ] `GET quiz/{id}/random`
    - Returns a random `Question` from the specified quiz

- [ ] `PATCH quiz/{id}/add`
    Adds a question to the specified quiz
    - Receives a `Question`
    - Returns the modified `Quiz`
    
- [ ] `DELETE quiz/{id}/delete/{questionID}`
    Deletes the specified question from the specified quiz
    - Returns the deleted `Question`
