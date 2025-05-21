This is a Befunge 93 interpreter written in Java using IntelliJ. 
# Features
  * All normal Befunge 93 features, including the size limit
  * Stack clearing: use the 's' symbol to clear the whole stack
  * Stack reversal: use the 'r' symbol to reverse the stack's order
  * The Function Library: use the 'f' symbol to execute the function associated with the Stack's top integer
  * Custom sized Befunge projects
# Functions
Functions were added as a way of making more options for developers without having to learn new characters. Functions can be called by pushing a number to the stack and using the 'f' symbol to call them.
Currently, there are 21 functions:
  <li>Print the whole stack as characters (0)</li>
  <li>Print the whole stack as integers (1)</li>
  <li>Push a random number from 0 to 255 to the top of the Stack (2)</li>
  <li>Pop the latest number <code>a</code> and push a number between 0 and <code>a-1</code> (3)</li>
  <li>Pop the latest number <code>a</code> and push a number between <code>a</code> and 255 (4)</li>
  <li>Pop the two latest numbers <code>a</code> and <code>b</code> and push a number between <code>a</code> and <code>b-1</code> (5)</li>
  <li>Pop the latest number <code>a</code> and print the <code>a</code> next items on the Stack as characters (6)</li>
  <li>Pop the latest number <code>a</code> and print the <code>a</code> next items on the Stack as integers (7)</li>
  <li>Clear the stack and push the sum of all numbers that were on it (8) </li>
  <li>Push the length of the stack on the stack (9)</li>
  <li>Pop the character at the top of the stack, then execute it as if it were part of the program (10)</li>
  <li>Move the value at the top of the Stack to the bottom of the Stack (11)</li>
  <li>Move the value at the bottom of the Stack to the top of the Stack (12)</li>
  <li>Calculate the highest integer in the Stack and push a copy of that integer to the top of the Stack (13)</li>
  <li>Calculate the lowest integer in the Stack and push a copy of that integer to the top of the Stack (14)</li>
  <li>Remove all numbers strictly below 0 from the list (15)</li>
  <li>Pop the number at the top of the stack, then push its factorial (16)</li>
  <li>Replace all numbers in the stack with their absolute value (17)</li>
  <li>Print all items on the stack as characters, but in reverse (18)</li>
  <li>Print all items on the stack as integers, but in reverse (19)</li>
  <li>Pop <code>a</code>, then wait <code>a</code> milliseconds before resuming the program (20)</li>
If the function called is out of bounds, it will be ignored.
