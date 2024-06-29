package az.turbo.turboextension;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) throws IOException {

        String html = "<div class=\"product-properties__i\">"
                + "<label class=\"product-properties__i-name\" for=\"ad_region\">Şəhər</label>"
                + "<span class=\"product-properties__i-value\">Bakı</span></div>";

        Document doc = Jsoup.parse(html);

        Element labelElement = doc.select("label[for=ad_region]").first();
        if (labelElement != null) {
            String labelText = labelElement.text();
            System.out.println("Label Text: " + labelText);

            Element spanElement = labelElement.nextElementSibling();
            if (spanElement != null) {
                String spanText = spanElement.text();
                System.out.println("Span Text: " + spanText);
            }
        }



























//        Document document = Jsoup.connect("https://turbo.az/autos/8366852-bentley-bentayga").get();
//
//        Elements extras = document.getElementsByClass("product-extras__i");
//
//        Elements credit = document.getElementsByClass("product-labels__i tz-d-flex tz-align-center");
//
//        for (Element element : credit){
//            System.out.println(element.text());
//        }

//
//        Document document = Jsoup.connect("https://turbo.az/autos/8366852-bentley-bentayga").get();
//
//        Elements elements = document.getElementsByClass("product-properties__i-value");
//        Elements extras = document.getElementsByClass("product-extras__i");
//        Elements credit = document.getElementsByClass("product-labels__i tz-d-flex tz-align-center");
//
//
//        for (Element element : elements) {
//            System.out.println(element.text());
//        }
//
//        for (Element element : extras) {
//            System.out.println(element.text());
//        }
//        for (Element element : credit) {
//            System.out.println(element.text());
//        }


//        List<Boolean> booleans = new ArrayList<>();
//        List<String> strings = new ArrayList<>();
//        for (Element element : extras) {
////            System.out.println(element.text());
//            strings.add(element.text());
//        }
//        for (String s : strings) {
//            System.out.println(s);
//        }



//            if (strings.contains("Yüngül lehimli disklər")) {
//                booleans.add(0, true);
//            } else {
//                booleans.add(0, false);
//            }
//            if (strings.contains("ABS")) {
//                booleans.add(1, true);
//            } else {
//                booleans.add(1, false);
//            }
//            if (strings.contains("Lyuk")) {
//                booleans.add(2, true);
//            } else {
//                booleans.add(2, false);
//            }
//            if (strings.contains("Yağış sensoru")) {
//                booleans.add(3, true);
//            } else {
//                booleans.add(3, false);
//            }
//            if (strings.contains("Mərkəzi qapanma")) {
//                booleans.add(4, true);
//            } else {
//                booleans.add(4, false);
//            }
//            if (strings.contains("Park radarı")) {
//                booleans.add(5, true);
//            } else {
//                booleans.add(5, false);
//            }
//            if (strings.contains("Kondisioner")) {
//                booleans.add(6, true);
//            } else {
//                booleans.add(6, false);
//            }
//            if (strings.contains("Oturacaqların isidilməsi")) {
//                booleans.add(7, true);
//            } else {
//                booleans.add(7, false);
//            }
//            if (strings.contains("Dəri salon")) {
//                booleans.add(8, true);
//            } else {
//                booleans.add(8, false);
//            }
//            if (strings.contains("Ksenon lampalar")) {
//                booleans.add(9, true);
//            } else {
//                booleans.add(9, false);
//            }
//            if (strings.contains("Arxa görüntü kamerası")) {
//                booleans.add(10, true);
//            } else {
//                booleans.add(10, false);
//            }
//            if (strings.contains("Yan pərdələr")) {
//                booleans.add(11, true);
//            } else {
//                booleans.add(11, false);
//            }
//            if (strings.contains("Oturacaqların ventilyasiyası")) {
//                booleans.add(12, true);
//            } else {
//                booleans.add(12, false);
//            }
//




//        int index = 0;
//        if (strings.get(index).contains("lehimli")) {
//            booleans.add(0, true);
//            index++;
//        } else booleans.add(0, false);
//        if (strings.get(index).equalsIgnoreCase("ABS")) {
//            booleans.add(1, true);
//            index++;
//        } else {
//            booleans.add(1, false);
//            index--;
//        }
//        if (strings.get(index).equalsIgnoreCase("Lyuk")) {
//            booleans.add(2, true);
//            index++;
//        } else {
//            booleans.add(2, false);
//            index--;
//        }
//        if (strings.get(index).equalsIgnoreCase("Yağış sensoru")) {
//            booleans.add(3, true);
//            index++;
//        } else {
//            booleans.add(3, false);
//            index--;
//        }
//        if (strings.get(index).equalsIgnoreCase("Mərkəzi qapanma")) {
//            booleans.add(4, true);
//            index++;
//        } else {
//            booleans.add(4, false);
//            index--;
//        }
//        if (strings.get(index).equalsIgnoreCase("Park radarı")) {
//            booleans.add(5, true);
//            index++;
//        } else {
//            booleans.add(5, false);
//            index--;
//        }
//        if (strings.get(index).equalsIgnoreCase("Kondisioner")) {
//            booleans.add(6, true);
//            index++;
//        } else {
//            booleans.add(6, false);
//            index--;
//        }
//        if (strings.get(index).equalsIgnoreCase("Oturacaqların isidilməsi")) {
//            booleans.add(7, true);
//            index++;
//        } else {
//            booleans.add(7, false);
//            index--;
//        }
//        if (strings.get(index).equalsIgnoreCase("Dəri salon")) {
//            booleans.add(8, true);
//            index++;
//        } else {
//            booleans.add(8, false);
//            index--;
//        }
//        if (strings.get(index).equalsIgnoreCase("Ksenon lampalar")) {
//            booleans.add(9, true);
//            index++;
//        } else {
//            booleans.add(9, false);
//            index--;
//        }
//        if (strings.get(index).equalsIgnoreCase("Arxa görüntü kamerası")) {
//            booleans.add(10, true);
//            index++;
//        } else {
//            booleans.add(10, false);
//            index--;
//        }
//        if (strings.get(index).equalsIgnoreCase("Yan pərdələr")) {
//            booleans.add(11, true);
//            index++;
//        } else {
//            booleans.add(11, false);
//            index--;
//        }
//        if (strings.get(index).equalsIgnoreCase("Oturacaqların ventilyasiyası")) {
//            booleans.add(12, true);
//            index++;
//        } else {
//            booleans.add(12, false);
//            index--;
//        }


//        int a = 0;
//        for (Boolean b : booleans) {
//            System.out.println(a + "-->" + b);
//            a++;
//        }

    }
}
