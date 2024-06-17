# progresses : 배포되어야 하는 순서대로의 작업
# speeds : 각 작업의 개발 속도
# 진도 100되면 배포 가능, 근데 앞의 것부터 배포된다.
# 각 배포당 몇 개의 기능이 배포되는가?

from collections import deque

def solution(progresses, speeds):
    progresses = deque(progresses)
    speeds = deque(speeds)
    answer = []
    while progresses:
        count = 0
        for i in range(len(progresses)):
            if progresses[i] < 100:
                if progresses[i] + speeds[i] >= 100:
                    progresses[i] = 100
                else:
                    progresses[i] += speeds[i]
        if progresses[0] == 100:
            while progresses and progresses[0] == 100:
                progresses.popleft()
                speeds.popleft()
                count += 1
                if len(progresses) == 0 or progresses[0] != 100:
                    answer.append(count)
    return answer