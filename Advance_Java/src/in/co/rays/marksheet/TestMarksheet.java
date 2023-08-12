package in.co.rays.marksheet;

import java.util.Iterator;
import java.util.List;

import in.co.rays.test.Testdelete;
import in.co.rays.test.Testupdate;

public class TestMarksheet {
	public static void main(String[] args) throws Exception {
		// testadd();
		// Testupdate();
		// Testdelete();
		// testFindRollNo();
		TestSearch();

	}

	private static void Testdelete() throws Exception {
		MarksheetModel model = new MarksheetModel();
		model.delete(311);

	}

	private static void TestSearch() throws Exception {
		MarksheetBean bean =  new MarksheetBean();
		bean.setName("r");
		 bean.setId(7);
		 bean.setRoll_no(405);
		bean.setPysics(50);

		MarksheetModel model = new MarksheetModel();

		List list = model.Search(bean, 1, 5);
		Iterator it = list.listIterator();
		while (it.hasNext()) {
			// System.out.println(it.next());
			bean = (MarksheetBean) it.next();
			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getRoll_no());
			System.out.print("\t" + bean.getPysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());

		}

	}

	private static void testFindRollNo() throws Exception {
		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = model.FindByRoll(5051);
		if (bean != null) {
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getRoll_no());
			System.out.println(bean.getPysics());
			System.out.println(bean.getChemistry());
			System.out.println(bean.getMaths());

		} else {
			System.out.println("no roll no find");
		}

	}

	private static void Testupdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setId(310);
		bean.setName("yash");
		bean.setRoll_no(505);
		bean.setPysics(34);
		bean.setChemistry(45);
		bean.setMaths(67);

		MarksheetModel model = new MarksheetModel();
		model.update(bean);

	}

	private static void testadd() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		// bean.setId(312);
		bean.setName("ram");
		bean.setRoll_no(310);
		bean.setPysics(34);
		bean.setChemistry(23);
		bean.setMaths(12);

		MarksheetModel model = new MarksheetModel();
		model.add(bean);

	}

}
