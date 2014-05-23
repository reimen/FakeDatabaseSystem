package org.reimen2422.mvc.models.modelclass;

public class User implements TableObjectInterface {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toData() {
        return id + " " + name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User(id=" + id + ", name=" + name + ")";
    }

    @Override
    public boolean equals(Object user) {
        return user instanceof User && id == ((User) user).getId();
    }

//    public static User serialize(String user_str) {
//        Pattern pattern = Pattern.compile("^[0-9]+ [0-9a-zA-Z]+$");
//        Matcher m = pattern.matcher(user_str);
//        if(!m.find()) {
////            throw new IllegalArgumentException("Illegal argument.");
//            return null;
//        }
//
//        String[] user_status = user_str.split(" ");
//        int user_id = Integer.parseInt(user_status[0]);
//        String user_name = user_status[1];
//
//        return new User(user_id, user_name);
//    }

    public static User serialize(String data) {
        try {
            String[] dataArray = data.split(" ");
            if(dataArray.length == 2) {
                int id = new Integer(dataArray[0]);
                String name = dataArray[1];
                return new User(id, name);
            }
            else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
