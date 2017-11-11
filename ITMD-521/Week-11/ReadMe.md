# Steps to follow to Create a .sql script named create.sql that will create the database hadoopguide, table widgets, and follow the schema given in the book
Created a sql script "create.sql" to create the database named as 'hadoopguide' and table as 'widgets' in mysql. 
DROP DATABASE hadoopguide is EXISTS;
CREATE DATABASE hadoopguide;
use hadoopguide;
CREATE TABLE widgets(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,widget_name VARCHAR(64) NOT NULL,price DECIMAL(10,2),
design_date DATE,version INT,design_comment VARCHAR(100));

# Steps to follow to include a script named step-2.* that will generate 5000 records (based on the 4 sample items given in the text) and INSERT this into the widgets table.

In this step I have written a java code "step_2.java" to access ,generate random records on the basis of 4 records shown in the book and insert 
those 5000 records into the widget table in the mysql. **To access the code open the file "step_2.java" as submitted by me.**

## Output for "step_2.java" are as follows:-
![Ishita Magotra](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-11/ans2%20hadoop.JPG)
![Ishita Magotra](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-11/ans2.1%20hadoop.JPG)

# Steps to follow to include a shell script named: step-3.sh that will execute the Sqoop import as given by the text book

In this step I have created a shell script "step-3.sh" to execute the sqoop import statement into the HDFS and the output of hadoop by running the command **hadoop fs -cat widgets/part-m-00000**. **I have also submitted a part-m-00000 file to have full access to the records** 

## Output:
![Ishita Magotra](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-11/step-3.sh)


 





