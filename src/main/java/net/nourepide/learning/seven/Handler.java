package net.nourepide.learning.seven;

import net.nourepide.learning.seven.annotation.AfterSuit;
import net.nourepide.learning.seven.annotation.BeforeSuit;
import net.nourepide.learning.seven.annotation.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Handler {

    public static void main(String[] args) throws ReflectiveOperationException {
        start(Application.class);
    }

    /**
     * Start invoking methods with annotations @BeforeSuit, @AfterSuit and @Test
     *
     * @param valueClass Testing class
     */
    public static <T> void start(Class<T> valueClass) throws ReflectiveOperationException {
        Data annotation = getAnnotation(valueClass.getMethods());
        Object object = valueClass.getConstructor().newInstance();

        invokeAll(annotation, object);
    }

    /**
     * Get method and returns Data with annotated methods @BeforeSuit, @AfterSuit and @Test
     *
     * @see Data
     * @see BeforeSuit
     * @see AfterSuit
     * @see Test
     */
    private static Data getAnnotation(Method... methods) {

        Method beforeSuit = null;
        Method afterSuit = null;
        final List<Method> tests = new ArrayList<>();

        for (Method method : methods) {
            for (Annotation annotation : method.getDeclaredAnnotations()) {

                final boolean checkBeforeSuit = checkAnnotation(annotation, BeforeSuit.class);
                final boolean checkAfterSuit = checkAnnotation(annotation, AfterSuit.class);
                final boolean checkTest = checkAnnotation(annotation, Test.class);

                if (checkBeforeSuit) {
                    if (beforeSuit == null) beforeSuit = method;
                    else throw new RuntimeException("BeforeSuit can be annotated only one method in instance");
                }

                if (checkAfterSuit) {
                    if (afterSuit == null) afterSuit = method;
                    else throw new RuntimeException("AfterSuit can be annotated only one method in instance");
                }

                if (checkTest) tests.add(method);
            }
        }

        return new Data(beforeSuit, afterSuit, tests);
    }

    /**
     * Checks annotation for class match
     *
     * @param annotation         gets annotation and looking for match in contains name
     * @param annotatedInterface class for matching
     */
    private static boolean checkAnnotation(Annotation annotation, Class annotatedInterface) {
        return annotation.toString().contains(annotatedInterface.getName());
    }

    /**
     * Invokes all methods annotated with @BeforeSuit, @AfterSuit and @Test
     *
     * @param annotation entity Data class contains all method after matching
     * @param object     object for context invoking
     */
    private static void invokeAll(Data annotation, Object object) {
        simplifyInvoke(annotation.getBeforeSuit(), object);

        sortTests(annotation.getTests());

        for (Method test : annotation.getTests()) {
            simplifyInvoke(test, object);
        }

        simplifyInvoke(annotation.getAfterSuit(), object);
    }

    /**
     * Sorting method annotated Test with priority comparing
     */
    private static void sortTests(List<Method> tests) {
        tests.sort((methodOne, methodTwo) -> {
            int valueOne = methodOne.getAnnotation(Test.class).priority();
            int valueTwo = methodTwo.getAnnotation(Test.class).priority();

            return Integer.compare(valueOne, valueTwo);
        });
    }

    /**
     * Wrapper for simplify invoking method
     */
    private static void simplifyInvoke(Method method, Object object) {
        try {
            if (method != null) method.invoke(object);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("Test method: " + method.getName() + " must not have arguments");
        }
    }
}
