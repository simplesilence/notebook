package com.shaun.informal.sign;


import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.*;

import static org.apache.commons.lang3.reflect.FieldUtils.getAllFields;
import static org.springframework.core.annotation.AnnotatedElementUtils.isAnnotated;
import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;

public class SignatureMain {

    private static final String DELIMETER = "&";

    private static final String NOT_FOUND = "notFount";

    /**
     * 生成所有注有 SignatureField属性 key=value的 拼接
     * orderSignature自行实现
     */
    public static String toSplice(Object object) {
        if (Objects.isNull(object)) {
            return StringUtils.EMPTY;
        }
        if (isAnnotated(object.getClass(), Signature.class)) {
            Signature sg = findAnnotation(object.getClass(), Signature.class);
            switch (sg.sort()) {
                case Signature.ALPHA_SORT:
                    return alphaSignature(object);
//                case Signature.ORDER_SORT:
//                    return orderSignature(object);
                default:
                    return alphaSignature(object);
            }
        }
        return toString(object);
    }

    private static String alphaSignature(Object object) {
        StringBuilder result = new StringBuilder();
        Map<String, String> map = new TreeMap<>();
        for (Field field : getAllFields(object.getClass())) {
            if (field.isAnnotationPresent(SignatureField.class)) {
                field.setAccessible(true);
                try {
                    if (isAnnotated(field.getType(), Signature.class)) {
                        if (!Objects.isNull(field.get(object))) {
                            map.put(field.getName(), toSplice(field.get(object)));
                        }
                    } else {
                        SignatureField sgf = field.getAnnotation(SignatureField.class);
                        if (StringUtils.isNotEmpty(sgf.customValue()) || !Objects.isNull(field.get(object))) {
                            map.put(StringUtils.isNotBlank(sgf.customName()) ? sgf.customName() : field.getName()
                                    , StringUtils.isNotEmpty(sgf.customValue()) ? sgf.customValue() : toString(field.get(object)));
                        }
                    }
                } catch (Exception e) {
                    System.out.println("签名拼接(alphaSignature)异常" + e);
                }
            }
        }

        for (Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<String, String> entry = iterator.next();
            result.append(entry.getKey()).append("=").append(entry.getValue());
            if (iterator.hasNext()) {
                result.append(DELIMETER);
            }
        }
        return result.toString();
    }

    /**
     * 针对array, collection, simple property, map做处理
     */
    private static String toString(Object object) {
        Class<?> type = object.getClass();
        if (BeanUtils.isSimpleProperty(type)) {
            return object.toString();
        }
        if (type.isArray()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < Array.getLength(object); ++i) {
                sb.append(toSplice(Array.get(object, i)));
            }
            return sb.toString();
        }
        if (ClassUtils.isAssignable(Collection.class, type)) {
            StringBuilder sb = new StringBuilder();
            for (Iterator<?> iterator = ((Collection<?>) object).iterator(); iterator.hasNext(); ) {
                sb.append(toSplice(iterator.next()));
                if (iterator.hasNext()) {
                    sb.append(DELIMETER);
                }
            }
            return sb.toString();
        }
        if (ClassUtils.isAssignable(Map.class, type)) {
            StringBuilder sb = new StringBuilder();
            for (Iterator<? extends Map.Entry<String, ?>> iterator = ((Map<String, ?>) object).entrySet().iterator(); iterator.hasNext(); ) {
                Map.Entry<String, ?> entry = iterator.next();
                if (Objects.isNull(entry.getValue())) {
                    continue;
                }
                sb.append(entry.getKey()).append("=").append(toSplice(entry.getValue()));
                if (iterator.hasNext()) {
                    sb.append(DELIMETER);
                }
            }
            return sb.toString();
        }
        return NOT_FOUND;
    }
}
