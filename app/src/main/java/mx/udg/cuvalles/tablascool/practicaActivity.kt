package mx.udg.cuvalles.tablascool

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_practica.*
import kotlin.random.Random

class practicaActivity : AppCompatActivity(){
    var resultado = 0
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practica)

        generaOperacion()

        btnProbar.setOnClickListener{
            val resText = etRespuesta.text.toString()
            if (resText.equals("")){
                val respuesta = resText.toInt()

            if (respuesta==resultado){
                Log.d("resultado","No le atinaste")
            }
            }
            generaOperacion()
        }


    }
    fun generaOperacion(){
        val operando1 = Random.nextInt(1,10)
        val operando2 = Random.nextInt(1,10)

        resultado = operando1*operando2
        tvPregunta.text = "$operando1 x $operando2 = ?"
        etRespuesta.text.clear()
    }
}