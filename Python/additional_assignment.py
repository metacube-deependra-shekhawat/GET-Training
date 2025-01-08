import json
with open ("sample_data.json", 'r') as jsonfile:
    sheet = json.load(jsonfile)

students = list(sheet['students'])
highestAvgMarks = 0
studentWithHighestAvgMarks = ""
studentsAvgMarks = {}
for student in students:
    subjects = student['details']['grades']
    if not(subjects['math']['completed'] and  subjects['science']['completed'] and  subjects['english']['completed']  and  subjects['history']['completed']):
        studentsAvgMarks[student["name"]] = 0
        continue
         
    marks = subjects['math']['score'] + subjects['science']['score'] + subjects['english']['score'] + subjects['history']['score']
    avgMarks = marks/4
    studentsAvgMarks[student["name"]] = avgMarks
    if avgMarks > highestAvgMarks:
        studentWithHighestAvgMarks = student["name"]
        highestAvgMarks = avgMarks

print(studentWithHighestAvgMarks)

with open("output.json", "w") as outfile:
    json.dump(studentsAvgMarks, outfile)