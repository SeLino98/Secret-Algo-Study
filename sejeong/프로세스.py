def solution(priorities,location):
    q = []
    answer = 0
    for idx,pri in enumerate(priorities):
        q.append((idx,pri))  # q에다가 인덱스와 우선순위를 같이 넣기
    while q:
        max_v = max(q,key=lambda x:x[1])[1]  # 우선순위가 가장높은 것 찾기
        t =q.pop(0)
        if t[1] < max_v: # 우선순위가 안높으면 q의 뒤로 보내기
            q.append(t)
        else:   # 가장높은 우선순위이면 실행하므로 실행횟수세기
            answer +=1
            if t[0] == location: # 우리가 찾는 인덱스위치이면
                return answer   # 실행횟수 출력



priorities = [1, 1, 9, 1, 1, 1]
location = 0
print(solution(priorities,location))