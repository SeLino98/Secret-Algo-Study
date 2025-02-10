import sys


def solve():
    input = sys.stdin.readline
    T = int(input().strip())  # 테스트 케이스 개수

    for _ in range(T):
        scores = list(map(int, input().split()))  # 5개의 점수 입력받기
        scores.sort()  # 정렬

        mid_scores = scores[1:4]  # 최댓값, 최솟값 제외
        if max(mid_scores) - min(mid_scores) >= 4:  # 중간 3개의 값 중 최대-최소 차이 확인
            print("KIN")
        else:
            print(sum(mid_scores))  # 합 출력


if __name__ == "__main__":
    solve()
