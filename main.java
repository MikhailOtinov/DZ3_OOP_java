//Создаем класс поток//
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Поток implements Iterable<УчебнаяГруппа> {
    private List<УчебнаяГруппа> учебныеГруппы = new ArrayList<>();

    public void добавитьГруппу(УчебнаяГруппа группа) {
        учебныеГруппы.add(группа);
    }

    @Override
    public Iterator<УчебнаяГруппа> iterator() {
        return учебныеГруппы.iterator();
    }
}

//Создаем класс StreamComparator для сравнения потоков //

import java.util.Comparator;

public class StreamComparator implements Comparator<Поток> {
    @Override
    public int compare(Поток поток1, Поток поток2) {
        return Integer.compare(поток1.учебныеГруппы.size(), поток2.учебныеГруппы.size());
    }
}


//Создаем класс ПотокСервис, для добавления метода для сортировки списка потоков с использованием StreamComparator://
import java.util.Collections;
import java.util.List;

public class ПотокСервис {
    public void сортироватьПотоки(List<Поток> потоки) {
        Collections.sort(потоки, new StreamComparator());
    }
}


//Модифицируем класс контрллер, чтобы добавить созданный сервис и метод для сортировки списка потоков://

import java.util.List;

public class Контроллер {
    private ПотокСервис потокСервис;

    public Контроллер(ПотокСервис потокСервис) {
        this.потокСервис = потокСервис;
    }

    public void сортироватьПотоки(List<Поток> потоки) {
        потокСервис.сортироватьПотоки(потоки);
    }
}
