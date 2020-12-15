package mx.udg.cuvalles.tablascool

import android.media.MediaPlayer
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
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
            if (!resText.equals("")){
                val respuesta = resText.toInt()
            if (respuesta==resultado){
                Log.d("resultado","Le atinaste")
            crerDialogoOk()
            }else{
                Log.d("resultado","No le atinaste")
            crerDialogoError()
            }
            }
            generaOperacion()
        }


    }fun crerDialogoOk(){
        val miDialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_ok,null)
        val mBuilder = AlertDialog.Builder(this).setView(miDialogView)
            .setTitle("Muy Bien!")
        val miDialogoOk = mBuilder.create()
        miDialogoOk.show()
        val miPlayer:MediaPlayer? = MediaPlayer.create(this,R.raw.aplausos)
        miPlayer?.start()
    }
    fun crerDialogoError(){
        val miDialogView = LayoutInflater.from(this).inflate(R.layout.dialogo_error,null)
        val mBuilder = AlertDialog.Builder(this).setView(miDialogView)
            .setTitle("Muy Mal!")
        val miDialogoError = mBuilder.create()
        miDialogoError.show()
        val miPlayer:MediaPlayer? = MediaPlayer.create(this,R.raw.abucheo)
        miPlayer?.start()
    }
    fun generaOperacion(){
        val operando1 = Random.nextInt(1,10)
        val operando2 = Random.nextInt(1,10)

        resultado = operando1*operando2
        tvPregunta.text = "$operando1 x $operando2 = ?"
        etRespuesta.text.clear()
    }
}