import matplotlib.pyplot as plt
import numpy as np

lst = [] # plotting array
for i in range(8):
    lst.append(0)


with open("Log.txt",'r') as f:
    while True:
        line = f.readline()
        if not line :
            break
        line = line.rstrip('\n')
        if(len(line)==84):
            if(line[5]=="*"):
                c1 = line[79]
                c2 = line[83]
                # print(c1)
                if((c1== '1' and c2 == 'A') or (c1=='A' and c2 == '1')):
                    lst[0] = lst[0]+1
                elif((c1 == 'A' and c2 == 'B')or(c1 == 'B' and c2 == 'A')):
                    lst[1] = lst[1]+1
                elif((c1 == 'B' and c2 == 'C')or(c1 == 'C' and c2 == 'B')):
                    lst[2] = lst[2]+1
                elif((c1 == 'C' and c2 == 'D')or(c1 == 'D' and c2 == 'C')):
                    lst[3] = lst[3]+1
                elif((c1 == 'A' and c2 == 'D')or(c1 == 'D' and c2 == 'A')):
                    lst[4] = lst[4]+1
                elif((c1 == '2' and c2 == 'B')or(c1 == 'B' and c2 == '2')):
                    lst[5] = lst[5]+1
                elif((c1 == '3' and c2 == 'C')or(c1 == 'C' and c2 == '3')):
                    lst[6] = lst[6]+1
                elif((c1 == '4' and c2 == 'D')or(c1 == 'D' and c2 == '4')):
                    lst[7] = lst[7]+1
                    
        if(len(line)==85):
            if(line[5]=="*"):
                c1 = line[79]
                c2 = line[84]
                if((c1== '1' and c2 == 'A') or (c1=='A' and c2 == '1')):
                    lst[0] = lst[0]+1
                elif((c1 == 'A' and c2 == 'B')or(c1 == 'B' and c2 == 'A')):
                    lst[1] = lst[1]+1
                elif((c1 == 'B' and c2 == 'C')or(c1 == 'C' and c2 == 'B')):
                    lst[2] = lst[2]+1
                elif((c1 == 'C' and c2 == 'D')or(c1 == 'D' and c2 == 'C')):
                    lst[3] = lst[3]+1
                elif((c1 == 'A' and c2 == 'D')or(c1 == 'D' and c2 == 'A')):
                    lst[4] = lst[4]+1
                elif((c1 == '2' and c2 == 'B')or(c1 == 'B' and c2 == '2')):
                    lst[5] = lst[5]+1
                elif((c1 == '3' and c2 == 'C')or(c1 == 'C' and c2 == '3')):
                    lst[6] = lst[6]+1
                elif((c1 == '4' and c2 == 'D')or(c1 == 'D' and c2 == '4')):
                    lst[7] = lst[7]+1

        

x = np.arange(0,8,1)
plt.figure()
plt.bar(x,lst)
plt.title("Number of flits vs connections")
plt.xlabel("Number of Connections")
plt.ylabel("Number of flits")
plt.show()        