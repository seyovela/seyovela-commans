package org.seyovela.ids.jpa;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.seyovela.ids.OrgRole;

@Converter(autoApply = false)
public class OrgRoleConverter implements AttributeConverter<OrgRole, Integer> {

    @Override
    public Integer convertToDatabaseColumn(OrgRole attribute) {
        return attribute == null ? null : attribute.getCode();
    }

    @Override
    public OrgRole convertToEntityAttribute(Integer dbData) {
        return dbData == null ? null : OrgRole.fromCode(dbData);
    }
}
