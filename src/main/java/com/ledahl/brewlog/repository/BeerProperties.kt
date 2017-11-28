package com.ledahl.brewlog.repository

class BeerProperties {

    companion object {
        const val TABLE_NAME: String = "beers"
        const val PRIMARY_KEY: String = "batch_number"
        const val NAME: String = "name"
        const val TYPE: String = "type"
        const val SIZE: String = "size"
        const val VOLUME_REMAINING: String = "volume_remaining"
        const val ORIGINAL_GRAVITY: String = "original_gravity"
        const val FINAL_GRAVITY: String = "final_gravity"
        const val ALCOHOL: String = "alcohol"
        const val DATE: String = "date"
        const val BREWER: String = "brewer"
        const val COMMENT: String = "comment"
        const val SELECTED: String = "selected"

        const val SELECT_ALL_BEERS: String = "SELECT " +
                "b." + BeerProperties.PRIMARY_KEY + ", " +
                "b." + BeerProperties.NAME + ", " +
                "b." + BeerProperties.TYPE + ", " +
                "b." + BeerProperties.SIZE + ", " +
                "b." + BeerProperties.VOLUME_REMAINING + ", " +
                "b." + BeerProperties.ORIGINAL_GRAVITY + ", " +
                "b." + BeerProperties.FINAL_GRAVITY + ", " +
                "b." + BeerProperties.ALCOHOL + ", " +
                "b." + BeerProperties.DATE + ", " +
                "u." + UserProperties.FIRST_NAME + ", " +
                "u." + UserProperties.LAST_NAME + ", " +
                "b." + BeerProperties.COMMENT + ", " +
                "b." + BeerProperties.SELECTED + " " +
                "FROM " + BeerProperties.TABLE_NAME + " b " +
                "LEFT JOIN users u ON b." + BeerProperties.BREWER + " = " +
                "u." + UserProperties.PRIMARY_KEY + " " +
                "ORDER BY " + BeerProperties.SELECTED + " DESC;"

        const val SELECT_ALL_AVAILABLE_BEERS: String = "SELECT " +
                "b." + BeerProperties.PRIMARY_KEY + ", " +
                "b." + BeerProperties.NAME + ", " +
                "b." + BeerProperties.TYPE + ", " +
                "b." + BeerProperties.SIZE + ", " +
                "b." + BeerProperties.VOLUME_REMAINING + ", " +
                "b." + BeerProperties.ORIGINAL_GRAVITY + ", " +
                "b." + BeerProperties.FINAL_GRAVITY + ", " +
                "b." + BeerProperties.ALCOHOL + ", " +
                "b." + BeerProperties.DATE + ", " +
                "u." + UserProperties.FIRST_NAME + ", " +
                "u." + UserProperties.LAST_NAME + ", " +
                "b." + BeerProperties.COMMENT + ", " +
                "b." + BeerProperties.SELECTED + " " +
                "FROM " + BeerProperties.TABLE_NAME + " b " +
                "LEFT JOIN users u ON b." + BeerProperties.BREWER + " = " +
                "u." + UserProperties.PRIMARY_KEY + " " +
                "WHERE " + BeerProperties.VOLUME_REMAINING + " > 0 " +
                "ORDER BY " + BeerProperties.SELECTED + " DESC;"

        const val SELECT_BEER: String = "SELECT " +
                "b." + BeerProperties.PRIMARY_KEY + ", " +
                "b." + BeerProperties.NAME + ", " +
                "b." + BeerProperties.TYPE + ", " +
                "b." + BeerProperties.SIZE + ", " +
                "b." + BeerProperties.VOLUME_REMAINING + ", " +
                "b." + BeerProperties.ORIGINAL_GRAVITY + ", " +
                "b." + BeerProperties.FINAL_GRAVITY + ", " +
                "b." + BeerProperties.ALCOHOL + ", " +
                "b." + BeerProperties.DATE + ", " +
                "u." + UserProperties.FIRST_NAME + ", " +
                "u." + UserProperties.LAST_NAME + ", " +
                "b." + BeerProperties.COMMENT + ", " +
                "b." + BeerProperties.SELECTED + " " +
                "FROM " + BeerProperties.TABLE_NAME + " b " +
                "LEFT JOIN users u ON b." + BeerProperties.BREWER + " = " +
                "u." + UserProperties.PRIMARY_KEY + " " +
                "WHERE " + BeerProperties.PRIMARY_KEY + "=:" + BeerProperties.PRIMARY_KEY + ";"

        const val SELECT_CURRENT_SELECTED_BEER: String = "SELECT " +
                "b." + BeerProperties.PRIMARY_KEY + ", " +
                "b." + BeerProperties.NAME + ", " +
                "b." + BeerProperties.TYPE + ", " +
                "b." + BeerProperties.SIZE + ", " +
                "b." + BeerProperties.VOLUME_REMAINING + ", " +
                "b." + BeerProperties.ORIGINAL_GRAVITY + ", " +
                "b." + BeerProperties.FINAL_GRAVITY + ", " +
                "b." + BeerProperties.ALCOHOL + ", " +
                "b." + BeerProperties.DATE + ", " +
                "u." + UserProperties.FIRST_NAME + ", " +
                "u." + UserProperties.LAST_NAME + ", " +
                "b." + BeerProperties.COMMENT + ", " +
                "b." + BeerProperties.SELECTED + " " +
                "FROM " + BeerProperties.TABLE_NAME + " b " +
                "LEFT JOIN users u ON b." + BeerProperties.BREWER + " = " +
                "u." + UserProperties.PRIMARY_KEY + " " +
                "WHERE " + BeerProperties.SELECTED + " " +
                "LIMIT 1;"

        const val INSERT_BEER: String = "INSERT INTO " + BeerProperties.TABLE_NAME +
                "(" +
                BeerProperties.NAME + ", " +
                BeerProperties.TYPE + ", " +
                BeerProperties.SIZE + ", " +
                BeerProperties.VOLUME_REMAINING + ", " +
                BeerProperties.ORIGINAL_GRAVITY + ", " +
                BeerProperties.DATE + ", " +
                BeerProperties.BREWER + ", " +
                BeerProperties.COMMENT +
                ") VALUES (" +
                ":" + BeerProperties.NAME + ", " +
                ":" + BeerProperties.TYPE + ", " +
                ":" + BeerProperties.SIZE + ", " +
                ":" + BeerProperties.VOLUME_REMAINING + ", " +
                ":" + BeerProperties.ORIGINAL_GRAVITY + ", " +
                ":" + BeerProperties.DATE + ", " +
                ":" + BeerProperties.BREWER + ", " +
                ":" + BeerProperties.COMMENT +
                ")"

        const val UPDATE_VOLUME_REMAINING: String = "UPDATE " + BeerProperties.TABLE_NAME + " " +
                "SET " + BeerProperties.VOLUME_REMAINING + "=:" + BeerProperties.VOLUME_REMAINING + " " +
                "WHERE " + BeerProperties.PRIMARY_KEY + "=:" + BeerProperties.PRIMARY_KEY + ";"
    }
}