package org.kikala.ioc.basic;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class DIFactory {

    private static Map<Class, Object> objects = new HashMap<>();

    public static Object getBean(Class type) {
        Object result = objects.get(type);
        if (result != null) {
            return result;
        }
        try {
            result = type.getDeclaredConstructor().newInstance(new Object[]{});
            objects.put(type, result);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return result;
    }
}
