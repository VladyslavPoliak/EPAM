package com.epam.poliak.part2;

import java.util.*;

public class HashTest {

    public static void main(String[] args) {

        HashMap<HashByStringLength, Transport> hashMap1 = new HashMap<>();
        HashMap<HashBySumLetters, Transport> hashMap2 = new HashMap<>();
        LinkedHashMap<HashByStringLength, Transport> linkedHashMap1 = new LinkedHashMap<>();
        LinkedHashMap<HashBySumLetters, Transport> linkedHashMap2 = new LinkedHashMap<>();
        hashMap1.put(new HashByStringLength("absd"), new Transport(1200, "Nissan"));
        hashMap1.put(new HashByStringLength("zxcv"), new Transport(4000, "Nissan"));
        hashMap1.put(new HashByStringLength("fsfs"), new Transport(2500, "Nissan"));
        hashMap1.put(new HashByStringLength("hasd"), new Transport(1000, "Nissan"));
        hashMap1.put(new HashByStringLength("rtrt"), new Transport(2400, "Nissan"));

        hashMap2.put(new HashBySumLetters("absd"), new Transport(1200, "Nissan"));
        hashMap2.put(new HashBySumLetters("zxcv"), new Transport(400, "Nissan"));
        hashMap2.put(new HashBySumLetters("zsfs"), new Transport(2500, "Nissan"));
        hashMap2.put(new HashBySumLetters("hasd"), new Transport(1000, "Nissan"));
        hashMap2.put(new HashBySumLetters("rtrt"), new Transport(2400, "Nissan"));


        linkedHashMap1.put(new HashByStringLength("absd"), new Transport(1200, "Nissan"));
        linkedHashMap1.put(new HashByStringLength("zxcv"), new Transport(400, "Nissan"));
        linkedHashMap1.put(new HashByStringLength("fsfs"), new Transport(2500, "Nissan"));
        linkedHashMap1.put(new HashByStringLength("hasd"), new Transport(1000, "Nissan"));
        linkedHashMap1.put(new HashByStringLength("rtrt"), new Transport(2400, "Nissan"));

        linkedHashMap2.put(new HashBySumLetters("absd"), new Transport(1200, "Nissan"));
        linkedHashMap2.put(new HashBySumLetters("zxcv"), new Transport(400, "Nissan"));
        linkedHashMap2.put(new HashBySumLetters("zsfs"), new Transport(2500, "Nissan"));
        linkedHashMap2.put(new HashBySumLetters("hasd"), new Transport(1000, "Nissan"));
        linkedHashMap2.put(new HashBySumLetters("rtrt"), new Transport(2400, "Nissan"));

        // sout hashMap1
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~HashMap1");
        Iterator iterator1 = hashMap1.entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator1.next();
            System.out.println(pair.getKey() + "   " + pair.getKey().hashCode() + " = " + pair.getValue());
        }
        // sout hashMap2
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~HashMap2");
        Iterator iterator2 = hashMap2.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator2.next();
            System.out.println(pair.getKey() + "   " + pair.getKey().hashCode() + " = " + pair.getValue());
        }

        // sout LinkedHashMap1
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~LinkedHashMap1");
        Iterator iterator3 = linkedHashMap1.entrySet().iterator();
        while (iterator3.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator3.next();
            System.out.println(pair.getKey() + "   " + pair.getKey().hashCode() + " = " + pair.getValue());
        }
        // sout LinkedHashMap2
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~LinkedHashMap2");
        Iterator iterator4 = linkedHashMap2.entrySet().iterator();
        while (iterator4.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator4.next();
            System.out.println(pair.getKey() + "   " + pair.getKey().hashCode() + " = " + pair.getValue());
        }
    }
}


