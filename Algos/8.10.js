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
        var nodeToAdd = new SLNode(value);
        //if there is nothing in this list
        if (this.head == null) {
            this.head = nodeToAdd;
            this.tail = nodeToAdd;
            //if the head and tail are the same (only one item)
        } else {
            this.tail.next = nodeToAdd;
            this.tail = nodeToAdd;
        }
        this.size++;
        return this;
    }

    //remove first value of the list
    dequeue() {
        //if we have an empty list, nothing to remove
        var returnedValue = null;
        if (this.head == null) {
            returnedValue = false;
            //otherwise if we only have a head (one value)
        } else if (this.head == this.tail) {
            returnedValue = this.head;
            this.head = null;
            this.size--; //should be 0
            //otherwise if we have more than two values
        } else {
            returnedValue = this.head;
            this.head = this.head.next;
            this.size--;
        }
        return returnedValue;
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
        var returnString = "";
        if (this.head == null) {
            returnString = "The SLQueue is empty";
        } else if (this.head == this.tail) {
            returnString =
                "The SLQueue has one node with a value of " + this.head.value;
        } else {
            returnString += "Head: " + this.head.value + ", ";
            var runner = this.head;
            while (runner.next.next != null) {
                runner = runner.next;
                returnString += "Node: " + runner.value + ", ";
            }
            returnString += "Tail: " + runner.next.value;
        }
        console.log(returnString);
    }
}

var queue = new SLQueue();
queue.enqueue(1);
queue.enqueue(2);
queue.enqueue(3);
queue.enqueue(4);
console.log("Start: ");
queue.printPretty();
console.log("After dequeue: ");
queue.dequeue();
queue.printPretty();
console.log("Is empty? ", queue.isEmpty());
console.log("Size: ", queue.getSize());
console.log("Front: ", queue.front());
