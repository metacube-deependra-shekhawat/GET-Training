list1 = ['a', 'b', 'c', 1, 2, 3]
list2 = [x for x in list1 if isinstance(x,int)]
print(list2)