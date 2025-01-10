class Parrot:
    species = 'Bird'
    def __init__(self,name,color):
        self.name = name
        self.color = color
    
foo = Parrot("Soni", "Pink")
print(foo.__class__.species)