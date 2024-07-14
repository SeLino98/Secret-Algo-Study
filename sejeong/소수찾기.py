# from itertools import permutations
# def sosu(num):  # 소수인지 검사하는 함수
#     if num < 2:  # 0 과 1 거르기
#         return False
#     for i in range(2,num): # 소수는 자기자신과 1로만나누어떨어지므로 2부터 자신의 수전까지의 수로
#         if num % i == 0:   # 나누었을떄 나머지가 0이 나올수 없다
#             return False
#     return True
#
#
# def solution(numbers):
#     answer = 0
#     lst = []
#     for i in numbers:
#         lst.append(i)  # lst = ['1','7']
#     lst2 = []  # lst2 = [1, 7, 17, 71]
#     for i in range(1,len(numbers)+1):
#         arr = permutations(lst,i)  # 순열사용하기
#         for k in arr:
#             if int(''.join(k)) in lst2:  # 중복제거하기
#                 continue
#             lst2.append(int(''.join(k)))
#
#
#     for i in lst2:  # numbers로 만들수 있는 모든 수를 소수인지 검사하기
#         if sosu(i) == True:
#             answer += 1
#     return answer
#
#
#
# numbers = "011"
# print(solution(numbers))





