#include <stdio.h>
#include <math.h>
#include <iostream>
#include <string>
#include <chrono>
#include <iostream>
#include <sys/time.h>
#include <ctime>

using namespace std;

long timeSinceEpochMillisec() {
  using namespace chrono;
  return duration_cast<milliseconds>(system_clock::now().time_since_epoch()).count();
}

long concat(int n)
{
  /// time is broken
  time_t start = timeSinceEpochMillisec(); 
  string temp = "";
  for (int i = 0; i < n; i++) 
  {  
    temp = temp + "a";
  }
  time_t end = timeSinceEpochMillisec(); 
  return end - start;
}

int main()
{
  int times[4];
  for (int i = 0; i < 4; i = i + 1) { 
    int time = (int)pow(10, i + 3);
    cout << concat(time) << flush;
    if (i != 4) 
      cout << "," << flush;
    else
      cout << endl;
  }
  return 0;
}



