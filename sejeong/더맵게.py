import heapq

def solution(scoville,K):
    answer = 0
    heapq.heapify(scoville)  # 스코빌배열을 heap으로 만들기
    while len(scoville) >= 2:
        min_v = heapq.heappop(scoville)
        if min_v >= K:  # 가장작은 요소가 K 이상이면 섞은횟수 출력
            return answer
        else:
            min_v2 = heapq.heappop(scoville)
            heapq.heappush(scoville,min_v+(min_v2*2))
            answer += 1 # 횟수세어주기
    # 하나가남았을때 K이상인지 확인하기
    if scoville[0] >= K:
        return answer
    else:
        return -1


scoville = [1,2,3]
K = 10
print(solution(scoville,K))