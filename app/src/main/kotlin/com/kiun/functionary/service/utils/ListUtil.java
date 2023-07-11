package com.kiun.functionary.service.utils;

import java.util.*;

public class ListUtil {

    public static<T> T first(List<T> list){
        if(list == null || list.size() == 0){
            return null;
        }
        return list.get(0);
    }

    public static<T> void removeWith(List<T[]> list, T[] value){
        for (int i = 0; i < list.size(); i++) {
            T[] array = list.get(i);
            for (T o : array){

                boolean isBreak = false;
                for (T w : value){
                    if(w == o){
                        list.remove(i--);
                        isBreak = true;
                        break;
                    }
                }
                if(isBreak) break;
            }
        }
    }

    public static<T> List<T> toList(Enumeration<T> enumeration){

        List<T> list = new ArrayList<>();
        while (enumeration.hasMoreElements()){
            T element = enumeration.nextElement();
            list.add(element);
        }

        return list;
    }

    public static void sortString(List<String> list){
        Collections.sort(list,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1 == null || o2 == null){
                    return -1;
                }
                if(o1.length() > o2.length()){
                    return 1;
                }
                if(o1.length() < o2.length()){
                    return -1;
                }
                if(o1.compareTo(o2) > 0){
                    return 1;
                }
                if(o1.compareTo(o2) < 0){
                    return -1;
                }
                if(o1.compareTo(o2) == 0){
                    return 0;
                }
                return 0;
            }
        });
    }
}
