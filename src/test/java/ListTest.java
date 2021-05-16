import com.lads.models.*;
import com.lads.models.Module;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListTest {

    @Test
    public void LOTTest(){
        LoT teacherList = new LoT();
        Teacher teacherTest1 = new Teacher("Max",new Date(2020,5,14));
        teacherTest1.addTrainingTaken("python","java");
        teacherTest1.addTrainingDue("management");
        teacherList.add(teacherTest1);

        Teacher teacherTest2 = new Teacher("Simon",new Date(2020,5,14));
        teacherTest2.addTrainingTaken("business");
        teacherTest2.addTrainingDue("management","French");
        teacherList.add(teacherTest2);

        Teacher teacherTest3 = new Teacher("Maria",new Date(2021,5,14));
        teacherTest2.addTrainingTaken("Math");
        teacherTest2.addTrainingDue();
        teacherList.add(teacherTest3);

        assertEquals(teacherList.getLastIndex(),2);
        assertEquals(teacherList.getArray()[0],teacherTest1);
        assertEquals(teacherList.getArray()[1],teacherTest2);
        assertEquals(teacherList.getArray()[2],teacherTest3);

        teacherList.remove(teacherTest2);
        assertEquals(teacherList.getLastIndex(),1);
        assertEquals(teacherList.getArray()[0],teacherTest1);
        assertEquals(teacherList.getArray()[1],teacherTest3);


    }

    @Test
    public void LOMTest(){
        LoM moduleList = new LoM();
        Module moduleTest1 = new Module("ADS",1);
        moduleTest1.addTraining("python");
        moduleTest1.addTraining("java");
        moduleTest1.addTeacher("Simon");
        moduleList.add(moduleTest1);

        Module moduleTest2 = new Module("DTA",2);
        moduleTest2.addTraining("java");
        moduleTest2.addTeacher("Max");
        moduleTest2.addTeacher("Simon");
        moduleList.add(moduleTest2);

        Module moduleTest3 = new Module("ECS",2);
        moduleTest3.addTraining("Cyber");
        moduleTest3.addTeacher("Joseph");
        moduleList.add(moduleTest3);

        assertEquals(moduleList.getLastIndex(),2);
        assertEquals(moduleList.getArray()[0],moduleTest1);
        assertEquals(moduleList.getArray()[1],moduleTest2);
        assertEquals(moduleList.getArray()[2],moduleTest3);

        moduleList.remove(moduleTest2);
        assertEquals(moduleList.getLastIndex(),1);
        assertEquals(moduleList.getArray()[0],moduleTest1);
        assertEquals(moduleList.getArray()[1],moduleTest3);


    }
}
