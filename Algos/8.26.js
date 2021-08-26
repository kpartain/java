class MinHeap {
    //MinHeap is a priority queue optimizd for fast retrieval of the minimum value
    //it uses an array but is best visualized using a tree structure where each node has left/right child
    //left child is 2i
    //right child is 2i + 1
    //parent of a given node is Math.Floor(i/2) will work for either child
    //           1
    //          / \
    //         3   4
    //        /\   /\
    //       8  7 5  6
    constructor() {
        this.heap = [null];
    }

    getMin() {
        return this.heap[1];
    }

    insert(num) {
        // 1. PUSH THE VALUE INTO THE ARRAY
        this.heap[this.heap.length] = num;
        let newValIndex = this.heap.length - 1;
        //console.log(heapLength);

        // 2. CHECK FOR PARENT VALUES
        while (Math.floor(newValIndex / 2) != 0) {
            let parentIndex = Math.floor(newValIndex / 2);
            //3. Is it Greater or Smaller
            if (this.heap[newValIndex] < this.heap[parentIndex]) {
                // 4. SWAP IF NECESSARY
                let temp = this.heap[parentIndex];
                this.heap[parentIndex] = this.heap[newValIndex];
                this.heap[newValIndex] = temp;
                newValIndex = parentIndex;
            } else {
                return this;
            }
        }
        return this;
    }

    extract() {
        let temp = this.heap[this.heap.length-1];
          this.heap[this.heap.length-1] = this.heap[1];
          this.heap[1] = temp;
          let answer = this.heap.pop()
  
        // THE INDEX OF THE VALUE THAT WE ARE SWAPPING
        var index = 1;
        var leftIdx = index * 2;
        var rightIdx = leftIdx + 1;
        
        while( leftIdx < this.heap.length - 1){
          // IS A SWAP NECESSARY
          if(this.heap[index] > this.heap[leftIdx] || this.heap[index] > this.heap[rightIdx]){
            if(this.heap[leftIdx] < this.heap[rightIdx]){
              //Swap for the left value
              [this.heap[index], this.heap[leftIdx]] = [this.heap[leftIdx], this.heap[index]];
              index = leftIdx;
            }
            else{
              //Swap for the right value
              [this.heap[index], this.heap[rightIdx]] = [this.heap[rightIdx], this.heap[index]];
              index = rightIdx; 
            }
          }
          leftIdx = index * 2;
          rightIdx = leftIdx + 1;
        }
        // RETURN THE MIN
        return answer;
    }
}

// var emptyHeap = new MinHeap();

// var heapOne = new MinHeap();
// var seeder = [null, 1, 3, 4, 8, 7, 5, 6];
// heapOne.heap = seeder;
// console.log(heapOne);
// console.log("Minimum:", heapOne.getMin());
// heapOne.insert(0);
// console.log(heapOne);

var heapTwo = new MinHeap();
var seeder2 = [null, 1, 3, 4, 8, 7, 5, 6];
heapTwo.heap = seeder2;
console.log("ORIGINAL\n",heapTwo);
console.log("Min found", heapTwo.extract());
console.log("AFTER\n",heapTwo);