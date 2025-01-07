num = int(input("Enter the number: "))
isPrime = True
for x in range(1,num-1):
    if(not num % 2):
        isPrime = False;
        break;
print(isPrime)