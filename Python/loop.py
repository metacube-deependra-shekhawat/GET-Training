num = int(input("Enter the number: "))
for x in range(num):
    if not x % 10:
        continue
    else: print(x);
