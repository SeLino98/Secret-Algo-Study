def solution(phone_book):
    # 문자열 특성 이용하기!!
    temp_book = sorted(phone_book)
    # 전체 전화번호 수
    length = len(phone_book)
    # 전부 확인해보기
    for i in range(length):
        # 기준이 되는 전화번호 총 글자 수
        i_len = len(temp_book[i])
        # 맨 처음이나 맨 마지막은 전화번호부 하나씩만 확인 가능
        if i == 0:
            if temp_book[0] in temp_book[1][:i_len]:
                return False
        elif i == (length-1):
            if temp_book[i] in temp_book[i-1][:i_len]:
                return False
        # 나머지는 전부 앞뒤 전화번호부랑 접두사로 확인해보기
        else:
            if temp_book[i] in temp_book[i-1][:i_len] or temp_book[i] in temp_book[i+1][:i_len]:
                return False
    else:
        return True