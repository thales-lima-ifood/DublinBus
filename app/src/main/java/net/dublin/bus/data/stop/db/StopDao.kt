package net.dublin.bus.data.stop.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import net.dublin.bus.model.Stop

@Dao
interface StopDao {
    @Query("SELECT * FROM stops")
    fun getStops(): List<Stop>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllStops(stops: List<Stop>)

    @Query("DELETE FROM stops")
    fun clear()
}