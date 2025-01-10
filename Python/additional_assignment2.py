import csv
import math

with open('student_scores.csv', mode ='r')as file:
    csvFile = csv.reader(file)

    header = next(csvFile)
    header.append("Total Score")
    header.append("Average Score")
    newList = [header]
    for line in csvFile:
        if not line[2].isnumeric() or not line[3].isnumeric() or not line[4].isnumeric():
            continue
        total = int(line[2])+int(line[3])+int(line[4])
        average = round((total/3), 2)
        line.append(total)
        line.append(average)
        newList.append(line)
        # newList[len(newList)-1][0] = len(newList)-1;

print(newList)
with open('student_scores_updated.csv', mode ='w', newline='\n') as file:
    writer = csv.writer(file)
    writer.writerows(newList)