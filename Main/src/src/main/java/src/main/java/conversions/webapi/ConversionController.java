package conversions.webapi;

import conversions.model.Metric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ConversionBean;

//Controller for mapping requests for the converter.
@RestController
public class ConversionController {
    int kelvin = 500;

    @Autowired
    ConversionBean conversionBean;

    @RequestMapping("/CelsiusToKelvin")
    @ResponseBody
    public ResponseEntity<Metric> getCelsius(@RequestParam(value = "value", required = true, defaultValue = "0") String value){

        return new ResponseEntity<Metric>(conversionBean.ktoc(Integer.valueOf(value)), HttpStatus.OK);
    }

    @RequestMapping("/KelvinToCelsius")
    @ResponseBody
    public ResponseEntity<Metric> getKelvin(@RequestParam(value = "value", required = true, defaultValue = "0") String value){

        return new ResponseEntity<Metric>(conversionBean.ctok(Integer.valueOf(value)), HttpStatus.OK);
    }

    @RequestMapping("/MilesToKilometers")
    @ResponseBody
    public ResponseEntity<Metric> getKilometers(@RequestParam(value = "value", required = true, defaultValue = "0") String value){

        return new ResponseEntity<Metric>(conversionBean.mtok(Integer.valueOf(value)), HttpStatus.OK);
    }

    @RequestMapping("/KilometersToMiles")
    @ResponseBody
    public ResponseEntity<Metric> getMiles(@RequestParam(value = "value", required = true, defaultValue = "0") String value){

        return new ResponseEntity<Metric>(conversionBean.ktom(Integer.valueOf(value)), HttpStatus.OK);
    }


}
