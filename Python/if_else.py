def findGrade(student):
    """
    This function takes a dict as an input which represents a student's marks of different subjects and prints corresponding grade
    """
    if student["math"] < 35 or student["physics"] < 35 or student["chemistry"] < 35:
        print("F")
        return
    total_marks = student["math"] +  student["physics"] + student["chemistry"] 
    avg_marks = total_marks / 3;
    if avg_marks <= 59:
        print("C")
    elif avg_marks <= 69:
        print("B")
    else:
        print("A")
    

students = {"Rahul": {"math": 55, "physics": 55, "chemistry": 55},
            "Bhupendra": {"math": 100, "physics": 100, "chemistry": 100},
            "Deependra": {"math": 39, "physics": 39, "chemistry": 30}}

findGrade(students["Bhupendra"])
findGrade(students["Deependra"])
findGrade(students["Rahul"])