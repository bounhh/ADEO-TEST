# Java - Spring

## My Event

* My Event is an application to manage musical events.


## Technical stack

* This is a maven project.
* It uses HSQLDB as an in-memory database.
* It starts using this maven lifecycle ```mvn spring-boot:run``` or using the IDE
* The user interface is available at [http://localhost:8080]
* The API resources are available at [http://localhost:8080/api/] 

## Context

* The user interface is tested and holds no identified issues. 
* We Identified a few things not working on the API.
* Your job is to fix the issues and add a new feature to the API.

## Identified Issues:

```
Please keep track (notes) of how you analysed and fixed the issues to help us 
understand the steps during the interview
```

1. Adding review does not work
2. Using the delete button works but elements comes back when i refresh the page 

## New Feature
```
Except for the testing libraries, No library/modules should be added to the dependencies
(use only pure java)
```

1. We would like to enable a new route for the API `/search/{query}`. It will allow us
to display filtered `events`.
The events are displayed only if at least one band has a member with the name matching the given
pattern.

Example: `/search/Wa`
```json
[{
    "title": "GrasPop Metal Meeting",
    "imgUrl": "img/1000.jpeg",
    "bands": [{
        "name": "Metallica",
        "members": [
            {
              "name": "Queen Anika Walsh"
            }
        ]
    },…
}…]
```

2. (BONUS) Add a `[count]` at each event and band 
to display the number of child items.

Example: `/search/Wa`
```json
[{
    "title": "GrasPop Metal Meeting [2]",
    "imgUrl": "img/1000.jpeg",
    "bands": [{
        "name": "Metallica [1]",
        "members": [
            {
              "name": "Queen Anika Walsh"
            }
        ]
    },…
}…]
```

## Team Appreciation

Team overall appreciation will be based on:
- Code readability, structure and consistency
- Tests, how they are written
- Bonus: usage of Functional concepts
