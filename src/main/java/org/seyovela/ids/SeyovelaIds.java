package org.seyovela.ids;

import java.security.SecureRandom;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Shared UUIDv7 generator for Seyovela runtime records (RFC 9562).
 * Seed/master IDs must still be fixed literals in Flyway migrations.
 */
public final class SeyovelaIds {

    private static final SecureRandom RANDOM = new SecureRandom();
    private static final AtomicLong LAST_TIMESTAMP_AND_SEQ = new AtomicLong();

    private SeyovelaIds() {
    }

    public static UUID next() {
        long now = System.currentTimeMillis();
        long previous;
        long next;
        do {
            previous = LAST_TIMESTAMP_AND_SEQ.get();
            long previousTs = previous >>> 16;
            long previousSeq = previous & 0xFFFFL;
            long ts;
            long seq;
            if (now > previousTs) {
                ts = now;
                seq = RANDOM.nextInt(1 << 16) & 0xFFFFL;
            } else {
                ts = previousTs;
                seq = (previousSeq + 1) & 0xFFFFL;
                if (seq == 0L) {
                    ts = previousTs + 1;
                }
            }
            next = (ts << 16) | seq;
        } while (!LAST_TIMESTAMP_AND_SEQ.compareAndSet(previous, next));

        long ts = next >>> 16;
        long seq = next & 0xFFFFL;

        long msb = (ts << 16) | (0x7L << 12) | (seq & 0x0FFFL);
        long lsb = RANDOM.nextLong();
        lsb = (lsb & 0x3FFFFFFFFFFFFFFFL) | 0x8000000000000000L;
        return new UUID(msb, lsb);
    }
}
