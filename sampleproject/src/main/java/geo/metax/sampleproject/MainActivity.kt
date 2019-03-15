package geo.metax.sampleproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import geo.metax.sampleproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = inflateDataBindingView<ActivityMainBinding>(R.layout.activity_main)

        val persons = mutableListOf(
            Person("Joe", "Doe", 1980),
            Person("John", "Doe", 1995),
            Person("Jasmine", "Doe", 1986),
            Person("Janine", "Doe", 1972)
        )

        binding.rv.adapter = PersonAdapter().apply { addAll(persons) }
    }
}
