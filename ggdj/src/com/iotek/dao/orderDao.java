package com.iotek.dao;

import java.util.List;

import com.iotek.entity.order;

public interface orderDao {
	public boolean saveOrder(order order) throws Exception;//��Ӷ���
	public boolean delOrder(String orderId) throws Exception;//ɾ������
	public List<order> queryAllOrder() throws Exception;//��ѯ���ж���
	public order queryOrder(String orderId) throws Exception;//���ݶ����Ų�ѯ������
	
	public List<order> queryUserOrder(int userId) throws Exception;//�����û�ID�Ų�ѯ���û���ӵ�еĶ���
	public boolean updateOrder(order order) throws Exception;//�޸Ķ�Ӧ����
	public List<order> queryOrderByUserDate(String date,int userId) throws Exception;//�����û�ID�ţ����ڲ�ѯ���û�����Ķ���
	public List<order> queryOrderByDate(String date) throws Exception;//��������ģ����ѯ
	
	
}
