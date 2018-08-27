package com.flysoohigh.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import static org.junit.Assert.assertEquals;

public class Runner {
    public static void main(String[] args) {
        User user = new User("Alex");

        InvocationHandler invocationHandler = (proxy, method, argz) -> {
            if(method.getName().equals("getName")){
                return ((String)method.invoke(user, argz)).toUpperCase();
            }
            return method.invoke(user, argz);
        };

        IUser userProxy = (IUser)Proxy.newProxyInstance(User.class.getClassLoader(),
                                                        User.class.getInterfaces(),
                                                        invocationHandler);

        assertEquals("ALEX", userProxy.getName());
    }
}
