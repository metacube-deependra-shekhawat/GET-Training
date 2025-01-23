class InvalidPasswordException(Exception):
    def __init__(self, message="Password must be at least 8 characters long."):
        self.message = message
        super().__init__(self.message)

def checkPassword():
    try:
        password = input("Enter your password: ")
        x = 5/0
        if len(password) < 8:
            raise InvalidPasswordException

        print("Password is valid.")

    except InvalidPasswordException:
        print("Error")
        # print(f"Error: {e}")

    except ZeroDivisionError:
        print("ZeroDivision Error")

checkPassword()