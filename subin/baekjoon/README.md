# VSCode에서 JavaScritp로 백준 문제 풀기
## 1. VSCode 설치
VSCode가 설치되어 있지 않다면 VSCode 홈페이지에서 다운로드하여 설치
## 2. Node.js 설치
Node.js가 설치되어 있지 않다면 Node.js 홈페이지에서 LTS 버전을 다운로드하여 설치
## 3. 로컬 코드 
```javascript
const fs = require('fs');
const input = fs.readFileSync('input.txt').toString().trim().split(' ');

const a = parseInt(input[0]);
const b = parseInt(input[1]);

console.log(a + b);
```
## 4. 제출 코드
```javascript
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split(' ');

const a = parseInt(input[0]);
const b = parseInt(input[1]);

console.log(a + b);
```