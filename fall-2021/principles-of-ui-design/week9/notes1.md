### Software Architecture

#### Desing Pattterns for GUIs 
#### View Tree
* Output
	- GUIs change thier output by **mutating** th view tree.
* Input
	- Inputs are attached to listeners 
	- They are associated with view.
* Layout

### Listener Pattern
- GUI input handling is an example
	* aka Pub-Sub, Event, Observer

#### Seperating Frontend from Backend
- View tree and listeners seperates input and output.

#### Model View Controller(MVC)
- View: output 
- Controller: input 
- Model: output


#### How to Seperate Controler and View
##### Widgets: Tightly Coupled View & Controller
- It consists of model&controller
- Reusable view-controller couples
- Also called component
- Examples: scrool bar, button and menubars 


### GUI Implementation Approach
- Procedural Programming
	* Code says *how* to get want you want(flow of control)
	* Code says *what* you want(no flow of control) 
- Declarative Programming
	* HTML, latex, 
	* Databases(SQL)
- Direct Programming
	* Creating what you want in a direct manipulation


#### Procedural
1. Put down block A
2. Put block B on block A
3. Put block C on block B

#### Declarative 
- A tower of 3 blocs

#### Direct manipulation
- Put 3 box with drag and drop


