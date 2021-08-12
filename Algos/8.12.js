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
    /** Methods will be in the STACK class Returns a new stack that is copy of the original stack.
     * Retain the original order. You may create extra temp SLStacks and/or SLQueues as storage.
     * @returns {SLStack} Copy of the original stack
     */
    copy() {}
    /**
     * Rearranges the stack so that numbers > 0 are on the top and any negatives are on the bottom
     * Retain the order of the positives and negatives Use extra stacks and/or queues as storage.
     */
    partitionPositives() {}
}

var s1 = new SLStack();
s1.push(1);
s1.push(2);
s1.push(3);
console.log("ORIGINAL \n" + s1);
var copiedStack = s1.copy();
console.log("COPIED STACK \n" + copiedStack);

var s2 = new SLStack();
s2.push(1);
s2.push(-2);
s2.push(-3);
s2.push(5);
s2.push(6);
console.log("ORIGINAL \n" + s2);
console.log("PARTITIONED \n" + s2.partitionPositives());
// 6 5 1 -3 -2
