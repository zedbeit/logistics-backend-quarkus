# miles-backend project

This project is the backend of a Logistics application. This project uses Quarkus, the Supersonic Subatomic Java Framework.

To be able run this project you must have quarkus installed, please visit this link to get started : https://quarkus.io/guides/getting-started.

# Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes,
and also the guidelines to follow to make your contributions to the project.

## Setup
Clone the develop branch to your desktop.
using the `git clone` command.

#### To run the application in development mode:
```
./mvnw compile quarkus:dev
```
#### To run the application in production mode:
```
./mvnw package
```
This command produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.

Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

#### To create a native executable: 
```
./mvnw package -Pnative
```
Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/report-generator-plugin-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

#### Related guides

- RESTEasy JAX-RS ([guide](https://quarkus.io/guides/rest-json)): REST endpoint framework implementing JAX-RS and more

#### RESTEasy JAX-RS example

REST is easy peasy with this Hello World RESTEasy resource.

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)

## Contribution guides
All contributions should be made on a new branch.
