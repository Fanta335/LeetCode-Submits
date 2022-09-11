class ListNode {
  constructor(val, next) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} list1
 * @param {ListNode} list2
 * @return {ListNode}
 */
const mergeTwoLists = function (list1, list2) {
  let current = new ListNode(-1);
  let result = current;

  while (list1 || list2) {
    let next = null;

    if (list1 === null) {
      next = list2;
      list2 = list2.next;
    } else if (list2 === null) {
      next = list1;
      list1 = list1.next;
    } else {
      if (list1.val <= list2.val) {
        next = list1;
        list1 = list1.next;
      } else {
        next = list2;
        list2 = list2.next;
      }
    }

    current.next = next;
    current = current.next;
  }

  return result.next;
};
