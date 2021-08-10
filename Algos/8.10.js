class SLNode {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}
class SLQueue {
    constructor() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //add value to end of list
    enqueue(value) {

    }

    //add value to start of list
    dequeue() {

    }

    isEmpty() {
        this.size == 0 ? true : false;
    }

    getSize() {
        return this.size;
    }

    front() {
        return this.head;
    }

    printPretty() {

    }
}
