#class
class User:
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.balance = 100

    def make_withdrawl(self, amount):
        self.balance -= amount
        return self

    def make_deposit(self, amount):
        self.balance += amount
        return self
    
    def display_user_balance(self):
        print(f"user:{self.name}, balance:{self.balance}")
        return self

    def transfer_money(self, other_user, amount):
        self.balance -= amount
        other_user.balance += amount

#users
lauren = User("Lauren Seyranian", "lauren@python.com")
bryce = User("Bryce Andrews", "bryce@python.com")
kristen = User("Kristen Seyranian", "kristen@python.com")

#functions

#1
lauren.make_deposit(10).make_deposit(10).make_deposit(10).make_withdrawl(5).make_deposit(10).display_user_balance()

#2
bryce.make_deposit(10).make_deposit(10).make_withdrawl(5).make_withdrawl(5).display_user_balance()

#3
kristen.make_deposit(10).make_withdrawl(5).make_withdrawl(5).make_withdrawl(5).display_user_balance()

#4
lauren.transfer_money(bryce, 50)
lauren.display_user_balance()
bryce.display_user_balance()