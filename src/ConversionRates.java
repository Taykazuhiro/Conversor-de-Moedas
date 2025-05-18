import java.util.Map;

public class ConversionRates {
    private String status;
    private String baseCode;
    private String exchargeCode;
    private Map<String, Double> conversion_rates;
    private ApiConnection api = new ApiConnection();

    public String getExchargeCode() {
        return exchargeCode;
    }

    public String getStatus() {
        return status;
    }

    public String getCode() {
        return baseCode;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }
    }