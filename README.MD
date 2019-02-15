## Dependencies:
Java version 1.8.0_201
SQLite version 3.19.3

## Additional tools used:
JDBC driver 3.32.1

## About:

This project will take any csv file and parse it line by line, using the *split()* method to separate the entries in each line by commas. 
The split method in this case checks if there are zero or an even number of quotes after any commas before cutting the row, so that any
After the process is done, a log file is created that holds the # of total, valid and bad entries with the right timestamp.
entries with commas in them are kept intact. An *SQLite* db is created at the specified path with one table X that contains exactly 10 columns A-J with one *ID* column as primary key with autoincrement, to match the sample csv file format. When parsing, any rows that do not match the number of columns and have any unvalid entries are instead inserted into a new bad-data.csv file. The file also gets created at the specified path. 

## Setup:

To choose the csv file to parse, specify the file location in the csvReader class, *csvFile* attribute. 
The location and name for the new csv file for bad records can be chosen in the csvWriter class, using the File constructor that takes a string parameter, called when the *PrintWriter* object is created. 
The filename for the database can be specified in the *SQLiteManager* class, in the *GetConnection* method by changing the url string.
A line-by-line output of the file being parsed and more is displayed in the console while the app is running, you can choose to remove the system.outs for a faster parsing in the *cvsReader* class.

## Running the project:

Download the JDK mentioned at the top, and the JDBC driver.
Open the project with any IDE and specify the path to the JDK in the project settings. You can use the jdbc driver by downloading the jar
file and move it to the project directory. You can then compile & run the app. You can also run it from any CLI. (Main class)
When the app is built, just run the *Main* class and watch the console for a line-by-line output while the csv file is being parsed. 

