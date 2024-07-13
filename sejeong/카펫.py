def solution(brown,yellow):
    area = brown + yellow  # 전체격자를 더해 넓이를 계산
    arr = []
    for i in range(1,area+1):  # 두수를 곱해서 넓이가 나올수있는 쌍 구하기
        if area % i == 0:
            if i >= area //i:  # 가로가 크거나 같으므로
                arr.append((i,area//i))  # (가로,세로) 쌍 넣기
    for a,b in arr:  # 가로세로가 될수있는 경우를 돌면서 그경우의 갈색격자수의 개수가 가지고있는격자수와일치하는지
        if (a * 2) + ((b-2) *2) == brown:
            return [a,b]
brown = 10
yellow = 2
print(solution(brown,yellow))
# 카펫의 가로 세로 크기 출력 , 가로는 세로와 같거나 더 길다