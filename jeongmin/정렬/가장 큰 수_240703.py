def solution(numbers):
    num_str = [str(num) for num in numbers]  # 숫자로 되어있는 것들 문자로 바꾸기 : O(n)
    num_str.sort(reverse=True, key=lambda x : x*4)  # 330이랑 3이 나오면 3이 먼저 올 수 있게하고, 1보다 6이 먼저 올 수 있게 하기 : O(n log n)
    # 문제 조건이 '0 이상 1,000 이하'라서 x*3만 해줘도 된다!!
    answer = "".join(num_str)  # 리스트에 들어가 있는 것들 합치기(내림차순이니까 합치는 수가 가장 큰 것) : O(n)
    return answer if answer[0] != "0" else "0"  # 0은 1개만 오면 되니까 그것만 예외처리 : O(1)