package com.system_design;

public class TokenBucket {

    private final long maxBucketSize;
    private final long refillRate;

    private double currentBucketSize;
    private long lastRillTimeStamp;

    public TokenBucket(final long maxBucketSize, final long refillRate) {
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillRate;

        currentBucketSize = maxBucketSize;
        lastRillTimeStamp = System.nanoTime();
    }

    public synchronized boolean allowRequest(int tokens) {
        refill();

        if (currentBucketSize >= tokens) {
            currentBucketSize -= tokens;
            return true;
        } else {
            return false;
        }
    }

    private void refill() {
        long now = System.nanoTime();
        double tokenToAdd = (now - lastRillTimeStamp) * refillRate / 1e9; // 10 ^ 9 1 << 2 == 2 ^ 2
        currentBucketSize = Math.min(maxBucketSize, currentBucketSize + tokenToAdd);
        lastRillTimeStamp = now;
    }
}
