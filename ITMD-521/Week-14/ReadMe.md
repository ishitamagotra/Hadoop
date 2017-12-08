## TEST 1
![Ishita Magotra](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/test%201%20graph.JPG)
![I M](https://github.com/illinoistech-itm/imagotra/blob/master/ITMD-521/Week-14/test%201.JPG)

# So from the graph I have observed that the Map Reduce time is descending and these are the following observations,
## The Text file as input and with 4 reducers took the least time to finish the job
## The Text file as input and with 1 reducer has taken the maximum time
## For reducer 1, the GZ file as input has taken the least MapReduce time
## For 2 reducer, the Text file as input has taken the least MapReduce time
## For 4 reducer Text file as input has taken the least MapReduce time
## For 8 reducer Text file as input has taken the least MapReduce time
### Hence, Bz input file is taking more time than Gz input file (except for 8 Reducer Bz) but less than Text file.
## Analysis  for Test 1
The Text file as input and with 4 reducers is consuming the least MapReduce time because there are 69 splits in the text file which are processed in a parallel fashion. Now, with the data having an input memory of 8.4 gb Text file with 8 reducers would function in the best manner. (Last paragraph of Page no. 123)



