package com.allendowney.cote.sortAndSearch;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {

    public static void main(String[] args) {
        UniqueEmailAddress a = new UniqueEmailAddress();
        String[] emails = {
                "test.email+james@coding.com",
                "test.e.mail+toto.jane@cod.ing.com",
                "testemail+tom@cod.ing.com" };
//        System.out.println(a.solve_1(emails));
        System.out.println(a.solve_split(emails));
    }

    //1.Basic
    public int solve_1(String[] emails) {
        // 1 ds
        //"test.email+james@coding.com"
        Set<String> set = new HashSet<>();// 중복x

        // 2 for while charAt()
        for (String email : emails) {
            String localName = makeLocalName(email);
            String dName = makeDName(email);

            set.add(localName + "@" + dName);
        }
        return set.size();
    }

    private String makeLocalName(String email) {
        StringBuilder sb = new StringBuilder();

        //"test.email+james@coding.com"
        for (int i = 0; i < email.length(); i++) {

            if (email.charAt(i) == '.') {
                continue;
            }
            if (email.charAt(i) == '+' || email.charAt(i) == '@') {
                break;
            }
            sb.append(email.charAt(i));
        }
        return sb.toString();
    }

    private String makeDName(String email) {
        return email.substring(email.indexOf("@") + 1);
    }

    // 3. split
    public int solve_split(String[] emails) {
        //"test.email+james@coding.com"

        //1 data structure
        Set<String> set = new HashSet<>();

        //2 for, while
        for (String email : emails) {
            String[] parts = email.split("@");
            String[] localName = parts[0].split("\\+");
            set.add(localName[0].replace(".", "") + "@" + parts[1]);
        }
        return set.size();
    }

}
