# list 탐색 풀이 - stack이랑 비슷
# from collections import deque
#
# def solution(s):
#     queue_s = deque(s)
#     count = 0
#
#     for bracket in queue_s:
#         count = count + 1 if bracket == '(' else count - 1
#         if count < 0:
#             return False
#     return not count

# Queue 풀이 - 제일 느림
# from collections import deque
#
# def solution(s):
#     queue_s = deque(s)
#     count = 0
#     while queue_s:
#         count = count + 1 if queue_s.popleft() == '(' else count - 1
#         if count < 0:
#             return False
#     return not count

# Stack 풀이 - 제일 빠름
from collections import deque

def solution(s):
    queue_s = deque()
    for bracket in s:
        if bracket == '(':
            queue_s.append(bracket)
        else:
            if not queue_s:
                return False
            else:
                 queue_s.pop()
    return not queue_s