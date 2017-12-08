# TEST 1
![Ishita Magotra](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/test%201%20graph.JPG)
![I M](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/test%201.JPG)

## So from the graph I have observed that the Map Reduce time is descending and these are the following observations,
1. The Text file as input and with 4 reducers took the least time to finish the job
2. The Text file as input and with 1 reducer has taken the maximum time
3. For reducer 1, the GZ file as input has taken the least MapReduce time
4. For 2 reducer, the Text file as input has taken the least MapReduce time
5. For 4 reducer Text file as input has taken the least MapReduce time
6. For 8 reducer Text file as input has taken the least MapReduce time
7. Hence, Bz input file is taking more time than Gz input file (except for 8 Reducer Bz) but less than Text file.
## Analysis  for Test 1
The Text file as input and with 4 reducers is consuming the least MapReduce time because there are 69 splits in the text file which are processed in a parallel fashion. Now, with the data having an input memory of 8.4 gb Text file with 8 reducers would function in the best manner. (Last paragraph of Page no. 123)

# TEST 2
![I M](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%202%20graph.JPG)
![I M](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/Test%202.JPG)

1. So from the graph I have observed that the Map Reduce time is descending and these are the following observations,
2. The Gz file as input and with 2 reducers took the least time to finish the job
3. The Text file as input and with 4 reducer has taken the maximum time
4. For reducer 1, the GZ file as input has taken the least MapReduce time
5. For reducer 2, the Text file as input has taken the least MapReduce time
6. For reducer 4, Gz file as input has taken the least MapReduce time
7. For reducer 8, Bz file as input has taken the least MapReduce time
8. Hence the Text and Gz input files are more efficient than the Bz file (except for 8 reducer Bz)  
## Analysis  for Test 2
This MapReduce process is not dependent on the format of the input.
However, this is the best MapReduce process for having a low MapReduce time which is very effective and we didn't got such outcomes from the result of the Test 2 that is due to the excessive number of failures seen in the MapReduce procedure. It might be taken into consideration because of poor machine arrangement. The procedure is quicker because of the quick transfer rate between the input of the reducer and the output of the map. (Page no. 126)





