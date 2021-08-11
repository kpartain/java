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
    enqueue(value) {
        var new_node = new SLNode(value);

        if (this.isEmpty()) {
            this.head = new_node;
            this.tail = new_node;
        } else {
            this.tail.next = new_node;
            this.tail = new_node;
        }
        this.size++;
        return this;
    }
    dequeue() {
        if (this.isEmpty()) {
            return null;
        }
        var removed_val = this.head.value;
        this.head = this.head.next;

        if (!this.head) {
            this.tail = null;
        }
        this.size--;
        return removed_val;
    }
    isEmpty() {
        return !this.head;
    }
    getSize() {
        return this.size;
    }
    front() {
        return this.head ? this.head.value : null;
    }
    printPretty() {
        let runner = this.head;
        let printString = "~ SLQueue ~ HEAD--(";
        while (runner && runner.next) {
            printString += runner === this.tail ? "TAIL " : "";
            printString += `${runner.value})->(`;
            runner = runner.next;
        }
        printString += runner === this.tail ? "TAIL " : "";
        printString += `${runner.value})->null\n`;
        console.log(printString);
    }
    // equals
    // Write a method on the Queue class that, given another queue, will return whether they are equal (same items in same order).
    // Do not use any extra array or objects as storage. Do not alter (pop from or push into) either queue.
    equals(secondQ) {}
    // isPalindrome
    // Write a method on the Queue class that returns whether or not the queue is a palindrome Use only 1 stack as additional storage
    //(no additional arrays / objects).
    isPalindrome() {}
}

/* 
 _____ _____ ____ _____ ___ _   _  ____ 
|_   _| ____/ ___|_   _|_ _| \ | |/ ___|
  | | |  _| \___ \ | |  | ||  \| | |  _ 
  | | | |___ ___) || |  | || |\  | |_| |
  |_| |_____|____/ |_| |___|_| \_|\____|
*/

var q1 = new SLQueue();
q1.enqueue(1);
q1.enqueue(2);
q1.enqueue(3);

var q2 = new SLQueue();
q2.enqueue(3);
q2.enqueue(2);
q2.enqueue(1);
console.log(q1.equals(q2)); // SHOULD RETURN FALSE

var q3 = new SLQueue();
q3.enqueue("a");
q3.enqueue("b");
q3.enqueue("c");
console.log(q3.isPalindrome()); // SHOULD RETURN FALSE
