# 12.  Create  a  BankAccount  class.  Your  class  should  support  these  methods:
# deposit, withdraw, get_balance, change_pin. Create one SavingsAccount class that
# behaves just like a BankAccount class, but also has an interest rate and a method
# that  increases  the  balance  by  the appropriate amount of interest. Create another
# FeeSavingsAccount  class  that  behaves  just  like  a  SavingsAccount,  but  also
# charges  a  fee  every  time  you  withdraw  money.  The  fee  should  be  set  in  the
# constructor and deducted before each withdrawal.
# Sajjad Ahmed Shaaz, 002410501093


class BankAccount:

    def __init__(self, initial_balance=0.0, pin="0000"):
        self._balance = float(initial_balance)
        self._pin = str(pin)

    def deposit(self, amount):
        amount = float(amount)
        if amount <= 0:
            return "Deposit amount must be greater than 0"
        self._balance += amount
        return self._balance

    def withdraw(self, amount, pin):
        amount = float(amount)
        if str(pin) != self._pin:
            return "Invalid PIN"
        if amount <= 0:
            return "Withdrawal amount must be greater than 0"
        if amount > self._balance:
            return "Insufficient balance"
        self._balance -= amount
        return self._balance

    def get_balance(self, pin):
        if str(pin) != self._pin:
            return "Invalid PIN"
        return self._balance

    def change_pin(self, old_pin, new_pin):
        if str(old_pin) != self._pin:
            return "Invalid old PIN"
        self._pin = str(new_pin)
        return "PIN changed successfully"


class SavingsAccount(BankAccount):

    def __init__(self, initial_balance=0.0, pin="0000", interest_rate=0.0):
        super().__init__(initial_balance, pin)
        self.interest_rate = float(interest_rate)

    def add_interest(self):
        interest = self._balance * self.interest_rate
        self._balance += interest
        return self._balance


class FeeSavingsAccount(SavingsAccount):

    def __init__(self, initial_balance=0.0, pin="0000", interest_rate=0.0, fee=0.0):
        super().__init__(initial_balance, pin, interest_rate)
        self.fee = float(fee)

    def withdraw(self, amount, pin):
        total = float(amount) + self.fee
        return super().withdraw(total, pin)


bank = BankAccount(1000, "1234")
print("BankAccount balance:", bank.get_balance("1234"))
print("After deposit:", bank.deposit(500))
print("After withdraw:", bank.withdraw(200, "1234"))
print(bank.change_pin("1234", "9876"))
print("Balance with new PIN:", bank.get_balance("9876"))

savings = SavingsAccount(1000, "1111", 0.05)
print("Savings before interest:", savings.get_balance("1111"))
print("Savings after interest:", savings.add_interest())

fee_savings = FeeSavingsAccount(1000, "2222", 0.05, 20)
print("FeeSavings before withdraw:", fee_savings.get_balance("2222"))
print("FeeSavings after withdraw+fee:", fee_savings.withdraw(200, "2222"))
