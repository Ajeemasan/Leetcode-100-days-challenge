class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            map.put(row, map.getOrDefault(row, 0) | (1 << col));
        }

        int ans = n * 2;

        for (int reservedMask : map.values()) {
            boolean leftFree = true;
            boolean rightFree = true;
            boolean middleFree = true;

            // Check Left Block: columns 2, 3, 4, 5
            for (int i = 2; i <= 5; i++) {
                if ((reservedMask & (1 << i)) != 0) {
                    leftFree = false;
                    break;
                }
            }

            // Check Right Block: columns 6, 7, 8, 9
            for (int i = 6; i <= 9; i++) {
                if ((reservedMask & (1 << i)) != 0) {
                    rightFree = false;
                    break;
                }
            }

            // Check Middle Block: columns 4, 5, 6, 7
            for (int i = 4; i <= 7; i++) {
                if ((reservedMask & (1 << i)) != 0) {
                    middleFree = false;
                    break;
                }
            }

            // Deduct from the maximum possible (2 per row) based on block availability
            if (leftFree && rightFree) {
                continue;
            } else if (leftFree || rightFree || middleFree) {
                ans -= 1;
            } else {
                ans -= 2;
            }
        }

        return ans;
    }
}