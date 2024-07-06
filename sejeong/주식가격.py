def solution(prices):
    n = len(prices)
    answer = [0] * n
    stack = []  # 계산덜된 주식가격 인덱스 넣는 스택

    for i in range(n):
        while stack and prices[stack[-1]] > prices[i]:  # 전의 주식가격이 더크면 계산하기
            j = stack.pop()
            answer[j] = i - j
        stack.append(i)

    while stack: # 나머지 안떨어진 주식가격 계산하기
        j = stack.pop()
        answer[j] = n - 1 - j

    return answer

prices = [1, 2, 3, 2, 3]
print(solution(prices))
