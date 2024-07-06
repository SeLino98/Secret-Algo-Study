def solution(bridge_length,weight,truck_weights):
    second = 0
    current_w = 0  # 현재 다리의 무게
    queue = [0] * bridge_length  # 다리

    while truck_weights:
        second += 1
        current_w -= queue.pop(0)
        if current_w + truck_weights[0] <= weight:  # 다리에 트럭이 들어갈 수 있으면
            queue.append(truck_weights[0]) # 다리에 트럭넣고
            current_w += truck_weights.pop(0) # 현재무가증가시키기
        else:
            queue.append(0) # 못들어가면 0넣기

    second += len(queue) # 마지막 트럭이 들어가면 나올때까지 시간더해주기
    return second


bridge_length = 2
weight = 10
truck_weights = [7,4,5,6]
print(solution(bridge_length,weight,truck_weights))