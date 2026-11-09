package org.seyovela.ids.jpa;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.seyovela.ids.RecordStatus;

@Converter(autoApply = false)
public class RecordStatusConverter implements AttributeConverter<RecordStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(RecordStatus attribute) {
        return attribute == null ? null : attribute.getCode();
    }

    @Override
    public RecordStatus convertToEntityAttribute(Integer dbData) {
        return dbData == null ? null : RecordStatus.fromCode(dbData);
    }
}
