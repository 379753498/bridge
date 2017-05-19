package com.html.jJsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTest {

	static String url = "http://www.cnblogs.com/zyw-205520/archive/2012/12/20/2826402.html";

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		// TODO Auto-generated method stub
		// BolgBody();
		article("http://www.hefei.gov.cn/");

	}

	/**
	 * 获取指定HTML 文档指定的body
	 * 
	 * @throws IOException
	 */
	private static void BolgBody() throws IOException {

	}

	/**
	 * 获取博客上的文章标题和链接
	 */
	static Map<String, Map<String, Integer>> urlmap = new HashMap<String, Map<String, Integer>>();;

	public static Map<String, Map<String, Integer>> article(String url) {

		System.out.println(url);
		Document doc;
		Map<String, Integer> str = new HashMap<String, Integer>();
		ArrayList<String> sa =new ArrayList<String>();
		try {
			doc = Jsoup.connect(url).get();
			Elements ListDiv = doc.getAllElements();
			for (Element element : ListDiv) {
				Elements links = element.getElementsByTag("a");
				for (Element link : links) {
					String linkHref = link.attr("href");
					String linkText = link.text().trim();
					if (linkHref.contains("http://")) {
						if (linkText.contains("北京")) {
							if (str.get(linkHref) != null) {
								continue;
							} else {
								str.put(linkHref, 1);
								sa.add(linkHref);
							}


							System.out.println(linkHref);
							System.out.println(linkText);
						
						}

					} else {
						continue;
					}

				}
				if (urlmap.get(url) != null) {
					return urlmap;
				} else {
					urlmap.put(url, str);
					for (int i = 0; i < sa.size(); i++) 
					{
						article(sa.get(i));
					}

				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return urlmap;

	}

	/**
	 * 获取指定博客文章的内容
	 */
	public static void Blog() {
		Document doc;
		try {
			doc = Jsoup
					.connect(
							"http://www.cnblogs.com/zyw-205520/archive/2012/12/20/2826402.html")
					.get();
			Elements ListDiv = doc.getElementsByAttributeValue("class",
					"postBody");
			for (Element element : ListDiv) {
				System.out.println(element.html());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
