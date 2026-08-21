class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long low = 1;
        long high = Long.MAX_VALUE;

        for (int coin : coins){
            high = Math.min(high, (long)(coin)*k);
        }

        while (low < high){
            long mid = low + (high - low)/2;
            if (count(mid, coins) >= k){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }

    public long count (long x, int[] coins){
        int n = coins.length;
        long count = 0;
        for (int mask = 1; mask < (1 << n) ; mask++){
            long l = 1;
            int bits = 0;
            boolean valid = true;

            for (int i = 0;i < n ; i++){
                if ((mask & (1 << i)) != 0){
                    bits++;
                    l = lcm(l, coins[i]);
                    if (l > x){
                        valid = false;
                        break;
                    }
                }

            }
            if (!valid) continue;

            long multiples = x/l;

            if (bits % 2 == 1){
                count += multiples;
            }
            else{
                count -= multiples;
            }

        }
        return count;
    }

    public long gcd(long a, long b){
        while (b != 0){
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
    public long lcm(long a, long b){
        long g = gcd(a, b);
        return (a/g)*b;
    }
}