package HomeWork3;

import java.util.*;

public class PhoneBook {

    public Map<String, ArrayList<Long>> map;

    public PhoneBook(Map<String, ArrayList<Long>> map) {
        this.map = map;
    }

    public void createMap(){
        map.put("Иванов", new ArrayList<Long>(Arrays.asList(+7111111l, +75555555l)));
        map.put("Андреев", new ArrayList<Long>(Arrays.asList(+72222222l)));
        map.put("Молчанов", new ArrayList<Long>(Arrays.asList(+73333333l)));
        map.put("Суворова", new ArrayList<Long>(Arrays.asList(+744444444l)));
        map.put("Букина", new ArrayList<Long>(Arrays.asList(+76665555l)));
    }

    public Map<String, ArrayList<Long>> add(String surname, ArrayList<Long> number){
        if(map.get(surname) == null){
            map.put(surname, number);
        } else {
            number.addAll(map.get(surname));
            map.put(surname, number);
        }
        return this.map;
    }

    public void get(String surname){
        System.out.println(map.get(surname));
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "map=" + map +
                '}';
    }

    public void info(){
        System.out.println(this);
    }


}

