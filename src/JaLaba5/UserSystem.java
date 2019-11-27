package JaLaba5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserSystem {
    private static Scanner in = new Scanner(System.in);

    public void main(ArrayList<User> users, User user){
        boolean OK = true;
        int n;
        while(OK){
            System.out.println("1.Оставить заявку\n2.Изменить личную информацию\n3.посмотреть списки участников и свое место в нем\n4.Выйти из профиля");
            n = in.nextInt();
            switch (n){
                case 1:
                    form(user);
                    break;
                case 2:
                    change(user);
                    break;
                case 3:
                    users.sort(new Comparator<User>() {////////////фикс
                        @Override
                        public int compare(User o1, User o2) {
                            if(o1.getPoint()<o2.getPoint())
                                return 1;
                            else if(o1.getPoint()>o2.getPoint())
                                return -1;
                            else
                                return 0;
                        }
                    });
                    for (User i: users){
                        if(i.getLogin() == user.getLogin()){
                            System.out.println("* Имя:" + i.getLogin() + " Баллы:"+ i.getPoint());
                        }
                        else
                            System.out.println("Имя:" + i.getLogin() + " Баллы:"+ i.getPoint());
                    }
                    break;
                case 4:
                    OK = false;
                    break;
            }
        }
    }
    void form(User user){
        int n;
        if(user.cheak() == false) {
            try {
                System.out.print("Введите колличество баллов, которое вам поставило жури:");
                n = in.nextInt();
                user.setPoint(n);
                System.out.println("Заявка оставлена. Желаем удачи ");
                user.setCheak(true);
            } catch (InputMismatchException e) {
                System.out.println("Кажется баллы вводятся числом, а не иными символами");
                form(user);
            }
        }
        else
            System.out.println("Боюсь вы уже оставляли заявку");
    }
    void change(User user){
        boolean OK = true;
        int n;
        String k;
        while (OK){
            System.out.println("Ваши текущие данные: Имя - "+ user.getName()+ " Логин - " +user.getLogin()+ " Пароль - "+ user.getPassword());
            System.out.println("1.Изменить имя\n2.Изменить логин\n3.Изменить пароль\n4.Закончить изменения");
            n = in.nextInt();
            switch (n){
                case 1:
                    System.out.println("Введите новое имя");
                    k = in.next();
                    user.setName(k);
                    break;
                case 2:
                    System.out.println("Введите новый логин");
                    k = in.next();
                    user.setLogin(k);
                    break;
                case 3:
                    System.out.println("Введите новый пароль");
                    k = in.next();
                    user.setPassword(k);
                    break;
                case 4:
                    OK = false;
                    break;
            }
        }
    }


}

