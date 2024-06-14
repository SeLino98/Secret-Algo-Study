def solution(genres,plays):
    result = []
    hash = {} # 장르가 키가 되고 장르의 모든 재생횟수가 값이되는 해시
    for i in range(len(genres)):
        if genres[i] not in hash:
            hash[genres[i]] = plays[i]
        else:
            hash[genres[i]] += plays[i]
    hash = sorted(hash.items(),key=lambda x:-x[1]) # 가장많이 재생된장르순서대로 정렬
    arr = []
    for i in range(len(genres)):
        arr.append((genres[i],plays[i],i)) # arr배열에 (장르,재생횟수,고유번호) 담기
    # 재생횟수는 내림차순 고유번호는 오름차순정렬
    arr = sorted(arr,key=lambda x:(-x[1],x[2]))

    for i in hash:
        cnt = 0
        for j in arr:
            if j[0] == i[0] : #장르가 같으면 고유번호 담기
                cnt += 1
                if cnt > 2 :  # 2개씩만 담기위해
                    break
                result.append(j[2])

    return result




genres = ["classic", "pop", "classic", "classic", "pop"]
plays = [500, 600, 150, 800, 2500]
print(solution(genres,plays))