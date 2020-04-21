package com.javarush.task.task20.task2002;

import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile, false);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

            javaRush.users.add(new User("Alex", "Sims", sdf.parse("24.09.1024"), true, User.Country.OTHER));
            javaRush.users.add(new User("Olex", "Sims", sdf.parse("24.09.1024"), true, User.Country.RUSSIA));
            javaRush.users.add(new User("Gex", "Sims", sdf.parse("24.09.1024"), false, User.Country.UKRAINE));
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            if (users != null) {
                PrintWriter pw = new PrintWriter(outputStream);
                for (User user : users) {
                    pw.println("User");
                    pw.println(user.getFirstName() != null ? user.getFirstName() : "null");
                    pw.println(user.getLastName() != null ? user.getLastName() : "null");
                    pw.println(user.getBirthDate() != null ? user.getBirthDate().getTime() : "null");
                    pw.println(user.isMale() ? "true" : "false");
                    pw.println(user.getCountry().getDisplayName() != null ? user.getCountry().getDisplayName() : "null");
                }
                pw.flush();
            }
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()) {
                if (reader.readLine().equals("User")) {
                    String firstName = reader.readLine();
                    String lastName = reader.readLine();
                    String birthDate = reader.readLine();
                    String isMale = reader.readLine();
                    String country = reader.readLine();
                    User.Country cont;
                    if (country.equals("Ukraine")) {
                        cont = User.Country.UKRAINE;
                    } else if (country.equals("Russia")) {
                        cont = User.Country.RUSSIA;
                    } else {
                        cont = User.Country.OTHER;
                    }

                    users.add(new User(!firstName.equals("null") ? firstName : null,
                            !lastName.equals("null") ? lastName : null,
                            !birthDate.equals("null") ? new Date(Long.parseLong(birthDate)) : null,
                            Boolean.parseBoolean(isMale),
                            cont));
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
