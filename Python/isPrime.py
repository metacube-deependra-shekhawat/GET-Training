num = int(input("Enter the number: "))
isPrime = True
for x in range(2,num-1):
    if(not num % x):
        isPrime = False;
        break;
print(isPrime)