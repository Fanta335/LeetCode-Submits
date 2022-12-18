/*
 * @lc app=leetcode id=1603 lang=java
 *
 * [1603] Design Parking System
 */

// @lc code=start
class ParkingSystem {
    int[] spaces;

    public ParkingSystem(int big, int medium, int small) {
        spaces = new int[3];
        spaces[0] = big;
        spaces[1] = medium;
        spaces[2] = small;
    }

    public boolean addCar(int carType) {
        spaces[carType - 1]--;
        return spaces[carType - 1] >= 0;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such: ParkingSystem obj = new
 * ParkingSystem(big, medium, small); boolean param_1 = obj.addCar(carType);
 */
// @lc code=end

