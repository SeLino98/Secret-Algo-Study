# 갈색은 (가로 + 세로-2)*2
# 노란색은 (가로-2)*(세로-2) = 약수조합으로 구해도 된다

def solution(brown, yellow):
    for i in range(brown//2, 0, -1):  # brown에서 반만 확인('가로+세로-2'의 값 범위니까)
        if yellow % (i-2) == 0:  # i가 노란색의 약수면
            j = (yellow // (i-2)) + 2  # 약수의 대칭값 찾아서
            if (i+j-2)*2 == brown:  # brown이랑도 부합하는지 확인 후
                return [i, j] if i >= j else [j, i]  # 답으로 구하기

# brown 범위 오름차순으로 검토한 버전
# def solution(brown, yellow):
#     for i in range(3, brown//2+1):
#         if yellow % (i-2) == 0:
#             j = (yellow // (i-2)) + 2
#             if (i+j-2)*2 == brown:
#                 return [i, j] if i >= j else [j, i]