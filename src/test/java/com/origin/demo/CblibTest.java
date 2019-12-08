package com.origin.demo;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by dengqingling on 2019-07-05
 */
public class CblibTest implements MethodInterceptor {

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private int index;

    public static void main(String[] args) {
        CblibTest cblibTest = new CblibTest();
        cblibTest.setIndex(10);
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CblibTest.class);
        enhancer.setCallback(cblibTest);

        //通过字节码技术动态创建子类实例
        CblibTest proxy = (CblibTest)enhancer.create();
        System.out.println("index : " + proxy.getIndex());
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("前置代理");
        //通过代理类调用父类中的方法
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("后置代理");
        return result;
    }

    public void aaa() {
        System.out.println("aaa");
        bbb();
    }

    public void bbb() {
        System.out.println("bbb");
    }
}
