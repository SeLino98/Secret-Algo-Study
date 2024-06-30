def solution(s):
    stack = []
    for i in s:
        if i == '(':
            stack.append(i)
        else:
            if len(stack) == 0: # )로시작하면 짝을 맞출수 없으므로 바로 False출력
                return False
            else:
                stack.pop()
    if len(stack) == 0:
        return True
    else:
        return False


s = "()()"
print(solution(s))