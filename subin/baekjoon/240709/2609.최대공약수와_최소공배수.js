const fs = require('fs')
const io = process.platform === "linux" ? "/dev/stdin" : './input.txt';

const [x, y] = fs.readFileSync(io).toString().trim().split(' ').map(Number)

console.log(x, y)