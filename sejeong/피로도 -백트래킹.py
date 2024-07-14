
def solution(k,dungeons):
    visited = len(dungeons) * [False] # 던전길이만큼 방문배열만들기
    def back(current_k,visited):
        max_v = 0
        for i in range(len(dungeons)):
            if visited[i] == False and dungeons[i][0] <= current_k: # 방문하지 않았고 들어갈수있으면
                visited[i] = True # 방문하고 백트래킹으로 최대 던전수 구하기
                max_v = max(max_v,1+back(current_k-dungeons[i][1],visited))
                visited[i] = False
        return max_v


    return back(k,visited)


k = 80
dungeons = 	[[80,20],[50,40],[30,10]]
print(solution(k,dungeons))