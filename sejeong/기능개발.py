def solution(progresses):
    answer = []
    x = 0
    day = [] #각 작업당 몇일 후 배포해야하는지 담을 배열
    for i in range(len(progresses)):
        if (100-progresses[i])%speeds[i] == 0:
            x = (100-progresses[i])//speeds[i]
        else:
            x = (100-progresses[i])//speeds[i] + 1
        day.append(x)
    stack = [day[0]]
    cnt = 1

    for i in range(1,len(day)):
        if day[i] > stack[-1]: # 뒤에오는 기간이 더길면
            answer.append(cnt) # 현재까지 배포될수 있는 수 담기
            stack[-1] = day[i] # 비교할 수 다시 바꾸기
            cnt = 1 # cnt수 리셋
        else:
            cnt+=1 # 작으면 배포될수없으므로 cnt세기

    answer.append(cnt) # 마지막 cnt수도 넣기
    return answer

progresses = [95, 90, 99, 99, 80, 99]
speeds = [1, 1, 1, 1, 1, 1]
print(solution(progresses))

# 작업에 걸리는 시간이 5,10,1,1,20,1 뒤에올숫자가 작으면 카운트세기