def solution(phone_book):
    phone_book.sort()  # 전화번호를 정렬한후
    for i in range(len(phone_book)-1):
        if phone_book[i+1].startswith(phone_book[i]): # 그다음전화번호가 앞의번호로 시작하는지 확인
            return False
    return True


phone_book = ["119", "97674223", "1195524421"]
print(solution(phone_book))