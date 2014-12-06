package controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import business.DataProcessing;
import business.StudentDao;
import model.Databean;
import model.Studentbean;


/**
// * @author Noumessi
 *
 */

public class Driver extends ActionSupport implements ModelDriven, ServletContextAware {
	
	private static final long serialVersionUID = 1L;
	private  List<Studentbean> lists=null;
	private Studentbean studentbean;
	private Databean databean;
	private String message;
	private ServletContext servletContext;
	

	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Driver() {
        super();
        System.out.println("initialization");
        
       
        // TODO Auto-generated constructor stub
    }
	
	
	protected boolean validId(){
				
		return !StudentDao.IdInuse(studentbean.getStudentId());		
	}
public Studentbean get_student(String id){
		
		if (id != null) {
			if (getLists().size() > 0) {
			        int index = -1;
			      for (int i = 0; i < getLists().size(); i++) {
			      if (lists.get(i).getStudentId().equalsIgnoreCase(id)) {
			            index = i;
			         }
			          }
			           if (index > -1) {
			return lists.get(index);
			} else {
			
			return null;
			}
			} else {
			
			return null;
			}
			} else {
			return null;
			}
	}


	
    public Databean getDatabean() {
		return databean;
	}



	public void setDatabean(Databean databean) {
		this.databean = databean;
	}



	public List<Studentbean> getLists() {
		return lists;
	}



	public static void setLists(List<Studentbean> lists) {
		lists = lists;
	}

/**
 * Called when survey form is submitted. Does the processing and decides whether the 
 * student has won the random data input test.
 * 
 * @return the list of students by Id
 */
public String send(){
	 System.out.println(studentbean.toString());
	if(validId()){// inserting info
		System.out.println("inside action");
		
		StudentDao.SaveForm(studentbean.getStudentId(),studentbean.getName(),
				studentbean.getAddress(),studentbean.getCity(),studentbean.getState(),studentbean.getZip(),
				studentbean.getTel(),studentbean.getEmail(),
				studentbean.getUrl(),studentbean.getDates(),studentbean.getHow(),studentbean.getLike(), 
				studentbean.getGraduationMonth(),studentbean.getYear(), studentbean.getRecommendation(),
				studentbean.getComment(),studentbean.getData());
		databean= DataProcessing.compute(studentbean.getData());
		
		if(databean.getMean()>=90)
			{
			servletContext.setAttribute("name", studentbean.getName());
			servletContext.setAttribute("idList", StudentDao.list_ID());
			servletContext.setAttribute("compMean", databean.getMean());
			servletContext.setAttribute("compStdv", databean.getDeviation());
			
			return "win";
			}else{
				servletContext.setAttribute("name", studentbean.getName());
				servletContext.setAttribute("idList", StudentDao.list_ID());
				servletContext.setAttribute("compMean", databean.getMean());
				servletContext.setAttribute("compStdv", databean.getDeviation());
				return "lost";
		   
			}
		
	}else{
		System.out.println("exits already");
		setMessage("StudentId already exist!!");
		servletContext.setAttribute("sms", getMessage());
		return "back";
	}
	
	
	
}

/**
 * Called when students attempt to retrieve data from a particular student. On success,
 * it returns success which is equivalent to the student info, on failure, it returns 
 * error which corresponds to no students found with that credential.
 * 
 * @return the student info.
 */
public String retrieve(){
	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		
	lists=StudentDao.List_students();
	// info student requested
	
	//request.setAttribute("idList", IDs);
	System.out.println("Selected Student: " + request.getParameter("act"));
	Studentbean student = get_student(request.getParameter("act").toString());
	System.out.println("Selected Student .: " + student);
	
	if (student == null) {
		System.out.println("[ERROR] :=: Going to the error student page.");
		return "back";
		} else {
			//lists = StudentDao.List_students();
			List<String> IDs = StudentDao.list_ID();
			servletContext.setAttribute("idList", IDs);
			//studentbean=student;
			servletContext.setAttribute("st", student);
		return "success";
		}
	
}


	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		studentbean=new Studentbean(); 
		return studentbean;
	}
	
	

	public Studentbean getStudentbean() {
		return studentbean;
	}

	public void setStudentbean(Studentbean studentbean) {
		this.studentbean = studentbean;
	}

	
	public void setServletContext(ServletContext arg0) {
		System.out.println("set context");
		// TODO Auto-generated method stub
		this.servletContext=arg0;
	}
	public ServletContext getServletContext() {
		System.out.println("get context");
		// TODO Auto-generated method stub
		return servletContext;
	}

}
