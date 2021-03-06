package br.com.data.datasource.database.dao

import androidx.room.*
import br.com.data.datasource.entity.Comic

@Dao
interface MarvelDao {
    @Query("SELECT * FROM comics")
    suspend fun getAllItems(): List<Comic>

    @Query("SELECT * FROM comics WHERE creation_date = :creation_date ORDER BY creation_date DESC")
    suspend fun getItemById(creation_date: String): Comic

    @Delete
    suspend fun delete(comic: Comic)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(comic: Comic)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateList(comics: List<Comic>)
}