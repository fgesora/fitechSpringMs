package com.loopdfs.cardproject.commons.config;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.ArrayList;
import java.util.List;

public class ClassLoaderUtil {
    public static List<Class<?>> getAllClassesInPackage(String packageName, Class parentClass) {
        Reflections reflections = new Reflections(packageName, new SubTypesScanner());
        return new ArrayList<>(reflections.getSubTypesOf(parentClass));
    }
}
