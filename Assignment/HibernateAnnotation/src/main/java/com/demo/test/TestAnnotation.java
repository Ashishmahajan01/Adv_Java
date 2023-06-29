package com.demo.test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.MyUser;

public class TestAnnotation {

	public static void main(String[] args) {
		MyUser u = new MyUser(99,"shamim","topper@gmail");
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tr =sess.beginTransaction();
		sess.save(u);
		MyUser u1 = new MyUser(99,"Ashish","neecheSeTopperper@gmail");
		 sess.save(u1);
		tr.commit();
		sess.close();
		sf.close();

	}

}
