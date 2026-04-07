# 20.  Write a python program to 
# i.  read lines from a file, break into tokens and convert the tokens to unique numerical 
# values using python dictionary. 
# ii.  Convert lines of different lengths into lines of same length (maximum length). Use 
# padding if and when required.

def process_file(filename):
    with open(filename) as f:
        lines = f.readlines()

    tokens = {}
    count = 0

    for line in lines:
        for word in line.split():
            if word not in tokens:
                tokens[word] = count
                count += 1

    max_len = max(len(line.split()) for line in lines)

    padded = [line.split() + ['<PAD>']*(max_len-len(line.split())) for line in lines]

    return tokens, padded

if __name__ == "__main__":
    tokens, padded_lines = process_file("input.txt")
    print("Tokens:", tokens)
    print("Padded Lines:", padded_lines)
