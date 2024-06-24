from collections import deque


def solution(bridge_length, weight, truck_weights):
    truck_weights = deque(truck_weights)  # 대기 중인 트럭들
    bridge = deque([0] * bridge_length)  # 다리 위의 트럭들 (0은 빈 공간)
    current_weight = 0  # 현재 다리 위 트럭들의 무게 합
    current_time = 0  # 총 시간

    while truck_weights or current_weight > 0:
        # 시간 증가
        current_time += 1

        # 다리의 첫 번째 칸(가장 앞)을 비우고, 그 트럭 무게만큼 현재 무게에서 뺀다
        current_weight -= bridge.popleft()

        if truck_weights:
            # 다음 트럭이 다리에 올라올 수 있는지 확인
            if current_weight + truck_weights[0] <= weight:
                truck = truck_weights.popleft()
                bridge.append(truck)
                current_weight += truck
            else:
                # 올라올 수 없으면 0을 추가하여 시간이 흐르게 한다
                bridge.append(0)

    return current_time