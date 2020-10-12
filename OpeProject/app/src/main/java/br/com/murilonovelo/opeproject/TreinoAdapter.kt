package br.com.murilonovelo.opeproject

import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.squareup.picasso.Picasso

class TreinoAdapter (
    val treinos: List<Treinos>,
    val onClick: (Treinos) -> Unit): RecyclerView.Adapter<TreinoAdapter.TreinosViewHolder>() {

        // ViewHolder com os elemetos da tela
        class TreinosViewHolder(view: View): RecyclerView.ViewHolder(view) {
            val cardNome: TextView = view.findViewById<TextView>(R.id.cardNome)
            val cardImg : ImageView = view.findViewById<ImageView>(R.id.cardImg)
            var cardProgress: ProgressBar = view.findViewById<ProgressBar>(R.id.cardProgress)
            var cardView: CardView = view.findViewById<CardView>(R.id.card_treino)
        }

        // Quantidade de treinos na lista

        override fun getItemCount() = this.treinos.size

        // inflar layout do adapter

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TreinosViewHolder {
            // infla view no adapter
            val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_treinos, parent, false)

            // retornar ViewHolder
            val holder = TreinosViewHolder(view)
            return holder
        }

        // bind para atualizar Views com os dados

        override fun onBindViewHolder(holder: TreinosViewHolder, position: Int) {
            val context = holder.itemView.context

            // recuperar objeto treino
            val treino = treinos[position]

            // atualizar dados de treino

            holder.cardNome.text = treino.nome
            holder.cardProgress.visibility = View.VISIBLE

            // download da imagem
            Picasso.with(context).load(treino.foto).fit().into(holder.cardImg,
                object: com.squareup.picasso.Callback{
                    override fun onSuccess() {
                        holder.cardProgress.visibility = View.GONE
                    }

                    override fun onError() {
                        holder.cardProgress.visibility = View.GONE
                    }
                })

            // adiciona evento de clique
            holder.itemView.setOnClickListener {onClick(treino)}
        }
}