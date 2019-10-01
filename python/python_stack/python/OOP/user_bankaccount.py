class BankAccount:
    def __init__(self, int_rate=0.02, balance=0):
        self.int_rate = int_rate
        self.balance = balance

    def deposit(self, amount):
        self.balance += amount
        return self

    def withdraw(self, amount):
        self.balance -= amount
        return self

    def display_account_info(self):
        print(f"balance:{self.balance}, int_rate:{self.int_rate}")
        return self



class User:
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account = BankAccount ()
        
    def deposit(self, amount):
        self.account.deposit (amount)
        return self

    def withdraw(self, amount):
        self.account.withdraw (amount)
        return self
    
    def display_user_balance(self):
        self.account.display_account_info()
        return self


lauren = User("Lauren Seyranian", "lauren@python.com")


lauren.deposit(100).deposit(100).deposit(100).withdraw(10).display_user_balance()