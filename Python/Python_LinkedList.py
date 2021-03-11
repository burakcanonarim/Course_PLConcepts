from pyllist import sllist
import sys

file1 = open(sys.argv[1], "r")
file2 = open(sys.argv[2], "r")

list1 = sllist()
list2 = sllist()

#file1 = open("First.txt", "r")
#file2 = open("Second.txt", "r")

for line in file1:
    b = int(line)
    list1.append(b)

for line in file2:
    c = int(line)
    list2.append(c)

def check(list1, list2):
    array = []
    for a in list1:
        if a not in list2:
            array.append(a)
    for line in file2:
        list2.append(line)
    print(array)
    print('\n')

print("Difference of elements in the first file from the second file is: ")
check(list1,list2)


print("Difference of elements in the second file from the first file is: ")
check(list2,list1)
