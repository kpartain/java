class CircleQueue {
    constructor(capacity) {
        this.size = 0;
        this.head_index = -1;
        this.tail_index = -1;
        this.items = new Array(capacity);
        this.capacity = capacity;
    }
    // Adds a new element into the list.
    enqueue(val) {
        // CIRCLE QUEUE IS FULL
        if (this.size == this.capacity) {
            console.log("Queue is full");
            return false;
        }
        // CIRCLE QUEUE IS EMPTY
        else if (this.head_index === -1) {
            this.head_index = 0;
            this.tail_index = 0;
            this.items[this.head_index] = val;
            this.size++;
        } else {
            // CIRCLE QUEUE IS PARTIALY FULL
            let x = this.tail_index % this.capacity;
            console.log(">(inside enqueue func) available index:", x);
            this.items[x + 1] = val;
            this.tail_index++;
            this.size++;
        }
    }
    //removes the last value
    dequeue() {
        // if (this.size == 0) {
        //     return false;
        // }
        // var removedValue = this.items[this.head_index - this.capacity];
        // let indexToRemove = this.head_index % this.capacity;
        // this.items[indexToRemove] = null;
        // this.head_index++;
        // this.size--;
        // return removedValue;
    }
}

var circQ = new CircleQueue(4);
circQ.enqueue(1);
circQ.enqueue(2);
console.log("EXPECT 1, 2\n", circQ);
circQ.enqueue(5);
console.log("EXPECT 1, 2, 5\n", circQ);
circQ.enqueue(3);
circQ.enqueue(4);
//should not be able to add another
console.log("EXPECT 1, 2, 5, 3\n", circQ);
