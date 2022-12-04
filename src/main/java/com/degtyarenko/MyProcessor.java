package com.degtyarenko;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MyProcessor {

    static void inject(MainController mainController) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        for (Field field : mainController.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectClass.class)) {
                Constructor<?> constructor = field.getType().getDeclaredConstructor();
                Object o = constructor.newInstance();
                boolean isAccessible = field.canAccess(mainController);
                field.setAccessible(true);
                field.set(mainController, o);
                field.setAccessible(isAccessible);
            }
        }
    }

}
