package com.sumon.mynotes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteRVAdapter(

        val context : Context,
        val noteClickInterface : NoteClickInterface,
        val noteClickDeleteInterface : NoteClickDeleteInterface
) : RecyclerView.Adapter<NoteRVAdapter.ViewHolder>() {

    private val allNotes = ArrayList<Note>()

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val tvNoteTitle = itemView.findViewById<TextView>(R.id.tvNoteTitle)
        val tvTimeStamp = itemView.findViewById<TextView>(R.id.tvTimeStamp)
        val ivDelete = itemView.findViewById<ImageView>(R.id.ivDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val imageView = LayoutInflater.from(parent.context).inflate(R.layout.note_rv_item, parent, false);
        return ViewHolder(imageView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tvNoteTitle.setText(allNotes.get(position).noteTitle)
        holder.tvTimeStamp.setText("Last Updated : " +allNotes.get(position).timeStamp)

        holder.ivDelete.setOnClickListener {
            noteClickDeleteInterface.onDeleteIconClick(allNotes.get(position))
        }

        holder.itemView.setOnClickListener {
            noteClickInterface.onNoteClick(allNotes.get(position))
        }

    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun updatelist(newList: List<Note>){

        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }
}
    interface NoteClickInterface{
        fun onNoteClick(note: Note)
    }

     interface NoteClickDeleteInterface{
         fun onDeleteIconClick(note: Note)
     }
