package com.sleepy.zeo.design_patterns.factory;

/**
 * 工厂模式
 */
public class FactoryMethod {
    public interface Sender {
        public void send();
    }

    public class MailSender implements Sender {
        @Override
        public void send() {
            System.out.println("This is mail sender.");
        }
    }

    public class SmsSender implements Sender {
        @Override
        public void send() {
            System.out.println("This is sms sender.");
        }
    }

    public class SenderFactory {
        private static final String TYPE_MAIL = "mail";
        private static final String TYPE_SMS = "sms";

        public Sender produce(String type) {
            if (TYPE_MAIL.equals(type)) {
                return new MailSender();
            }
            if (TYPE_SMS.equals(type)) {
                return new SmsSender();
            }

            System.out.println("请输入正确的类型!");
            return null;
        }

        public Sender produceMail() {
            return new MailSender();
        }

        public Sender produceSms() {
            return new SmsSender();
        }
    }
}
