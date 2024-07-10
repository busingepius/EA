package properties;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "myapp")
@Validated
public class AppProperties {

	private String applictionName;
	@NotBlank
	private String version;
	private String serverUrl;
	@NotBlank
	private String serverName;
	private User user = new User();

	private List<String> countries;

	public void print() {
		System.out.println("applictionName="+applictionName);
		System.out.println("version="+version);
		System.out.println("serverUrl="+serverUrl);
		System.out.println("serverName="+serverName);
		for(String s: countries) {
			System.out.println(s);
		}
		System.out.println("user firstname="+user.firstname);
		System.out.println("user lastname="+user.lastname);
		System.out.println("user username="+user.username);
		System.out.println("user password="+user.password);

		
	}	

	public String getApplictionName() {
		return applictionName;
	}



	public void setApplictionName(String applictionName) {
		this.applictionName = applictionName;
	}



	public String getVersion() {
		return version;
	}



	public void setVersion(String version) {
		this.version = version;
	}



	public String getServerUrl() {
		return serverUrl;
	}



	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}



	public String getServerName() {
		return serverName;
	}



	public void setServerName(String serverName) {
		this.serverName = serverName;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public List<String> getCountries() {
		return countries;
	}



	public void setCountries(List<String> countries) {
		this.countries = countries;
	}



	@Valid
	public class User {

		@NotBlank
		private String firstname;
		@NotBlank
		private String lastname;
		@NotBlank
		private String username;
		@Size(max = 15, min = 6)
		private String password;

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	}




}
