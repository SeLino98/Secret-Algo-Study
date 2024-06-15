def solution(genres, plays):
    songs = len(genres) # 노래 총 몇 곡 있는지
    genres_dic = {} # 몇 번 재생되었는지 확인용
    song_dic = {} # 노래 번호별 재생 횟수
    answer = [] # 노래 목록

    for many in range(songs):
        if genres[many] in genres_dic.keys():
            genres_dic[genres[many]] += plays[many]
        else:
            genres_dic[genres[many]] = plays[many]

    for i in range(songs):
        if genres[i] in song_dic.keys():
            song_dic[genres[i]].append((plays[i], i))
        else:
            song_dic[genres[i]] = [(plays[i], i)]

    how_many = []
    for k,v in genres_dic.items():
        how_many.append((v,k))
    how_many.sort(reverse=True)
    # 많이 재생된 장르부터 담는다
    for i in how_many:
        song_dic[i[1]].sort(reverse=True)
        if len(song_dic[i[1]]) < 2:
            answer.append(song_dic[i[1]][0][1])
        else:
            # 동일하게 들으면 작은 것부터 해야하는데 이걸 어떻게 처리하지??
            temp = []
            for two in range(2):
                if not temp:
                    temp.append(song_dic[i[1]][two])
                else:
                    if song_dic[i[1]][two][0] == temp[0][0]:
                        if song_dic[i[1]][two][1] >= temp[0][1]:
                            temp.append(song_dic[i[1]][two])
                        else:
                            temp.insert(0,song_dic[i[1]][two])
                    else:
                        temp.append(song_dic[i[1]][two])
            answer.append(temp[0][1])
            answer.append(temp[1][1])
    return answer