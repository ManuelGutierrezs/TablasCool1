package mx.udg.cuvalles.tablascool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEstudiar.setOnClickListener {
            val i = Intent(this,EstudiarActivity::class.java)
            startActivity(i)
        }
        btnPractica.setOnClickListener {
            val i = Intent(this, practicaActivity::class.java)
            startActivity(i)
        }
    }
}