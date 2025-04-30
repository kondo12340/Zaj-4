import java.util.Collection;
import java.util.ArrayList;
import java.io.*;

public class Service {

    public void addStudent(Student student) throws IOException {
        var f = new FileWriter("db.txt", true);
        var b = new BufferedWriter(f);
        b.append(student.ToString());
        b.newLine();
        b.close();
    }

    public Collection<Student> getStudents() throws IOException {
        var ret = new ArrayList<Student>();
        var f = new FileReader("db.txt");
        var reader = new BufferedReader(f);
        String line;
        while ((line = reader.readLine()) != null) {
            ret.add(Student.Parse(line));
        }
        reader.close();
        return ret;
    }

    public Student findStudentByName(String nameFragment) {
        try {
            var reader = new BufferedReader(new FileReader("db.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                Student s = Student.Parse(line);
                if (s.getImie().toLowerCase().contains(nameFragment.toLowerCase())) {
                    reader.close();
                    return s;
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean removeStudentByNameSurname(String imie, String nazwisko) {
        try {
            var students = getStudents();
            var filtered = new ArrayList<Student>();

            boolean found = false;

            for (Student s : students) {
                if (s.getImie().equalsIgnoreCase(imie) && s.getNazwisko().equalsIgnoreCase(nazwisko)) {
                    found = true;
                    continue; 
                }
                filtered.add(s);
            }

           
            var writer = new BufferedWriter(new FileWriter("db.txt", false));
            for (Student s : filtered) {
                writer.write(s.ToString());
                writer.newLine();
            }
            writer.close();

            return found;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
