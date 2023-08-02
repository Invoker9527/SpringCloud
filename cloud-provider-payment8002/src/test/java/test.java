import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @Author YangRuiHong
 * @Create 2022-02-14 15:07
 * @Description
 */
public class test {
    public static void main(String[] args) throws IOException {
        /*
         * 使用jsoup完成爬虫操作
         */
        // 需要爬取的网址
        Document doc = Jsoup.connect("https://www.shuyuewu.co/0_708").get();
        String url = "https://www.biquge.com";

//		System.out.println(doc);
        // 获取网页的标题
        String s = doc.title();
        System.out.println(s);
        // 获取内容 css选择器来获取
        // 爬取标签#fmimg下的属性的值(此处获取的是超链接地址)
        String img = doc.select("#fmimg").select("img").attr("src");
        System.out.println(img);
        // #info > h1获取标签里面的内容text();
        String name = doc.select("#info").select("h1").text();
        System.out.println(name);
        // 获取一类数据 集合
        Elements ele = doc.select("#list").select("dd");
        int x = 1;
        for (Element element : ele) {
            x++;
            String zname = element.select("a").text();
            String href = element.select("a").attr("href");
            System.out.println(zname + "," + href);
            doc = Jsoup.connect(url + href).get();
            // html（）按照网页信息读取
            String zjxx = doc.select("#content").html();
            System.out.println(zjxx.replaceAll("[<br>&nbsp;]+", ""));// 将网页源代码中的格式代码去掉
            if (x == 2) {
                break;
            }
        }

    }
}

