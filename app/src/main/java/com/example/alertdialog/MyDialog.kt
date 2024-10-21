package com.example.listview

import android.app.AlertDialog
import android.content.Context
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast

class MyDialog {
    companion object {
        fun createDialog(context: Context, adapter: ArrayAdapter<User>) =
            AdapterView.OnItemClickListener { parent, v, position, id ->
                val builder = AlertDialog.Builder(context)
                builder.setTitle("Внимание!")
                    .setMessage("Удалить данные?\n${adapter.getItem(id.toInt()).toString()}")
                    .setCancelable(true)
                    .setNegativeButton("Нет") { dialog, whitch ->
                        dialog.cancel()
                    }
                    .setPositiveButton("Да") { dialog, whitch ->
                        val note = adapter.getItem(position)
                        adapter.remove(note)
                    }.create()
                builder.show()
            }

    }
}