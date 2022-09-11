/**
 * @param {string} string
 * @return {string}
 */
const longestPalindrome = function (string) {
  let dp = createMatrix(string.length);
  let max = 0;
  let left = 0;
  let right = 0;

  for (let i = string.length - 1; i >= 0; i--) {
    dp[i][i] = true;

    for (let j = i + 1; j <= string.length; j++) {
      dp[i][j] = string[i] === string[j];

      if (j - i > 2) {
        dp[i][j] = dp[i + 1][j - 1] && string[i] === string[j];
      }

      if (dp[i][j] && max <= j - i + 1) {
        max = j - i + 1;
        left = i;
        right = j;
      }
    }
  }

  return string.substring(left, right + 1);
};

const createMatrix = (n) => {
  const matrix = [];

  for (let i = 0; i < n; i++) {
    matrix.push(new Array(n).fill(null));
  }

  return matrix;
};
