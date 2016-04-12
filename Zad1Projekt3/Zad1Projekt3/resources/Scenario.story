Scenario: IsNull should return true if stack is empty
Given stack is empty
Then IsNull should be true


Scenario: IsNull should return false if stack isnt empty
Given stack by <list>
Then IsNull should be false

Examples:
|list|
|5,9,2|
|42,10|
|32,1,1|
|2|

Scenario: MyPop should throw an eception if stack is empty
When stack is empty
Then MyPop should throw an exception



Scenario: Test MyPop
Given the nonEmpty stack by <list>
When MyPop occurs
Then the top of stack should be <elem>

Examples:
|list|elem|
|34,21,45,2,3|2|
|33,2|33|
|421,22,562|22|
|414,145,4,2|4|

Scenario: Test MyPush
Given an element by <elem>
When an element is added to the stack
Then the stack should have <elem>

Examples:
|elem|
|222|
|444|
|313|
	 
Scenario:  MyTop should throw an eception if stack is empty
When stack is empty
Then MyTop should throw an exception

Scenario: Test MyTop 
When Add new element <elem>
Then MyTop should be <elem>

Examples:
|elem|
|34|
|6442|
|3|
|33|
