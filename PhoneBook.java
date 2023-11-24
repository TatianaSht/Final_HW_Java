package HW_PhoneBook;

import java.util.ArrayList;

/*
Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена
с разными телефонами, их необходимо считать, как одного человека с разными телефонами.
Вывод должен быть отсортирован по убыванию числа телефонов.
*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class PhoneBook {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
    
        phoneBook.addPhone("Брекоткин", "+11111111111");
        phoneBook.addPhone("Мясников", "+44444444444");
        phoneBook.addPhone("Ярица", "+1111222233");
        phoneBook.addPhone("Исаев", "+75555555555");
        phoneBook.addPhone("Исаев", "+75555555556");
        phoneBook.addPhone("Брекоткин", "+22222222222");
        phoneBook.addPhone("Брекоткин", "+33333333333");
        phoneBook.addPhone("Рожков", "+77777777777");
    
    
        System.out.println(phoneBook.getPhoneNum("+11111111111"));
        System.out.println(phoneBook.getByName("Исаев"));
        System.out.println(phoneBook.getAll());   

    }


    
    private final Map<String, List<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    // Добавление новой записи
    public void addPhone(String name, String phoneNumber) {
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
    }


    // Поиск записи по номеру телефона
    String getPhoneNum(String phoneNum) {
        System.out.println("Поисковый запрос - " + phoneNum);
        System.out.println("найдены следующие записи:");
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            List<String> phoneNumbers = entry.getValue();
            if (phoneNumbers.contains(phoneNum)) {
                stringBuilder.append(entry.getKey());
                stringBuilder.append(" : ");
                stringBuilder.append(entry.getValue());
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }


    // Поиск записи по фамилии
    String getByName(String name) {
        System.out.println("Поисковый запроc - "+ name);
        System.out.println("найдены следующие записи:");
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            String phoneNumbers = entry.getKey();
            if (phoneNumbers.contains(name)) {
                stringBuilder.append(entry.getKey());
                stringBuilder.append(" : ");
                stringBuilder.append(entry.getValue());
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }


    // Вывод всех записей с сортировкой по убыванию числа телефонов
    String getAll() {
        System.out.println("Список контактов телефонного справочника:");
        StringBuilder stringBuilder = new StringBuilder();
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        entries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));
        for (Map.Entry<String, List<String>> entry : entries) {
            List<String> phoneNumbers = entry.getValue();
            stringBuilder.append(entry.getKey());
            stringBuilder.append(" : ");
            stringBuilder.append(phoneNumbers);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
