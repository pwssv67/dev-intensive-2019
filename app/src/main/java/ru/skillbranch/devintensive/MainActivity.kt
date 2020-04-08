package ru.skillbranch.devintensive

import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import ru.skillbranch.devintensive.extensions.hideKeyboard
import ru.skillbranch.devintensive.models.Bender

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var benderImage: ImageView
    lateinit var textTxt: TextView
    lateinit var messageEt: EditText
    lateinit var sendButton:ImageView
    lateinit var benderObj : Bender

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        benderImage = iv_bender
        textTxt= tv_text
        messageEt = et_message
        sendButton = iv_send

        val status = savedInstanceState?.getString("STATUS")?: Bender.Status.NORMAL.name
        val question = savedInstanceState?.getString("QUESTION")?: Bender.Question.NAME.name

        benderObj = Bender(Bender.Status.valueOf(status), Bender.Question.valueOf(question) )
        val(phrase, color) = benderObj.listenAnswer(messageEt.text.toString().toLowerCase())
        messageEt.setText("")
        val(r,g,b) = color
        benderImage.setColorFilter(Color.rgb(r,g,b), PorterDuff.Mode.MULTIPLY)
        textTxt.text = phrase
        sendButton.setOnClickListener (this)
        textTxt.text = benderObj.askQuestion()

        messageEt.setOnEditorActionListener{_, actionId, _ ->
            if(actionId == EditorInfo.IME_ACTION_DONE) {
                val(phrase, color) = benderObj.listenAnswer(messageEt.text.toString().toLowerCase())
                messageEt.setText("")
                val(r,g,b) = color
                benderImage.setColorFilter(Color.rgb(r,g,b), PorterDuff.Mode.MULTIPLY)
                textTxt.text = phrase
                true
            } else {
                false
            }
        }


    }

        override fun onClick(v:View?){
            if (v!= null && v.id == R.id.iv_send) {
                val(phrase, color) = benderObj.listenAnswer(messageEt.text.toString().toLowerCase())
                messageEt.setText("")
                val(r,g,b) = color
                benderImage.setColorFilter(Color.rgb(r,g,b), PorterDuff.Mode.MULTIPLY)
                textTxt.text = phrase
               // messageEt.onEditorAction(EditorInfo.IME_ACTION_DONE)
                hideKeyboard(this)
            }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("STATUS", benderObj.status.name)
        outState.putString("QUESTION", benderObj.question.name)
    }
}
