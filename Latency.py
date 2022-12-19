import matplotlib.pyplot as plt
import numpy as np
import math

counter = 0;

with open("input.txt",'r') as f:
    while True:
        line = f.readline()
        if not line :
            break
        counter = counter + 1
        

# print(counter)

lst = []
for i in range(counter):
    lst.append(0)
    
packet = []
    
with open("Log.txt",'r') as f:
    indexcount = 0
    while True:
        line = f.readline()
        if not line :
            break
        line = line.rstrip('\n')
        if(len(line)==92):
            c1 = int(line[63])
            c2 = int(line[91])
            if(abs(c1-c2) == 2):
                lst[indexcount] = 48
            elif(abs(c1-c2) == 3 or abs(c1-c2) == 1):
                lst[indexcount] = 36
            
            indexcount = indexcount + 1
        if(len(line)>120):
            line = line.split(" ")
            packet.append(line[2])
            pass
            

with open("Latency_Graph_info.txt",'w') as f:
    for i in range(len(packet)):
        line = str(i) + " : " + packet[i]
        f.write(line+'\n')


x = np.arange(0,counter,1)
plt.figure()
plt.bar(x,lst)
plt.title("Latency vs Packet")
plt.xlabel("Packet number")
plt.ylabel("Latency")
plt.show()   