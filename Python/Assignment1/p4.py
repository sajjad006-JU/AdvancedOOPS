import re

pattern = r'^(\+?\d{1, 3})?[\s-]?\d{10}$'
phone = input("Enter mobile number : ")

if re.match(pattern, phone):
    print("matched!")
else:
    print("not matched")