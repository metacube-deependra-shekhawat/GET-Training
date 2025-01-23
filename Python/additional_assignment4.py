import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from scipy import stats

# Reading the files
employees = pd.read_csv("employees.csv")
performance = pd.read_csv("performance.csv")

# Checking for Null/Missing values
employees.dropna(inplace=True)
performance.dropna(inplace=True)

# Changing to DateTime format
employees['DateOfJoining'] = pd.to_datetime(employees['DateOfJoining'], format='%Y-%m-%d')
performance['Month'] = pd.to_datetime(performance['Month'], format='%Y-%m')

# Calculating Tenure of Employees
now = pd.Timestamp.now()
employees['Tenure'] = ((now - employees['DateOfJoining']).dt.days / 30).round(2)

# Merging the tables
mergedTable = pd.merge(employees,performance, on='EmployeeID', how="inner")

# Average Metrics Calculation
employees['AverageSales'] = mergedTable.groupby(["EmployeeID"])['Sales'].transform('mean')
employees['AverageHoursWorked'] = mergedTable.groupby(["EmployeeID"])['HoursWorked'].transform('mean')
employees['AverageClientSatScore'] = mergedTable.groupby(["EmployeeID"])['ClientSatisfactionScore'].transform('mean')

# Top 5 Employees with highest average sales
top5Emp = employees.sort_values("AverageSales", ascending=False).head(5)
deptWithHighestScore = mergedTable.groupby(['Department'])['ClientSatisfactionScore'].apply('sum').sort_values(ascending=False)

# Calculating Z-Score and outliers
z = np.abs(stats.zscore(mergedTable['ClientSatisfactionScore']))
threshold = 0.9
outlier = mergedTable[z > threshold]
# print(outlier)

# plt.hist(mergedTable['Sales'])
# plt.show()

# print(performance)
print(employees)