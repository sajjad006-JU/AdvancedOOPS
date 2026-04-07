# 27. Convert Snake case to Pascal case, camel case and kebab case.

def convert(s):
    words = s.split('_')

    pascal = ''.join(w.capitalize() for w in words)
    camel = words[0] + ''.join(w.capitalize() for w in words[1:])
    kebab = '-'.join(words)

    return pascal, camel, kebab

print(convert("hello_world_this_is_snake_case"))