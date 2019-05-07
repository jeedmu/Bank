package data;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
import dk.eamv.bank.domain.Bank;
import dk.eamv.bank.domain.Property;
import dk.eamv.bank.domain.Role;
import dk.eamv.bank.domain.User;
import dk.eamv.bank.ejb.Admin;

public class RequestHandler implements Admin {

	@Override
	public void editUser(User user) {
		
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> getUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editRole(Role role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRole(int roleID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Role createRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> getRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Role> getRole(int roleID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editProperty(Property property) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProperty(String property) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createProperty(Property property) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Property> getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Property> getProperty(String property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editBank(Bank bank) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBank(String address) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createBank(Bank bank) {
		String url = "http://desktop-g3507t3:8080/bank.ws/rest/admin/createBank/";
		HttpPost post = new HttpPost(url);
		return false;
	}

	@Override
	public List<Bank> getBanks() {
		String url = "http://desktop-g3507t3:8080/bank.ws/rest/admin/getBanks/";
		
		List<Bank> result = null;
		ObjectMapper mapper = new ObjectMapper();
		HttpClient client = HttpClientBuilder.create().build();
		
		HttpGet get = new HttpGet(url);
		
		try {
			HttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			String string = EntityUtils.toString(entity);
			System.out.println(string);
			result = mapper.readValue(string, new TypeReference<List<Bank>>() {});
		}
		catch(IOException e){
			
		}
		return result;
	}

	@Override
	public Optional<Bank> getBank(int regNumber) {
		String url = "http://desktop-g3507t3:8080/bank.ws/rest/admin/getBanks/";
		
		Optional<Bank> result = null;
		ObjectMapper mapper = new ObjectMapper();
		HttpClient client = HttpClientBuilder.create().build();
		
		HttpGet get = new HttpGet(url);
		get.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		get.addHeader("regNumber", Integer.toString(regNumber));
		
		try {
			HttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			String string = EntityUtils.toString(entity);
			System.out.println(string);
			result = mapper.readValue(string, new TypeReference<Bank>() {});
		}
		catch(IOException e){
			
		}
		return result;
	}

}
