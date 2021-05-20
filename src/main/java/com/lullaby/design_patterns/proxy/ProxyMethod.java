package com.lullaby.design_patterns.proxy;

/**
 * 代理模式
 *
 * 已有的方法在使用的时候需要对原有的方法进行改进，比如这里想改进SourceImpl的method方法，
 * 采用一个代理类调用原有的方法，然后在调用前后进行对原方法的改进
 */
public class ProxyMethod {

    public static interface Sourceable {
        public void method();
    }

    public static class SourceImpl implements Sourceable {
        @Override
        public void method() {
            System.out.println("The original method.");
        }
    }

    public static class Proxy implements Sourceable {
        private SourceImpl source;

        public Proxy() {
            super();
            this.source = new SourceImpl();
        }

        @Override
        public void method() {
            before();
            source.method();
            after();
        }

        private void before() {
            System.out.println("Before proxy.");
        }

        private void after() {
            System.out.println("After proxy.");
        }
    }

    public static void main(String[] args) {
        Sourceable proxy = new Proxy();
        proxy.method();
    }
}
