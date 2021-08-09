class Stack {
    constructor(items = []) {
        this.items = items;
    }
    push(item) {
        this.items[this.items.length] = item;
    }
    // Returns undefined if empty
    pop() {
        var returnedLastIndex = this.items[this.items.length - 1];
        this.items.pop();
        return returnedLastIndex;
    }
    // aka top, returns undefined if empty
    peek() {
        return this.items[this.items.length - 1];
    }
    isEmpty() {
        if (this.items.length == 0) {
            return true;
        } else {
            return false;
        }
    }
    size() {
        return this.items.length;
    }
    print() {
        var returnString = "START-- ";
        for (var i = 0; i < this.items.length; i++) {
            returnString += this.items[i] + " -- ";
        }
        returnString += "END";
        console.log(returnString);
    }
}
var testStack = new Stack([0, 1, 2, 3, 4]);
console.log("BEFORE:");
testStack.print();
console.log(testStack);
testStack.push(5);
console.log("PUSH 5:");
testStack.print();
console.log(testStack);
var returnedElement = testStack.pop();
console.log("RETURNED ELEMENT FROM POP: ", returnedElement);
console.log("AFTER POP: ");
testStack.print();
console.log("PEEK: ", testStack.peek());
console.log("IS EMPTY: ", testStack.isEmpty());
console.log("SIZE: ", testStack.size());

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
        if (this.head == null) {
            return true;
        } else {
            return false;
        }
    }
    // Adds a new node with the given value in front of the head node.
    push(value) {
        var newHead = new SLNode(value);
        if (this.head != null) {
            newHead.next = this.head;
        }
        this.head = newHead;
        // console.log("length before push: ", this.length);
        this.length++;
        // console.log("length after push: ", this.length);
        return this;
    }
    // Removes the head node - return the popped value -- important!
    pop() {
        if (this.head == null) {
            return false;
        }
        var nodeToRemove = this.head;
        this.head = nodeToRemove.next;
        nodeToRemove.next = null;
        // console.log("length before pop: ", this.length);
        this.length--;
        // console.log("length after pop: ", this.length);
        return nodeToRemove;
    }
    size() {
        return this.length;
    }
    peek() {
        return this.head;
    }
    printPretty() {
        if (this.head == null) {
            console.log("LIST EMPTY");
            return;
        }
        var runner = this.head;
        var printstring = "START-- [";
        while (runner.next != null) {
            printstring += runner.value + ", ";
            runner = runner.next;
        }
        printstring += runner.value + "] --END";
        console.log(printstring);
    }
    // Reverses stack with the order of the nodes reversed
    // use an extra stack as storage and utilize the pop and push methods. Hint: you can re-point the head.
    reverse() {
        var newerList = new SLStack();
        var goalLength = this.length;
        while (newerList.length != goalLength) {
            var removedElement = this.pop();
            console.log(removedElement);
            newerList.push(removedElement);
            newerList.length++;
        }
        return newerList;
    }
}
console.log("--------------------------------------- SINGLY LINKED STACK ---------------------------------------")
var newList = new SLStack();
for (var i = 1; i < 6; i++) {
    newList.push(i);
}
newList.printPretty();
var reversedList = newList.reverse();
reversedList.printPretty();
