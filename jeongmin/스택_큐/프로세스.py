from collections import deque

def solution(priorities, location):
    pri_que = deque([(priorities[i], i) for i in range(len(priorities))])
    find_process = (priorities[location], location)
    max_process = deque(sorted(priorities, reverse=True))
    count = 0
    while pri_que:
        process = pri_que.popleft()
        if max_process[0] == process[0]:
            max_process.popleft()
            count += 1
            if process == find_process:
                return count
        pri_que.append(process)
