# Sajjad Ahmed Shaaz, 002410501093
# Write  a  function  findfiles  that  recursively  descends  the  directory  tree  for  the  specified 
# directory and generates paths of all the files in the tree. 

import os

# defines a traversing functin
def traverse_directory(directory):
    for root, dir, files in os.walk(directory):
        for file in files:
            path = os.path.join(root, file)
            yield path

for file in traverse_directory('/'):
    print(file)