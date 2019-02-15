
Additional tools used:
JDBC driver 3.32.1

This project will take any csv file and parse it line by line, using the split() method to separate the entries in each line by commas. 
The split method in this case checks if there are zero or an even number of quotes after any commas before cutting the row, so that any
entries with commas in them are kept intact. 

An SQLite db is created at the specified path with one table X that contains exactly 10 columns A-J with one ID column as primary key with
autoincrement, to match the sample csv file format.

When parsing, any rows that do not match the number of columns and have any unvalid entries are instead inserted into a new bad-data.csv 
file. The file also gets created at the specified path.

After the process is done, a log file is created that holds the # of total, valid and bad entries with the right timestamp.

To choose the csv file to parse, specify the file location in the csvReader class, csvFile attribute. A location and name can
be chosen for the new csv file for bad records in the csvWriter class, using the File constructor that takes a string parameter
called when the PrintWriter object is created. 

The filename for the database can be specified in the SQLiteManager class, in the GetConnection method by changing the url string.

