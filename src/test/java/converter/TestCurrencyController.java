package converter;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import converter.service.CurrencyService;

@WebMvcTest
class TestCurrencyController {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CurrencyService service;
	
	@Test
	public void testHomepage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Welcome to currency converter app")));
	}
	
	
	@Test
	public void calculateAmountTest() throws Exception {
		
		when(service.exchangeCurrency("CAD", 1000)).thenReturn("Amount after conversion is 17.000000923871994");
		this.mockMvc.perform(get("/convertINRto/CAD/amount/1000")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Amount after conversion is 17.000000923871994")));
	}
}
