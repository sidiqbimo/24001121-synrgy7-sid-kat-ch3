import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class AlphabetAdapter(
    private val alphabetList: List<Char>,
    private val onItemClick: (Char) -> Unit
) : RecyclerView.Adapter<AlphabetAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_alphabet, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val alphabet = alphabetList[position]
        holder.bind(alphabet)
    }
    override fun getItemCount(): Int {
        return alphabetList.size
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val button: Button = itemView.findViewById(R.id.alphabetButton)
        fun bind(alphabet: Char) {
            button.text = alphabet.toString()
            button.setOnClickListener {
                onItemClick(alphabet)
            }
        }
    }
}