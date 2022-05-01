package lesson2_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи.
С помощью метода get() искать номер телефона по фамилии. Следует учесть,
что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны.
 */
public class PhoneBook {

    Map<String, String> map = new HashMap<>();

    public Map<String, String> getMap() {
        return map;
    }

    public void add(String phone, String firstname) {
        this.map.put(phone, firstname);
    }

    public ArrayList<String> get(String firstname) {
        List<String> listPhone = new ArrayList<String>();
        for (Map.Entry<String, String> pb : map.entrySet()) {
            if (pb.getValue().equals(firstname)) {

                listPhone.add(pb.getKey());
            }
        }
        return (ArrayList<String>) listPhone;

    }

}
