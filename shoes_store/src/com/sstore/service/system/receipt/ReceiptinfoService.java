package com.sstore.service.system.receipt;

import java.util.List;

import com.sstore.dao.system.ReceiptDAO;
import com.sstore.po.ReceiptInfo;
/**
 * <p>Title: ShoppingQuerySerlvet</p>
 * <p>Description: ��Ʒ������Ϣ��ѯ��ҵ���߼�����</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author ����
 * @version 1.0
 */
public class ReceiptinfoService {
	/**
	 * ���ݷ��ʶ���
	 */
	private ReceiptDAO dao = new ReceiptDAO();
	/**
	 * ��ѯ���ж�����Ϣ
	 * @return
	 */
	public List<ReceiptInfo> getAllReceipt(){
		return dao.getAllReceipt();
	}
	/**
	 * �����Ʒ������Ϣ
	 * 
	 * @param receipt
	 * @return
	 */
	public boolean add(ReceiptInfo receipt) {

		if (receipt != null && receipt.getReceiptId() != null
				&& !receipt.getReceiptId().equals("")) {

			return dao.add(receipt);
		}
		return false;
	}
	/**
	 * ���ݽ������Ų�ѯ������Ϣ
	 * 
	 * @param receiptId
	 *            ��������
	 * @return
	 */
	public ReceiptInfo getReceipt(String receiptId) {

		try {
			return dao.getReceiptInfo(Integer.parseInt(receiptId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * �޸Ľ�������Ϣ
	 * 
	 * @param receipt
	 *            ��������Ϣ
	 * @return
	 */
	public boolean update(ReceiptInfo receipt) {

		try {

			if (receipt != null && receipt.getReceiptId() != null) {
				// �Ȳ�ѯ���޸�
				ReceiptInfo puser = dao.getReceiptInfo(receipt.getReceiptId());
				
				if (puser != null) {
					
					puser.setReceiptPrice(receipt.getReceiptPrice());

					return dao.update(puser);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	/**
	 * ���ݽ�������ɾ����������Ϣ
	 * @param receiptId ��������
	 * @return
	 */
	public boolean delete(String receiptId) {

		try {
			if (receiptId != null && !"".endsWith(receiptId)) {

				return dao.delete(Integer.parseInt(receiptId));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
