# CS 5004 Module 11 - Composition in Java

The main goal of this project is to demonstrate the use of composition in Java.

## Description

This project contains two examples. The first example is a `Pet` class that does not use composition. The second example is a `Pet` class that uses composition. The purpose of these examples is to illustrate the difference between using and not using composition in object-oriented programming.

## Advantages of Using Composition

Composition is a design principle in object-oriented programming where a class is designed to contain instances of other classes. These other classes are often referred to as "components". Here are some advantages of using composition:

1. **Code Reusability**: Composition allows for code reusability. For example, in the `Pet` class, the `Diet`, `Habitat`, and `Health` classes are reused. This means that the same `Diet`, `Habitat`, or `Health` class can be used in any other class that requires these functionalities.

2. **Flexibility**: Composition provides flexibility in the sense that it is easy to change the behavior of a class at runtime by changing the classes it composes. This is in contrast to inheritance, where the behavior of a class is set at compile time.

3. **Simplicity**: Composition simplifies the design of complex systems by allowing you to build more complex objects by combining simpler ones. Each individual component can be understood in isolation.

4. **Loose Coupling**: Composition allows for loose coupling between classes. The composed classes can be developed and tested independently of each other.

5. **Eliminates "is-a" relationship**: Unlike inheritance, which is based on an "is-a" relationship (a subclass is a type of the superclass), composition is based on a "has-a" relationship (a class has a component). This can often be a more natural way to model real-world relationships.

In the `Pet` class example, the `Pet` class has a `Diet`, `Habitat`, and `Health`. This is a more natural way to model the relationship, as a pet doesn't inherit from a diet, habitat, or health, but rather, it has these components.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them:

- Java Development Kit (JDK)
- IntelliJ IDEA 2023.3.5

### Installing

A step by step series of examples that tell you how to get a development environment running:

1. Clone the repository to your local machine.
2. Open the project in IntelliJ IDEA.
3. Build and run the project.

## Running the examples

To run the examples, navigate to the `Pet` class in the project structure and run the main method. Observe the output and compare the behavior of the `Pet` class in both examples.