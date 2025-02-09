import sys

def solve():
    input = sys.stdin.readline  # 함수 자체를 저장
    size_a = len(list(input().strip()))
    size_b = len(list(input().strip()))
    if size_a < size_b:
        print("no")
    else:
        print("go")


if __name__ == "__main__":
    solve()
