<<<<<<< HEAD
## AI Conversation platform
=======
---

# AI COnversation platform

This project is a  Spring Boot application that merges sorted `.dat` files from a specified directory into a single output file.

Please Refer - DOC.md for solution approach related details.

## Table of Contents

- [Requirements](#requirements)
- [Project Structure](#project-structure)
- [Setup](#setup)
- [Build and Run](#build-and-run)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [Usage Example](#usage-example)
- [License](#license)

## Requirements

- Java 11 or higher
- Maven 3.6 or higher

## Project Structure

```
Assignment_Mendix
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── org
│   │   │       └── example
│   │   │           ├── controller
│   │   │           │   └── FileMergerController.java
│   │   │           └── service
│   │   │               └── FileMergerService.java
│   │   └── resources
│   └── test
│       └── java
│           └── org
│               └── example
│                   └── controller
│                   |    └── FileMergerControllerTest.java
└── README.md
```

## Setup

1. **Download the Repository and unzip:**

   ```bash
   cd Assignment_Mendix
   ```

2. **Install Dependencies:**

   Ensure you have Maven installed, then run:

   ```bash
   mvn clean install
   ```

## Build and Run

### Building the Project

To build the project, use Maven:

```bash
mvn clean package
```

This command will compile the code, run tests, and package the application into a JAR file located in the `target` directory.

### Running the Application

You can run the application using Maven:

```bash
mvn spring-boot:run
```

## API Endpoints

### POST `/mendix/mergeSortedFiles`

Merges sorted `.dat` files from a specified input directory into a single output file.

- **Request Parameters:**
    - `inputPath` (required): The path to the directory containing the sorted `.dat` files.
    - `outputPath` (required): The path to the output file(not directory but output file path).

- **Sample Request:**

  ```bash
  curl -X POST "http://localhost:8080/mendix/mergeSortedFiles" \
  -d "inputPath=/path/to/input" \
  -d "outputPath=/path/to/output/output.dat"
  ```

- **Response:**
    - `200 OK` if the files are merged successfully.
    - `400 Bad Request` if any required parameter is missing.

## Testing

### Running Unit Tests

To run the unit tests, use the following command:

```bash
mvn test
```

This will execute all the tests in the `src/test/java` directory and provide a summary of the results.

## Usage Example

1. Place your sorted `.dat` files in a directory, for example, `/Users/username/inputFiles`.
2. Run the application.
3. Make a POST request to the `/mendix/mergeSortedFiles` endpoint with the input and output paths.

Example using `curl`:

```bash
curl -X POST "http://localhost:8080/mendix/mergeSortedFiles" \
-d "inputPath=/Users/username/inputFiles" \
-d "outputPath=/Users/username/output/merged.dat"
```

After execution, the merged file will be available at the specified `outputPath` i.e. `merged.dat`.

Reach out at vinayakghatul@gmail.com for any queries/doubts.
>>>>>>> 51b2e88 (Initial commit)
