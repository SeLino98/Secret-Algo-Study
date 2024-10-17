def function():
    if A < B:
        print("<")
    elif A > B:
        print(">")
    else:
        print('==')


A, B = input().split()
A = int(A)
B = int(B)
function()