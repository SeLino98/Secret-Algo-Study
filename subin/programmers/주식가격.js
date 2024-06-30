function solution(prices) {
  let ans = Array(prices.length).fill(0)
  let stack = []
  for (let i = 0; i < prices; i++) {
    // 배열이 빈 값이 아니고 해당 가격이 이전에 넣었던 가격보다 적으면 ans에 넣기
    while (stack.length > 0 && prices[i] < prices[stack[stack.length]]) {
      x = stack.pop()
      ans[x] = i - x
    }
    stack.push(i)
  }
  // 끝까지 살아남은 자들의 값을 계산해주기!
  while (stack.length > 0) {
    y = stack.pop()
    ans[y] = prices.length - 1 - j
  }

  return ans
}
console.log(solution([1, 2, 3, 2, 3]))