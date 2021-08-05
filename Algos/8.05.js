class SLNode {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
}

class SLL {
    constructor() {
        this.head = null;
    }

    printValues() {
        if (this.head == null) {
            console.log("LIST EMPTY");
            return;
        }
        // IF THE LIST IS NOT EMPTY
        var runner = this.head;
        while (runner != null) {
            console.log(runner.value);
            runner = runner.next;
        }
    }

    insertAtBack(data) {
        var newNode = new SLNode(data);
        if (this.head == null) {
            this.head = newNode;
            return this;
        }
        if (this.head.next == null) {
            this.head.next = newNode;
            return this;
        }
        var runner = this.head;
        while (runner.next != null) {
            runner = runner.next;
        }
        runner.next = newNode;
        return this;
    }

    seedFromArr(arr) {
        for (var i = 0; i < arr.length; i++) {
            this.insertAtBack(arr[i]);
        }
        return this;
    }

    insertAtFront(value) {
        var newHead = new SLNode(value);
        if (this.head != null) {
            newHead.next = this.head;
        }
        this.head = newHead;
        return this;
    }

    average() {
        var sum = 0;
        var numberOfNodes = 0;
        var runner = this.head;
        while (runner.next != null) {
            sum = sum + runner.value;
            runner = runner.next;
            numberOfNodes++;
        }
        sum += runner.value;
        var average = sum / numberOfNodes;
        console.log(
            "SUM",
            sum,
            ", NUMBER OF NODES",
            numberOfNodes,
            ", AVERAGE",
            average
        );
        return average;
    }

    contains(value) {
        if (this.head == null) {
            return false;
        }
        var runner = this.head;
        while (runner != null) {
            if (runner.value == value) {
                return true;
            }
            runner = runner.next;
        }
        return false;
    }

    removeBack() {
        if (this.head == null || this.head.next == null) {
            return false;
        }
        var runner = this.head;
        while (runner.next.next != null) {
            runner = runner.next;
        }
        runner.next = null;
        return this;
    }

    containsRecursive(val, current = this.head) {
        if (current == null) {
            return false;
        } else if (current.value == val) {
            return true;
        } else {
            current = current.next;
            return this.containsRecursive(val, current);
        }
    }
}

var testSLL = new SLL();
testSLL.insertAtBack(3).insertAtBack(2).insertAtBack(1);
console.log("BEFORE REMOVE BACK");
testSLL.printValues();
testSLL.insertAtFront(7).insertAtFront(8).insertAtFront(9);
console.log("CONTAINS 1?", testSLL.contains(1));
console.log("AFTER REMOVE BACK");
testSLL.removeBack();
testSLL.printValues();
console.log("CONTAINS 1?", testSLL.containsRecursive(1));
