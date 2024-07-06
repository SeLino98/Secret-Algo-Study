const fs = require('fs')
const io = process.platform === "linux" ? "/dev/stdin" : "./input.txt"
// n 소수 개수
// n개의 수가 arr에 저장
// trim 안해주니까 틀림 양끝 공백 없애주기 :)
const [n, ...arr] = fs.readFileSync(io).toString().trim().split(/\s+/)
const numArray = arr.map(Number)

function isPrime(value) {
  if (value === 1) return false
  for (let i = 2; i < Math.floor(Math.sqrt(value)) + 1; i++) {
    // 제곱근까지 나눠지는지 확인
    if (value % i === 0) {
      return false
    }
  }
  return true
}

let cnt = 0

numArray.forEach((el) => {
  if (isPrime(el)) {
    cnt++
  }
})

console.log(cnt)