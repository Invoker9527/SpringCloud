import com.atguigu.springcloud.bean.People;
import com.atguigu.springcloud.bean.User;
import com.atguigu.springcloud.config.SpringConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @Author YangRuiHong
 * @Create 2022-02-24 11:16
 * @Description
 */

public class test {
    public static int a = 3;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user.getName());
        People people = context.getBean("people", People.class);
        System.out.println(people.getUser());
        System.out.println(people);

    }

    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        People people = context.getBean("people", People.class);
        people.setId(12);
        System.out.println(people);
        System.out.println(people.getUser());
    }

    @Test
    public void test2() {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        User user = context.getBean("user", User.class);
        user.say();
    }

    @Test
    public void test3() {
        double sum = 100, height = 100;
        for (int i = 1; i <= 9; i++)//计算第一次落地到第九次落地再弹起小球经过多少米
        {
            height = height / 2;
            sum = sum + height * 2;
        }//循环结束，小球第十次落地
        height = height / 2;//第十次弹起的高度，按题意此时不再计算
        System.out.println("第十次落地时的高度是：" + height + "\n小球共经过：" + sum + "米");
    }

    @Test
    public void test4() {
        System.out.println(a);
        a++;
        System.out.println(a);
    }

    @Test
    public void test5() {
        System.out.println(a);
    }
}



