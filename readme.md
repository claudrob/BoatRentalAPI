# BoatRentalAPI

This is a Spring Boot application that provides a GraphQL API for a boat rental service.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java 17
- Maven
- An SQL database (H2, PostgreSQL, etc.)

### Installing

1. Clone the repository:

git clone git@github.com:claudrob/BoatRentalAPI.git

2. Navigate to the project directory:

cd BoatRentalAPI

3. Build the project with Maven:

mvn clean install

4. Run the application:
mvn spring-boot:run

The application will start on port 8080.

## API Endpoints

The application provides the following GraphQL API endpoints:

- `/graphql`: The main endpoint for interacting with the GraphQL API.

### How to Interact with the API

You can interact with the API using any HTTP client or a GraphQL client like GraphiQL, etc. Here's an example of how to make a request to the `/graphql` endpoint:

For Examlpe:
http://localhost:8080/graphql

## Query all Pets

query{
 pets{
 	id
	name
  type
	breed
	weight
  vaccinated
  trainingLevel
}
}

## Query by Max WEIGHT

query {
  petsByMaxWeight(maxWeight: 25.0) {
    id
    name
    type
    breed
    weight
    vaccination
    trainingLevel
  }
}

## Query Pet by VACCINATED Status


query {
  petsByVaccinationStatus(vaccinated: true) {
    id
    name
    type
    breed
    weight
    vaccinated
    trainingLevel
  }
}

## Pets by Excluded Breed

query {
  petsByExcludedBreed(excludedBreed: "Poodle") {
    id
    name
    type
    breed
    weight
    vaccinated
    trainingLevel
  }
}

## Query by Eligibility for boat rental.


query {
  eligiblePets(weight: 25.0, vaccinated: true, breed: "Poodle", trainingLevel: 3) {
    id
    name
    type
    breed
    weight
    vaccination
    trainingLevel
  }
}




## Mutations



## Add a Pet

mutation{
  addPet(input: {
    name: "Pancha3"
    type: "Dog"
    breed: "DutchHund"
    weight: 15
    vaccination: true
    trainingLevel: 3
  })
  {
    id
    name
    weight
  }
}

## Delete a PET


mutation {
  deletePet(id: 1)
}


## Update a Pet

mutation {
  updatePet(id: 1, pet: {name: "New Name", 
    type: "New Type", breed: "New Breed", weight: 10.0, vaccination: true, trainingLevel: 5}) {
    name
    type
  }
}

## Database

Currently, the application uses an in-memory H2 database. You can access the H2 console by navigating to http://localhost:8080/h2-console and using the following credentials:
JDBC URL: jdbc:h2:mem:BoatRentalDB
User Name: sa

Currently on startup, the application will create the following tables:
Pet (id, name, type, breed, weight, vaccinated, training_level)

And some sample data will be inserted into the Pet table for testing.


## Running the tests

You can run the tests with the above GraphQL queries using a GraphQL client.

## Pending work and comments:

1. Add a pet owner entity and associate it with the pet entity.
2. Migrate the in-memory H2 database to a PostgreSQL database.
3. Review the vaccinated data type in the pet entity since it is currently a boolean.
4. Set a limit validation to the training level attribute in the pet entity.






