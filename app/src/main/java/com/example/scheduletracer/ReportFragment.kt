package com.example.scheduletracer

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.math.log

class ReportFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_report, container, false)

        var txtfrom = v.findViewById<EditText>(R.id.txtDt1)
        var txtto = v.findViewById<EditText>(R.id.txtDt2)
        var btn = v.findViewById<Button>(R.id.btnSend)
        var txt = v.findViewById<EditText>(R.id.editTextTextMultiLine)

        btn.setOnClickListener(View.OnClickListener {
            val port = 8081
            val from = txtfrom.text.toString()
            val to = txtto.text.toString()
            var str : String = "{"


            var files: Array<String> = requireContext().fileList()
            for (i in files) {
                if (i in from..to) {

                    str += "\"$i\":["
                    val file = File(requireContext().filesDir, i)
                    for (ii in file.readLines()) {
                        str += "\"$ii\","
                    }
                    str = str.dropLast(1) + "],"
                }
                str = str.dropLast(1)
            }
            str += "}"

            txt.setText(str)

        })

        return v
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ReportFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}