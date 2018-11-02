package net.nourepide.learning.seven;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Entity for save data of getAnnotation in Handler
 * It was decided to make a separate class for readability
 *
 * @see Handler
 */
public class Data {

    private final Method beforeSuit;
    private final Method afterSuit;
    private final List<Method> tests;

    public Data(Method beforeSuit, Method afterSuit, List<Method> tests) {
        this.beforeSuit = beforeSuit;
        this.afterSuit = afterSuit;
        this.tests = tests;
    }

    public Method getBeforeSuit() {
        return beforeSuit;
    }

    public Method getAfterSuit() {
        return afterSuit;
    }

    public List<Method> getTests() {
        return tests;
    }
}
