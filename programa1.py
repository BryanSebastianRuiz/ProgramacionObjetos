import sys
import numpy as np
from scipy.integrate import quad
from math import sqrt

def action1():
    print("Welcome you chose sum")
    num1 = float(input("Enter the first number: "))
    num2 = float(input("Enter the second number: "))
    result = num1 + num2
    print("The result of the sum is: ", result)


def action2():
    print("Welcome you chose substraction")
    num1 = float(input("Enter the first number: "))
    num2 = float(input("Enter the second number: "))
    result = num1 - num2
    print("The result of the substraction is: ", result)


def action3():
    print("Welcome you chose multiplication")
    num1 = float(input("Enter the first number: "))
    num2 = float(input("Enter the second number: "))
    result = num1 * num2
    print("The result of the multiplication is: ", result)


def action4():
    print("Welcome you chose division")
    num1 = float(input("Enter the first number: "))
    num2 = float(input("Enter the second number: "))
    result = num1 / num2
    print("The result of the division is: ", result)


def action5():
    print("Welcome you chose square root")
    num1 = float(input("Enter a number: "))
    result = num1 * num1
    print("The result of the square root is: ", result)


def action6():
    print("Welcome you chose integrals")
    
    num1 = float(input("Enter the first limit of integration: "))
    num2 = float(input("Enter the second limit of integration: "))
    
    def f(x):
        return x ** 2 + 2 * x + 1
    
    resultado, error = quad(f, num1, num2)
    print(f"The result of the integral is: {resultado}")
    

def action7():
    print("Welcome you chose sum of matrices")
    print("ROWS")
    a = float(input("Enter the first number for the rows: "))
    b = float(input("Enter the second number for the rows: "))
    c = float(input("Enter the third number for the rows: "))
    d = float(input("Enter the fourth number for the rows: "))
    e = float(input("Enter the fifth number for the rows: "))
    f = float(input("Enter the sixth number for the rows: "))
    g = float(input("Enter the seventh number for the rows: "))
    h = float(input("Enter the eighth number for the rows: "))
    i= float(input("Enter the nineth number for the rows: "))

    print("COLUMNS")
    a1 = float(input("Enter the first number for the rows: "))
    b1 = float(input("Enter the second number for the rows: "))
    c1 = float(input("Enter the third number for the rows: "))
    d1 = float(input("Enter the fourth number for the rows: "))
    e1 = float(input("Enter the fifth number for the rows: "))
    f1 = float(input("Enter the sixth number for the rows: "))
    g1 = float(input("Enter the seventh number for the rows: "))
    h1 = float(input("Enter the eighth number for the rows: "))
    i1 = float(input("Enter the nineth number for the rows: "))

    M1 =[[a,b,c],   
        [d,e,f],   
        [g,h,i]]  

    M2 =[[a1,b1,c1],
        [d1,e1,f1],
        [g1,h1,i1]]

    M1 = np.array(M1)
    M2 = np.array(M2)

    result1 = M1[0,:] * M2[:,0]
    result2 = M1[1,:] * M2[:,1]
    result3 = M1[2,:] * M2[:,2]
    print(result1)
    print(result2)
    print(result3)


def action8():
    print("Coming out")
    sys.exit()

option = {
    '1': (" Sum", action1),
    '2': (" Subtraction", action2),
    '3': (" Multiplication", action3),
    '4': (" Division", action4),
    '5': (" Square Root", action5),
    '6': (" Integrals", action6),
    '7': (" Sum of Matrices", action7),
    '8': (" Exit", action8)
}

while True:
    print("Welcome to the calculator")
    for key, value in option.items():
        print(key + ": " + value[0])

    selected_option = input("Select an option: ")

    if selected_option in option:
        print(option[selected_option][0])
        option[selected_option][1]()
    else:
        print("Invalid option")


