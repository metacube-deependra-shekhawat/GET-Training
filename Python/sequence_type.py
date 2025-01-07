# List
countries = ["India", "United States", "United Kingdom"]
countries.append("United Arab Emirates")
countries.pop(1);
countries.insert(1,"Sweden")
print(countries)

# Set 
countries_set = {"India", "USA", "UK"}
countries_set.update(["India", "UAE"])
# Not possible to access element in a set using index, as it is unordered
countries_set.discard("USA")
print(countries_set)