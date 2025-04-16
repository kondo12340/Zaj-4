
import java.io.IOException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Service s = new Service();

    while (true) {
      System.out.println("\n1. Dodaj nowego studenta");
      System.out.println("2. Wyświetl wszystkich studentów");
      System.out.println("0. Wyjście");
      System.out.print("Wybierz opcję: ");

      int wybor = sc.nextInt();
      sc.nextLine();

      if (wybor == 0)
        break;

      try {
        switch (wybor) {
          case 1:
            System.out.print("Podaj imię nowego studenta: ");
            String imie = sc.nextLine();
            System.out.print("Podaj wiek nowego studenta: ");
            int wiek = sc.nextInt();
            sc.nextLine();
            System.out.print("Podaj nazwisko nowego studenta: ");
            String nazwisko = sc.nextLine();
           
            Student nowystudent = new Student(imie, wiek);
            s.addStudent(nowystudent);
            break;

          case 2:
            var students = s.getStudents();
            System.out.println("\nLista studentów:");
            for (Student current : students) {
              System.out.println(current.ToString());
            }
            break;
        }
      } catch (IOException e) {
 
        e.printStackTrace();
      }
    }
  }
}
