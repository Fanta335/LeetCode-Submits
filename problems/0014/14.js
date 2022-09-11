/**
 * @param {string[]} strs
 * @return {string}
 */
const longestCommonPrefix = (strs) => {
  let pref = strs[0];

  for (let i = 1; i < strs.length; i++) {
    const curr = strs[i];
    if (curr === "") return "";

    for (let j = 0; j < curr.length; j++) {
      if (pref[j] !== curr[j]) {
        pref = pref.substring(0, j);
        break;
      }
      if (j === curr.length - 1) {
        pref = curr;
      }
    }
  }

  return pref;
};

console.log(longestCommonPrefix(["flower", "flow", "flight"]));
