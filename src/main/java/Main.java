import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Service s = new Service();

        while (true) {
            System.out.println("\n1. Dodaj nowego studenta");
            System.out.println("2. Wyświetl wszystkich studentów");
            System.out.println("3. Znajdź studenta po fragmencie imienia");
            System.out.println("4. Usuń studenta po imieniu i nazwisku");
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

                        System.out.print("Podaj nazwisko nowego studenta: ");
                        String nazwisko = sc.nextLine();

                        System.out.print("Podaj wiek nowego studenta: ");
                        int wiek = sc.nextInt();

                        int rok, miesiac, dzien;

                        while (true) {
                            System.out.print("Podaj rok urodzenia (1-3000): ");
                            rok = sc.nextInt();
                            if (rok >= 1 && rok <= 3000) break;
                            System.out.println("Nieprawidłowy rok. Spróbuj ponownie.");
                        }

                        while (true) {
                            System.out.print("Podaj miesiąc urodzenia (1-12): ");
                            miesiac = sc.nextInt();
                            if (miesiac >= 1 && miesiac <= 12) break;
                            System.out.println("Nieprawidłowy miesiąc. Spróbuj ponownie.");
                        }

                        while (true) {
                            System.out.print("Podaj dzień urodzenia (1-31): ");
                            dzien = sc.nextInt();
                            if (dzien >= 1 && dzien <= 31) break;
                            System.out.println("Nieprawidłowy dzień. Spróbuj ponownie.");
                        }

                        sc.nextLine();

                        String dataUrodzenia = String.format("%04d-%02d-%02d", rok, miesiac, dzien);

                        Student nowyStudent = new Student(imie, nazwisko, wiek, dataUrodzenia);
                        s.addStudent(nowyStudent);
                        break;

                    case 2:
                        var students = s.getStudents();
                        System.out.println("\nLista studentów:");
                        for (Student current : students) {
                            System.out.println(current.ToString());
                        }
                        break;

                    case 3:
                        System.out.print("Podaj fragment imienia do wyszukania: ");
                        String szukany = sc.nextLine();
                        Student znaleziony = s.findStudentByName(szukany);
                        if (znaleziony != null) {
                            System.out.println("Znaleziono: " + znaleziony.ToString());
                        } else {
                            System.out.println("Nie znaleziono studenta z takim imieniem.");
                        }
                        break;

                    case 4:
                        System.out.print("Podaj imię studenta do usunięcia: ");
                        String delImie = sc.nextLine();

                        System.out.print("Podaj nazwisko studenta do usunięcia: ");
                        String delNazwisko = sc.nextLine();

                        boolean usunieto = s.removeStudentByNameSurname(delImie, delNazwisko);
                        if (usunieto) {
                            System.out.println("Student został usunięty.");
                        } else {
                            System.out.println("Nie znaleziono studenta o podanym imieniu i nazwisku.");
                        }
                        break;

                    default:
                        System.out.println("Nieznana opcja.");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        sc.close();
    }
}
