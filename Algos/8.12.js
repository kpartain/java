class SLNode {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class SLStack {
    constructor() {
        this.head = null;
        this.length = 0;
    }

    isEmpty() {
        return this.head == null;
    }
    push(value) {
        var new_node = new SLNode(value);
        new_node.next = this.head;
        this.head = new_node;
        this.length++;
    }
    pop() {
        if (!this.head) {
            return null;
        }
        var removed = this.head.value;
        this.head = this.head.next;
        this.length--;
        return removed;
    }

    size() {
        return this.length;
    }

    peek() {
        return this.head ? this.head.value : null;
    }
    printPretty() {
        let runner = this.head;
        let printString = "~ SLStack ~ HEAD--(";
        while (runner.next != null) {
            printString += runner.value + ")->(";
            if(runner.next != null) {
                runner = runner.next;
            }
        }
        printString += runner.value + ")->null\n";
        console.log(printString);
    }
    reverse() {
        var tempStack = new SLStack();
        while (this.head) {
            tempStack.push(this.pop());
        }
        this.head = tempStack.head;
        this.length = tempStack.length;
    }
    /** Methods will be in the STACK class Returns a new stack that is copy of the original stack.
     * Retain the original order. You may create extra temp SLStacks and/or SLQueues as storage.
     * @returns {SLStack} Copy of the original stack
     */
    copy() {
        let temp = new SLStack();
        let temptwo = new SLStack();
        var originalLength = this.length;
        while(temptwo.length != originalLength){
            this.length != 0 ? temp.push(this.pop()) : temptwo.push(temp.pop());
        }
        return temptwo;
    }
    /**
     * Rearranges the stack so that numbers > 0 are on the top and any negatives are on the bottom
     * Retain the order of the positives and negatives Use extra stacks and/or queues as storage.
     */
    partitionPositives() {
        let pos = new SLStack();
        let neg = new SLStack();
        let origLength = this.length;
        while (!this.isEmpty()) {
            this.peek() < 0 ? neg.push(this.pop()) : pos.push(this.pop());
        }
        while (this.length != origLength) {
            neg.length != 0 ? this.push(neg.pop()) : this.push(pos.pop());
        }
        return this;
    }
}

var s1 = new SLStack();
s1.push(1);
s1.push(2);
s1.push(3);
console.log("ORIGINAL");
s1.printPretty();
var copyOfS1 = s1.copy();
console.log("COPIED STACK");
copyOfS1.printPretty();

var sl2 = new SLStack();
sl2.push(1);
sl2.push(-2);
sl2.push(-3);
sl2.push(5);
sl2.push(6);
console.log("ORIGINAL TWO");
sl2.printPretty();
console.log("PARTITIONED");
var partS = sl2.partitionPositives();
partS.printPretty();
// 6 5 1 -3 -2
