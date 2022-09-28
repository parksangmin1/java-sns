package user;

import java.io.Serializable;

public class User implements Serializable{
	private String id;
	private String password;
	private String name;
	private int age;
	private String sex;
	private String email;
	private String profile;
	private int friends_no;
	
	public User(String id, String password, String name, int age, String sex, String email, String profile,
			int friends_no) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.email = email;
		this.profile = profile;
		this.friends_no = friends_no;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getProfile() {
		return profile;
	}
	
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	public int getFriends_no() {
		return friends_no;
	}
	
	public void setFriends_no(int friends_no) {
		this.friends_no = friends_no;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", age=" + age + ", sex=" + sex
				+ ", email=" + email + ", profile=" + profile + ", friends_no=" + friends_no + "]";
	}
}

