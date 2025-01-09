import json
with open ("sample_data.json", 'r') as jsonfile:
    sheet = json.load(jsonfile)

students = list(sheet['students'])
highestAvgMarks = 0
studentWithHighestAvgMarks = ""
studentsAvgMarks = {}

for student in students:
    subjects = student['details']['grades']
    # print(subjects)
    marks = 0
    completedSubjectCount = 0
    for subject in subjects:
        if subjects[subject]['completed']:
            marks += subjects[subject]['score']
            completedSubjectCount += 1
    if completedSubjectCount == 0:
        studentsAvgMarks[student["name"]] = 0
        continue
    avgMarks = marks/completedSubjectCount
    studentsAvgMarks[student["name"]] = avgMarks
    if avgMarks > highestAvgMarks:
        studentWithHighestAvgMarks = student["name"]
        highestAvgMarks = avgMarks

# print(studentWithHighestAvgMarks)

sheet['avgMarks'] = studentsAvgMarks
with open("sample_data.json", "w") as outfile:
    json.dump(sheet, outfile, indent= 4)