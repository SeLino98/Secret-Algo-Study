from itertools import permutations

def go_dungeon(order, fatigue, dungeons):
    defeat_dungeon = 0
    for sunseo in order:
        if fatigue >= dungeons[sunseo][0]:
            fatigue -= dungeons[sunseo][1]
            defeat_dungeon += 1
        else:
            return defeat_dungeon
    return defeat_dungeon

def solution(k, dungeons):
    dungeon_cnt = len(dungeons)
    can_go_sunyeol = permutations([i for i in range(dungeon_cnt)], dungeon_cnt)
    return max(list(map(lambda order: go_dungeon(order, fatigue=k, dungeons=dungeons), can_go_sunyeol)))