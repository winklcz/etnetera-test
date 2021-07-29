package com.etnetera.hr;

import com.etnetera.hr.data.JavaScriptFramework;
import com.etnetera.hr.data.JavaScriptFrameworkVersion;
import com.etnetera.hr.data.QJavaScriptFramework;
import com.etnetera.hr.repository.JavaScriptFrameworkRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Class used for Spring Boot/MVC based tests.
 *
 * @author Etnetera
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaScriptFrameworkTests {

    public static final String TEST = "test";
    public static final String TEST_2 = "test2";

    @Autowired
    private JavaScriptFrameworkRepository javaScriptFrameworkRepository;

    @Test
    @Transactional
    public void createAndGet() {

        JavaScriptFramework create = createTestEntity();

        JavaScriptFramework get = javaScriptFrameworkRepository.getOne(create.getId());

        Assert.assertNotNull(get);
        Assert.assertEquals(TEST, get.getName());
        Assert.assertNotNull(get.getId());
    }

    @Test
    @Transactional
    public void updateAndGet() {

        JavaScriptFramework create = createTestEntity();

        create.setName(TEST_2);
        javaScriptFrameworkRepository.save(create);

        Assert.assertNotNull(create);
        Assert.assertEquals(TEST_2, create.getName());
    }

    @Test
    @Transactional
    public void delete() {

        JavaScriptFramework create = createTestEntity();

        javaScriptFrameworkRepository.delete(create);

        BooleanBuilder predicates = new BooleanBuilder();
        Optional<JavaScriptFramework> get = javaScriptFrameworkRepository.
                findOne(predicates.and(QJavaScriptFramework.javaScriptFramework.name.eq(TEST)));

        Assert.assertTrue(get.isEmpty());
    }

    private JavaScriptFramework createTestEntity() {

        List<JavaScriptFrameworkVersion> javaScriptFrameworkVersions = new ArrayList<>();
        javaScriptFrameworkVersions.add(JavaScriptFrameworkVersion.builder()
                .number("1")
                .build());

        return javaScriptFrameworkRepository.save(JavaScriptFramework.builder()
                .deprecationDate(new Date(System.currentTimeMillis()))
                .name(TEST)
                .versions(javaScriptFrameworkVersions)
                .build());
    }
}
