package com.linda.apiintegration

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException

class MainActivity4 : AppCompatActivity() {
    private var mTextViewResult: TextView? = null
    private var mQueue: RequestQueue? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        mTextViewResult = findViewById(R.id.text_view_result2)
        val buttonParse = findViewById<Button>(R.id.button_parse2)
        mQueue = Volley.newRequestQueue(this)
        buttonParse.setOnClickListener { jsonParse() }
    }

    private fun jsonParse()
    {
        val url = "https://italian-jokes.vercel.app/api/jokes"

        val request = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                Log.d("Linda", response.toString())
                var text: String? = try {
                    response.getString("joke")
                } catch (e: JSONException) {
                    throw RuntimeException(e)
                }
                text?.let { Log.d("Linda", it) }
                mTextViewResult!!.text = text
            }) { error -> error.printStackTrace() }

        mQueue!!.add(request)

    }

}