package ru.sbt.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class BeanUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */
    public static void assign(Object to, Object from) {

        List<Method> methodsTo = getMethodsSetFromObject(to);
        Class<?> clazz = from.getClass();
        while (clazz != null) {
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if ((method.getName().matches("get[A-Z].+")) &&
                        (method.getParameterCount() == 0) &&
                        (method.getReturnType() != void.class)) {
                    searchSetters(to, methodsTo, from, method);
                }
            }
            clazz = clazz.getSuperclass();
        }
    }

    private static List<Method> getMethodsSetFromObject(Object o) {

        List<Method> resultMethods = new ArrayList<>();
        Class<?> clazz = o.getClass();
        while (clazz != null) {
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if ((method.getName().matches("set[A-Z].+")) &&
                        (method.getParameterCount() == 1) &&
                        (method.getReturnType() == void.class)) {
                    resultMethods.add(method);
                }
            }
            clazz = clazz.getSuperclass();
        }
        return resultMethods;
    }

    private static void searchSetters(Object to, List<Method> methodsTo, Object from, Method methodFrom) {

        for (Method methodTo : methodsTo) {
            if (isEqualsMetodGetFromSetTo(methodTo, methodFrom)) {
                invokeMetod(to, methodTo, from, methodFrom);
            }
        }
    }

    private static void invokeMetod(Object to, Method methodTo, Object from, Method methodFrom) {

        try {
            methodTo.invoke(to, (methodFrom.invoke(from)));
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {
            throw new RuntimeException("Error invoke", e);
        }
    }

    private static boolean isEqualsMetodGetFromSetTo(Method to, Method from) {

        boolean result = false;
        if ((to.getName().length() != from.getName().length()) ||
                (!from.getReturnType().isAssignableFrom(to.getParameterTypes()[0]))) {
            return false;
        }
        if (to.getName().substring(3).equals(from.getName().substring(3))) {
            result = true;
        }

        return result;
    }
}