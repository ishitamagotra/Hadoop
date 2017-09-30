# Instructions to Compile and Run the code :

1. Using Power Shell, Start the vagrant by using a command: **vagrant up**
2. Now, start the machine by using the command: **vagrant ssh**
3. Make an input directory using the command: **hadoop fs -mkdir -p ima/ncdc/1990/**
                                              **hadoop fs -mkdir -p ima/ncdc/1991/**
                                               **hadoop fs -mkdir -p ima/ncdc/1992/**
                                               **hadoop fs -mkdir -p ima/ncdc/1993/**
5. Next, Copy from your Local machine all the txt files to the input directory using the command: **hadoop fs -copyFromLocal /home/vagrant/1990-sample.txt ima/ncdc/1990/**
**hadoop fs -copyFromLocal /home/vagrant/1991-sample.txt ima/ncdc/1991/**
**hadoop fs -copyFromLocal /home/vagrant/1992-sample.txt ima/ncdc/1992/**
**hadoop fs -copyFromLocal /home/vagrant/1993-sample.txt ima/ncdc/1993/**
6. Copy all the Max Temperature java files with the command:**/hadoop-book/ch02-intro/src/main/java$ cp MaxTemperature*.java ~/**
7. Navigate to home directory using the command: **cd~**
8. Now do an **ls** to see whether all the txt files which were copied from the local system into the input directory are available. 
9. Using, **vi** or **vim** make changes to MaxTemperatureMapper.java , MaxTemperatureReducer.java , MaxTemperature.java , MaxTemperatureWithCombiner.java.
10. To rename the file now follow the command: **mv MaxTemperatureMapper.java InvalidStationIdMapper.java** ,
                                               **mv MaxTemperatureReducer.java InvalidStationIdReducer.java** ,
                                               **mv MaxTemperature.java InvalidStationId.java** ,
                                               **mv MaxTemperatureWithCombiner.java InvalidStationIdWithCombiner.java**
11. Compile all the java files using the command: **hadoop com.sun.tools.javac.Main InvalidStationId*.java**
12. Create a jar file as: jar cf id.jar Highestvisibilityperyear*.class
13. To, find the output use the command: **hadoop jar id.jar InvalidStationId ima/ncdc/1991/1991-sample.txt output/ncdc/91/1** **hadoop jar id.jar InvalidStationId ima/ncdc/1992/1992-sample.txt output/ncdc/92/1**  **hadoop jar id.jar InvalidStationId ima/ncdc/1993/1993-sample.txt output/ncdc/93/1**.This will perform a map reduce task. 
14. Final output will be displayed using the command:**hadoop fs -cat output/ncdc/90/1/part-r-00000**
                                                     **hadoop fs -cat output/ncdc/91/1/part-r-00000**
                                                     **hadoop fs -cat output/ncdc/92/1/part-r-00000**
                                                     **hadoop fs -cat output/ncdc/93/1/part-r-00000**
                                                     
 SO, this is the final output of all the individual files.                                                   
