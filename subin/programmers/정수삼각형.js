function solution(triangle) {
  const N = triangle.length  // 삼각형 깊이
  const numbers = Array(2 ** (N - 1)).fill([triangle[0][0], [0, 0]]) // 삼각형 기초와 현재 위치
  let idx = 0
  while (true) {
    // 위치
    const leftI = numbers[idx][1][0]
    const leftJ = numbers[idx][1][1]
    const rightI = numbers[idx + 1][1][0]
    const rightJ = numbers[idx + 1][1][1]
    if (rightJ === N - 1) {
      break
    }
    // 해당 num
    let leftNum = numbers[idx][0]
    let rightNum = numbers[idx + 1][0]
    
    leftNum += triangle[leftI + 1][leftJ]
    rightNum += triangle[rightI + 1][rightJ + 1]

    numbers[idx] = [leftNum, [leftI + 1, leftJ]]
    numbers[idx + 1] = [rightNum, [rightI + 1, rightJ + 1]]

    idx += 2
    if (idx === 2 ** (N - 1)) {
      idx = 0
    }
  }

  const ans = Math.max(...numbers)

  return numbers
}

console.log(solution([[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]))