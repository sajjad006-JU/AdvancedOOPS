#  Write a simple program which loops over a list of user data (tuples containing a username, 
# email and age) and adds each user to a directory if the user is at least 16 years old. You do 
# not  need  to  store  the  age.  Write  a  simple  exception  hierarchy  which  defines  a  different 
# exception for each of these error conditions: 
# ●  the username is not unique 
# ●  the age is not a positive integer 
# ●  the user is under 16 
# ●  the  email  address  is  not  valid  (a  simple  check  for  a  username,  the  @  symbol  and  a 
# domain name is sufficient) 
# Raise these exceptions in your program where appropriate. Whenever an exception occurs, 
# your  program  should  move  onto  the  next  set  of  data  in  the  list.  Print  a  different  error 
# message for each different kind of exception.
import re

class UserAlreadyExistsException(Exception):
    pass

class InvalidAgeException(Exception):
    pass

class UnderAgeException(Exception):
    pass

class InvalidEmailException(Exception):
    pass


users = [
    ("meaow", "meaow@meaow.in", 12),
    ("bhaw bhaw", "bhaw@bhaw.uk", 17),
    ("ding dong", "ding@dong.ca", -1),
    ("meaow", "chui@mui.com", 12),
    ("chui mui", "chao@jao", 19)
]

user_directory = {}
pattern = r'^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$'

for user in users:
    try:
        if user[0] in users:
            raise UserAlreadyExistsException("Username already exists")
        if user[2] < 0:
            raise InvalidAgeException("Age should be a positive number")
        if user[2] <16:
            raise UnderAgeException("You should be atleast 16 years old")
        if not re.fullmatch(pattern, user[1]):
            raise InvalidEmailException("invalid email address!")
        
        print("Valid User! Added to Database!")
        user_directory[user[0]] = user[1]
    except Exception as e:
        print(e)

print(user_directory)