# 21.  Write a python program to identify and extract numerical chunks from a text file and 
# convert them into words; e.g.; 1992  nineteen hundred and ninety two

def num_to_words(n):
    if n == 0:
        return "zero"

    ones = ["", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen"]
    tens = ["", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"]
    scales = ["", "thousand", "million", "billion"]

    def get_hundreds(num):
        words = []
        # Handle the hundreds place
        if num >= 100:
            words.append(ones[num // 100])
            words.append("hundred")
            num %= 100
            if num > 0:
                words.append("and")
        
        # Handle the tens and ones place
        if num >= 20:
            words.append(tens[num // 10])
            num %= 10
            if num > 0:
                words.append(ones[num])
        elif num > 0:
            words.append(ones[num])
            
        return " ".join(words)

    # Special rule to match the example for years/hundreds (e.g., 1992 -> nineteen hundred and ninety two)
    if 1100 <= n <= 1999:
        hundreds_part = ones[n // 100] + " hundred"
        remainder = n % 100
        if remainder > 0:
            # We remove "and" from get_hundreds if it exists to prevent "and and"
            return hundreds_part + " and " + get_hundreds(remainder).replace("and ", "")
        return hundreds_part

    # Standard grouping for all other numbers (e.g., 2024 -> two thousand twenty four)
    final_words = []
    scale_idx = 0
    
    while n > 0:
        chunk = n % 1000
        if chunk > 0:
            chunk_words = get_hundreds(chunk)
            if scale_idx > 0:
                final_words.insert(0, chunk_words + " " + scales[scale_idx])
            else:
                final_words.insert(0, chunk_words)
        n //= 1000
        scale_idx += 1

    return " ".join(final_words)

def extract_and_convert(filename):
    try:
        with open(filename, 'r') as file:
            text = file.read()
    except FileNotFoundError:
        print(f"Error: The file {filename} was not found.")
        return

    extracted_numbers = []
    current_chunk = ""

    # Manually parse through the text character by character
    for char in text:
        if char.isdigit():
            current_chunk += char
        else:
            if current_chunk:
                extracted_numbers.append(int(current_chunk))
                current_chunk = ""
                
    # Catch any number that might be at the very end of the file
    if current_chunk:
        extracted_numbers.append(int(current_chunk))

    # Print the final conversions
    for num in extracted_numbers:
        print(f"{num} \t {num_to_words(num)}")

# ==========================================
# TEST IMPLEMENTATION
# ==========================================
if __name__ == "__main__":
    test_filename = "sample_text.txt"
    with open(test_filename, "w") as f:
        f.write("I was born in 1992. The company made 45000 dollars in 2024.\n")
        f.write("There are exactly 365 days in a year, and 0 regrets!")

    # 2. Run our extraction function
    print("Extracting and Converting...\n" + "-"*40)
    extract_and_convert(test_filename)