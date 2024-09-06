package org.example.reflection;

import org.example.annotation.EventHandler;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class EventProcessor {
    private List<Class<?>> clazzes;

    public EventProcessor(String packageName,Class<? extends Annotation> annotation) {
        clazzes = ReflectionHelper.findAnnotatedClass(packageName,annotation);
    }

    public  <T> T getInstance(Class<T> clazz){
        Constructor<T> constructor = null;
        try {
            constructor = clazz.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    public void getClassNamesWithAnnotation(){
        clazzes
                .forEach(c -> System.out.println(c.getSimpleName()));
    }
    public void getInstanceWithAnnotation(){
       clazzes
                .forEach(c -> System.out.println(getInstance(c)));
    }
}
