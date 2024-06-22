package az.turbo.turboextension.service;

import az.turbo.turboextension.entity.CarEntity;
import az.turbo.turboextension.repository.CarRepository;
import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class JsoupService {
    private final CarRepository carRepository;
    private List<Boolean> productExtras = new ArrayList<>();
    private List<String> elementTexts = new ArrayList<>();
    private List<Boolean> booleans = new ArrayList<>();
    private List<String> strings = new ArrayList<>();


    @Scheduled(fixedRate = 30000)
    public void detachCarInfo() throws IOException {
        Document document = Jsoup.connect("https://turbo.az/autos/8492685-mercedes-e-300-de").get();

        Elements elements = document.getElementsByClass("product-properties__i-value");
        Elements extras = document.getElementsByClass("product-extras__i");
        Elements credit = document.getElementsByClass("product-labels__i tz-d-flex tz-align-center");


        for (Element element : elements) {
            elementTexts.add(element.text());
        }

        for (Element element : extras) {
            strings.add(element.text());
        }
        for (Element element : credit) {
            strings.add(element.text());
        }

        checkExtras();
    }

//    public static void main(String[] args) throws IOException {
//        detachCarInfo();
//
//    }


    public void test() {
        CarEntity carEntity = CarEntity.builder()
                .city(elementTexts.get(0))
                .mark(elementTexts.get(1))
                .model(elementTexts.get(2))
                .graduationYear(elementTexts.get(3))
                .banType(elementTexts.get(4))
                .color(elementTexts.get(5))
                .engine(elementTexts.get(6))
                .odometer(elementTexts.get(7))
                .gearBox(elementTexts.get(8))
                .transmitter(elementTexts.get(9))
                .isItNew(elementTexts.get(10))
                .numberOfSeats(elementTexts.get(11))
                .numberOfOwners(elementTexts.get(12))
                .situation(elementTexts.get(13))
                .region(elementTexts.get(14))
                .alloyWheels(booleans.get(0))
                .abs(booleans.get(1))
                .hatch(booleans.get(2))
                .rainSensor(booleans.get(3))
                .centralLocking(booleans.get(4))
                .parkRadar(booleans.get(5))
                .airConditioning(booleans.get(6))
                .seatHeating(booleans.get(7))
                .leatherSalon(booleans.get(8))
                .xenonLamps(booleans.get(9))
                .rearViewCamera(booleans.get(10))
                .sideCurtains(booleans.get(11))
                .seatVentilation(booleans.get(12))
                .credit(booleans.get(13))
                .barter(booleans.get(14))
                .build();

        carRepository.save(carEntity);

    }

    public void checkExtras() {
        if (strings.contains("Yüngül lehimli disklər")) {
            booleans.add(0, true);
        } else {
            booleans.add(0, false);
        }
        if (strings.contains("ABS")) {
            booleans.add(1, true);
        } else {
            booleans.add(1, false);
        }
        if (strings.contains("Lyuk")) {
            booleans.add(2, true);
        } else {
            booleans.add(2, false);
        }
        if (strings.contains("Yağış sensoru")) {
            booleans.add(3, true);
        } else {
            booleans.add(3, false);
        }
        if (strings.contains("Mərkəzi qapanma")) {
            booleans.add(4, true);
        } else {
            booleans.add(4, false);
        }
        if (strings.contains("Park radarı")) {
            booleans.add(5, true);
        } else {
            booleans.add(5, false);
        }
        if (strings.contains("Kondisioner")) {
            booleans.add(6, true);
        } else {
            booleans.add(6, false);
        }
        if (strings.contains("Oturacaqların isidilməsi")) {
            booleans.add(7, true);
        } else {
            booleans.add(7, false);
        }
        if (strings.contains("Dəri salon")) {
            booleans.add(8, true);
        } else {
            booleans.add(8, false);
        }
        if (strings.contains("Ksenon lampalar")) {
            booleans.add(9, true);
        } else {
            booleans.add(9, false);
        }
        if (strings.contains("Arxa görüntü kamerası")) {
            booleans.add(10, true);
        } else {
            booleans.add(10, false);
        }
        if (strings.contains("Yan pərdələr")) {
            booleans.add(11, true);
        } else {
            booleans.add(11, false);
        }
        if (strings.contains("Oturacaqların ventilyasiyası")) {
            booleans.add(12, true);
        } else {
            booleans.add(12, false);
        }
        if (strings.contains("Kredit")) {
            booleans.add(13, true);
        } else {
            booleans.add(13, false);
        }
        if (strings.contains("Barter")) {
            booleans.add(14, true);
        } else {
            booleans.add(14, false);
        }

        test();

    }


}
