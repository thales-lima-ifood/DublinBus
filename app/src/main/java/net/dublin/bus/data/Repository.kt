package net.dublin.bus.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable
import net.dublin.bus.common.Utility
import net.dublin.bus.data.stop.local.LocalRouteDataSource
import net.dublin.bus.data.stop.local.LocalStopDataSource
import net.dublin.bus.model.Route
import net.dublin.bus.model.Stop

class Repository(val context: Context) {
    fun initRepository(): Observable<Void> {
        return Observable.create {
            val jsonStops = Utility.readStringFromFile(context, "stops.json")
            val jsonRoutes = Utility.readStringFromFile(context, "routes.json")
            val g = Gson()
            val stopList: List<Stop> = g.fromJson(jsonStops, object : TypeToken<List<Stop>>() {}.type)
            val routesList: List<Route> = g.fromJson(jsonRoutes, object : TypeToken<List<Route>>() {}.type)
            val routeDataSource = LocalRouteDataSource(context)
            val stopDataSource = LocalStopDataSource(context)
            routeDataSource.saveAll(routesList)
            stopDataSource.saveAll(stopList)
        }
    }
}