package dao;

import pojos.Employee;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String addEmpDetails(Employee newEmp) {
		
		String mesg = "Adding emp Details";
		
		//1. Get Session from SF(Session Factory)
		Session session = getFactory().getCurrentSession();
		
		Transaction tx= session.beginTransaction();
		
		try {
			//Session API: public serializable save(Object transientObjRef)
			Integer id=(Integer)session.save(newEmp);
			tx.commit();
		
			 mesg="Adding emp Details, Id="+id;
		}catch (RuntimeException e) {
			// TODO: handle exception
			if(tx!=null)
			{
				tx.rollback();
			}
		   throw e;
		}	
		return mesg;
	}

}
