
import com.lads.models.Date;
import com.lads.models.dataStructure.Lab;
import com.lads.models.dataStructure.Module;
import com.lads.models.dataStructure.Teacher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class DataStructureTest {

    @Test
    public void toStringTest(){
        Teacher teacherTest1 = new Teacher("Simon",new Date(2020,5,14));
        teacherTest1.addTrainingTaken("training1","training2");
        teacherTest1.addTrainingDue("training1");
        teacherTest1.addSkills("python","java");

        assertEquals(teacherTest1.toString(),"Simon|2020|5|14|[training1]|[training1, training2]|[python, java]\n");

        Teacher teacherTest2 = new Teacher("Max",new Date(2020,5,14));
        teacherTest2.addTrainingTaken("training3");
        teacherTest2.addTrainingDue("java");

        Lab labTest = new Lab("python101",2);
        labTest.addTeacher(teacherTest1,teacherTest2);
        labTest.addTrainingRequired("training101","training102");
        assertEquals(labTest.toString(),"python101|2|[training101, training102]|[Simon,Max]\n");


        Module moduleTest = new Module("Module1");
        moduleTest.addTeacher(teacherTest1,teacherTest2);
        moduleTest.addLabs(labTest);
        assertEquals(moduleTest.toString(),"Module1|[Simon,Max]|[python101]\n");

    }

}
