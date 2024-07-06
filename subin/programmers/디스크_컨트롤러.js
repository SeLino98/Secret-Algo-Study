class MinHeap {
  constructor() {
    this.heap = [null];
  }

  get size() {
    return this.heap.length - 1
  }

  get min() {
    return this.heap[1]
  }

  swap(idx1, idx2) {
    [this.heap[idx1], this.heap[idx2]] = [this.heap[idx2], this.heap[idx1]];
  }

  heappush(value) {
    this.heap.push(value)
    this.heapifyUp();
  }

  heapifyUp() {
    let idx = this.heap.length - 1;
    while (idx > 1 && this.heap[(idx / 2) >> 0][0] > this.heap[idx][0]) {
      this.swap((idx / 2) >> 0, idx);
      idx = (idx / 2) >> 0;
    }
  }

  heappop() {
    if (this.size === 0) {
      return null;
    }
    if (this.size === 1) {
      return this.heap.pop();
    }
    const min = this.heap[1];
    this.heap[1] = this.heap.pop();
    this.heapifyDown(1);
    return min;
  }

  heapifyDown(idx) {
    while (idx * 2 < this.heap.length) {
      let smallerChildIndex = idx * 2
      if (smallerChildIndex + 1 < this.heap.length && this.heap[smallerChildIndex + 1][0] < this.heap[smallerChildIndex][0]) {
        smallerChildIndex ++
      };

      if (this.heap[idx][0] <= this.heap[smallerChildIndex][0]) {
        break
      };
      this.swap(idx, smallerChildIndex);
      idx = smallerChildIndex
    }
  }
}


function solution(jobs) {
  const minHeap = new MinHeap()
  jobs.sort((a, b) => {
    return a[0] - b[0];
  })
  let length = jobs.length
  let totalTime = 0
  let start = -1
  let end = 0
  let i = 0

  while (i < length || minHeap.size > 0) {
    // 기간 내에 있는 것 넣기
    // 파이썬처럼 체인 비교가 안된다!!!
    while (i < length && start < jobs[i][0] && jobs[i][0] <= end) {
      minHeap.heappush([jobs[i][1], jobs[i][0]])
      i++
    }

    // 힙 사이즈가 있으면?
    if (minHeap.size > 0) {
      const curr_job = minHeap.heappop()
      start = end
      end += curr_job[0]
      totalTime += end - curr_job[1]
    } else {
      // 다음 힙으로 넘어가기
      end = jobs[i][0]
    }
  }
  const answer = Math.floor(totalTime / length)
  return answer
}

console.log(solution([[0, 3], [1, 9], [2, 6]]));