package pl.filip.downloader.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Downloader {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://wiadomosci.gazeta.pl/wiadomosci/0,0.html").get();
        
        Elements h2elements = document.select("h2");
        for (Element h2element : h2elements) {
            String h2Url=h2element.select("a").attr("href");
            String text = h2element.text();
            System.out.println(text+"link do artykułu:"+" "+h2Url);
        }

    }
}
