package Collections_Tasks.stringFilter;

import java.util.*;

/**
 * Created by Seva_ on 03.05.2017.
 */
public class StringFilterImpl implements StringFilter{
    public static Set<String> stringHashSet = new HashSet<>();

    @Override
    public void add(String s) {
        if (s != null) {
            stringHashSet.add(s.toLowerCase());
        } else {
            stringHashSet.add(s);
        }
    }

    @Override
    public boolean remove(String s) {
        if (s != null) {
            if (stringHashSet.remove(s.toLowerCase())){
                return true;
            } else return false;
        } else {
            if (stringHashSet.remove(s)){
                return true;
            } else return false;
        }
    }

    @Override
    public void removeAll() {
        stringHashSet.removeAll(stringHashSet);
    }

    @Override
    public Collection<String> getCollection() {
        return stringHashSet;
    }

    @Override
    public Iterator<String> getStringsContaining(String chars) {
        Set<String> startSet = new HashSet<String>();

        if (chars != null) {
            chars = chars.toLowerCase();
        }

        for (String str : stringHashSet) {
            if ((chars != null) && (!chars.isEmpty())){
                if ((str != null) && (str.contains(chars))) {
                    startSet.add(str);
                }
            } else {
                startSet.add(str);
            }
        }

        Iterator<String> it = startSet.iterator();
        return it;
    }

    @Override
    public Iterator<String> getStringsStartingWith(String begin) {
        Set<String> startSet = new HashSet<String>();

        if (begin != null) {
            begin = begin.toLowerCase();
        }

        for (String str : stringHashSet) {
            if ((begin != null) && (!begin.isEmpty())){
                if ((str != null) && (str.startsWith(begin))) {
                    startSet.add(str);
                }
            } else {
                startSet.add(str);
            }
        }

        Iterator<String> it = startSet.iterator();
        return it;
    }

    @Override
    public Iterator<String> getStringsByNumberFormat(String format) {
        Set<String> startSet = new HashSet<String>();

        if (format != null) {
            format = format.toLowerCase();
        }


        if ((format != null) && (!format.isEmpty())) {
            for (String str : stringHashSet) {
                if ((str == null) || (format.length() != str.length())) {
                    continue;
                }

                int i = 0;
                boolean flag = true;
                while (i < format.length()) {
                    if (format.charAt(i) != '#') {
                        if (format.charAt(i) != str.charAt(i)) {
                            flag = false;
                            break;
                        }
                    } else {
                        if ((str.charAt(i) != '0') && (str.charAt(i) != '1') && (str.charAt(i) != '2') && (str.charAt(i) != '3') &&
                                (str.charAt(i) != '4') && (str.charAt(i) != '5') && (str.charAt(i) != '6') && (str.charAt(i) != '7') &&
                                (str.charAt(i) != '8') && (str.charAt(i) != '9')) {
                            flag = false;
                            break;
                        }
                    }
                    i++;
                }

                if (flag) {
                    startSet.add(str);
                }
            }

        } else {
            for (String str : stringHashSet) {
                startSet.add(str);
            }
        }

        Iterator<String> it = startSet.iterator();
        return it;
    }

    /**
     * Ищет и возвращает строки, удовлетворяющие заданному шаблону поиска, содержащему символы *
     * в качестве wildcards (на месте * в строке может быть ноль или больше любых символов).<br/>
     * <a href="http://en.wikipedia.org/wiki/Wildcard_character#File_and_directory_patterns">Про * wildcard</a>.<br/>
     * Примеры шаблонов, которым удовлетворяет строка "distribute": "distr*", "*str*", "di*bute*".<br/>
     * Упрощение: достаточно поддерживать всего два символа * в шаблоне.<br/>
     * Примечание: в данной постановке задачи НЕ предполагается использование регулярных выражений
     * и какого-либо высокоуровневого API (эти темы изучаются позже), цель - применить методы String.<br/>
     * Если <code>pattern</code> - пустая строка или <code>null</code>,
     * то результат содержит все строки данного набора.<br/>
     *
     * @param pattern шаблон поиска (все буквы в нем - в нижнем регистре)
     * @return строки, удовлетворяющие заданному шаблону поиска
     */
    @Override
    public Iterator<String> getStringsByPattern(String pattern) {
        Set<String> startSet = new HashSet<String>();
        ArrayList<String> arLis = new ArrayList<>();

        if ((pattern != null) && (!pattern.isEmpty())) {
            int i = 0;
            int a = 0;
            while (i < pattern.length()) {
                if (pattern.charAt(i) == '*') {
                    arLis.add(String.copyValueOf(pattern.toCharArray(), a, i - a));
                    arLis.add("*");
                    a = i + 1;
                }
                i++;
            }
            if (pattern.length() - a > 0) {
                arLis.add(String.copyValueOf(pattern.toCharArray(), a, pattern.length() - a));
            }

            for (String str : stringHashSet) {

                if (str == null) {
                    continue;
                }

                Iterator<String> it = arLis.iterator();
                boolean lastIsStar = false;
                boolean flag = true;
                int number = 0;
                String copyStr = String.copyValueOf(str.toCharArray());

                while (it.hasNext()) {
                    String itStr = it.next();
                    number++;

                    if (itStr.equals("*")) {
                        lastIsStar = true;
                        continue;
                    } else {
                        lastIsStar = false;
                        int k = copyStr.indexOf(itStr);
                        if (k < 0) {
                            flag = false;
                            break;
                        } else {
                            if ((number == 1) && (k != 0)) {
                                flag = false;
                                break;
                            }
                            copyStr = String.copyValueOf(copyStr.toCharArray(), k + itStr.length(), copyStr.length() - k - itStr.length());
                        }
                    }
                }
                if (flag && (lastIsStar || copyStr.isEmpty())) {
                    startSet.add(str);
                }
            }
        } else {
            for (String str : stringHashSet) {
                startSet.add(str);
            }
        }

        Iterator<String> it = startSet.iterator();
        return it;
    }


//    public static void main(String... args) {
//        StringFilter a = new StringFilterImpl();
//        a.add("protection");
//        a.add("programs");
//        a.add("problems");
//        a.add("program");
//        a.add("proprietary");
//        a.add("protect");
//        System.out.println(a.getCollection());
//
//
//        Iterator<String> it = a.getStringsByPattern("pro*");
//
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
//
//        //distribute, restrictions, distributed, redistributors, restricted, distribution
//        a.removeAll();
//        a.add("distribute");
//        a.add("restrictions");
//        a.add("distributed");
//        a.add("redistributors");
//        a.add("restricted");
//        a.add("distribution");
//        System.out.println(a.getCollection());
//        it = a.getStringsByPattern("*str*");
//
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
//
//        a.removeAll();
//        a.add("1kek");
//        a.add("k1ek");
//        a.add("ke1k");
//        a.add("kek1");
//        a.add("k1e1k");
//        a.add("1kek1");
//        a.add("kek");
//        System.out.println(a.getCollection());
//        it = a.getStringsByPattern("k*e*k");
//
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
//
//    }
}
