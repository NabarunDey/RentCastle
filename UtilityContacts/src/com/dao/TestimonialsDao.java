package com.dao;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import testimonials.appService.inputBeans.TestimonialsAppServiceIB;

import com.databaseBeans.TestimonialsDBBean;
import com.structures.status.ProductStatus;

@Transactional
public class TestimonialsDao {

	HibernateTemplate template;  

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}


	public List<TestimonialsDBBean> getOnLoadTestimonial(String userName)
	{
		List<TestimonialsDBBean> testimonialsDBBeans = null;

		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(TestimonialsDBBean.class)
				.add(Restrictions.like("status", ProductStatus.APPROVED.toString()));

		testimonialsDBBeans = criteria.list();
		Collections.shuffle(testimonialsDBBeans);

		if(StringUtils.isNotEmpty(userName))
		{

			TestimonialsDBBean myTestimonialsDBBean =null;
			for(TestimonialsDBBean testimonialsDBBean : testimonialsDBBeans)
			{
				if(testimonialsDBBean.getUsername().equals(userName))
				{
					myTestimonialsDBBean = testimonialsDBBean;
					testimonialsDBBeans.remove(testimonialsDBBean);
					break;
				}
			}
			testimonialsDBBeans.add(myTestimonialsDBBean);
			Collections.reverse(testimonialsDBBeans);
		}
		return testimonialsDBBeans;
	}

	public List<TestimonialsDBBean> getTestimonialsForUser(String userName)
	{
		List<TestimonialsDBBean> testimonialsDBBeans = null;

		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(TestimonialsDBBean.class)
				.add(Restrictions.like("username", userName));
		testimonialsDBBeans = criteria.list();
		return testimonialsDBBeans;
	}

	public void addTestimonial(TestimonialsAppServiceIB testimonialsAppServiceIB)
	{
		List<TestimonialsDBBean> testimonialsDBBeans = null;

		Criteria criteria = template.getSessionFactory().getCurrentSession().createCriteria(TestimonialsDBBean.class)
				.add(Restrictions.like("username", testimonialsAppServiceIB.getUsername()));
		testimonialsDBBeans = criteria.list();

		TestimonialsDBBean testimonialsDBBean = null;
		if(null!=testimonialsDBBeans && testimonialsDBBeans.size()>0)
		{
			testimonialsDBBean= testimonialsDBBeans.get(0);
			testimonialsDBBean.setComment(testimonialsAppServiceIB.getComment());
			testimonialsDBBean.setDisplayName(testimonialsAppServiceIB.getDisplayName());
			testimonialsDBBean.setImagePath(testimonialsAppServiceIB.getImagePath());
			testimonialsDBBean.setRating(testimonialsAppServiceIB.getRating());
			testimonialsDBBean.setStatus(ProductStatus.PENDING.toString());
			testimonialsDBBean.setUsername(testimonialsAppServiceIB.getUsername());
			template.update(testimonialsDBBean);
		}

		else
		{
			testimonialsDBBean=	new TestimonialsDBBean();
			testimonialsDBBean.setComment(testimonialsAppServiceIB.getComment());
			testimonialsDBBean.setDisplayName(testimonialsAppServiceIB.getDisplayName());
			testimonialsDBBean.setImagePath(testimonialsAppServiceIB.getImagePath());
			testimonialsDBBean.setRating(testimonialsAppServiceIB.getRating());
			testimonialsDBBean.setStatus(ProductStatus.PENDING.toString());
			testimonialsDBBean.setUsername(testimonialsAppServiceIB.getUsername());

			template.save(testimonialsDBBean);
		}
	}


}
