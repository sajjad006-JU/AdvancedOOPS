import os

def traverse_directory(directory):
    for root, dir, files in os.walk(directory):
        for file in files:
            path = os.path.join(root, file)
            yield path

for file in traverse_directory('.'):
    print(file)