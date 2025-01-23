class Book:
    def __init__(self, title, author, genre, count=1):
        self.title = title
        self.author = author
        self.genre = genre
        self.count = count

    def isAvail(self):
        return self.count > 0


class User:
    id = 1
    def __init__(self, name):
        self.userId = User.id
        self.name = name
        self.borrowedBooks = []
        User.id += 1


class Library:
    def __init__(self):
        self.books = {}
        self.users = {}

    def addBook(self, book):
        if book.title in self.books:
            self.books[book.title].count += book.count
        else:
            self.books[book.title] = book

    def removeBook(self, title):
        if title in self.books:
            if self.books[title].count > 1:
                self.books[title].count -= 1
            else:
                del self.books[title]

    def searchBook(self, **kwargs):
        results = []
        for book in self.books.values():
            if all(getattr(book, key, None) == value for key, value in kwargs.items()):
                results.append(book)
        return results

    def addUser(self, user):
        if user.userId in self.users:
            print("User already exists")
        else:
            self.users[user.userId] = user
            print("User added")

    def borrowBook(self, userId, title):
        user = self.users.get(userId)
        if not user:
            print("User not found")
            return

        if len(user.borrowedBooks) >= 3:
            print("User has already borrowed 3 books")
            return

        if title in self.books and self.books[title].isAvail:
            self.books[title].count -= 1
            user.borrowedBooks.append(self.books[title])
        else:
            print("Book not available")

    def returnBook(self, userId, title):
        user = self.users.get(userId)
        if not user:
            print("User not found")
            return

        for book in user.borrowedBooks:
            if book.title == title:
                book.count += 1
                user.borrowedBooks.remove(book)
                return

        print("Book not found in user's borrowed list")

library = Library()
library.addBook(Book("Book1", "Author1", "Genre1"))
library.addBook(Book("Book2", "Author2", "Genre2"))
library.addBook(Book("Book3", "Author3", "Genre2"))
library.addBook(Book("Book4", "Author1", "Genre1"))
library.addBook(Book("Book5", "Author2", "Genre2"))
library.addBook(Book("Book6", "Author3", "Genre2"))

library.addUser(User("User1"))
library.addUser(User("User5"))
library.addUser(User("User2"))
library.addUser(User("User3"))

library.borrowBook(1,"Book1")
library.borrowBook(2,"Book4")
library.borrowBook(1,"Book2")
library.borrowBook(1,"Book3")
library.borrowBook(1,"Book4")
library.borrowBook(2,"Book4")

library.returnBook(1,"Book1")

res = library.searchBook(genre="Genre2")
for r in res:
    print(r.title)