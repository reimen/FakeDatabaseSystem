package org.reimen2422.mvc.models.database.table.usertype;

import org.reimen2422.mvc.models.database.Database;
import org.reimen2422.mvc.models.database.schemamodels.usertype.User;
import org.reimen2422.mvc.models.database.schemamodels.usertype.User$;

public class UserTable extends UserTypeTable<User> {

    public UserTable(Database database) {
        super(database, User$.getInstance());
    }

}
