def solution(clothes):
    hash = {} # 의상의 종류가 키인 해시
    for a,b in clothes:
        if b not in hash:
            hash[b] = 1
        else:
            hash[b] += 1
    lst = []
    for i in hash:
        lst.append(hash[i] + 1) # 각 의상의 종류개수 + 선택안할수도 있는 경우하나 더하기
    answer = 1
    for i in lst:
        answer *= i  # 각 경우의 수 다곱하기
    return answer-1 # 최소하나의 의상은 입어야 하므로 아무것도 없는 경우 하나빼기


clothes = [["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]
print(solution(clothes))