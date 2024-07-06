import heapq

def solution(jobs):
    answer = 0
    time = 0
    jobs_cnt = len(jobs)
    heapq.heapify(jobs)

    temp = []
    while jobs or temp:
        while jobs and jobs[0][0] <= time:
            waiting_time, working_time = heapq.heappop(jobs)
            heapq.heappush(temp, [working_time, waiting_time])

        if temp:
            work, wait = heapq.heappop(temp)
            time += work
            start_time = wait
            answer += time - start_time

        elif jobs:
            waiting_time, working_time = heapq.heappop(jobs)
            time = waiting_time + working_time
            answer += working_time

    return answer // jobs_cnt