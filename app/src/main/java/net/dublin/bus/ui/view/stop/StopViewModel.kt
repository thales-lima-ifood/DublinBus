package net.dublin.bus.ui.view.stop

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import net.dublin.bus.data.stop.repository.StopRepository
import net.dublin.bus.model.Stop

internal class StopViewModel(val repository: StopRepository) : ViewModel() {
    private var stops: LiveData<List<Stop>> = repository.getData()

    fun getStops(): LiveData<List<Stop>> {
        return stops
    }
}
