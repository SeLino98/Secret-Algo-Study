function solution(m, n, puddles) {
  // Array.from(arrayLike, mapFn)
  // arrayLike 배열로 변환할 순회 가능 또는 유사 배열 객체
  // mapFn 배열의 모든 요소에 대해 호출할 함수
  // 셋 다 2차원 배열 생성 방법으로 가독성이나 초기화 방식, 성능은 Array.from이 더 좋다고할 수 있다.
  // const arr = Array.from(Array(m), () => new Array(n))
  // const arr = Array.from({length : m}, () => new Array(n))
  // const arr = new Array(m).fill().map(() => new Array(n))
  const road = Array.from({length: n}, () => new Array(m).fill(0))  // 빈 길 생성
  // 집 표시
  road[0][0] = 1
  // 웅덩이 표시
  for (const [pc, pr] of puddles) {
    road[pr - 1][pc - 1] = -1
  }
  for (let r = 0; r < n; r++) {
    for (let c = 0; c < m; c ++) {
      // 웅덩이 있는 경우 경로가 없으므로 0
      if (road[r][c] === -1) {
        road[r][c] = 0;
        continue
      }
      if (r > 0) {
        road[r][c] += road[r - 1][c]
      }
      if (c > 0) {
        road[r][c] += road[r][c - 1]
      }
      // 오버 플로우 방지하여 숫자 자료형 범위 내로 계산하도록 하기
      // (a + b) % m = ((a % m) + (b % m)) % m -> 모듈러 연산
      road[r][c] %= 1000000007  
    }
  }
  return road[n-1][m-1];
}