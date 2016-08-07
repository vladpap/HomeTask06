package ru.sbt.utils;

import java.lang.reflect.Method;

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
        Class<?> clazz = from.getClass();
        while (clazz != null) {
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if ((method.getName().matches("get[A-Z].+")) &&
                        (method.getParameterCount() == 0) &&
                        (method.getReturnType() != void.class)) {
                    searchSetters(to, from, method);
                }
            }
            clazz = clazz.getSuperclass();
        }
    }

    private static void searchSetters(Object to, Object from, Method methodFrom) {

        Class<?> clazz = to.getClass();
        while (clazz != null) {
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if ((method.getName().matches("set[A-Z].+")) &&
                        (method.getParameterCount() == 1) &&
                        (method.getReturnType() == void.class) &&
                        (methodFrom.getName().length() == method.getName().length()) &&
                        (methodFrom.getReturnType() == method.getParameterTypes()[0])) {
                    // TODO: 07.08.16 invoke
                    invokeMetod(to, method, from, methodFrom);
                }
            }
            clazz = clazz.getSuperclass();
        }
        System.out.println("----------------------------------");
    }

    private static void invokeMetod(Object to, Method methodTo, Object from, Method methodFrom) {

        System.out.println(to.getClass().getName() + " " + methodTo.getName() + " - " +
                from.getClass().getName() + " " + methodFrom.getName());
    }
}