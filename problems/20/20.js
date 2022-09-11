class Node {
  constructor(data, next) {
    this.data = data;
    this.next = next;
  }
}

class Stack {
  constructor() {
    this.head = null;
  }

  push(data) {
    let temp = this.head;
    this.head = new Node(data);
    this.head.next = temp;
  }

  pop() {
    if (this.head === null) {
      return null;
    }

    let temp = this.head;
    this.head = this.head.next;
    return temp.data;
  }

  peek() {
    if (this.head === null) {
      return null;
    }

    return this.head.data;
  }
}

const pairs = { ")": "(", "}": "{", "]": "[" };

/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function (s) {
  let stack = new Stack();
  const arr = s.split("");

  for (let i = 0; i < arr.length; i++) {
    if (stack.peek() !== null && stack.peek() === pairs[arr[i]]) {
      stack.pop();
    } else {
      stack.push(arr[i]);
    }
  }

  return stack.peek() === null;
};
