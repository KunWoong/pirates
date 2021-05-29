package me.kwy.pirates.model.businessDay;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

/*
 * DB에 저장할 떄에 코드값으로 저장.
 * Object로 변환할 떄에는 요일 명으로 매핑함.
 */
@Converter(autoApply = true)
public class DateTypeConverter implements AttributeConverter<DateType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(DateType dateType) {
        return dateType.code;
    }

    @Override
    public DateType convertToEntityAttribute(Integer integer) {
        return Stream.of(DateType.values())
                .filter(dateType -> dateType.code == integer)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

    }
}
