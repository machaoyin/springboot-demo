package com.mcy.springbootdemo.web.controller;

import com.mcy.springbootdemo.custom.CommonController;
import com.mcy.springbootdemo.entity.User;
import com.mcy.springbootdemo.repository.UserRepository;
import com.mcy.springbootdemo.web.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController extends CommonController<User, Integer, UserForm> {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = {"/", "index"})
    public String index(){
        return "manage";
    }

    @Override
    public Specification<User> buildSpec(UserForm form) {
        Specification<User> spec = new Specification<User>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //本集合用于封装查询条件
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.hasText(form.getSearch())) {
                    Predicate name = cb.like(root.get("loginName"), "%" + form.getSearch() + "%");
                    Predicate username = cb.like(root.get("username"), "%" + form.getSearch() + "%");
                    Predicate or = cb.or(name, username);
                    predicates.add(or);
                }
                return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
            }
        };
        return spec;
    }
}
