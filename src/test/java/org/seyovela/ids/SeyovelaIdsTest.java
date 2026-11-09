package org.seyovela.ids;

import org.junit.jupiter.api.Test;
import org.seyovela.ids.jpa.AccountStatusConverter;
import org.seyovela.ids.jpa.MembershipStatusConverter;
import org.seyovela.ids.jpa.OrgRoleConverter;
import org.seyovela.ids.jpa.RecordStatusConverter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SeyovelaIdsTest {

    @Test
    void nextProducesUuidVersion7() {
        UUID id = SeyovelaIds.next();
        assertEquals(7, id.version());
        assertEquals(2, id.variant());
    }

    @Test
    void nextProducesUniqueValues() {
        Set<UUID> seen = new HashSet<>();
        for (int i = 0; i < 10_000; i++) {
            assertTrue(seen.add(SeyovelaIds.next()));
        }
    }

    @Test
    void enumConvertersRoundTrip() {
        assertEquals(RecordStatus.ACTIVE, new RecordStatusConverter().convertToEntityAttribute(
                new RecordStatusConverter().convertToDatabaseColumn(RecordStatus.ACTIVE)));
        assertEquals(MembershipStatus.INVITED, new MembershipStatusConverter().convertToEntityAttribute(
                new MembershipStatusConverter().convertToDatabaseColumn(MembershipStatus.INVITED)));
        assertEquals(OrgRole.OWNER, new OrgRoleConverter().convertToEntityAttribute(
                new OrgRoleConverter().convertToDatabaseColumn(OrgRole.OWNER)));
        assertEquals(AccountStatus.DISABLED, new AccountStatusConverter().convertToEntityAttribute(
                new AccountStatusConverter().convertToDatabaseColumn(AccountStatus.DISABLED)));
    }
}
