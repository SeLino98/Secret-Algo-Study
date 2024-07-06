def solution(citations):
    citations.sort(reverse=True)
    cnt = 0
    for i in citations:  #citations배열의 각요소를 돌면서 몇번인용되어있는지의 수가 개수세어서 몇편인용되었는지보다 작거나 같은것이 h-index값
        if cnt >= i:
            return cnt
        cnt += 1
    return cnt  # 배열의 마지막요소가 같을때 for 문에 안걸리므로 마지막 h-index값 출력


citations = [4,4,4,3]
# 각 인용된 횟수 , h번이상인용된 논문이 h편 이상일때 h가 h -index다

print(solution(citations))