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

        System.out.println(startSet);



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
        return null;
    }


//    public static void main(String... args) {
//        StringFilter a = new StringFilterImpl();
//        a.add("k32");
//        a.add(null);
//        a.add("kekbt");
//        a.add("12");
//        a.add("1");
//        a.add("53");
//
//        System.out.println(a.getCollection());
//        Iterator<String> it = a.getStringsByNumberFormat("k#2");
//
////        while (it.hasNext()) {
////            System.out.println(it.next());
////        }
//    }
}
