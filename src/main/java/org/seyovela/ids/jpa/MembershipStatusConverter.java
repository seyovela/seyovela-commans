package org.seyovela.ids.jpa;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.seyovela.ids.MembershipStatus;

@Converter(autoApply = false)
public class MembershipStatusConverter implements AttributeConverter<MembershipStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(MembershipStatus attribute) {
        return attribute == null ? null : attribute.getCode();
    }

    @Override
    public MembershipStatus convertToEntityAttribute(Integer dbData) {
        return dbData == null ? null : MembershipStatus.fromCode(dbData);
    }
}
