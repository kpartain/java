// class SLNode {
//     constructor(value){
//         this.head = SLNode;
//         this.value = value;
//         this.next = SLNode;
//     }
// }
let head = new SLNode(1);
let runner_temp = head;
for (let i of [7,3,5,2]) {
    let new_node = new SLNode(i);
    runner_temp.next = new_node;
    runner_temp = new_node;
}

console.log(head.val);
console.log(head.next.val);
console.log(head.next.next.next.val);

/*

head  -> next  ->  next -> null
| 1 | -> | 7 |  -> | 5 | 
*/