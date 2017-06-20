package chinasofti.commons;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction1 extends ActionSupport  {
	// 非Ioc方式
	ActionContext context = ActionContext.getContext();
	Map<String, Object> application = context.getApplication();
	Map<String, Object> session1 = context.getSession();
	Map request1 = (Map) context.get("request");

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpSession session2 = request.getSession();
	ServletContext application2 = ServletActionContext.getServletContext();

}
