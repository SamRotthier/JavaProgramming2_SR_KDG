package be.kdg.java2.reflection;

import java.lang.reflect.*;
import java.util.*;

public class ReflectionTools {
    public static void classAnalysis (Class... aClass){
        for (Class c : aClass) {
            System.out.println("\nAnalyse van de klasse: " + c.getSimpleName());
            System.out.println("==================================================");
            System.out.printf("Fully quallified name    :%s%n", c.getName());
            System.out.printf("Naam van de superklasse  : %s%n", c.getSuperclass().getName().split("\\.")[c.getSuperclass().getName().split("\\.").length-1]);
            System.out.printf("Naam van de package      : %s%n", c.getPackage().toString());
            System.out.print("Interfaces               : ");

            for (Class i : c.getInterfaces()) {
                System.out.print(i.getName().split("\\.")[i.getName().split("\\.").length-1] + " ");
            }
                System.out.println();

                System.out.println("Constructors:");
            for (Constructor constr : c.getConstructors()) {
                System.out.printf("%10s%s%n", "", constr.toGenericString());
            }

            System.out.print("attributen     :");
            for (Field dField : c.getDeclaredFields()) {
                System.out.printf("%s(%s) ", dField.getName(),
                        Arrays.asList(dField.getType().getName().split("\\.")).get(dField.getType().getName().split("\\.").length - 1));
            }

            System.out.print("\ngetters        :");
            for (Method dMethod : c.getDeclaredMethods()) {
                if (dMethod.getName().contains("get"))
                    System.out.printf("%s ", dMethod.getName());
            }

            System.out.print("\nsetters        :");
            for (Method dMethod : c.getDeclaredMethods()) {
                if (dMethod.getName().contains("set"))
                    System.out.printf("%s ", dMethod.getName());
            }

            System.out.print("\nandere methoden:");
            for (Method dMethod : c.getDeclaredMethods()) {
                if (!dMethod.getName().contains("get") && !dMethod.getName().contains("set"))
                    System.out.printf("%s ", dMethod.getName());
            }
            System.out.println();
        }
    }

    public static Object runAnnotated(Class<?> aClass) {
        Object o = null;
        try {
            o = aClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Method method : aClass.getMethods()) {
            if (method.getAnnotation(CanRun.class) != null && method.getGenericParameterTypes().length == 1 &&
                    method.getGenericParameterTypes()[0].getTypeName().equals("java.lang.String")) {
                String value = method.getAnnotation(CanRun.class).value();
                try {
                    method.invoke(o, value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return o;
    }
}
