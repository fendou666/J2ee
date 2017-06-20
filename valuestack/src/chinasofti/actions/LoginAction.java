package chinasofti.actions;

import chinasofti.commons.BaseAction1;
import chinasofti.commons.BaseAction2;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction{

	String uname;
	String psd;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}

	public String login() {
		System.out.println("login()");
		System.out.println(uname + "@" + psd);
		ActionContext context = ActionContext.getContext();
		context.put("sex", "man");
		context.getValueStack().set("age1", 100);
		UserInfo ui = new UserInfo("zhangsan", 24);
		context.getSession().put("loginuser", ui);
		return "success";
	}
}
