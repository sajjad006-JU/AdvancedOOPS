# .  Write a regular expression to validate a phone number. 
# Sajjad Ahmed Shaaz, 002410501093

import re

pattern = r'^(\+?\d{1, 3})?[\s-]?\d{10}$'
phone = input("Enter mobile number : ")

if re.match(pattern, phone):
    print("matched!")
else:
    print("not matched")