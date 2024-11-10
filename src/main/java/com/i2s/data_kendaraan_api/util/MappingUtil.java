package com.i2s.data_kendaraan_api.util;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public class MappingUtil {
    private static ModelMapper modelMapper = new ModelMapper();

    public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source.stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }

    public static <S, T> T map(S source, Class<T> targetClass){
        return modelMapper.map(source, targetClass);
    }

    public static <T> void setPatchedData(T source, T target) {
        Field[] fields = source.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(source);
                if (value != null) {
                    field.set(target, value);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
