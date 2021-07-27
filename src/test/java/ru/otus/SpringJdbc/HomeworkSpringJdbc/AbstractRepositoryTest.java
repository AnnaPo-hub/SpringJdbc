package ru.otus.SpringJdbc.HomeworkSpringJdbc;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;

@DataMongoTest
@EnableConfigurationProperties
@ComponentScan({"ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories"})
public class AbstractRepositoryTest {
}