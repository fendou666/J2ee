package chinasofti.actions;

public class UserInfo {

	private String name;
	private int age;
	public UserInfo(String p_name, int p_age) {
		name = p_name;
		age = p_age;
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
	@Override
	public String toString() {
		return name + "@" + age;
	}

}
