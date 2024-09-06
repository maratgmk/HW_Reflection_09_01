package org.example;

import org.example.annotation.EventHandler;
import org.example.reflection.EventProcessor;
import org.example.reflection.ReflectionHelper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EventProcessor processor = new EventProcessor("org.example.handlers",EventHandler.class);
        
        processor.getClassNamesWithAnnotation();
        processor.getInstanceWithAnnotation();
    }

}
/**
 * 1 У Вас есть небольшой фреймворк для обработки событий в игре. Вам нужно использовать Reflection API
 * для динамического нахождения всех классов-обработчиков событий, отмеченных вашей аннотацией
 * @EventHandler. Затем необходимо создать экземпляры этих классов и зарегистрировать их в системе
 * обработки событий:
 * 1.1 Создайте аннотацию @EventHandler.
 * 1.2 Создайте несколько классов-обработчиков в пакете handlers и отметьте их аннотацией @EventHandler.
 * Содержимое классов не принципиально.
 * 1.3 Напишите класс EventProcessor, который будет использовать Reflection API для нахождения и создания
 * обработчиков событий.
 * 1.4 Используйте вспомогательный класс ReflectionHelper из задания, выполненного на лекции, для поиска
 * классов с аннотацией @EventHandler.
 * 1.5 После запуска Вашей программы выведите объекты всех обработчиков в консоль.
 */