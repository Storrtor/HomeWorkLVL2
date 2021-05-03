    package HomeWork3;

    import java.util.*;
    import java.util.function.Function;

    public class App {
        public static void main(String[] args) {

        /**
         * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
         * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
         * Посчитать сколько раз встречается каждое слово.
         */

        String[] str = new String[]{"Шелти", "Папийон", "Малинуа", "Немецкая овчарка", "Шелти", "Немецкая овчарка",
                "Колли", "Шипперке", "Шелти", "Такса", "Якутская лайка", "Хаски", "Шелти", "Хаски", "Белая швейцарская овчарка"};
        makeUniq(str);

        /**
         * 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
         * В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по фамилии.
         * Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
         * @param str
         */

        PhoneBook phoneBook = new PhoneBook(new HashMap<>());

        phoneBook.createMap();

        phoneBook.add("Ермолаев", new ArrayList<>(Arrays.asList(+799999999l)));
        phoneBook.add("Смирнов", new ArrayList<>(Arrays.asList(+788888888l)));
        phoneBook.add("Миронов", new ArrayList<>(Arrays.asList(+777777777l)));
        phoneBook.get("Миронов");
        phoneBook.info();
        phoneBook.get("Иванов");
        phoneBook.add("Иванов", new ArrayList<>(Arrays.asList(+716545717l)));
        phoneBook.get("Иванов");


       }

        public static void makeUniq(String str[]){
            Set<String> uniqStr = new LinkedHashSet<>();
            uniqStr.addAll(Arrays.asList(str));
            System.out.println(uniqStr);

            Map<String, Integer> map = new HashMap<>();
            int count = 1;
            for (int i = 0; i < str.length; i++) {
                for (int j = 0; j < str.length; j++) {
                    if(i != j){
                        if(str[i] == str[j]){
                            count++;
                        }
                    }
                }
                map.put(str[i],count);
                count = 1;
            }
            System.out.println(map.toString());
        }


    }
