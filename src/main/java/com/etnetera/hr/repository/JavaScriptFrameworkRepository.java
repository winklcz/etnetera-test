package com.etnetera.hr.repository;

import com.etnetera.hr.data.JavaScriptFramework;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Spring data repository interface used for accessing the data in database.
 * 
 * @author Etnetera
 *
 */
@RepositoryRestResource(collectionResourceRel = "jsf", path = "jsf")
public interface JavaScriptFrameworkRepository extends SpringDataRestJpaRepository<JavaScriptFramework, Long> {
}
