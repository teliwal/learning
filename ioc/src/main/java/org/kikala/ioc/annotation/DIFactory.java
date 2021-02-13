package org.kikala.ioc.annotation;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DIFactory {


    private static Map<Class, Object> objects;

    private static void initialiseBeans() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        objects = initComposantClasses();
        for (Map.Entry<Class, Object> entry : objects.entrySet()) {
            List<Field> injected = getInjectFieldsInClass(entry.getKey());
            for (Field field : injected) {
                Object composant = objects.get(field.getType());
                field.setAccessible(true);
                field.set(entry.getValue(), composant);
            }
        }
    }

    private static Map<Class, Object> initComposantClasses() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Map<Class, Object> objects = new HashMap<>();
        Reflections reflections = new Reflections("");
        Set<Class<?>> comp = reflections.getTypesAnnotatedWith(Composant.class);
        for (Class c : comp) {
            objects.put(c, c.getDeclaredConstructor().newInstance(new Object[]{}));
        }
        return objects;
    }

    private static List<Field> getInjectFieldsInClass(Class c) {
        return FieldUtils.getFieldsListWithAnnotation(c, Inject.class);
    }

    public static Object getBean(Class type) {
        if (objects == null) {
            try {
                initialiseBeans();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return objects.get(type);
    }
}
