package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает функционал банка.
 *
 * @version 1.0
 */

public class BankService {
    /**
     * Хранение осуществаляется в коллекции типа Map
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя, если его нет в базе
     *
     * @param user - Клиент {@link User}
     */

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Привязываем счет клиенту
     * Если клиент есть в базе, ему присваивается счет.
     *
     * @param passport - номер паспорта клиента
     * @param account  - номер счета клиента
     */
    public void addAccount(String passport, Account account) {
        Optional<User> accExist = findByPassport(passport);
        if (accExist.isPresent()) {
            List<Account> newAcc = users.get(accExist.get());
            if (!newAcc.contains(account)) {
                newAcc.add(account);
            }
        }
    }

    /**
     * Поиск клиента по номеру паспорта
     *
     * @param passport - номер паспорта
     * @return - если клиент есть в базе возвращает объект {@link User}
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(User -> User.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод для поиска пользователя в системе по счетам
     *
     * @param passport  - номер паспорта клиента
     * @param requisite - номер счета клиента
     * @return - если клиент есть в базе вовзращает объект {@link Account}
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(User -> User.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
    }

    /**
     * Метод переводит деньги с одного счета на другой
     * 1. Опеределяет есть ли такой пользователь в базе
     * 2. Проверяет достаточно ли денег на счете для проведения операции
     * 3. Производит перевод средств
     *
     * @param srcPassport   - номер паспорта отправителя
     * @param srcRequisite  - номер счета отправителя
     * @param destPassport  - номер паспорта получателя
     * @param destRequisite - номер счета получателя
     * @param amount        - сумма перевода
     * @return - возвращает true, если перевод произведен успешно,
     * false, если перевод не был совершен по какой-либо причине
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> accountSrc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> accountDest = findByRequisite(destPassport, destRequisite);
        if ((accountSrc.isPresent()) && (accountDest.isPresent()) && (accountSrc.get().getBalance() >= amount)) {
            accountSrc.get().setBalance(accountSrc.get().getBalance() - amount);
            accountDest.get().setBalance(accountDest.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}