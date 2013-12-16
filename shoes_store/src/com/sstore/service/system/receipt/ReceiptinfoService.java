package com.sstore.service.system.receipt;

import java.util.List;

import com.sstore.dao.system.ReceiptDAO;
import com.sstore.po.ReceiptInfo;
/**
 * <p>Title: ShoppingQuerySerlvet</p>
 * <p>Description: 商品进货信息查询的业务逻辑处理</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author 刘钊
 * @version 1.0
 */
public class ReceiptinfoService {
	/**
	 * 数据访问对象
	 */
	private ReceiptDAO dao = new ReceiptDAO();
	/**
	 * 查询所有订单信息
	 * @return
	 */
	public List<ReceiptInfo> getAllReceipt(){
		return dao.getAllReceipt();
	}
	/**
	 * 添加商品进货信息
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
	 * 根据进货单号查询进货信息
	 * 
	 * @param receiptId
	 *            进货单号
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
	 * 修改进货单信息
	 * 
	 * @param receipt
	 *            进货单信息
	 * @return
	 */
	public boolean update(ReceiptInfo receipt) {

		try {

			if (receipt != null && receipt.getReceiptId() != null) {
				// 先查询再修改
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
	 * 根据进货单号删除进货单信息
	 * @param receiptId 进货单号
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
