package in.co.rays.user;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUser {
	public static void main(String[] args)  throws  Exception{
	//	Testadd();
	//	Testupdate();
		TestSearch();
	}

	private static void TestSearch()  throws Exception{
		UserBean bean = new UserBean();
		String dob = "1997-08-09";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      bean.setDob(sdf.parse(dob));
      UserModel model = new UserModel();
      List list = model.search(bean);
      Iterator it = list.iterator();
      while (it.hasNext()) {
    	  bean =( UserBean)it.next();
    	  System.out.println(bean.getId());
    	  System.out.println(bean.getFirst_name());
    	  System.out.println(bean.getLast_name());
          System.out.println(bean.getLogin_id());
          System.out.println(bean.getPassword());
          System.out.println(bean.getDob());
          System.out.println(bean.getAddress());
	}
	
		
	}

	private static void Testupdate() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = model.findByPk(2);
		if (bean!=null) {
     bean.setFirst_name("udit");
     bean.setLast_name("gurjar");
     model.update(bean);
     System.out.println("user exite & updated");
		}else {
			System.out.println("user not exit....!!!");
		}
		

		
		
	
		
	}

	private static void Testadd() throws Exception {
		UserBean bean = new UserBean();
		String dob = "1996-08-09";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	//	bean.setId(1);
		bean.setFirst_name("raja");
		bean.setLast_name("yadav");
		bean.setLogin_id("raja@gmail.com");
		bean.setPassword("123455");
		bean.setDob(sdf.parse(dob));
		bean.setAddress("indori");
		UserModel model = new UserModel();
		model.add(bean);
		
		
	}
	

}
