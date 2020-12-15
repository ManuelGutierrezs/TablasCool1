package mx.udg.cuvalles.tablascool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_estudiar.*

class EstudiarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estudiar)


        var listaElementos = mutableListOf<String>()




        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                listaElementos.clear()
                if (p1 < 1){
                    seekBar.setProgress(1)
                }
                if (p1 > 0){
                    for (i in 0..10){
                        val texto = "$p1 x $i = ${p1*i}"
                        listaElementos.add(texto)
                    }
                    val adaptador = ArrayAdapter(application,android.R.layout.simple_list_item_1,listaElementos)

                    listaTablas.adapter = adaptador
                }

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })



     }
}


