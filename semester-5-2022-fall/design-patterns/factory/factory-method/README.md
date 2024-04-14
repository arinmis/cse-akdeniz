# Factory Method Pattern

Defines an interface for creating an object, but lets subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.

## Pizza Shop

The problem that is solved with the factory method pattern is handling the instantiation of different types of pizzas. There are mainly two types of stores New York and Chicago pizza stores.

<div align="center">
    <img src="https://user-images.githubusercontent.com/56651041/218298531-c6c0bf65-b5f0-4632-b31a-02086bb4bb29.png" alt="uml">
</div>

## Design principles

1. The Dependency Inversion  

Depend upon abstractions. Do not depend upon concrete classes.
- No variable should hold a reference to a concrete class.
- No class should derive from a concrete class.
- No method should override an implemented method of any of its base classes.
