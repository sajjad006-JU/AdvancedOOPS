# 17.  Write a function that flattens a nested dictionary structure like one obtain from Twitter 
# and Facebook APIs or from some JSON file. 
# nested = { 
# 'fullname': 'Alessandra', 
# 'age': 41, 
# 'phone-numbers': ['+447421234567', '+447423456789'], 
# 'residence': { 
# 'address': { 
# 'first-line': 'Alexandra Rd', 
# 'second-line': '', 
# Testing, Profiling, and Dealing with Exceptions 
# [ 230 ] 
# }, 
# 'zip': 'N8 0PP', 
# 'city': 'London', 
# 'country': 'UK', 
# }, 
# }

def flatten_dict(d, parent_key='', sep='.'):
    items = []
    for k, v in d.items():
        new_key = parent_key + sep + k if parent_key else k
        if isinstance(v, dict):
            # FIXED: Added .items() here
            items.extend(flatten_dict(v, new_key, sep=sep).items())
        else:
            items.append((new_key, v))
    return dict(items)

nested = {
    'fullname': 'Alessandra',
    'age': 41,
    'phone-numbers': ['+447421234567', '+447423456789'],
    'residence': {
        'address': {
            'first-line': 'Alexandra Rd',
            'second-line': ''
        },
        'zip': 'N8 0PP',
        'city': 'London',
        'country': 'UK'
    }
}

flat_dict = flatten_dict(nested)

# Using a loop to print it nicely
for key, value in flat_dict.items():
    print(f"'{key}': {value}")