# 풀이 최신순 정렬
from itertools import permutations
import math

def making_num(number):
    find_all_johap = set()
    for length in range(1, len(number)+1):
        num_johap = permutations(number, length)
        for maked_number in num_johap:
            find_all_johap.add(int("".join(maked_number)))
    return find_all_johap

def sosu(num): # 약수 대칭성을 활용해 √n보다 작은 것들만 조사
    if num < 2:
        return False
    elif num == 2:
        return True
    else:
        jegobgeun = int(math.sqrt(num)) + 1
        for i in range(2, jegobgeun):
            if num % i == 0:
                return False
        return True

def solution(numbers):
    answer = 0
    all_number = making_num(numbers)
    for num in all_number:
        if sosu(num):
            answer += 1
    return answer

#
# from itertools import permutations
#
# def making_num(number):
#     find_all_johap = set()   # 중복 제거 한번에 & 시간복잡도 줄이기위해 set 사용
#     for length in range(1, len(number)+1):  # 나올 수 있는 숫자조합 순열로 전부 구해보기
#         num_johap = permutations(number, length)
#         for maked_number in num_johap:
#             find_all_johap.add(int("".join(maked_number)))   # 문자였던 걸 숫자로 바꿔서 set에 담아주기
#     return find_all_johap
#
# def sosu(num):
#     if num == 0 or num == 1:
#         return False
#     for i in range(2, num-1):   # 2부터 n-1까지 나눠서 소수인지 확인
#         if num % i == 0:
#             return False
#     return True
#
# def solution(numbers):
#     answer = 0
#     all_number = making_num(numbers)  # 만들 수 있는 모든 수 만들기
#     for num in all_number:
#         if sosu(num):  # 소수면 +1하기
#             answer += 1
#     return answer

# 예전에 풀었던 것(23년도)
# answer = 0
# def findSosu(num):
#     global answer
#     for i in range(1, num):
#         if i != 1 and num % i == 0:
#             return 0
#     if num > 1:
#         answer += 1
#     return 1
#
# def solution(numbers):
#     global answer
#     n = len(numbers)
#     visited = [0 for _ in range(n)]
#     check = set()
#
#     def sunyeol(result, n):
#         temp2 = int(result)
#         if temp2 != 0:
#             if not temp2 in check:
#                 findSosu(temp2)
#                 check.add(temp2)
#         for i in range(n):
#             if visited[i] == 0:
#                 temp3 = ""
#                 temp3 += result
#                 temp3 += numbers[i]
#                 visited[i] = 1
#                 sunyeol(temp3, n)
#                 visited[i] = 0
#
#     for i in range(n):
#         temp = ""
#         temp += numbers[i]
#         visited[i] = 1
#         sunyeol(temp, n)
#         visited[i] = 0
#
#     return answer