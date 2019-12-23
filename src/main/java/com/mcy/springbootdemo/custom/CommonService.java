package com.mcy.springbootdemo.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 公共Service
 * @param <T>
 * @param <ID>
 */
public class CommonService<T,ID> {
	@Autowired(required = false)
	private CommonRepository<T, ID> baseDAO;

	//查询所有
	public List<T> findAll(){
		return baseDAO.findAll();
	}

	//根据id查询
	public T findById(ID id) {
		Optional<T> optional = baseDAO.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	//保存方法
	@Transactional
	public void save(T entity) {
		baseDAO.save(entity);
	}

	//根据实体类删除
	public void delete(T entity) {
		baseDAO.delete(entity);
	}

	//根据id查询
	@Transactional
	public void deleteById(ID id) {
		baseDAO.deleteById(id);
	}

	//排序查询所有
	public List<T> findAll(Sort sort){
		return baseDAO.findAll(sort);
	}

	//动态条件查询
	public List<T> findAll(Specification<T> spec){
		return baseDAO.findAll(spec);
	}

	//分页查询
	public Page<T> findAll(Pageable pageable){
		return baseDAO.findAll(pageable);
	}

	//动态条件分页查询
	public Page<T> findAll(Specification<T> spec, Pageable pageable){
		return baseDAO.findAll(spec,pageable);
	}

	//动态条件排序查询
	public List<T> findAll(Specification<T> spec, Sort sort){
		return baseDAO.findAll(spec,sort);
	}
}
