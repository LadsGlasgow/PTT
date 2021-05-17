

import com.lads.models.Date;
import com.lads.models.connection.FileIO;
import com.lads.models.dataStructure.Lab;
import com.lads.models.dataStructure.Module;
import com.lads.models.dataStructure.Teacher;
import com.lads.models.iterator.Aggregate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileIOTest {

    @Test
    public void normalStoreTest(){
        FileIO fileIO = FileIO.getInstance();
        fileIO.setDirectory("C:\\Users\\flyingjack\\OneDrive\\UofGlasgow Files\\COMPSCI5059 Software Engineering M\\PTT\\src\\main\\java\\com\\lads\\data\\");

        Teacher teacherTest1 = new Teacher("Simon",new Date(2020,5,14));
        teacherTest1.addTrainingTaken("training1","training2");
        teacherTest1.addTrainingDue("training1");
        teacherTest1.addSkills("python","java");


        Teacher teacherTest2 = new Teacher("Max",new Date(2020,5,14));
        teacherTest2.addTrainingTaken("training3");
        teacherTest2.addTrainingDue("java");
        teacherTest2.addSkills("business");

        Aggregate<Teacher> teacherAggregate = new Aggregate<>();
        teacherAggregate.add(teacherTest1);
        teacherAggregate.add(teacherTest2);

        fileIO.storeData("teacher",teacherAggregate);

        Lab labTest1 = new Lab("python101",2);
        labTest1.addTeacher(teacherTest1,teacherTest2);
        labTest1.addTrainingRequired("training101","training102");

        Lab labTest2 = new Lab("java202",2);
        labTest2.addTeacher(teacherTest2);
        labTest2.addTrainingRequired("training302");

        Aggregate<Lab> labAggregate = new Aggregate<>();
        labAggregate.add(labTest1);
        labAggregate.add(labTest2);

        fileIO.storeData("lab",labAggregate);


        Module moduleTest1 = new Module("Module1");
        moduleTest1.addTeacher(teacherTest1);
        moduleTest1.addLabs(labTest1,labTest2);

        Module moduleTest2 = new Module("Module2");
        moduleTest2.addTeacher(teacherTest2);
        moduleTest2.addLabs(labTest1);


        Aggregate<Module> moduleAggregate = new Aggregate<>();
        moduleAggregate.add(moduleTest1);
        moduleAggregate.add(moduleTest2);

        fileIO.storeData("module",moduleAggregate);

        Aggregate<Teacher> teacherAggregateRead = fileIO.fetchData("teacher");
        assertEquals(teacherAggregateRead.findByName("Simon").toString(),
                    "Simon|2020|5|14|[training1]|[training1, training2]|[python, java]\n"
                );
        assertEquals(teacherAggregateRead.findByName("Max").toString(),
                "Max|2020|5|14|[java]|[training3]|[business]\n"
        );

        Aggregate<Lab> labAggregateReadTest = fileIO.fetchData("lab");
        assertEquals(labAggregateReadTest.findByName("python101").toString(),"python101|2|[training101, training102]|[Simon,Max]\n");
        assertEquals(labAggregateReadTest.findByName("java202").toString(),"java202|2|[training302]|[Max]\n");

        Aggregate<Module> moduleAggregateReadTest = fileIO.fetchData("module");
        assertEquals(moduleAggregateReadTest.findByName("Module1").toString(),"Module1|[Simon]|[python101,java202]\n");
        assertEquals(moduleAggregateReadTest.findByName("Module2").toString(),"Module2|[Max]|[python101]\n");


    }
}
