class SLNode{
    constructor(value){
        this.value = value
        this.next = null
    }
}

class SLL{
    constructor(){
        this.head = null;
    }    

    printValues() {
        if(this.head == null){
            console.log("LIST EMPTY")
            return
        }
        // IF THE LIST IS NOT EMPTY
        var runner = this.head
        while(runner != null){
            console.log(runner.value)
            runner = runner.next;
        }
    }
    
    insertAtBack(data){
        var newNode = new SLNode(data);
        if (this.head == null) {
            this.head = newNode;
            return this;
        }
        if (this.head.next == null){
            this.head.next = newNode;
            return this;
        }
        var runner = this.head
        while(runner.next != null) {
            runner = runner.next;
        }
        runner.next = newNode;
        return this;
    }

    seedFromArr(arr) {
        for(var i = 0; i < arr.length; i++){
            this.insertAtBack(arr[i]);
        }
        return this;
    }

    insertAtFront(value){
        var newHead = new SLNode(value);
        if(this.head != null) {
            newHead.next = this.head;
        }
        this.head = newHead;
        return this;
    }

    average(){
        var sum = 0;
        var numberOfNodes = 0;
        var runner = this.head;
        while(runner.next != null) {
            sum = sum + runner.value;
            runner = runner.next;
            numberOfNodes++;
        }
        sum += runner.value;
        var average = sum / numberOfNodes;
        console.log("SUM", sum, ", NUMBER OF NODES", numberOfNodes, ", AVERAGE", average);
        return average;
    }


}

var testSLL = new SLL();
testSLL.insertAtBack(3).insertAtBack(2).insertAtBack(1);
console.log("BEFORE");
testSLL.printValues();
testSLL.insertAtFront(7).insertAtFront(8).insertAtFront(9);
console.log("AFTER");
testSLL.printValues();
console.log("AVERAGE");
console.log(testSLL.average());