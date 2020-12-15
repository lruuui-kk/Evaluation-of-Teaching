package com.evaluation_of_teaching;

import com.evaluation_of_teaching.model.StudentEntity;
import com.evaluation_of_teaching.service.ChooseClassService;
import com.evaluation_of_teaching.service.impl.ChooseClassServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EvaluationOfTeachingApplicationTests {

    @Test
    void contextLoads() {
        ChooseClassService chooseClassService = new ChooseClassServiceImpl();
        List<StudentEntity> list = chooseClassService.queryChooseListByUser("1");
        for (StudentEntity student : list) {
            System.out.println(student);
        }
    }

}
