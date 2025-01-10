class Patient:
    def __init__(self,id,name,ssn):
        self.id = id
        self.name = name
        self.ssn = ssn
        
    def getId(self):
        return self.id
    
    def setId(self, id):
        self.id = id
    
    def getName(self):
        return self.name

    def setName(self, name):
        self.name = name
    
    def getSsn(self):
        return self.ssn

    def setSsn(self, ssn):
        self.ssn = ssn
        

Rohit = Patient(1,"Rohit","RR131")

print(Rohit.getId())
Rohit.setId(2)
print(Rohit.getId())


print(Rohit.getName())
Rohit.setName("Rohitt")
print(Rohit.getName())

print(Rohit.getSsn())
Rohit.setSsn("RR213")
print(Rohit.getSsn())
