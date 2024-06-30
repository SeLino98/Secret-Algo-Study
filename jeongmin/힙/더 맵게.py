import heapq

def solution(scoville, K):
    count = 0
    heapq.heapify(scoville)   # heap으로 만들어주고

    while len(scoville) > 1:    # heap 길이가 1이기 전까지 반복해서 계산
        first = heapq.heappop(scoville)
        if first >= K:    # 첫번째가 K보다 크면 조건 성공이니까 count 반환
            return count
        second = heapq.heappop(scoville)
        heapq.heappush(scoville, first + second*2)  # 문제와 같이 연산
        count += 1

    return count if scoville[0] >= K else -1  # 다 계산했는데도 K보다 안크면 -1 반환
