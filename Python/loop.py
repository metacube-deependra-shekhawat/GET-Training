num = int(input("Enter the number: "))
for x in range(num+1):
    if not x % 10:
        continue
    elif x > 100:
        break;
    else: print(x);

# str = 'Hello World';
# #      012345678910
# print(str[7:9])
# print(str[::-1])