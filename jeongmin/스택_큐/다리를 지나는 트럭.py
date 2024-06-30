from collections import deque

def solution(bridge_length, weight, truck_weights):
    if len(truck_weights) == 1:
        return bridge_length + 1
    bridge = deque([0 for _ in range(bridge_length)])
    trucks = deque(truck_weights)
    total_weight = weight
    count = 0
    while trucks:
        total_weight += bridge.popleft()
        count += 1
        if total_weight >= trucks[0]:
            truck = trucks.popleft()
            bridge.append(truck)
            total_weight -= truck
        else:
            bridge.append(0)
    if not bridge == deque([0 for _ in range(bridge_length)]):
        while bridge:
            bridge.popleft()
            count += 1
    return count