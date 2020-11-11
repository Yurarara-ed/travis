# Project Virtual Memory - Pak Yuriy

#####About program
My program shows the work of three replacement algorithms: FIFO,LRU 
and OPT using the example of arrays with numbers

#####Input data format
Create a file with the extension. on one line there should be a memory limit (one number) on another line, numbers separated by a space - a request queue. 
The program is not sensitive to empty strings as well as multiple data declarations. 
It uses the first condition processed. 
###Attention! 
*The number of requests must be greater than or equal to the memory limit*

##### How to run?
You need to open terminal at the bottom of your IDE and type
there: 
`gradle run --args="[pathToTheFile]"`

Instead of *[pathToTheFile]* you need write the path to your .txt file 
with an algorithm: `gradle run --args="/Users/mraker/file.txt"`

If you put your file inside **NormalAlgorithms** folder, you will
need to write only a filename: `gradle run --args="filename.txt"`

##### About functions

###### getAppeals
`fun getAppeals(filepath: String): MutableList<Number>`
Gets a list of requests. Returns list of numbers

###### fillMemory
`fun fillMemory(memorylimit: Int, appeals: MutableList<Number>): MutableList<Number>`
Primary filling of RAM. Returns an array of numbers

###### getRequestsStack
`fun getRequestsStack(memorylimit: Int, appeals: MutableList<Number>): MutableList<Number>`
Getting a list of requests after the initial filling of RAM. Returns an array of numbers

###### writingResult
`fun writingResult(lines: MutableList<String>)`
The function converts data from the array resulting from the execution of the function "substitution" 
into a string and writes it to a file "output.txt" in main directory

###### predictFuture
`fun predictFuture(memory: MutableList<Number>, requests: MutableList<Number>, index: Int): List<Frame>`
This function predicts the future. Not literally, of course. Going through the list of requests, 
it counts the number of calls of a particular operation 
and displays the one to which there were the least number of calls.

###### checkFilesProperties
`fun checkFilesProperties(filepath: String): Boolean`
The function checks the file extension and its input
1. Compliance of the file extension to the ".txt" format
2. The presence of text inside the file
3. The presence of a condition inside the file

###### getMemoryLimit
`fun getMemoryLimit(filepath: String): Int`
Gets the virtual memory limit. Returns Int



###### FIFO LRU and OPT
This functions is an engine of this program.
All of them get the memory limit and appeals, Then the work of the replacement algorithms is calculated.
Returns the same types of data. MutableList<MutableList<Number>>
Only opt have include method (predictFuture)
