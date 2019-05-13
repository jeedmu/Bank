package dk.eamv.bank.javafx.Implementations;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import dk.eamv.bank.javafx.domain.Account;
import dk.eamv.bank.javafx.domain.Customer;
import dk.eamv.bank.javafx.domain.Entry;
import dk.eamv.bank.javafx.domain.Transfer;
import dk.eamv.bank.javafx.interfaces.IDataRequestHandler;
import dk.eamv.bank.constants.Constants;

public class DataRequestHandler implements IDataRequestHandler {

	private ObjectMapper mapper = new ObjectMapper();
	private HttpClient client = HttpClientBuilder.create().build();

	@Override
	public void createNewAccount(Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createNewCustomer(Customer customer) {
		String url = Constants.serverUrl + "/bank.ws/rest/employee/createCustomer";
		
		HttpPost post = new HttpPost();
		post.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		

	}

	@Override
	public List<Customer> getCustomers(String customerID, String name, String phoneNumber) {

		String url = Constants.serverUrl + "/bank.ws/rest/employee/customerSearch/";
		List<Customer> result = null;

		HttpGet get = new HttpGet(url);
		get.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		get.addHeader("phoneNumber", phoneNumber);

		try {

			HttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			String string = EntityUtils.toString(entity);
			System.out.println(string);
			result = mapper.readValue(string, new TypeReference<List<Customer>>() {
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<Account> getAccounts(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entry> getEntries(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomer(String customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createNewTransfer(Transfer transfer) {
		// TODO Auto-generated method stub

	}

}
