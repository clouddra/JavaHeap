Approach to the problem 

Use heap and hashing to solve the problem.
Hashtable contains <woman name, index of woman in heap>
Heap sorted by dilation status.



Algorithm:

ArriveAtHospital
Insert the new woman and shiftUp if needed.		O(log n) 
Add entry to hashtable 					O(1)

UpdateStatus
Hash the woman's name to get its index in heap. 	O(1)
Access the woman in the heap directly and update. 	O(log n)
shiftUp if needed and update hashtable while shifting.

GiveBirth
Hash the woman's name to get its index in heap. 	O(1)
Access the node in the heap directly and remove it. 	O(log n) 
Much like ExtractMax except for the possiblity of shiftUp.
There will not be a case of both shiftUp and shiftDown. Only either 1 or none at all. 
Update hashtable while shifting.


Query
Return top of heap. 					O(1)



Collaborators:
Hong Shihan
Koh Zhi Kai
Thian Chang Yi Benjamin