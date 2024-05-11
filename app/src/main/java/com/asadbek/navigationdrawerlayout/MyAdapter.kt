package com.asadbek.navigationdrawerlayout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val context:Context,val list:ArrayList<MyUser>): RecyclerView.Adapter<MyAdapter.VH>(){

        // VH - view holder asosiy classning ichki klassi
        // nested class - ichki klass, tashqi klass imkoniyatlaridan(o`zgaruvchilar, funktsiyalar) foydalana olmaydi
        // tashqi klass xam nested ichki klass imkoniyatlaridan foydalana olmaydi
        // inner class - ichki klass, tashqi klass imkoniyatlaridan(o`zgaruvchi,funktsiyalar) foydalana oladi
        // tashqi klass inner clasdan foydalana olmasdi
        inner class VH(itemView: View):RecyclerView.ViewHolder(itemView){
            // onBind - listdagi ma`lumotlarni o`zida olib keladigan asosiy funktsiya hisoblanadi
            // buni ichida biz itemimizdagi viewlarni kelayotgan ma`lutmotlarga tenglashimiz va ekranga chiqarishimiz mumkin.
            fun onBind(myUser: MyUser){
                itemView.findViewById<TextView>(R.id.itemUserMessage).text = myUser.message
                itemView.findViewById<TextView>(R.id.itemUserName).text = myUser.name

            }
        }

        // itemlarni yaratib berishi uchun kerak bo`ladigan funktsiya
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            return VH(LayoutInflater.from(parent.context).inflate(R.layout.my_item,parent,false))
        }

        // nechta item yaratib berishi kerakligini ko`rsatish uchun
        override fun getItemCount(): Int {
            return list.size
        }

        // onBind ga listdan ma`lumotlarni olib berishi uchun kerak bo`ladigan fun
        override fun onBindViewHolder(holder: VH, position: Int) {
            holder.onBind(list[position])
        }
}