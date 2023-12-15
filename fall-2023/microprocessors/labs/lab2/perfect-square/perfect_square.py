def is_square(number):
    for n in range(1, number):
        square = n * n
        print(n, square) 
        if square == number:
            return True
    return False

number = 25
print(str(number) + " is square: ", is_square(number))
