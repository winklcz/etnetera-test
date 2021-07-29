package com.etnetera.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface SpringDataRestJpaRepository<T, ID> extends SpringDataRestRepository<T, ID>, JpaRepository<T, ID> {
}
