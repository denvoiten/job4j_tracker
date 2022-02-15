package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает функционал банка.
 * @version 1.0
 */

public class BankService {
    /**
     * Хранение осуществаляется в коллекции типа Map
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя, если его нет в базе
     * @param user - Клиент {@link User}
     */

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Привязываем счет клиенту
     * Если клиент есть в базе, ему присваивается счет.
     * @param passport - номер паспорта клиента
     * @param account - номер счета клиента
     */
    public void addAccount(String passport, Account account) {
        User accExist = findByPassport(passport);
        if (accExist != null) {
            List<Account> newAcc = users.get(accExist);
            if (!newAcc.contains(account)) {
                newAcc.add(account);
            }
        }
    }

    /**
     * Поиск клиента по номеру паспорта
     * @param passport - номер паспорта
     * @return - если клиент есть в базе возвращает объект {@link User}
     */
    public User findByPassport(String passport) {
        for (User element : users.keySet()) {
            if (passport.equals(element.getPassport())) {
                return element;
            }
        }
        return null;
    }

    /**
     * Метод для поиска пользователя в системе по счетам
     * @param passport - номер паспорта клиента
     * @param requisite - номер счета клиента
     * @return - если клиент есть в базе вовзращает объект {@link Account}
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> account = users.get(user);
            for (Account element : account) {
                if (requisite.equals(element.getRequisite())) {
                    return element;
                }
            }
        }
        return null;
    }

    /**
     * Метод переводит деньги с одного счета на другой
     * 1. Опеределяет есть ли такой пользователь в базе
     * 2. Проверяет достаточно ли денег на счете для проведения операции
     * 3. Производит перевод средств
     *
     * @param srcPassport - номер паспорта отправителя
     * @param srcRequisite - номер счета отправителя
     * @param destPassport - номер паспорта получателя
     * @param destRequisite - номер счета получателя
     * @param amount - сумма перевода
     * @return - возвращает true, если перевод произведен успешно,
     * false, если перевод не был совершен по какой-либо причине
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accountSrc = findByRequisite(srcPassport, srcRequisite);
        Account accountDest = findByRequisite(destPassport, destRequisite);
        if ((accountSrc != null) && (accountDest != null) && (accountSrc.getBalance() >= amount)) {
            accountSrc.setBalance(accountSrc.getBalance() - amount);
            accountDest.setBalance(accountDest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}