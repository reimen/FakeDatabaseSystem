package org.reimen2422.mvc.models.database.table.usertype;

import org.reimen2422.mvc.models.database.Database;
import org.reimen2422.mvc.models.database.schemamodels.usertype.User;
import org.reimen2422.mvc.models.database.schemamodels.usertype.UserChild;
import org.reimen2422.mvc.models.database.schemamodels.usertype.UserChild$;

import java.util.ArrayList;
import java.util.List;

public class UserChildTable extends UserTypeTable<UserChild> {

    public UserChildTable(Database database) {
        super(database, UserChild$.getInstance());
    }

}
