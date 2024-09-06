package org.example.reflection;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReflectionHelper {
    private static final String CLASS_TYPE = ".class";

    public static List<Class<?>> findAnnotatedClass(String packageName, Class<? extends Annotation> annotation) {
        List<Class<?>> result = new ArrayList<>();
        if (packageName == null || annotation == null) {
            return result;
        }
        String path = packageName.replace(".", "/");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try {
            Iterator<URL> resources = classLoader.getResources(path).asIterator();
            while (resources.hasNext()) {
                File directory = new File(resources.next().getFile());
                if (!directory.exists()) {
                    continue;
                }
                String[] files = directory.list();
                for (String file : files) {
                    if (file.endsWith(CLASS_TYPE)) {
                        String className = packageName + "." + file.substring(0, file.length() - CLASS_TYPE.length());
                        Class<?> clazz = Class.forName(className);
                        if (clazz.isAnnotationPresent(annotation)) {
                            result.add(clazz);
                        }
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
