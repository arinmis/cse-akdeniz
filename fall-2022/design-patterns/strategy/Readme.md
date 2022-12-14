# Strategy Pattern

Defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorihtm vary independently from cliens that use it.  
With strategy pattern we are able _change objects behavior at runtime_.

## Duck Simulator

Duck simulator is a sample application. There are different kinds of duck that sounds and fly differently. Inherting quack behaviour from _Duck_ abstract class is not an optimal way, since not all of he ducks sound in a same way. UML diagram below explain the code in _src_ directory:

<div class="center">
![strategy](https://user-images.githubusercontent.com/56651041/207471042-74aaf6e7-f23e-4a3b-9845-c5bb118a4213.png)
</div>
