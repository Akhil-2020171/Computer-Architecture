# Computer-Architecture
Repository containing project source codes and details of Computer Architecture Course
-------------------------------------------------------------------------------------------
In this project, we have implemented a cycle accurate simulator of an NOC router and Mesh.
# Here is a diagram of the mesh:
  1          2
   \        /
    A ---- B
    |      |
    |      |
    D ---- C
   /        \
  4          3
  In this, the numbers 1,2,3,4 represent the PEs, and the alphabets A,B,C,D represent the routers

This simulator has the following input format: It will have line(s) with 4 integers seperated by space,
the first integer will denote the cycle number at which data transfer starts taking place,
the second integer will denote the source PE
the third integer will denote the destination PE
The fourth integer will denote the data that is to be transferred (It is a 96 bit binary)

# Example of input:
20 1 2 010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101
10 1 3 011101011100010111010010110101010111010111000101110100101101010101110101110001011101001011010101
50 2 4 111100101100101000100101010101011111001011001010001001010101010111110010110010100010010101010101

# Working of the code:
1. We have first made two Scanner objects, sc1 and sc2. Using sc1 we read the input file and traversed
through it to count the number of lines contained in it. We have defined a class "payload", which has 4
fields, which are each of the 4 parts of an input line. Then, using the number of lines we now know, we
created an array of payloads, and each payload in the array is given the 4 input values in the fields.
Next, we sort that array based on the value of the first field, so that the data that has to be transferred
earlier comes first.

2. Then, we have used a FileWriter to start writing the log file. The log file will keep getting updated as 
the code runs. We have now used a 3rd scanner here to read the input regarding which routing algorithm is to
be used. If you wish to use the XY algorithm, type XY, if you wish to use the YX algorithm, type YX. 

3. After this, the for loop starts. It iterates through each of the payloads in the array. We have defined a 
process class, and a new process object will be made for each payload in the array. Inside the process class, 
there is a process.run() method, which is basically doing the simulation.

4. Every time process.run() is called for a payload, the 1st value of payload is read to obtain the cycle number
at which the data transfer is supposed to start.The 2nd and 3rd values are read to obtain the source and 
destination, and the header flit is made using these values. Now, as we know, the data is supposed to be 
transferred in packets of 8, so we have run a for loop that takes 8 bits of the data value at a time to transfer.
For every 8 bits, we define a 2d string, that contains a header, the data, and a tail. The header is basically an 
array that contains 2 values, source and destination. The tail contains either -1 or 1. -1 indicates that there are
more flits of the same data to come next, and the last flit of a data has tail 1, which indicates that that flit is 
the last part of that data.

5. Now, to simulate sending the data to the required PE, we use a recursive algorithm. We have made 4 classes, namely
routerA, routerB, routerC and routerD. In each of these routers, a method called switchallocator() is defined, which
basically simulates sending the flit to the next router according to the routing algorithm that was chosen earlier.
Each router class has this switchallocator() method which is called until the flit reaches the destination. We use 2
variables, pointer and cyclenum to be able to track and print the current location and the current cycle number whenever
a flit gets transferred. So every time switchallocator() is called, the current location and cycle number gets printed in 
the log file, and hence we are able to keep track of the flit. When the flit reaches the router that is local to the 
destination PE, then the flit is sent to the PE and the algorithm ends. 

6. So, in the output log file we obtain the output which is basically information about which data flit went to what router
in which cycle number. 

# *How to use the simulator:*
1. Insert the input in the format described above in the input.txt file.
2. Run the code, when prompted, enter the desired routing algorithm you want to run and press enter.
3. Obtain the results in the Log.txt file.

