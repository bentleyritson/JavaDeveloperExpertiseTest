package service;

import conversions.model.Metric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversionBean implements MerticConversion{

    @Autowired
    Metric metric;

    @Override
    public Metric ktoc(int kelvin) {        //Conversion of Kelvin to Celsius
        metric.setKilometers(0);
        metric.setMiles(0);

        metric.setKelvin(kelvin);
        metric.setCelsius((int) (metric.getKelvin() - 273.15));
        System.out.println("ktoc");
        System.out.println(metric.getCelsius());

        return metric;
    }

    @Override
    public Metric ctok(int celsius) {       //Conversion of  celsius to Kelvin
        metric.setKilometers(0);
        metric.setMiles(0);

        metric.setCelsius(celsius);
        metric.setKelvin((int) (metric.getCelsius() + 273.15));
        System.out.println("ctok");
        System.out.println(metric.getKelvin());
        return metric;
    }

    @Override
    public Metric mtok(int miles) {     //Conversion of Miles to Kilometers
        metric.setKelvin(0);
        metric.setCelsius(0);

        metric.setMiles(miles);
        metric.setKilometers((int) (metric.getMiles() * 1.609 ));
        System.out.println("mtok");
        System.out.println(metric.getKilometers());
        return metric;
    }

    @Override
    public Metric ktom(int kilometer) {     //Conversion of Kilometers to Celsius
        metric.setKelvin(0);
        metric.setCelsius(0);

        metric.setKilometers(kilometer);
        metric.setMiles((int) (metric.getKilometers() / 1.609));
        System.out.println("ktom");
        System.out.println(metric.getMiles());
        return metric;
    }
}
