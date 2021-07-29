package com.etnetera.hr.repository;

import com.querydsl.core.types.EntityPath;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface SpringDataRestRepository<T, ID> extends Repository<T, ID>, QuerydslPredicateExecutor<T>, QuerydslBinderCustomizer {

    @Override
    default void customize(QuerydslBindings bindings, EntityPath root) {
    }
}
