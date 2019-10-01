class BankAccount:
    def __init__(self, int_rate=0.01, balance=0):
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

    def yield_interest(self):
        if self.balance > 0:
            self.balance = self.balance + self.balance * self.int_rate
        else:
            print("Insufficient Funds.")
        return self

lauren = BankAccount()
bryce = BankAccount()


#1
lauren.deposit(100).deposit(100).deposit(100).withdraw(10).yield_interest().display_account_info()


#2
bryce.deposit(100).deposit(100).withdraw(10).withdraw(10).withdraw(10).withdraw(10).yield_interest().display_account_info()