import java.io.*;
import java.util.Scanner;

public class Notesapp {
    private static final String FILE_NAME = "notes.txt";

    public static void writeNote(String note) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(note + "\n");
            System.out.println("Note saved.");
        } catch (IOException e) {
            System.out.println("Error saving note: " + e.getMessage());
        }
    }

    public static void readNotes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\nSaved Notes:");
            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No notes found yet.");
        } catch (IOException e) {
            System.out.println("Error reading notes: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Add Note\n2. View Notes\n3. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear input buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter note: ");
                    String note = sc.nextLine();
                    writeNote(note);
                    break;
                case 2:
                    readNotes();
                    break;
                case 3:
                    System.out.println("Exiting Notes App.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 3);
        sc.close();
    }
}
