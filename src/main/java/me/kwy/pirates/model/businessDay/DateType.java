package me.kwy.pirates.model.businessDay;

import java.util.Arrays;
import java.util.stream.Stream;

/*
 * 요일을 코드값으로 관리하기 위하여 enum으로 관리합니다.
*/
public enum DateType{
    Monday(1, "Monday"),
    Tuesday(2, "Tuesday"),
    Wednesday(3, "Wednesday"),
    Thursday(4, "Thursday"),
    Friday(5, "Friday"),
    Saturday(6, "Saturday"),
    Sunday(7, "Sunday");

    public int code;
    public String word;


    DateType(int code, String word){
        this.code = code;
        this.word = word;
    }

    public static DateType getByWord(String word){
        return Stream.of (DateType.values())
                .filter((dayType) -> dayType.equalWord(word))
                .findAny()
                .orElse(null);
    }

    public static DateType getByCode(int code){
        return Arrays.stream(DateType.values())
                .filter((dayType) -> dayType.equalCode(code))
                .findFirst()
                .orElse(null);
    }


    public boolean equalWord(String word){
        return this.word.equals(word);
    }
    public boolean equalCode(int code){
        return this.code == code;
    }

    @Override
    public String toString() {
        return "DateType{" +
                "code=" + code +
                ", word='" + word + '\'' +
                '}';
    }
}
