package com.harry.hibernate.service.impl;

import com.harry.hibernate.dao.BookShopDao;
import com.harry.hibernate.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDao bookShopDao;
	
	/**
	 * Spring hibernate ���������
	 * 1. �ڷ�����ʼ֮ǰ
	 * ��. ��ȡ Session
	 * ��. �� Session �͵�ǰ�̰߳�, �����Ϳ����� Dao ��ʹ�� SessionFactory ��
	 * getCurrentSession() ��������ȡ Session ��
	 * ��. ��������
	 * 
	 * 2. ��������������, ��û�г����쳣, ��
	 * ��. �ύ����
	 * ��. ʹ�͵�ǰ�̰߳󶨵� Session �����
	 * ��. �ر� Session
	 * 
	 * 3. �����������쳣, ��:
	 * ��. �ع�����
	 * ��. ʹ�͵�ǰ�̰߳󶨵� Session �����
	 * ��. �ر� Session
	 */
	@Override
	public void purchase(String username, String isbn) {
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		bookShopDao.updateBookStock(isbn);
		bookShopDao.updateUserAccount(username, price);
	}

}
