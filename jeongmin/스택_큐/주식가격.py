# 처음 푼 풀이
def solution(prices):
    answer = []
    stock_length = len(prices)
    for now_idx in range(stock_length):
        if now_idx == stock_length-1:
            answer.append(0)
            return answer
        else:
            count = 0
            for next_idx in range(now_idx + 1, stock_length):
                count += 1
                if prices[now_idx] > prices[next_idx]:
                    break
            answer.append(count)
    return answer


# 스택으로 푸는 풀이!!
# def solution(prices):
#     n = len(prices)
#     # 답을 넣을 공간 크기에 맞게 미리 만들어놓기(정적 할당)
#     answer = [0] * n
#     stack = []
#
#     # 인덱스 비교를 위해 전체 순회한다
#     for i in range(n):
#         # 스택이 비어 있지 않고(앞 가격들이 기준 가격보다 더 작은 것들이 있을때)
#         # 현재 가격이 스택의 마지막 가격보다 낮으면(스택마지막부터 비교해서 일자 늘려나가는 것)
#         while stack and prices[i] < prices[stack[-1]]:
#             # 제일 가까운 날의 가격 인덱스
#             idx = stack.pop()
#             # 다음날보다 가격이 높은 거니까 가격이 떨어져있는 상태일때 일자 측정(현재와 과거 인덱스=일자 비교)
#             answer[idx] = i - idx
#         # 당일 가격 인덱스 넣기(비교용으로 나보다 작은 가격 나오기 전까지 담겨있게 된다)
#         stack.append(i)
#
#     # 스택에 남아있는 인덱스 처리 (끝까지 가격이 떨어지지 않음)
#     while stack:
#         # 최종적으로 나보다 작은 가격이 나오지 않은 것들의 인덱스
#         idx = stack.pop()
#         # 전체 날에서 들어간 날 빼기
#         answer[idx] = n - 1 - idx
#
#     return answer
