import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Date;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Date;
import java.util.Properties;

public class EmailDemo {

    JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

    @Test
    public void sendSimpleMail() {
        javaMailSender.setHost("smtp.qq.com");
        javaMailSender.setPort(465);
        javaMailSender.setUsername("940883614@qq.com");
        // 邮箱的一个码
        javaMailSender.setPassword("oycebklohuokbfaa");
        javaMailSender.setDefaultEncoding("UTF-8");
        Properties conf = new Properties();
        conf.setProperty("mail.smtp.timeout", "25000");
        conf.setProperty("mail.smtp.auth", "false");
        conf.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        javaMailSender.setJavaMailProperties(conf);

        // 构建一个邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件主题
        message.setSubject("hello 叼毛！");
        // 设置邮件发送者，这个跟application.yml中设置的要一致
        message.setFrom("940883614@qq.com");
        // 设置邮件接收者，可以有多个接收者，中间用逗号隔开，以下类似
        // message.setTo("10*****16@qq.com","12****32*qq.com");
        message.setTo("1197510935@qq.com", "2325789212@qq.com");
        // 设置邮件抄送人，可以有多个抄送人
//        message.setCc("12****32*qq.com");
        // 设置隐秘抄送人，可以有多个
//        message.setBcc("7******9@qq.com");
        // 设置邮件发送日期
        message.setSentDate(new Date());
        // 设置邮件的正文
        message.setText("----来自你宏哥"
                + "\r\n"


                + "hello，叼毛，你好帅");
        // 发送邮件
        javaMailSender.send(message);
    }
}