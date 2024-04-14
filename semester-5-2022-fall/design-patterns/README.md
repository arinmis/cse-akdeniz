# Design principles

1. Encapsulate what varies  
Identify the aspects of your application that vary and separate them from what stays the same.

2. Program to an interface, not an implementation   
It means program to a supertype.

3. Favor composition over inheritance  
Has-A can be beter than IS-A.

4. The Open-Closed Principle  
Classes should be open for extension, but closed for modification.

5. The Dependency Inversion   
Depend upon abstractions. Do not depend upon concrete classes.
    - No variable should hold a reference to a concrete class.
    - No class should derive from a concrete class.
    - No method should override an implemented method of any of its base classes.
