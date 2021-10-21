### What is Arduino
- It Consist of two part
  * Circuit board - phisical hardware
  * IDE - Software

### Arduino Coding

  void setup() {
    // setup
  }

  void loop() {
    // put your codes here
  }

#### Chars
char myChar = 'A';  
char myChar = '65';

#### Integer
int age = 21;

#### Boolean
bool isOkay = false; 

#### Constant
LOW  -> 0 
HIGH -> 1 

#### Functions

##### pinMode()
- pinMode(ledPin, OUTPUT);
- pinMode(inPin, iNPUT);
##### Digital Read and Write 
  val = digitalRead(inPin);
  digitalWrite(ledPin, val);
