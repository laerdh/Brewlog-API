package com.ledahl.brewlog.repository

class UserProperties {

    companion object {
        const val TABLE_NAME: String = "users"
        const val PRIMARY_KEY: String = "id"
        const val FIRST_NAME: String = "first_name"
        const val LAST_NAME: String = "last_name"
        const val INITIALS: String = "initials"
        const val EMAIL: String = "email"

        fun alias(column: String) : String = TABLE_NAME + "." + column

        const val SELECT_ALL_USERS = "SELECT " +
                PRIMARY_KEY + ", " +
                FIRST_NAME + ", " +
                LAST_NAME + ", " +
                INITIALS + ", " +
                EMAIL + " " +
                "FROM " + TABLE_NAME + ";"

        const val SELECT_USER_BY_EMAIL = "SELECT " +
                PRIMARY_KEY + ", " +
                FIRST_NAME + ", " +
                LAST_NAME + ", " +
                INITIALS + ", " +
                EMAIL + " " +
                "FROM " + TABLE_NAME + " " +
                "WHERE " + EMAIL + "=:" + EMAIL
    }
}