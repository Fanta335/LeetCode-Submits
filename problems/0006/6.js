/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function (s, numRows) {
  if (numRows === 1) {
    return s;
  }

  let stacks = [];
  for (let i = 0; i < numRows; i++) {
    stacks.push([]);
  }

  let currStack = 0;
  let isDown = true;

  for (let i = 0; i < s.length; i++) {
    if (isDown) {
      stacks[currStack].push(s[i]);

      if (currStack === stacks.length - 1) {
        isDown = false;
        currStack--;
      } else {
        currStack++;
      }
    } else {
      stacks[currStack].push(s[i]);

      if (currStack === 0) {
        isDown = true;
        currStack++;
      } else {
        currStack--;
      }
    }
  }

  let result = [];
  for (const stack of stacks) {
    result.push(stack.join(""));
  }

  return result.join("");
};

console.log(convert("P,,,,AYPALISHIRING", 3));
