def solution(numbers):
    numbers = list(map(str,numbers)) # 리스트의 숫자를 문자열로 바꾸기
    # 문자열의 비교는 첫자리부터 큰순서대로 비교하므로 숫자를 여러번 반복했을때 큰숫자가 오도록 정렬하기
    numbers = sorted(numbers,key=lambda x:x*4,reverse=True)
    answer = ''
    for i in numbers:
        answer += i
    if answer[0] == '0':  # 만약 '000' 이런식으로 될때는 0만출력해야함
        return '0'
    return answer


numbers = [6, 10, 2]
print(solution(numbers))


