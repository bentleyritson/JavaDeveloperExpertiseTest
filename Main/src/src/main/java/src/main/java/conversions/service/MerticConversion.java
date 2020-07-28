package conversions.service;

import conversions.model.Metric;

//Contract for Metric conversions
public interface MerticConversion {

    Metric  ktoc(int kelvin);

    Metric ctok(int celsius);

    Metric mtok(int mile);

    Metric ktom(int kilometer);

    
}
