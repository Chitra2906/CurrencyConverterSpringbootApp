package converter.data;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
@Service
public class CurrencyData {

		public float exchangeRate(String toCode) {
			HashMap<String,Float> RateList = new HashMap<String,Float>();
			RateList.put("Euro",(float) 0.012);
			RateList.put("CAD",(float)0.017);
			RateList.put("USD",(float)0.013);
			Float rate = RateList.get(toCode);
			return rate;
		
		
		}
		
		
}
