package com.javarush.task.task25.task2503;

import org.apache.commons.lang3.ArrayUtils;

import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    Column(String columnName) {
        this.columnName = columnName;
    }

    // Column.configureColumns(Column.Amount, Column.AccountNumber, Column.BankName);
    // [-1, 2, 1, 0]

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();

        // меняем тупую логику массива на более оптимальную... индекс массива - отвечает за последотельность,
        // а значение - какой именно объект инума
        int[] correctArray = new int[realOrder.length];
        for (int i = 0; i < correctArray.length; i++) {
            correctArray[i]= -1;
            for (int j = 0; j < realOrder.length; j++) {
                if (realOrder[j] == i) {
                    correctArray[i] = j;
                }
            }
        }

        // все, готово, просто добавить надо
        for (int i = 0; i < correctArray.length; i++) {
            if (correctArray[i] == -1) continue;;
            Column column = getColumnById(correctArray[i]);
            if (column.isShown()) {
                result.add(column);
            }
        }
        return result;
    }

    private static Column getColumnById(int i) {
        for (Column column : values()) {
            if (column.ordinal() == i) {
                return column;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getColumnName() {
        return columnName;
    }

    @Override
    public boolean isShown() {
        return realOrder[this.ordinal()] != -1;
    }

    @Override
    public void hide() {
        realOrder[this.ordinal()] = -1;
    }
}
