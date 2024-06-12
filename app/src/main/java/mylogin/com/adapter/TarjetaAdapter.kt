package mylogin.com.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import model.Tarjeta
import mylogin.com.R


class TarjetaAdapter(private val listaTarjetas: List<Tarjeta>) : RecyclerView.Adapter<TarjetaAdapter.TarjetaViewHolder>() {

    // ViewHolder para cada elemento en el RecyclerView
    class TarjetaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitulo: TextView = itemView.findViewById(R.id.tvTitulo)
        val tvDescripcion: TextView = itemView.findViewById(R.id.tvDescripcion)
    }

    // Crea nuevos ViewHolder (invocado por el layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarjetaViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_tarjeta, parent, false)
        return TarjetaViewHolder(itemView)
    }

    // Reemplaza el contenido de una vista (invocado por el layout manager)
    override fun onBindViewHolder(holder: TarjetaViewHolder, position: Int) {
        val tarjeta = listaTarjetas[position]
        holder.tvTitulo.text = tarjeta.titulo
        holder.tvDescripcion.text = tarjeta.descripcion
    }

    // Devuelve el tamaño de tu lista de datos (invocado por el layout manager)
    override fun getItemCount() = listaTarjetas.size
}
