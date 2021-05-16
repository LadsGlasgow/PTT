import com.lads.models.*;
import com.lads.models.Module;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class FileIOTest {

    private String path = "C:\\Users\\flyingjack\\OneDrive\\UofGlasgow Files\\COMPSCI5059 Software Engineering M\\PTT\\src\\main\\java\\com\\lads\\data\\TeacherData.txt";
    private String path2 = "C:\\Users\\flyingjack\\OneDrive\\UofGlasgow Files\\COMPSCI5059 Software Engineering M\\PTT\\src\\main\\java\\com\\lads\\data\\ModuleData.txt";

    @Test
    public void teacherTest(){
        FileIO<Teacher> teacherFileIO = new FileIO<>(this.path);
        List<Teacher> teacherList = new LoT();
        Teacher teacherTest1 = new Teacher("Max",new Date(2020,5,14));
        teacherTest1.addTrainingTaken("python","java");
        teacherTest1.addTrainingDue("management");

        teacherList.add(teacherTest1);

        Teacher teacherTest2 = new Teacher("Simon",new Date(2020,5,14));
        teacherTest2.addTrainingTaken("business");
        teacherTest2.addTrainingDue("management","French");

        teacherList.add(teacherTest2);

        teacherFileIO.storeData(teacherList);

        try {
            FileReader fr = new FileReader(this.path);
            Scanner s = new Scanner(fr);
            String line1 = s.nextLine();
            assertEquals("Max|2020|5|14|[management]|[python, java]",line1);
            String line2 = s.nextLine();
            assertEquals("Simon|2020|5|14|[management, French]|[business]",line2);


        }catch (IOException e){
            e.printStackTrace();
        }


        List<Teacher> readTeacherList = teacherFileIO.fetchData(new Teacher(),new LoT());
        assertEquals(readTeacherList.findByName("Simon").toString(),teacherTest2.toString());
        assertEquals(readTeacherList.findByName("Max").toString(),teacherTest1.toString());

    }

    @Test
    public void moduleTest(){
        FileIO<Module> moduleFileIO = new FileIO<>(this.path2);
        List<Module> moduleList = new LoM();

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


        moduleFileIO.storeData(moduleList);

        try {
            FileReader fr = new FileReader(this.path2);
            Scanner s = new Scanner(fr);
            String line1 = s.nextLine();
            assertEquals("ADS|[Simon]|1|[python, java]",line1);
            String line2 = s.nextLine();
            assertEquals("DTA|[Max, Simon]|2|[java]",line2);


        }catch (IOException e){
            e.printStackTrace();
        }


        List<Module> readModuleList = moduleFileIO.fetchData(new Module(),new LoM());
        assertEquals(readModuleList.findByName("ADS").toString(),moduleTest1.toString());
        assertEquals(readModuleList.findByName("DTA").toString(),moduleTest2.toString());

    }

}
