package mx.udg.cuvalles.tablascool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_estudiar.*
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.*
import java.util.*

class EstudiarActivity : AppCompatActivity() , TextToSpeech.OnInitListener, AdapterView.OnItemClickListener{
    var tts:TextToSpeech? =null
    var listaElementos: MutableList<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estudiar)


         listaElementos = mutableListOf<String>()
        tts = TextToSpeech(this,this)
        Log.i("lenguajes",Locale.getAvailableLocales().toString())

        listaTablas.setOnItemClickListener(this)

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                listaElementos!!.clear()
                if (p1 < 1){
                    seekBar.setProgress(1)
                }
                if (p1 > 0){
                    for (i in 0..10){
                        val texto = "$p1 x $i = ${p1*i}"
                        listaElementos!!.add(texto)
                    }
                    val adaptador = ArrayAdapter(application,android.R.layout.simple_list_item_1,listaElementos!!)

                    listaTablas.adapter = adaptador
                }

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })



     }

    override fun onInit(status: Int) {
        if (status==TextToSpeech.SUCCESS){
            val result = tts!!.setLanguage(Locale("es_MX"))
            if (result != TextToSpeech.LANG_NOT_SUPPORTED && result != TextToSpeech.LANG_MISSING_DATA)
                Toast.makeText(this, "todo ok", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "Lenguaje no soportado", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        if (tts!! !=null){
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val textoALeer = listaElementos!!.get(p2)
        tts!!.speak(textoALeer,TextToSpeech.QUEUE_FLUSH,null,null)

    }
}


