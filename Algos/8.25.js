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
        let newValIndex = this.heap.length-1; 
        //console.log(heapLength);

        // 2. CHECK FOR PARENT VALUES
        while((Math.floor(newValIndex/2)) != 0){
            let parentIndex = Math.floor(newValIndex/2);
            //3. Is it Greater or Smaller
            if(this.heap[newValIndex] < this.heap[parentIndex]){
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
}

var emptyHeap = new MinHeap();

var heapOne = new MinHeap();
var seeder = [null, 1, 3, 4, 8, 7, 5, 6];
heapOne.heap = seeder;
console.log(heapOne);
console.log("Minimum:",heapOne.getMin());
heapOne.insert(0);
console.log(heapOne);

