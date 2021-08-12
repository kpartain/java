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

    isEmpty(){
      return this.head == null;
    }
    push(value){
      var new_node = new SLNode(value);
      new_node.next = this.head;
      this.head = new_node;
      this.length++;
    }
    pop(){
      if (!this.head) {
        return null;
      }
      var removed = this.head.value;
      this.head = this.head.next;
      this.length--;
      return removed;
    }

    size(){
      return this.length;
    }

    peek(){
      return this.head? this.head.value: null;
    }
    printPretty() {
      let runner = this.head;
      let printString = "~ SLStack ~ HEAD--(";
      while (runner && runner.next) {
        printString+= `${runner.value})->(`;
        runner = runner.next;
      }
      printString+=`${runner.value})->null\n`;
      console.log(printString);
    }
    reverse() {
      var tempStack = new SLStack();
      while(this.head) {
        tempStack.push(this.pop());
      }
      this.head = tempStack.head;
      this.length = tempStack.length;
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
    partitionPositives() {
        
    }
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
