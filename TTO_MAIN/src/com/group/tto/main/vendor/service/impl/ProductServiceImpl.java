package com.group.tto.main.vendor.service.impl;

import java.io.InputStream;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.group.tto.cmn.model.Product;
import com.group.tto.main.dao.FileDao;
import com.group.tto.main.vendor.dao.PoductDao;
import com.group.tto.main.vendor.service.ProductService;

@Service
@Repository("vendorProductServiceImpl")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private PoductDao poductDao;
	@Autowired
    private FileDao  fileDao;
	public PoductDao getPoductDao() {
		return poductDao;
	}

	public FileDao getFileDao() {
		return fileDao;
	}

	public void setFileDao(FileDao fileDao) {
		this.fileDao = fileDao;
	}

	public void setPoductDao(PoductDao poductDao) {
		this.poductDao = poductDao;
	}

	@Override
	@Transactional
	public void addProduct(Product product,InputStream input) {
		poductDao.createProduct(product);
		
		System.out.println("-=====================-:"+product.getProductPicUrl());
		fileDao.saveFile(input,product.getProductPicUrl());
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public List<Product> findAllProductsBySid(long sid) {

		return poductDao.findAllProducts(sid);
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public List<Product> findProductsByLabel(long label, long sid) {

		return poductDao.findProductsByLabel(label, sid);
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void updateProducts(Product product) {
		poductDao.updateProduct(product);
	}

	@Override
	@Transactional
	public void deleteProducts(long pid) {
		poductDao.deleteProduct(pid);
	}

}
