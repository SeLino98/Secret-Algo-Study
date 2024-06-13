def solution(clothes):
    # 의상 종류에 따른 의상 이름 리스트 딕셔너리
    dic_clothes = {}
    for dress in clothes:
        if dress[1] in dic_clothes:
            dic_clothes[dress[1]].extend([dress[0]])
        else:
            dic_clothes[dress[1]] = [dress[0]]
    # 종류별 전체 옷이 몇 벌씩 있는지
    how_many_clothes = [len(dic_clothes[clothes_list]) for clothes_list in dic_clothes]
    # 경우의 수에 따라 (각 요소+1)한걸 전부 곱한 후 -1 해주면 됨
    answer = 1
    for count in how_many_clothes:
        answer *= (count + 1)
    return answer - 1