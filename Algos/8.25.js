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
        this.heap = [];
    }

    getMin() {
        return this.heap[1];
    }

    insert(num) {
        this.heap.push(num);
        var insertedValueIndex = this.heap.length - 1;
        
        
        while(this.heap[(Math.floor(insertedIndex/2))] != null) {

            var insertedValueParentIndex = Math.floor(insertedIndex/2)
            
            if(this.heap[insertedValueParentIndex] > this.heap[insertedValueIndex]){
                [this.heap[insertedValueIndex], this.heap[insertedValueParentIndex]] = [this.heap[insertedValueParentIndex], this.heap[insertedValueIndex]];
            }
            insertedValueIndex = insertedValueParentIndex;
        }
        
    }
}

var emptyHeap = new MinHeap();

var heapOne = new MinHeap();
var seeder = [null, 1, 3, 4, 8, 7, 5, 6];
heapOne.heap = seeder;
console.log(heapOne);
console.log("Minimum:",heapOne.getMin());

