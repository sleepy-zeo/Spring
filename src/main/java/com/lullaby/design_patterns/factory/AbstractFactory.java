package com.lullaby.design_patterns.factory;

/**
 * 抽象工厂模式
 *
 * 想增加一个新的Sender，只要同时增加一个Sender的实现类和Provider的实现类即可
 */
public class AbstractFactory {

    public static interface Sender {
        public void send();
    }

    public static class MailSender implements Sender {
        @Override
        public void send() {
            System.out.println("This is mail sender.");
        }
    }

    public static class SmsSender implements Sender {
        @Override
        public void send() {
            System.out.println("This is sms sender.");
        }
    }

    public static interface Provider {
        public Sender produce();
    }

    public static class SendMailFactory implements Provider {

        @Override
        public Sender produce() {
            return new MailSender();
        }
    }

    public static class SendSmsFactory implements Provider {

        @Override
        public Sender produce() {
            return new SmsSender();
        }
    }

    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.send();
    }
}
