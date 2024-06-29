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
import java.util.*;

@Service
@Data
public class JsoupService {
    private final CarRepository carRepository;
    private final Map<String, String> productProperties = new HashMap<>();
    private final List<String> productValue = new ArrayList<>();
    private final Map<String, Boolean> productLabels = new HashMap<>();

     public void startPoint(String url) throws IOException {
        Document document = Jsoup.connect(url).get();

        List<String> classNames = Arrays.asList(
                "product-labels__i-icon product-labels__i-icon--loan",
                "product-labels__i-icon product-labels__i-icon--barter"
        );

        for (String className : classNames) {
            Elements elements = document.getElementsByClass(className);
            String name = className.split("--")[1];
            checkProductLabels(elements, name);
        }

        printProductLabels(productLabels);

        Elements productPropertiesI = document.getElementsByClass("product-properties__i");

        List<String> desiredAttributes = Arrays.asList(
                "ad_region", "ad_make_id", "ad_model", "ad_reg_year",
                "ad_category", "ad_color", "ad_engine_volume", "ad_mileage",
                "ad_transmission", "ad_gear", "ad_new", "ad_seats_count",
                "ad_prior_owners_count", "ad_Vəziyyəti", "ad_market"
        );

        for (String attribute : desiredAttributes) {
            Element element = productPropertiesI.select("label[for=" + attribute + "]").first();
            setProductProperties(element);
        }

        printProductProperties(productProperties);


        Elements productExtras = document.getElementsByClass("product-extras__i");

        List<String> features = Arrays.asList(
                "Yüngül lehimli disklər",
                "ABS",
                "Lyuk",
                "Yağış sensoru",
                "Mərkəzi qapanma",
                "Park radarı",
                "Kondisioner",
                "Oturacaqların isidilməsi",
                "Dəri salon",
                "Ksenon lampalar",
                "Arxa görüntü kamerası",
                "Yan pərdələr",
                "Oturacaqların ventilyasiyası"
        );

        for (String feature : features) {
            boolean exists = checkFeatureExistence(productExtras, feature);
            productLabels.put(feature, exists);
        }

        printProductLabels(productLabels);


        setCarRepository();


    }

    private boolean checkFeatureExistence(Elements productExtras, String feature) {
        for (Element extra : productExtras) {
            if (extra.text().contains(feature)) {
                return true;
            }
        }
        return false;
    }

    private void checkProductLabels(Elements element, String name) {
        Boolean check = !element.isEmpty();
        productLabels.put(name, check);
    }

    private void setProductProperties(Element element) {
        String labelText = "";
        if (element != null) {
            labelText = element.text();

            Element spanElement = element.nextElementSibling();
            String spanText = "";
            if (spanElement != null) {
                spanText = spanElement.text();
            }
            productProperties.put(labelText, spanText);
        }
    }

    public void printProductProperties(Map<String, String> map) {
        System.out.println("Using entrySet:");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    public void printProductLabels(Map<String, Boolean> map) {
        System.out.println("Using entrySet:");
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    public void setCarRepository() {
        CarEntity carEntity = new CarEntity();
        carEntity.setCity(productProperties.get("Şəhər"));
        carEntity.setMark(productProperties.get("Marka"));
        carEntity.setModel(productProperties.get("Model"));
        carEntity.setGraduationYear(productProperties.get("Buraxılış ili"));
        carEntity.setBanType(productProperties.get("Ban növü"));
        carEntity.setColor(productProperties.get("Rəng"));
        carEntity.setEngine(productProperties.get("Mühərrik"));
        carEntity.setOdometer(productProperties.get("Yürüş"));
        carEntity.setGearBox(productProperties.get("Sürətlər qutusu"));
        carEntity.setTransmitter(productProperties.get("Ötürücü"));
        carEntity.setIsItNew(productProperties.get("Yeni"));
        carEntity.setSituation(productProperties.get("Vəziyyəti"));
        carEntity.setRegion(productProperties.get("Hansı bazar üçün yığılıb"));
        carEntity.setNumberOfSeats(productProperties.get("Yerlərin sayı"));
        carEntity.setNumberOfOwners(productProperties.get("Sahiblər"));

        carEntity.setAlloyWheels(productLabels.get("Yüngül lehimli disklər"));
        carEntity.setAbs(productLabels.get("ABS"));
        carEntity.setHatch(productLabels.get("Lyuk"));
        carEntity.setRainSensor(productLabels.get("Yağış sensoru"));
        carEntity.setCentralLocking(productLabels.get("Mərkəzi qapanma"));
        carEntity.setParkRadar(productLabels.get("Park radarı"));
        carEntity.setAirConditioning(productLabels.get("Kondisioner"));
        carEntity.setSeatHeating(productLabels.get("Oturacaqların isidilməsi"));
        carEntity.setLeatherSalon(productLabels.get("Dəri salon"));
        carEntity.setXenonLamps(productLabels.get("Ksenon lampalar"));
        carEntity.setRearViewCamera(productLabels.get("Arxa görüntü kamerası"));
        carEntity.setSideCurtains(productLabels.get("Yan pərdələr"));
        carEntity.setSeatVentilation(productLabels.get("Oturacaqların ventilyasiyası"));

        carEntity.setCredit(productLabels.get("loan"));
        carEntity.setBarter(productLabels.get("barter"));

        System.out.println(carEntity);

        carRepository.save(carEntity);
    }


}
