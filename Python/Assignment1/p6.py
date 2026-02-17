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

users = [
    ("meaow", "meaow@meaow.in", 12),
    ("bhaw bhaw", "bhaw@bhaw.uk", 17),
    ("ding dong", "ding@dong.ca", 21),
]

for user in users:
    